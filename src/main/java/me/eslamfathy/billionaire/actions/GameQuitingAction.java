package me.eslamfathy.billionaire.actions;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.model.Question;

public class GameQuitingAction implements Action {
    @Override
    public void doAction(GameContext gameContext, Question question) {
        System.exit(0);
    }
}
