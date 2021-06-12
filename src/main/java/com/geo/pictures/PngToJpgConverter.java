package com.geo.pictures;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

//@Component
public class PngToJpgConverter {

    @Value("${app.tshirts.man}")private String manPics;
    @Value("${app.tshirts.outputfolder}")private String outputFolder;


    @EventListener(ApplicationReadyEvent.class)
    private void convertFormat() throws IOException {

        Path source = Paths.get(manPics);
        Path target = Paths.get(outputFolder+"new.jpg");

        BufferedImage originalImage = ImageIO.read(source.toFile());

        // jpg needs BufferedImage.TYPE_INT_RGB
        // png needs BufferedImage.TYPE_INT_ARGB

        // create a blank, RGB, same width and height
        BufferedImage newBufferedImage = new BufferedImage(
                originalImage.getWidth(),
                originalImage.getHeight(),
                BufferedImage.TYPE_INT_RGB);

        // draw a white background and puts the originalImage on it.
        newBufferedImage.createGraphics()
                .drawImage(originalImage,
                        0,
                        0,
                        Color.WHITE,
                        null);


        // save an image
        ImageIO.write(newBufferedImage, "jpg", target.toFile());
        System.out.println("image converted success");



    }


}
