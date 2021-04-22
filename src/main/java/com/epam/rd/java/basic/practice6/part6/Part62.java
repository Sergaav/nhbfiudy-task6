package com.epam.rd.java.basic.practice6.part6;

import java.util.*;

public class Part62 {

    public static void printThreeLongestWords(List<String> data) {
        Map<String, Integer> map = new LinkedHashMap<>();
        data.forEach((k) -> map.put(k, k.length()));
        map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(3)
                .forEach((k) -> System.out.println(k.getKey() + " ==> " + k.getValue()));
    }
}
