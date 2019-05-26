package me.eslamfathy.billionaire.service;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.model.Question;
import me.eslamfathy.billionaire.states.*;
import me.eslamfathy.billionaire.utils.Constants;
import me.eslamfathy.billionaire.utils.FileUtils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

public class GameContextService {

    private FileUtils fileUtils = new FileUtils();
    private static GameContextService gameContextService;

    private GameContextService() {
    }

    public static GameContextService getInstance() {
        if (gameContextService == null) {
            gameContextService = new GameContextService();
        }
        return gameContextService;
    }

    public void initialize(GameContext gameContext) {
        gameContext.getStates().add(new PromoState());
        gameContext.getStates().add(new MainMenuState());
    }

    public void addNextState(GameContext gameContext, State state) {
        ((LinkedList) gameContext.getStates()).addFirst(state);
    }

    public void goBackToMainMenu(GameContext gameContext) {
        gameContext.getStates().clear();
        addNextState(gameContext, new MainMenuState());
    }

    public void gotToResult(GameContext gameContext) {
        gameContext.getStates().clear();
        addNextState(gameContext, new ResultState());
    }

    public GameContext createNewGame(String playerName) {
        if (playerName != null) {
            GameContext gameContext = new GameContext();
            gameContext.getPlayer().setName(playerName);
            addQuestionsStates(gameContext);
            addNextState(gameContext, new WinnerState());
            return gameContext;
        }
        return null;
    }

    public GameContext load(String name) throws IOException, ClassNotFoundException {
        Optional<Object> loadedObject = fileUtils.load(Constants.SAVE_PATH, fileUtils.getSaveFileName(name));
        return loadedObject.map(object -> (GameContext) object).orElseThrow(ClassNotFoundException::new);
    }

    public void save(GameContext gameContext) throws IOException {
        String playerName = gameContext.getPlayer().getName();
        if (playerName != null) {
            fileUtils.save(gameContext, Constants.SAVE_PATH, fileUtils.getSaveFileName(playerName));
        } else {
            throw new IOException("Invalid file name");
        }
    }


    public void addQuestionsStates(GameContext gameContext) {
        Queue<Question> questions = QuestionsGenerator.getInstance().generate();
        List<QuestionState> questionStates = questions.stream().map(QuestionState::new).collect(Collectors.toList());
        gameContext.getStates().addAll(questionStates);
    }
}
