package me.eslamfathy.billionaire.service;

import me.eslamfathy.billionaire.model.Player;
import me.eslamfathy.billionaire.model.Question;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameServiceTest {

    @Test
    public void play() {
        GameService gameService = new GameService();
        assertFalse(gameService.play(new Player()));
    }

    @Test
    public void playStage() {
        GameService gameService = new GameService();
        assertFalse(gameService.playStage(new Question()));
    }
}