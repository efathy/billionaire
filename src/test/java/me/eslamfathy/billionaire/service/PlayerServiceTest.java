package me.eslamfathy.billionaire.service;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class PlayerServiceTest {


    private final InputStream originalIn = System.in;

    @Test
    public void choose() {
        ByteArrayInputStream inContent = new ByteArrayInputStream("1".getBytes());
        System.setIn(inContent);

        PlayerService playerService = new PlayerService();
        Assert.assertEquals(new Integer(1), playerService.choose());

        System.setIn(originalIn);
    }

    @Test
    public void reply() {
        ByteArrayInputStream inContent = new ByteArrayInputStream("Joe".getBytes());
        System.setIn(inContent);

        PlayerService playerService = new PlayerService();
        Assert.assertEquals("Joe", playerService.reply());

        System.setIn(originalIn);
    }
}