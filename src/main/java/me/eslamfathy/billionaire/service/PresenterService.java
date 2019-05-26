package me.eslamfathy.billionaire.service;

import me.eslamfathy.billionaire.actions.Action;
import me.eslamfathy.billionaire.actions.ActionsFactory;
import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.model.Player;
import me.eslamfathy.billionaire.model.Question;
import me.eslamfathy.billionaire.states.QuestionState;
import me.eslamfathy.billionaire.states.State;
import me.eslamfathy.billionaire.utils.Constants;
import me.eslamfathy.billionaire.utils.FileUtils;
import me.eslamfathy.billionaire.utils.OutputUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PresenterService {
    private OutputUtils outputUtils = new OutputUtils();
    private FileUtils fileUtils = new FileUtils();
    private static PresenterService presenterService;

    private PresenterService() {
    }

    public static PresenterService getInstance() {
        if (presenterService == null) {
            presenterService = new PresenterService();
        }
        return presenterService;
    }

    public void sayPromo() {
        outputUtils.displayByMessageKey("welcome.state.game.promo");
        outputUtils.sleep(1.0);
    }

    public void introducePresenter(GameContext gameContext) {
        outputUtils.displayByMessageKey("welcome.state.presenter.name", gameContext.getPresenter().getName());
        outputUtils.sleep(1.0);
    }

    public Integer askMainMenuChoices(Integer numberOfChoices) {
        outputUtils.displayByMessageKey("main.menu.state");
        Integer choice = PlayerService.getInstance().choose();
        if (choice < 0 || choice > numberOfChoices) {
            choice = askMainMenuChoices(numberOfChoices);
        }
        return choice;
    }

    public String askPlayerName() {
        outputUtils.displayByMessageKey("player.name.state");
        return PlayerService.getInstance().reply();
    }

    public void welcomePlayer(Player player) {
        outputUtils.displayByMessageKey("welcome.player.state", player.getName());
        outputUtils.sleep(2.0);
    }

    public String askLoadFileName() throws IOException {
        List<String> savedFiles = fileUtils.getSavedFiles(Constants.SAVE_PATH);
        outputUtils.display(savedFiles.stream().map(String::valueOf).collect(Collectors.joining()));
        String fileName = PlayerService.getInstance().reply();
        if (!savedFiles.contains(fileName)) {
            fileName = askLoadFileName();
        }
        return fileName;
    }

    public void respondCorrectAnswer(Question question) {
        outputUtils.displayByMessageKey("question.state.correct.answer");
        if (question.getAnswerExplanation() != null) {
            outputUtils.display(question.getAnswerExplanation());
        }
        outputUtils.sleep(2.0);
    }

    public void respondWrongAnswer() {
        outputUtils.displayByMessageKey("question.state.wrong.answer");
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
        outputUtils.displayByMessageKey("question.state", messageArgs.toArray(new String[0]));
    }

    private Action getChoiceAction(Question question) {
        try {
            return ActionsFactory.getInstance().getAction(question, PlayerService.getInstance().reply());
        } catch (IllegalArgumentException e) {
            return getChoiceAction(question);
        }
    }

    public void sayResult(Player player) {
        outputUtils.displayByMessageKey("result.state", getPrizeValue(player).toString());
        outputUtils.sleep(3.0);
    }

    public void congratulateWinnerPlayer() {
        outputUtils.displayByMessageKey("winner.state.billionaire");
        outputUtils.sleep(3.0);
    }

    private Long getPrizeValue(Player player) {
        State currentState = player.getLastState();
        if (currentState instanceof QuestionState) {
            QuestionState questionState = (QuestionState) currentState;
            return questionState.getQuestion().getPrize().getPrizeValue();
        }
        return 0L;
    }
}
