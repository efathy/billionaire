package me.eslamfathy.billionaire.actions;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.model.Question;

public interface Action {

    public void doAction(GameContext gameContext, Question question);
}
