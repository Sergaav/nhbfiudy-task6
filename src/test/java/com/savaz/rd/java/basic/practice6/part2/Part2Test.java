package com.savaz.rd.java.basic.practice6.part2;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Part2Test {

    @Test
    public void shouldRemoveByIndexArrayFasterThenLinked() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < 10000; ++i) {
            list2.add(i);
            list1.add(i);
        }
        long list1Time = Part2.removeByIndex(list1, 4);
        long list2Time = Part2.removeByIndex(list2, 4);
        Assert.assertTrue(list2Time > list1Time * 4);
    }

    @Test
    public void shouldRemoveIteratorArrayAndLinkedTheSame() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < 100000; ++i) {
            list1.add(i);
            list2.add(i);
        }
        long list1Time = Part2.removeByIterator(list1, 4);
        long list2Time = Part2.removeByIterator(list2, 4);
        System.out.println(list1Time+"  "+list2Time);

        Assert.assertTrue((list2Time-list1Time) <= list1Time);
    }

}