package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;

public interface State {
    public void start(GameContext gameContext);
}
