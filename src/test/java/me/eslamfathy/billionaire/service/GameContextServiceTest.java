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
        GameContextService gameContextService = new GameContextService();
        assertNull(gameContextService.createNewGame(null));
    }

    @Test
    public void createPlayerWithName() {
        GameContextService gameContextService = new GameContextService();
        assertNotNull(gameContextService.createNewGame("Joe"));
    }

    @Test(expected = FileNotFoundException.class)
    public void loadPlayerNullName() throws IOException, ClassNotFoundException {
        GameContextService gameContextService = new GameContextService();
        assertNull(gameContextService.load(null));
    }

    @Test(expected = FileNotFoundException.class)
    public void loadPlayerNotExist() throws IOException, ClassNotFoundException {
        GameContextService gameContextService = new GameContextService();
        gameContextService.load("Jane");
    }

    @Test
    public void loadPlayerExist() throws IOException, ClassNotFoundException {
        GameContextService gameContextService = new GameContextService();
        GameContext gameContext = new GameContext();
        gameContext.getPlayer().setName("Jane");
        gameContextService.save(gameContext);
        assertNotNull(gameContextService.load("Jane"));
    }

    @Test(expected = IOException.class)
    public void loadPlayerException() throws IOException, ClassNotFoundException {
        GameContextService gameContextService = new GameContextService();
        assertNull(gameContextService.load("Jane"));
    }

    @Test(expected = IOException.class)
    public void savePlayerNullName() throws IOException {
        GameContextService gameContextService = new GameContextService();
        gameContextService.save(new GameContext());
    }

    @Test(expected = IOException.class)
    public void savePlayerException() throws IOException {
        GameContextService gameContextService = new GameContextService();
        gameContextService.save(new GameContext());
    }

    @Test
    public void initialize() {
        GameContextService gameContextService = new GameContextService();
        GameContext gameContext = new GameContext();
        gameContextService.initialize(gameContext);
        assertTrue(gameContext.getStates().peek() instanceof PromoState);
    }

    @Test
    public void addNextState() {
        GameContextService gameContextService = new GameContextService();
        GameContext gameContext = new GameContext();
        gameContextService.addNextState(gameContext, new WinnerState());
        assertTrue(gameContext.getStates().peek() instanceof WinnerState);
    }

    @Test
    public void goBackToMainMenu() {
        GameContextService gameContextService = new GameContextService();
        GameContext gameContext = new GameContext();
        gameContextService.goBackToMainMenu(gameContext);
        assertTrue(gameContext.getStates().peek() instanceof MainMenuState);
    }

    @Test
    public void gotToResult() {
        GameContextService gameContextService = new GameContextService();
        GameContext gameContext = new GameContext();
        gameContextService.gotToResult(gameContext);
        assertTrue(gameContext.getStates().peek() instanceof ResultState);
    }

    @Test
    public void addQuestionsStates() {
        GameContextService gameContextService = new GameContextService();
        GameContext gameContext = new GameContext();
        gameContextService.addQuestionsStates(gameContext);
        assertFalse(gameContext.getStates().isEmpty());
    }
}