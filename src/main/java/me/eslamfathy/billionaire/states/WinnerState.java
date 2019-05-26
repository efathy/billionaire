package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.service.PresenterService;

public class WinnerState implements State {

    @Override
    public void start(GameContext gameContext) {
        PresenterService.getInstance().congratulateWinnerPlayer();
        GameContextService.getInstance().goBackToMainMenu(gameContext);
    }
}
