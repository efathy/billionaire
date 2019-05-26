package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.utils.LoggerUtils;
import me.eslamfathy.billionaire.utils.OutputUtils;

import java.io.IOException;

public class GameSavingState implements State {
    private LoggerUtils loggerUtils = new LoggerUtils();
    private OutputUtils outputUtils = new OutputUtils();
    private GameContextService gameContextService = new GameContextService();

    @Override
    public void start(GameContext gameContext) {
        //TODO
        try {
            gameContextService.save(gameContext);
            outputUtils.displayByMessageKey("game.saving.state.success");
        } catch (IOException e) {
            loggerUtils.logError("Failed to save file", e);
            outputUtils.displayByMessageKey("game.saving.state.failed");
        }
        gameContextService.goBackToMainMenu(gameContext);
    }
}
