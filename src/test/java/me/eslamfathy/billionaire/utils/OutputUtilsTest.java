package me.eslamfathy.billionaire.utils;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class OutputUtilsTest {

    private static final String MESSAGE = "hello";

    private static final PrintStream originalOut = System.out;

    @Test
    public void display() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputUtils outputUtils = new OutputUtils();
        outputUtils.display(MESSAGE);
        assertEquals(MESSAGE, outContent.toString().trim());

        System.setOut(originalOut);
    }

    @Test
    public void displayByMessageKey() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputUtils outputUtils = new OutputUtils();
        outputUtils.displayByMessageKey("output.test");
        assertEquals(MESSAGE, outContent.toString().trim());

        System.setOut(originalOut);
    }
}