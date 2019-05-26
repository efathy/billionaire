package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.service.PresenterService;

public class GameCreationState implements State {
    private PresenterService presenterService = new PresenterService();
    private GameContextService gameContextService = new GameContextService();

    public GameCreationState(){
    }

    public GameCreationState (PresenterService presenterService){
        this.presenterService = presenterService;
    }

    @Override
    public void start(GameContext gameContext) {
        String playerName = presenterService.askPlayerName();
        gameContext.copy(gameContextService.createNewGame(playerName));
        gameContextService.addNextState(gameContext, new WelcomePlayerState());
    }
}
