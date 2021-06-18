package com.geo.phones;

import java.util.Arrays;

public class Calculator {

    public static void main(String[] args) {

        String line = "895764553784";
        System.out.println(Arrays.stream(line.split("")).map(i -> Integer.parseInt(i)).reduce(0,(a,b) -> a+b));
        System.out.println(Arrays.stream(line.split("")).map(i -> Integer.parseInt(i)).reduce(0,Integer::sum));
        System.out.println(Arrays.stream(line.split("")).reduce("",String::concat));
        System.out.println(Arrays.stream(line.split("")).reduce("",String::join));

    }
}
