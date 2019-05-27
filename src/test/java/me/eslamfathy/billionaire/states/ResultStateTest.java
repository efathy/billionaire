package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.model.Prize;
import me.eslamfathy.billionaire.model.Question;
import org.junit.Assert;
import org.junit.Test;

public class ResultStateTest {
    @Test
    public void start() {
        GameContext gameContext = new GameContext();
        Question question = new Question();
        question.setPrize(Prize.A);
        gameContext.getPlayer().setLastPrize(Prize.A);

        ResultState resultStage = new ResultState();
        resultStage.start(gameContext);
        Assert.assertTrue(gameContext.getStates().peek() instanceof MainMenuState);
    }
}