package me.eslamfathy.billionaire.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class OutputUtilsTest {

    private static final String MESSAGE = "hello";
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void display() {
        OutputUtils outputUtils = new OutputUtils();
        outputUtils.display(MESSAGE);
        assertEquals(MESSAGE, outContent.toString().trim());
    }

    @Test
    public void displayByMessageKey() {
        OutputUtils outputUtils = new OutputUtils();
        outputUtils.displayByMessageKey("output.test");
        assertEquals(MESSAGE, outContent.toString().trim());
    }
}