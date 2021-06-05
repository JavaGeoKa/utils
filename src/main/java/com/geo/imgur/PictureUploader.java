package com.geo.imgur;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geo.model.ImgurResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component
public class PictureUploader {



    private static String CID = "dec56150d2e791b";

    @Value("${app.pics}")private String picsPath;
    @Value("${app.outfile}")private String outFile;

    List<String> links = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @EventListener(ApplicationReadyEvent.class)
    public void handlePictures() throws IOException {

//====================Read files

        Files.walk(Paths.get(picsPath))
                .filter(Files::isRegularFile)
                .forEach(f -> {
                        if (f.toString().endsWith(".jpg")) {
                            try {
                                links.add(f.getFileName().toString() + " -> " + jsonResponseParse(uploadContent(toBase64(f.toFile()))));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }

                });

        Files.deleteIfExists(Paths.get(outFile));
        Files.write(Paths.get(outFile), (Iterable<String>)links::iterator);
        System.out.println("result -> " + outFile + "\npics -> " + links.size());
        System.exit(0);


    }

    private String jsonResponseParse(String uploadContent) throws JsonProcessingException {
        ImgurResponseDto dto = mapper.readValue(uploadContent, ImgurResponseDto.class);
        return dto.getData().getLink();
    }


//        Files.lines(Paths.get(requestsOutFile)).forEach(requests::add);






    //======================Imgur uploader
    public static String uploadContent(String fileString) throws Exception {
        URL url = new URL("https://api.imgur.com/3/image");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        String data = URLEncoder.encode("image", "UTF-8") + "=" + fileString;
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Client-ID " + CID );
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.connect();
        StringBuilder stb = new StringBuilder();
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);
        wr.flush();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            stb.append(line).append("\n");
        }
        wr.close();
        rd.close();
        System.out.println("Uploaded");
        return stb.toString();
    }



    public static String toBase64(File file) throws Exception {
        try {
            byte[] b = new byte[(int) file.length()];
            FileInputStream fs = new FileInputStream(file);
            fs.read(b);
            fs.close();
            return URLEncoder.encode(DatatypeConverter.printBase64Binary(b), "UTF-8");
        } catch (IOException e) {
            throw new Exception();
        }
    }



}
