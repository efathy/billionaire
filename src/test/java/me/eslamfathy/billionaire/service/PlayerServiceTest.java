package me.eslamfathy.billionaire.service;

import me.eslamfathy.billionaire.model.Player;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class PlayerServiceTest {



    @Test
    public void createPlayer() {
        PlayerService playerService = new PlayerService();
        Player player = playerService.create("Joe");
        assertNotNull(player);
    }


    @Test
    public void load() throws IOException {
        PlayerService playerService = new PlayerService();
        Player player = playerService.load("Joe");
        assertNotNull(player);
    }

    @Test
    public void save() throws IOException {
        PlayerService playerService = new PlayerService();
        playerService.save(new Player());
    }
}