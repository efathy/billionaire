package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.PresenterService;
import me.eslamfathy.billionaire.utils.Constants;
import me.eslamfathy.billionaire.utils.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameLoadingStateTest {
    private final static String PLAYER_NAME = "JOE";

    @Test
    public void start() throws IOException {
        PresenterService presenterService = Mockito.mock(PresenterService.class);
        Mockito.when(presenterService.askLoadFileName()).thenReturn(PLAYER_NAME);

        GameLoadingState gameLoadingState = new GameLoadingState(presenterService);
        GameContext gameContext = new GameContext();
        gameContext.getPlayer().setName(PLAYER_NAME);
        gameContext.getStates().add(new WinnerState());
        FileUtils fileUtils = new FileUtils();
        fileUtils.save(gameContext, Constants.SAVE_PATH, fileUtils.getSaveFileName(PLAYER_NAME));
        gameLoadingState.start(gameContext);

        Assert.assertEquals(2, gameContext.getStates().size());
    }
}