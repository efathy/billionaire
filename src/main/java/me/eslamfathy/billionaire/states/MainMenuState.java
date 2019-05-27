package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.service.PresenterService;

public class MainMenuState implements State {
    @Override
    public void start(GameContext gameContext) {
        State nextState = PresenterService.getInstance().askMainMenuAndGetNextState();
        GameContextService.getInstance().addNextState(gameContext, nextState);
    }
}
