package me.eslamfathy.billionaire.model;

import me.eslamfathy.billionaire.states.State;
import me.eslamfathy.billionaire.utils.Constants;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class GameContext implements Serializable {
    private static final long serialVersionUID = 1L;

    private Player player;
    private Presenter presenter;
    private Queue<State> states;

    public GameContext(){
        this.player = new Player();
        this.presenter = new Presenter(Constants.PRESENTER_NAME);
        this.states = new LinkedList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public Queue<State> getStates() {
        return states;
    }

    public void copy(GameContext gameContext) {
        this.player = gameContext.getPlayer();
        this.presenter = gameContext.getPresenter();
        this.states = gameContext.getStates();
    }
}
