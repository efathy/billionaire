package me.eslamfathy.billionaire.model;

import me.eslamfathy.billionaire.states.State;

import java.io.Serializable;

public class Player extends Human implements Serializable {
    private static final long serialVersionUID = 1L;

    private State lastState;

    public State getLastState() {
        return lastState;
    }

    public void setLastState(State lastState) {
        this.lastState = lastState;
    }
}
