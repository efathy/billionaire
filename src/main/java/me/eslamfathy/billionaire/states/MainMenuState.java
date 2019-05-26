package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.service.PresenterService;

public class MainMenuState implements State {
    private PresenterService presenterService = new PresenterService();
    private GameContextService gameContextService = new GameContextService();

    @Override
    public void start(GameContext gameContext) {
        Integer choice = presenterService.askMainMenuChoices();
        gameContextService.addNextState(gameContext, choice == 1 ? new GameCreationState() : new GameLoadingState());
    }
}
