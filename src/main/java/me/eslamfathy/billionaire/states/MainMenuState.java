package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.service.PresenterService;

public class MainMenuState implements State {
    @Override
    public void start(GameContext gameContext) {
        Integer choice = PresenterService.getInstance().askMainMenuChoices(2);
        GameContextService.getInstance().addNextState(gameContext, choice == 1 ? new GameCreationState() : new GameLoadingState());
    }
}
