package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.PresenterService;

public class WelcomePlayerState implements State {

    @Override
    public void start(GameContext gameContext) {
        PresenterService.getInstance().welcomePlayer(gameContext.getPlayer());
    }
}
