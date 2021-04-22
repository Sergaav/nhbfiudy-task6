package com.epam.rd.java.basic.practice6.part6;

import java.util.*;

public class Part61 {

    public static void printThreeMostFrequent(List<String> data) {
        Map<String, Integer> map = new HashMap<>();
        data.forEach((k) -> map.put(k, map.getOrDefault(k, 0) + 1));
        map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(3)
                .forEach((k) -> System.out.println(k.getKey() + " ==> " + k.getValue()));
    }

}
