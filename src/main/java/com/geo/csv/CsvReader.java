package com.geo.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CsvReader {
    public static Map<String,String> translatedWords = new ConcurrentHashMap<>();

    public static void readCsvToTranslatedWords() throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader("/home/g/Downloads/Translated.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (!values[1].toLowerCase().matches("[a-zA-Z]+")) {
                    translatedWords.put(values[0], values[1].toLowerCase());

                }

            }
            br.close();
        }
    }





    }
