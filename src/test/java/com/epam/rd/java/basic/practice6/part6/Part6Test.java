package com.epam.rd.java.basic.practice6.part6;

import org.junit.After;
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

    }

    @Test
    public void shouldPrintThreeLongestWords(){

    }

    @Test
    public void shouldPrintThreeDuplicatesInverted(){

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
