package me.eslamfathy.billionaire.utils;

import org.junit.Test;

import java.util.MissingResourceException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MessageUtilsTest {
    private MessageUtils messageUtils = new MessageUtils();

    @Test
    public void getMessageFound() {
        assertEquals("hello", messageUtils.getMessage("output.test"));
    }

    @Test(expected = MissingResourceException.class)
    public void getMessageNotFound() {
        messageUtils.getMessage("output.test.123");
    }
}