package com.epam.rd.java.basic.practice6.part6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part6 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        if (args[0].equals("-i") || args[0].equals("--input")) {
            Path path = Paths.get(args[1]);
            try {
                byte[] bytes = Files.readAllBytes(path);
                String[] strings = new String(bytes, StandardCharsets.UTF_8).split(System.lineSeparator());
                for (String s : strings) {
                    String[] words = s.split(" ");
                    list.addAll(Arrays.asList(words));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (args[2].equals("-t") || args[2].equals("--task")) {
            String task = args[3];
            switch (task) {
                case "frequency":
                    Part61.printThreeMostFrequent(list);
                    break;
                case "length":
                    Part62.printThreeLongestWords(list);
                    break;
                case "duplicates":
                    Part63.printThreeWordsWithDuplicates(list);
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }

}
