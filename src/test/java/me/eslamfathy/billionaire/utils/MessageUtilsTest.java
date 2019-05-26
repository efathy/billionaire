package me.eslamfathy.billionaire.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageUtilsTest {
    private MessageUtils messageUtils = new MessageUtils();

    @Test
    public void getMessage() {
        assertEquals("Saved Successfully", messageUtils.getMessage("game.saving.state.success"));
    }
}