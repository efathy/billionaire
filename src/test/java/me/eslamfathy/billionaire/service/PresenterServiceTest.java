package me.eslamfathy.billionaire.service;

import me.eslamfathy.billionaire.actions.CorrectAnswerAction;
import me.eslamfathy.billionaire.actions.GameQuitingAction;
import me.eslamfathy.billionaire.actions.GameSavingAction;
import me.eslamfathy.billionaire.actions.WrongAnswerAction;
import me.eslamfathy.billionaire.model.Prize;
import me.eslamfathy.billionaire.model.Question;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(PowerMockRunner.class)
@PrepareForTest({PlayerService.class})
public class PresenterServiceTest {

    @Mock
    private PlayerService playerService;

    @Test
    public void respondQuestionWrongAnswer() {
        PowerMockito.mockStatic(PlayerService.class);
        Mockito.when(PlayerService.getInstance()).thenReturn(playerService);
        Mockito.when(playerService.reply()).thenReturn("1");

        Question question = generateQuestion();
        Assert.assertTrue(PresenterService.getInstance().askQuestion(question) instanceof WrongAnswerAction);
    }

    @Test
    public void respondQuestionCorrectAnswer() {
        PowerMockito.mockStatic(PlayerService.class);
        Mockito.when(PlayerService.getInstance()).thenReturn(playerService);
        Mockito.when(playerService.reply()).thenReturn("3");

        Question question = generateQuestion();
        Assert.assertTrue(PresenterService.getInstance().askQuestion(question) instanceof CorrectAnswerAction);
    }

    @Test
    public void chooseSaving() {
        PowerMockito.mockStatic(PlayerService.class);
        Mockito.when(PlayerService.getInstance()).thenReturn(playerService);
        Mockito.when(playerService.reply()).thenReturn("S");

        Question question = generateQuestion();
        Assert.assertTrue(PresenterService.getInstance().askQuestion(question) instanceof GameSavingAction);
    }

    @Test
    public void chooseQuiting() {
        PowerMockito.mockStatic(PlayerService.class);
        Mockito.when(PlayerService.getInstance()).thenReturn(playerService);
        Mockito.when(playerService.reply()).thenReturn("Q");

        Question question = generateQuestion();
        Assert.assertTrue(PresenterService.getInstance().askQuestion(question) instanceof GameQuitingAction);
    }

    private Question generateQuestion() {
        Question question = new Question();
        question.setStatement(
                "what percentage of 5 to 16 year olds in the UK have a mental health problem?");
        Map<String, String> choicesMap = new HashMap<>();
        choicesMap.put("1", "1%");
        choicesMap.put("2", "5%");
        choicesMap.put("3", "10%");
        choicesMap.put("4", "20%");
        question.setChoices(choicesMap);
        question.setCorrectAnswer(3);
        question.setPrize(Prize.A);
        return question;
    }
}