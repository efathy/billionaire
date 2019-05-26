package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.utils.LoggerUtils;
import me.eslamfathy.billionaire.utils.OutputUtils;

import java.io.IOException;

public class GameSavingState implements State {

    @Override
    public void start(GameContext gameContext) {
        try {
            GameContextService.getInstance().save(gameContext);
            new OutputUtils().displayByMessageKey("game.saving.state.success");
        } catch (IOException e) {
            new LoggerUtils().logError("Failed to save file", e);
            new OutputUtils().displayByMessageKey("game.saving.state.failed");
        }
        GameContextService.getInstance().goBackToMainMenu(gameContext);
    }
}
