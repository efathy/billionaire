package me.eslamfathy.billionaire.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PresenterServiceTest {

    private PresenterService presenterService;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        PlayerService playerService = Mockito.mock(PlayerService.class);
        presenterService = new PresenterService(playerService);
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void respondQuestionAnswer() {
        // TODO: 2019-05-26
    }

    @Test
    public void isValidChoice() {
        // TODO: 2019-05-26
    }

    @Test
    public void getValidChoice() {
        // TODO: 2019-05-26
    }

}