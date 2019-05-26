package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.PresenterService;

public class PromoState implements State {

    @Override
    public void start(GameContext gameContext) {
        PresenterService.getInstance().sayPromo();
        PresenterService.getInstance().introducePresenter(gameContext);
    }
}
