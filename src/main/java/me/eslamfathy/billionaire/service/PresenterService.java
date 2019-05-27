package me.eslamfathy.billionaire.service;

import me.eslamfathy.billionaire.actions.Action;
import me.eslamfathy.billionaire.actions.ActionsFactory;
import me.eslamfathy.billionaire.model.*;
import me.eslamfathy.billionaire.states.GameCreationState;
import me.eslamfathy.billionaire.states.GameLoadingState;
import me.eslamfathy.billionaire.states.State;
import me.eslamfathy.billionaire.utils.Constants;
import me.eslamfathy.billionaire.utils.FileUtils;
import me.eslamfathy.billionaire.utils.OutputUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PresenterService {
    private OutputUtils outputUtils = new OutputUtils();
    private FileUtils fileUtils = new FileUtils();
    private static PresenterService presenterService;
    private Map<String, State> mainMenuChoices;

    private PresenterService() {
        mainMenuChoices = getMainMenuChoices();
    }

    public static PresenterService getInstance() {
        if (presenterService == null) {
            presenterService = new PresenterService();
        }
        return presenterService;
    }

    public void sayPromo() {
        outputUtils.displayAsciiStatementByMessageKey(15, "welcome.state.game.promo");
        outputUtils.sleep(1.0);
    }

    public void introducePresenter(GameContext gameContext) {
        outputUtils.displayColoredStatement(Color.BLUE, "welcome.state.presenter.name", gameContext.getPresenter()
                                                                                                   .getName());
        outputUtils.sleep(1.0);
    }

    public State askMainMenuAndGetNextState() {
        outputUtils.displayColoredStatement(Color.BLUE, "main.menu.state");
        String choice = PlayerService.getInstance().reply();
        if (!mainMenuChoices.containsKey(choice)) {
            return askMainMenuAndGetNextState();
        }
        return mainMenuChoices.get(choice);
    }

    private Map<String, State> getMainMenuChoices() {
        Map<String, State> choices = new HashMap<>();
        choices.put("1", new GameCreationState());
        choices.put("2", new GameLoadingState());
        return choices;
    }

    public String askPlayerName() {
        outputUtils.displayColoredStatement(Color.BLUE, "player.name.state");
        return PlayerService.getInstance().reply();
    }

    public void welcomePlayer(Player player) {
        outputUtils.displayColoredStatement(Color.BLUE, "welcome.player.state", player.getName());
        outputUtils.sleep(2.0);
    }

    public String askLoadFileName() throws IOException {
        List<String> savedFiles = fileUtils.getSavedFiles(Constants.SAVE_PATH);
        outputUtils.display(
                "Saves Available: " + savedFiles.stream().map(String::valueOf).collect(Collectors.joining(" - ")));
        String fileName = PlayerService.getInstance().reply();
        if (!savedFiles.contains(fileName)) {
            fileName = askLoadFileName();
        }
        return fileName;
    }

    public void respondCorrectAnswer(Question question) {
        outputUtils.displayColoredStatement(Color.GREEN, "question.state.correct.answer");
        if (question.getAnswerExplanation() != null) {
            outputUtils.display(question.getAnswerExplanation());
        }
        outputUtils.sleep(2.0);
    }

    public void respondWrongAnswer() {
        outputUtils.displayColoredStatement(Color.RED, "question.state.wrong.answer");
        outputUtils.sleep(2.0);
    }

    public boolean isCorrectAnswer(Question question, Integer answer) {
        return question.getCorrectAnswer().equals(answer);
    }

    public Action askQuestion(Question question) {
        displayQuestion(question);
        return getChoiceAction(question);
    }

    private void displayQuestion(Question question) {
        List<String> messageArgs = new ArrayList<>();
        messageArgs.add(String.valueOf(question.getPrize().getPrizeValue()));
        messageArgs.add(question.getStatement());
        messageArgs.addAll(question.getChoices().values());
        outputUtils.displayColoredStatement(Color.BLUE, "question.state", messageArgs.toArray(new String[0]));
    }

    private Action getChoiceAction(Question question) {
        try {
            return ActionsFactory.getInstance().getAction(question, PlayerService.getInstance().reply());
        } catch (IllegalArgumentException e) {
            return getChoiceAction(question);
        }
    }

    public void sayResult(Player player) {
        Long prize = Optional.ofNullable(player).map(Player::getLastPrize).map(Prize::getPrizeValue).orElse(0L);
        if (prize > 0L) {
            outputUtils.displayColoredStatement(Color.GREEN, "result.state.success", String.valueOf(prize));
        } else {
            outputUtils.displayColoredStatement(Color.RED, "result.state.failure");
        }
        outputUtils.sleep(3.0);
    }

    public void congratulateWinnerPlayer() {
        outputUtils.displayAsciiStatementByMessageKey(14, "winner.state.billionaire");
        outputUtils.sleep(3.0);
    }
}
