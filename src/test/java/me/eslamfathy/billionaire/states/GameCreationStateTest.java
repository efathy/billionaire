package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.PresenterService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GameCreationStateTest {

    @Test
    public void start() {
        PresenterService presenterService = Mockito.mock(PresenterService.class);
        GameCreationState gameCreationState = new GameCreationState(presenterService);
        GameContext gameContext = new GameContext();
        gameCreationState.start(gameContext);
        Assert.assertFalse(gameContext.getStates().isEmpty());
    }
}