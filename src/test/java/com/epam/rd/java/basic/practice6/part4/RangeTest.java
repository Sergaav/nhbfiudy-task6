package com.epam.rd.java.basic.practice6.part4;

import org.junit.Assert;
import org.junit.Test;

public class RangeTest {

    @Test
    public void shouldCorrectIterateWhenFalse(){
        Range range = new Range(3, 10);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer el : range) {
            stringBuilder.append(String.format("%d ", el));
        }
        stringBuilder.append(System.lineSeparator());
        String expected = "3 4 5 6 7 8 9 10 "+System.lineSeparator();
        Assert.assertEquals(expected,stringBuilder.toString());
    }

    @Test
    public void shouldCorrectIterateWhenTrue(){
        Range range = new Range(3, 10,true);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer el : range) {
            stringBuilder.append(String.format("%d ", el));
        }
        stringBuilder.append(System.lineSeparator());
        String expected = "10 9 8 7 6 5 4 3 "+System.lineSeparator();
        Assert.assertEquals(expected,stringBuilder.toString());
    }
}
