package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.PresenterService;
import me.eslamfathy.billionaire.utils.Constants;
import me.eslamfathy.billionaire.utils.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;

@RunWith(PowerMockRunner.class)
@PrepareForTest({PresenterService.class})
public class GameSavingStateTest {
    private final static String PLAYER_NAME = "JOE";

    @Mock
    private PresenterService presenterService;

    private FileUtils fileUtils = new FileUtils();

    @After
    public void tearDown() throws IOException {
        fileUtils.deleteFolder(Constants.SAVE_PATH);
    }

    @Test
    public void start() throws IOException {
        PowerMockito.mockStatic(PresenterService.class);
        Mockito.when(PresenterService.getInstance()).thenReturn(presenterService);
        Mockito.when(presenterService.askLoadFileName()).thenReturn(PLAYER_NAME);

        GameSavingState gameSavingState = new GameSavingState();
        GameContext gameContext = new GameContext();
        gameContext.getPlayer().setName(PLAYER_NAME);
        gameContext.getStates().add(new WinnerState());

        gameSavingState.start(gameContext);

        Assert.assertEquals(1, fileUtils.getSavedFiles(Constants.SAVE_PATH).size());
    }
}