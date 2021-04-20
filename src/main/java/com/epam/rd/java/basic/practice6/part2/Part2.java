package com.epam.rd.java.basic.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new LinkedList<>();
        for (int i = 0; i < 10000; ++i) {
            list.add(i);
            list1.add(i);
            list2.add(i);
            list3.add(i);
        }
        long start = System.currentTimeMillis();
        System.out.println(removeByIndex(list, 4));
        System.out.println(System.currentTimeMillis() - start);
        long start1 = System.currentTimeMillis();
        System.out.println(removeByIndex(list1, 4));
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        System.out.println(removeByIterator(list2, 4));
        System.out.println(System.currentTimeMillis() - start2);
        long start3 = System.currentTimeMillis();
        System.out.println(removeByIterator(list3, 4));
        System.out.println(System.currentTimeMillis() - start3);
    }

    public static long removeByIndex(final List<Integer> list, final int k) {
        int pos = 0;
        while (list.size() != 1) {
            pos = (pos + k - 1) % list.size();
            list.remove(pos);
        }
        return list.get(0);
    }

    public static long removeByIterator(final List<Integer> list, int k) {
        Iterator<Integer> iterator;
        int pos = k;
        while (list.size() != 1) {
            iterator = list.iterator();
            while (iterator.hasNext()) {
                if (pos > 0) {
                    iterator.next();
                    pos--;
                }
                if (pos == 0) {
                    iterator.remove();
                    pos = k;
                }
            }
        }
        return list.get(0);
    }
}
