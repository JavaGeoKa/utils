package com.geo.pictures;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

//@Component
public class PicturesResizer {

    @Value("${app.tshirts.testfolder}")private String testFolder;
    @Value("${app.tshirts.outputfolder}")private String outputFolder;


    private static final int IMG_WIDTH = 450;
    private static final int IMG_HEIGHT = 450;

    private Integer counter =0;


    @EventListener(ApplicationReadyEvent.class)
    private void walkDirectories() throws IOException {
        System.out.println("Start RESIZE");

        Files.walk(Paths.get(testFolder), 1)
                .filter(Files::isRegularFile)
                .filter(f -> f.toString().endsWith(".jpg"))
                .forEach(f -> {

                    try {
                        handlePicture(f);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        System.out.println("resize success " + counter + " files");

    }

    private void handlePicture(Path f) throws IOException {
        //load image
        Path target = Paths.get(outputFolder+"image" + counter++ +".jpg");

        try (InputStream is = new FileInputStream(f.toFile())) {
            resize(is, target, IMG_WIDTH, IMG_HEIGHT);
        }


    }

    private void resize(InputStream is, Path target, int imgWidth, int imgHeight) throws IOException {
        // read an image to BufferedImage for processing
        BufferedImage originalImage = ImageIO.read(is);

        // create a new BufferedImage for drawing
        BufferedImage newResizedImage
                = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = newResizedImage.createGraphics();

        //g.setBackground(Color.WHITE);
        //g.setPaint(Color.WHITE);

        // background transparent
        g.setComposite(AlphaComposite.Src);
        g.fillRect(0, 0, imgWidth, imgHeight);

        /* try addRenderingHints()
        // VALUE_RENDER_DEFAULT = good tradeoff of performance vs quality
        // VALUE_RENDER_SPEED   = prefer speed
        // VALUE_RENDER_QUALITY = prefer quality
        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                              RenderingHints.VALUE_RENDER_QUALITY);

        // controls how image pixels are filtered or resampled
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                              RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        // antialiasing, on
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                              RenderingHints.VALUE_ANTIALIAS_ON);*/

        Map<RenderingHints.Key,Object> hints = new HashMap<>();
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        hints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.addRenderingHints(hints);

        // puts the original image into the newResizedImage
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        // get file extension
//        String s = target.getFileName().toString();
//        String fileExtension = s.substring(s.lastIndexOf(".") + 1);
//        System.out.println("fileExtension = " + fileExtension);

        // we want image in png format
        ImageIO.write(newResizedImage, "jpg", target.toFile());


    }


}
