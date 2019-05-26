package me.eslamfathy.billionaire.service;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.model.Player;
import me.eslamfathy.billionaire.model.Question;
import me.eslamfathy.billionaire.states.QuestionState;
import me.eslamfathy.billionaire.states.State;
import me.eslamfathy.billionaire.utils.Constants;
import me.eslamfathy.billionaire.utils.FileUtils;
import me.eslamfathy.billionaire.utils.OutputUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PresenterService {
    private OutputUtils outputUtils = new OutputUtils();
    private PlayerService playerService = new PlayerService();
    private FileUtils fileUtils = new FileUtils();

    public PresenterService(){}

    public PresenterService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void sayPromo() {
        outputUtils.displayByMessageKey("welcome.state.game.promo");
        outputUtils.sleep(1.0);
    }

    public void introducePresenter(GameContext gameContext) {
        outputUtils.displayByMessageKey("welcome.state.presenter.name", gameContext.getPresenter().getName());
        outputUtils.sleep(1.0);
    }

    public Integer askMainMenuChoices() {
        outputUtils.displayByMessageKey("main.menu.state");
        return playerService.choose();
        //TODO if player didn't answer correctly
    }

    public String askPlayerName() {
        outputUtils.displayByMessageKey("player.name.state");
        return playerService.reply();
    }

    public void welcomePlayer(Player player) {
        outputUtils.displayByMessageKey("welcome.player.state", player.getName());
        outputUtils.sleep(2.0);
    }

    public String askLoadFileName() throws IOException {
        List<String> savedFiles = fileUtils.getSavedFiles(Constants.SAVE_PATH);
        outputUtils.display(savedFiles.stream().map(String::valueOf).collect(Collectors.joining()));
        return playerService.reply();
        //TODO if player didn't answer correctly
    }

    public boolean respondQuestionAnswer(Question question, Integer choice) {
        boolean correctAnswer = isCorrectAnswer(question, choice);
        if (correctAnswer) {
            outputUtils.displayByMessageKey("question.state.correct.answer");
            outputUtils.display(question.getAnswerExplanation());
        } else {
            outputUtils.displayByMessageKey("question.state.wrong.answer");
        }
        outputUtils.sleep(3.0);
        return correctAnswer;
    }

    private boolean isCorrectAnswer(Question question, Integer answer) {
        return question.getCorrectAnswer().equals(answer);
    }

    public boolean isValidChoice(Question question, Integer choice) {
        return question.getChoices().containsKey(choice);
    }

    public Integer askQBillionaireQuestionChoice(Question question, GameContext gameContext) {
        outputUtils.displayByMessageKey("question.state", String.valueOf(question.getPrize().getPrizeValue()), question
                .getStatement(), Arrays.toString(question.getChoices().entrySet().toArray()));
        return getValidChoice(question, gameContext);
    }

    private Integer getValidChoice(Question question, GameContext gameContext) {
        Integer choice = -1;
        boolean validChoice = false;
        while (!validChoice) {
            choice = playerService.choose();
            validChoice = isValidChoice(question, choice);
            if (!validChoice) {
                outputUtils.displayByMessageKey("question.state.invalid.choice", gameContext.getPlayer().getName());
            }
        }
        return choice;
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
