package com.geo.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvController {


    public static void main(String[] args) throws IOException {

        Map<String,String> translatedWords = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/home/g/Downloads/Chats/Translated.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if(!values[1].toLowerCase().matches("[a-zA-Z]+")) {
                    translatedWords.put(values[0],values[1].toLowerCase());

                }

            }
            br.close();
        }


        translatedWords.entrySet().forEach(System.out::println);
        System.out.println(translatedWords.size());


    }


}
