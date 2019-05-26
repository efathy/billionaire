package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.service.PresenterService;
import me.eslamfathy.billionaire.utils.LoggerUtils;
import me.eslamfathy.billionaire.utils.OutputUtils;

import java.io.IOException;

public class GameLoadingState implements State {
    private OutputUtils outputUtils = new OutputUtils();
    private GameContextService gameContextService = new GameContextService();
    private PresenterService presenterService;
    private LoggerUtils loggerUtils = new LoggerUtils();

    public GameLoadingState() {
        this.presenterService = new PresenterService();
    }

    public GameLoadingState(PresenterService presenterService){
        this.presenterService = presenterService;
    }

    @Override
    public void start(GameContext gameContext) {
        try {
            gameContext.copy(gameContextService.load(presenterService.askLoadFileName()));
            gameContextService.addNextState(gameContext, new WelcomePlayerState());
        } catch (IOException | ClassNotFoundException e) {
            loggerUtils.logError("Failed to load file", e);
            outputUtils.display("Failed to load file");
            gameContextService.goBackToMainMenu(gameContext);
        }
    }
}
