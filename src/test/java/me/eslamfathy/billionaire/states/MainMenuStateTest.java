package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.PresenterService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({PresenterService.class})
public class MainMenuStateTest {

    @Mock
    private PresenterService presenterService;

    @Test
    public void startNewGame() {
        PowerMockito.mockStatic(PresenterService.class);
        Mockito.when(PresenterService.getInstance()).thenReturn(presenterService);
        Mockito.when(presenterService.askMainMenuAndGetNextState()).thenReturn(new GameCreationState());

        MainMenuState mainMenuState = new MainMenuState();
        GameContext gameContext = new GameContext();
        mainMenuState.start(gameContext);

        Assert.assertTrue(gameContext.getStates().peek() instanceof GameCreationState);
    }

    @Test
    public void startLoadGame() {
        PowerMockito.mockStatic(PresenterService.class);
        Mockito.when(PresenterService.getInstance()).thenReturn(presenterService);
        Mockito.when(presenterService.askMainMenuAndGetNextState()).thenReturn(new GameLoadingState());

        MainMenuState mainMenuState = new MainMenuState();
        GameContext gameContext = new GameContext();
        mainMenuState.start(gameContext);

        Assert.assertTrue(gameContext.getStates().peek() instanceof GameLoadingState);
    }
}