package com.geo.pictures;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class PictureConnectorMan {

    @Value("${app.tshirts.testfolder}")private String testFolder;
    @Value("${app.tshirts.outputfolder}")private String outputFolder;
    @Value("${app.tshirts.man}")private String manPics;

    private Integer counter = 0;


    @EventListener(ApplicationReadyEvent.class)
    private void walkDirectories() throws IOException {

        Files.walk(Paths.get(testFolder), 1)
                .filter(Files::isRegularFile)
                .filter(f -> f.toString().endsWith(".jpg"))
                .forEach(f -> {
                    try {
                        connectPictures(f);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        System.out.println("handle files " + counter);
    }

    private void connectPictures(Path f) throws IOException {
        Path target = Paths.get(outputFolder + "file" + counter++ +".jpg");

        BufferedImage source = ImageIO.read(new File(manPics));
        BufferedImage logo = ImageIO.read(f.toFile());

        Graphics g = source.getGraphics();
        g.drawImage(logo, 660, 1050, null);      //500*500 -> 620*1030   //450*450 ->
        g.dispose();

        ImageIO.write(source, "jpg", target.toFile());



    }


}
