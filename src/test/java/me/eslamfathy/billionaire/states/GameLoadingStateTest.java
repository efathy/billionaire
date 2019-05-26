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
public class GameLoadingStateTest {
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

        GameLoadingState gameLoadingState = new GameLoadingState();
        GameContext gameContext = new GameContext();
        gameContext.getPlayer().setName(PLAYER_NAME);
        gameContext.getStates().add(new WinnerState());
        FileUtils fileUtils = new FileUtils();
        fileUtils.save(gameContext, Constants.SAVE_PATH, fileUtils.getSaveFileName(PLAYER_NAME));
        gameLoadingState.start(gameContext);

        Assert.assertEquals(2, gameContext.getStates().size());
    }
}