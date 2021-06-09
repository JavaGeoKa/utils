package com.geo.parser;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

//@Component
public class TelegramParser {

    @Value("${app.parser.in}")private String inputFolder;
    @Value("${app.parser.users}")private String outputUserFile;

//Users
    private static File input;
    private TreeSet<String> chatUsers = new TreeSet<>();


//Phrases
    private static TreeSet<String> phrases = new TreeSet<>();
    private static TreeSet <String> clearPhrases = new TreeSet<>();
    static StringBuilder s = new StringBuilder();
    static ArrayList<String> globalWordsArray = new ArrayList<>();
    static TreeSet <String> uniqueWords = new TreeSet<>();
    static Map<String, Long> ratingWords = new HashMap<>();



    //    @EventListener(ApplicationReadyEvent.class)
    private void getActiveUsers() throws IOException {

        Files.walk(Paths.get(inputFolder), 1)
                .filter(Files::isRegularFile)
                .forEach(f -> {

                    input = new File(f.toString());
                    Document doc = null;
                    try {
                        doc = Jsoup.parse(input, "UTF-8");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Elements users = doc.getElementsByClass("from_name");
                    users.stream().map(u -> u.text()).forEach(chatUsers::add);

                });
        System.out.println(chatUsers.size());
        chatUsers.forEach(System.out::println);

    }




//    @EventListener(ApplicationReadyEvent.class)
    public void collectPhrases() throws IOException {

        Files.walk(Paths.get(inputFolder), 1)
                .filter(Files::isRegularFile)
                .forEach(f -> {

                    input = new File(f.toString());
                    Document doc = null;
                    try {
                        doc = Jsoup.parse(input, "UTF-8");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Elements messages = doc.getElementsByClass("text");
                    messages.stream().map(m -> m.text()).forEach(phrases::add);
                });


        System.out.println("collect messages -> " + phrases.size());

//create clearPhrases
        phrases.stream().forEach(p -> {
             s.setLength(0);
             s.append(p.replaceAll("[^a-zA-Z]", " "));
             clearPhrases.add(s.toString());
        });
        phrases.clear();

//create globalWordsArray
        clearPhrases.forEach(p -> {
            Arrays.stream(p.split(" ")).forEach(w -> globalWordsArray.add(w)); });

//create uniqueWordsSet
        globalWordsArray.stream().filter(w -> w.length() > 3).forEach(w -> uniqueWords.add(w));

//create ratingWords
        ratingWords = globalWordsArray.stream().filter(w -> w.length() > 3)
                .collect(Collectors.groupingBy(s->s,Collectors.counting()));

        ratingWords.entrySet().stream().sorted(Collections
                .reverseOrder(Map.Entry.comparingByValue())).limit(10000).forEach(System.out::println);
        System.out.println("rating words size -> " + ratingWords.size());




    }




}
