package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import org.junit.Assert;
import org.junit.Test;

public class WinnerStateTest {

    @Test
    public void start() {
        WinnerState winnerState = new WinnerState();
        GameContext gameContext = new GameContext();
        winnerState.start(gameContext);
        Assert.assertTrue(gameContext.getStates().peek() instanceof MainMenuState);
    }
}