package com.savaz.rd.java.basic.practice6.part1;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;

public class WordContainerTest {
    public static String data = "asd 43 asdf asd 43\n434 asdf\nkasdf asdf stop asdf\nstop\n";
    public static InputStream tempInputStream = System.in;
    public static InputStream myInputStream;
    public static PrintStream consoleStream = System.out;
    public static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeClass
    public static void createStream() {
        myInputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(myInputStream);
        PrintStream myStream = new PrintStream(outputStream);
        System.setOut(myStream);
    }

    @Test
    public void shouldBeRightCountLines() {

        try {
            WordContainer.main(new String[]{});
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] result = outputStream.toString().split("\n");
        Assert.assertEquals(5,result.length);
    }

    @Test
    public void shouldPrintRightOut(){
        try {
            WordContainer.main(new String[]{});
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = outputStream.toString();
        String expected = "asdf : 3"+System.lineSeparator() +
                "43 : 2"+System.lineSeparator() +
                "asd : 2"+System.lineSeparator() +
                "434 : 1"+System.lineSeparator() +
                "kasdf : 1"+System.lineSeparator();
        Assert.assertEquals(expected,result);
    }


    @AfterClass
    public static void closeStream() {
        System.setIn(tempInputStream);
        System.setOut(consoleStream);
    }


}
