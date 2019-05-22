package me.eslamfathy.billionaire.service;

import me.eslamfathy.billionaire.model.Player;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.Assert.*;

public class PlayerServiceTest {

    @Test
    public void createPlayerWithNullName() {
        PlayerService playerService = new PlayerService();
        assertNull(playerService.create(null));
    }

    @Test
    public void createPlayerWithName() {
        PlayerService playerService = new PlayerService();
        assertNotNull(playerService.create("Joe"));
    }

    @Test
    public void loadPlayerNullName() throws IOException {
        PlayerService playerService = new PlayerService();
        assertNull(playerService.load(null));
    }

    @Test
    public void loadPlayerNotExist() throws IOException {
        PlayerService playerService = new PlayerService();
        assertNull(playerService.load("Jane"));
    }

    @Test
    public void loadPlayerExist() throws IOException {
        PlayerService playerService = new PlayerService();
        assertNull(playerService.load("Jane"));
    }

    @Test(expected = IOException.class)
    public void loadPlayerException() throws IOException {
        PlayerService playerService = new PlayerService();
        assertNull(playerService.load("Jane"));
    }

    @Test
    public void savePlayerNullName() throws IOException {
        PlayerService playerService = new PlayerService();
        playerService.save(new Player());
    }

    @Test
    public void savePlayerExist() throws IOException {
        PlayerService playerService = new PlayerService();
        playerService.save(new Player());
    }

    @Test(expected = IOException.class)
    public void savePlayerException() throws IOException {
        PlayerService playerService = new PlayerService();
        playerService.save(new Player());
    }
}