package me.eslamfathy.billionaire.controller;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.states.State;

public class GameController {

    public void start() {
        GameContext gameContext = new GameContext();
        GameContextService.getInstance().initialize(gameContext);

        while (!gameContext.getStates().isEmpty()){
            State currentState  = gameContext.getStates().poll();
            if(currentState != null) {
                currentState.start(gameContext);
                gameContext.getPlayer().setLastState(currentState);
            }
        }
    }
}
