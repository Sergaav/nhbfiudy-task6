package com.epam.rd.java.basic.practice6.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WordContainer {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        while (reader.ready()) {
            String[] words = reader.readLine().split(" ");
            for (String s : words) {
                if (s.equals("stop"))
                    break;
                list.add(s);
            }
        }
        List<String> unique = list.stream().distinct().collect(Collectors.toList());
        List<Word> outList = new ArrayList<>();
        for (String u : unique) {
            int count = 0;
            for (String str : list) {
                if (u.equals(str))
                    count++;
            }
            outList.add(new Word(u, count));
        }
        Collections.sort(outList);
        for (Word w:outList) {
            System.out.println(w.getContent()+": "+w.getFrequency());
        }
    }

}
