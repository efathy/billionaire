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
public class GameCreationStateTest {
    private final static String PLAYER_NAME = "JOE";

    @Mock
    private PresenterService presenterService;

    @Test
    public void start() {
        PowerMockito.mockStatic(PresenterService.class);
        Mockito.when(PresenterService.getInstance()).thenReturn(presenterService);
        Mockito.when(presenterService.askPlayerName()).thenReturn(PLAYER_NAME);

        GameContext gameContext = new GameContext();
        new GameCreationState().start(gameContext);
        Assert.assertFalse(gameContext.getStates().isEmpty());
        Assert.assertEquals(PLAYER_NAME, gameContext.getPlayer().getName());
    }
}