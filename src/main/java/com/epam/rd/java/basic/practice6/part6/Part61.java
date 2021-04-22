package com.epam.rd.java.basic.practice6.part6;

import java.util.*;
import java.util.stream.Collectors;

public class Part61 {

    private Part61() {
    }

    public static void printThreeMostFrequent(List<String> data) {
        Map<String, Integer> map = new LinkedHashMap<>();
        data.forEach(k -> map.put(k, map.getOrDefault(k, 0) + 1));
       List<Map.Entry<String,Integer>> list = map.entrySet().stream()
               .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
               .limit(3).sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList());
        for (Map.Entry<String,Integer> entry : list){
            System.out.println(entry.getKey()+" ==> "+entry.getValue());

        }
    }

}
