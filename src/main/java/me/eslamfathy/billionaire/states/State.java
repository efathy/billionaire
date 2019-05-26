package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;

import java.io.Serializable;

public interface State extends Serializable {
    public void start(GameContext gameContext);
}
