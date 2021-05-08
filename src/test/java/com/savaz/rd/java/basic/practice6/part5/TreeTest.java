package com.savaz.rd.java.basic.practice6.part5;

import org.junit.*;

import java.io.*;

public class TreeTest {
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
    public void shouldAddElementsInRightStructure() {
        Tree<Integer> tree = new Tree<>();
        String expected = "    0" + System.lineSeparator() +
                "  1" + System.lineSeparator() +
                "    2" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "    4" + System.lineSeparator() +
                "  5" + System.lineSeparator() +
                "    6" + System.lineSeparator();
        tree.add(3);
        tree.add(5);
        tree.add(1);
        tree.add(2);
        tree.add(0);
        tree.add(4);
        tree.add(6);
        tree.print();
        String result = outputStream.toString();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldRemoveElementFromTree() {
        Tree<Integer> tree = new Tree<>();
        String expected = "    0" + System.lineSeparator() +
                "  1" + System.lineSeparator() +
                "    2" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "    4" + System.lineSeparator() +
                "  6" + System.lineSeparator();
        tree.add(3);
        tree.add(5);
        tree.add(1);
        tree.add(2);
        tree.add(0);
        tree.add(4);
        tree.add(6);
        tree.remove(5);
        tree.print();
        String result = outputStream.toString();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldReturnFalseIfExistInTree() {
        Tree<Integer> tree = new Tree<>();
        tree.add(3);
        tree.add(5);
        tree.add(1);
        tree.add(2);
        tree.add(0);
        tree.add(4);
        tree.add(6);
        boolean result = tree.add(1);
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseIfRemoveAbsent() {
        Tree<Integer> tree = new Tree<>();
        tree.add(3);
        tree.add(5);
        tree.add(1);
        tree.add(2);
        tree.add(0);
        tree.add(4);
        tree.add(6);
        boolean result = tree.remove(10);
        Assert.assertFalse(result);
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
