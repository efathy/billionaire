package me.eslamfathy.billionaire.controller;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.states.State;

public class GameController {

    private GameContextService gameContextService = new GameContextService();

    public void start() {
        GameContext gameContext = new GameContext();
        gameContextService.initialize(gameContext);

        while (!gameContext.getStates().isEmpty()){
            State currentState  = gameContext.getStates().poll();
            if(currentState != null) {
                currentState.start(gameContext);
                gameContext.getPlayer().setLastState(currentState);
            }
        }
    }
}
