package me.eslamfathy.billionaire.service;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.states.MainMenuState;
import me.eslamfathy.billionaire.states.PromoState;
import me.eslamfathy.billionaire.states.ResultState;
import me.eslamfathy.billionaire.states.WinnerState;
import me.eslamfathy.billionaire.utils.Constants;
import me.eslamfathy.billionaire.utils.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class GameContextServiceTest {

    private FileUtils fileUtils = new FileUtils();

    @Before
    public void setUp() {
        try {
            fileUtils.createDirectory(Constants.SAVE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            fileUtils.deleteFolder(Constants.SAVE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createPlayerWithNullName() {
        assertNull(GameContextService.getInstance().createNewGame(null));
    }

    @Test
    public void createPlayerWithName() {
        assertNotNull(GameContextService.getInstance().createNewGame("Joe"));
    }

    @Test(expected = FileNotFoundException.class)
    public void loadPlayerNullName() throws IOException, ClassNotFoundException {
        assertNull(GameContextService.getInstance().load(null));
    }

    @Test(expected = FileNotFoundException.class)
    public void loadPlayerNotExist() throws IOException, ClassNotFoundException {
        GameContextService.getInstance().load("Jane");
    }

    @Test
    public void loadPlayerExist() throws IOException, ClassNotFoundException {
        GameContext gameContext = new GameContext();
        gameContext.getPlayer().setName("Jane");
        GameContextService.getInstance().save(gameContext);
        assertNotNull(GameContextService.getInstance().load("Jane"));
    }

    @Test(expected = IOException.class)
    public void loadPlayerException() throws IOException, ClassNotFoundException {
        assertNull(GameContextService.getInstance().load("Jane"));
    }

    @Test(expected = IOException.class)
    public void savePlayerNullName() throws IOException {
        GameContextService.getInstance().save(new GameContext());
    }

    @Test(expected = IOException.class)
    public void savePlayerException() throws IOException {
        GameContextService.getInstance().save(new GameContext());
    }

    @Test
    public void initialize() {
        GameContext gameContext = new GameContext();
        GameContextService.getInstance().initialize(gameContext);
        assertTrue(gameContext.getStates().peek() instanceof PromoState);
    }

    @Test
    public void addNextState() {
        GameContext gameContext = new GameContext();
        GameContextService.getInstance().addNextState(gameContext, new WinnerState());
        assertTrue(gameContext.getStates().peek() instanceof WinnerState);
    }

    @Test
    public void goBackToMainMenu() {
        GameContext gameContext = new GameContext();
        GameContextService.getInstance().goBackToMainMenu(gameContext);
        assertTrue(gameContext.getStates().peek() instanceof MainMenuState);
    }

    @Test
    public void gotToResult() {
        GameContext gameContext = new GameContext();
        GameContextService.getInstance().gotToResult(gameContext);
        assertTrue(gameContext.getStates().peek() instanceof ResultState);
    }

    @Test
    public void addQuestionsStates() {
        GameContext gameContext = new GameContext();
        GameContextService.getInstance().addQuestionsStates(gameContext);
        assertFalse(gameContext.getStates().isEmpty());
    }
}