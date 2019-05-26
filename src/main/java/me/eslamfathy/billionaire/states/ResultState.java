package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.service.PresenterService;

public class ResultState implements State {
    private PresenterService presenterService = new PresenterService();
    private GameContextService gameContextService = new GameContextService();

    public void start(GameContext gameContext) {
        presenterService.sayResult(gameContext.getPlayer());
        gameContextService.goBackToMainMenu(gameContext);
    }
}
