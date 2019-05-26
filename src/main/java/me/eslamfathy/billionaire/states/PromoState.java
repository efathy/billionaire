package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.PresenterService;

public class PromoState implements State {

    private PresenterService presenterService = new PresenterService();

    @Override
    public void start(GameContext gameContext) {
        presenterService.sayPromo();
        presenterService.introducePresenter(gameContext);
    }
}
