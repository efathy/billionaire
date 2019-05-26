package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.service.PresenterService;

public class GameCreationState implements State {

    @Override
    public void start(GameContext gameContext) {
        String playerName = PresenterService.getInstance().askPlayerName();
        gameContext.copy(GameContextService.getInstance().createNewGame(playerName));
        GameContextService.getInstance().addNextState(gameContext, new WelcomePlayerState());
    }
}
