package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.service.PresenterService;
import me.eslamfathy.billionaire.utils.LoggerUtils;
import me.eslamfathy.billionaire.utils.OutputUtils;

import java.io.IOException;

public class GameLoadingState implements State {

    @Override
    public void start(GameContext gameContext) {
        try {
            gameContext.copy(GameContextService.getInstance().load(PresenterService.getInstance().askLoadFileName()));
            GameContextService.getInstance().addNextState(gameContext, new WelcomePlayerState());
        } catch (IOException | ClassNotFoundException e) {
            LoggerUtils.getInstance().logError("Failed to load file", e);
            new OutputUtils().display("Failed to load file");
            GameContextService.getInstance().goBackToMainMenu(gameContext);
        }
    }
}
