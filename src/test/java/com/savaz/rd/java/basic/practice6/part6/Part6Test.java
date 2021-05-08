package com.savaz.rd.java.basic.practice6.part6;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Part6Test {

    PrintStream consoleStream;
    PrintStream stream;
    OutputStream outputStream;

    @Before
    public void mockSystemIn() {
        consoleStream = System.out;
        outputStream = new ByteArrayOutputStream();
        stream = new PrintStream(outputStream);
        System.setOut(stream);
    }

    @Test
    public void shouldPrintThreeMostFrequent(){
        String expected = "whale ==> 3"+System.lineSeparator() +
                "cheetah ==> 4"+System.lineSeparator() +
                "bison ==> 3"+System.lineSeparator();
        String fileName = "part6.txt";
        Part6.main(new String[] {"--input", fileName, "--task","frequency"});
        String result = outputStream.toString();
        Assert.assertEquals(expected,result);
    }

    @Test
    public void shouldPrintThreeLongestWords(){
        String expected = "chimpanzee ==> 10"+System.lineSeparator() +
                "mongoose ==> 8"+System.lineSeparator() +
                "tortoise ==> 8"+System.lineSeparator();
        String fileName = "part6.txt";
        Part6.main(new String[] {"--input", fileName, "--task","length"});
        String result = outputStream.toString();
        Assert.assertEquals(expected,result);
    }

    @Test
    public void shouldPrintThreeDuplicatesInverted(){
        String expected = "RAUGAJ"+System.lineSeparator() +
                "NOSIB"+System.lineSeparator() +
                "ELAHW"+System.lineSeparator();
        String fileName = "part6.txt";
        Part6.main(new String[] {"--input", fileName, "--task","duplicates"});
        String result = outputStream.toString();
        Assert.assertEquals(expected,result);
    }

    @After
    public void closeMockingSystemIn() {
        System.setOut(consoleStream);
        try {
            outputStream.close();
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
    }
    
}
