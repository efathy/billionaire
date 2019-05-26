package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.service.PresenterService;

public class ResultState implements State {

    public void start(GameContext gameContext) {
        PresenterService.getInstance().sayResult(gameContext.getPlayer());
        GameContextService.getInstance().goBackToMainMenu(gameContext);
    }
}
