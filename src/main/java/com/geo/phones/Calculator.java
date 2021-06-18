package com.geo.phones;

import java.util.Arrays;

public class Calculator {

    public static void main(String[] args) {

        String line = "8957645537849";
        System.out.println(Arrays.stream(line.split("")).map(i -> Integer.parseInt(i)).reduce(0,(a,b) -> a+b));

    }
}
