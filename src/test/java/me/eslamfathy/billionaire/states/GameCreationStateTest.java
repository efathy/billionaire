package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.service.PresenterService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GameCreationStateTest {

    //TODO
//    private MessageUtils messageUtils = new MessageUtils();
//
//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final ByteArrayInputStream inContent = new ByteArrayInputStream("Joe".getBytes());
//    private final PrintStream originalOut = System.out;
//    private final InputStream originalIn = System.in;
//
//    @Before
//    public void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//        System.setIn(inContent);
//    }
//
//    @After
//    public void restoreStreams() {
//        System.setOut(originalOut);
//        System.setIn(originalIn);
//    }

    @Test
    public void start() {
        PresenterService presenterService = Mockito.mock(PresenterService.class);
        GameCreationState gameCreationState = new GameCreationState(presenterService);
        GameContext gameContext = new GameContext();
        gameCreationState.start(gameContext);
        Assert.assertTrue(gameContext.getStates().size() > 0);
    }
}