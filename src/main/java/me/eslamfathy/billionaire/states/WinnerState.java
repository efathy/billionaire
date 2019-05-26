package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.service.PresenterService;

public class WinnerState implements State {
    private PresenterService presenterService = new PresenterService();
    private GameContextService gameContextService = new GameContextService();

    @Override
    public void start(GameContext gameContext) {
        presenterService.congratulateWinnerPlayer();
        gameContextService.goBackToMainMenu(gameContext);
    }
}