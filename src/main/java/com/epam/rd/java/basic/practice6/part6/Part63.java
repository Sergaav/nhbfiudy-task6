package com.epam.rd.java.basic.practice6.part6;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Part63{

    public static void printThreeWordsWithDuplicates(List<String> data) {
        Map<String, Integer> map = new LinkedHashMap<>();
        data.forEach(k -> map.put(k, map.getOrDefault(k, 0) + 1));
        List<Map.Entry<String,Integer>> list= map.entrySet().stream().limit(4).filter(k->k.getValue() > 1)
                .collect(Collectors.toList());
        for (Map.Entry<String,Integer> entry : list ){
            System.out.println(new StringBuilder(entry.getKey().toUpperCase()).reverse());
        }
    }
}
