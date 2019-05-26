package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.actions.CorrectAnswerAction;
import me.eslamfathy.billionaire.actions.GameSavingAction;
import me.eslamfathy.billionaire.actions.WrongAnswerAction;
import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.model.Prize;
import me.eslamfathy.billionaire.model.Question;
import me.eslamfathy.billionaire.service.PresenterService;
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
@PrepareForTest({PresenterService.class})
public class QuestionStateTest {

    @Mock
    private PresenterService presenterService;

    @Test
    public void executePlayerAnswerCorrect() {
        Question question = generateQuestion();
        QuestionState questionStage = new QuestionState(question);
        GameContext gameContext = new GameContext();
        gameContext.getStates().add(new QuestionState(new Question()));
        PowerMockito.mockStatic(PresenterService.class);
        Mockito.when(PresenterService.getInstance()).thenReturn(presenterService);
        Mockito.when(presenterService.askQuestion(question)).thenReturn(new CorrectAnswerAction());

        questionStage.start(gameContext);
        Assert.assertTrue(gameContext.getStates().peek() instanceof QuestionState);
    }

    @Test
    public void executePlayerAnswerWrong() {
        Question question = generateQuestion();
        QuestionState questionStage = new QuestionState(question);
        GameContext gameContext = new GameContext();
        gameContext.getStates().add(new QuestionState(new Question()));
        PowerMockito.mockStatic(PresenterService.class);
        Mockito.when(PresenterService.getInstance()).thenReturn(presenterService);
        Mockito.when(presenterService.askQuestion(question)).thenReturn(new WrongAnswerAction());

        questionStage.start(gameContext);
        Assert.assertTrue(gameContext.getStates().peek() instanceof ResultState);
    }

    @Test
    public void executePlayerSavingOption() {
        Question question = generateQuestion();
        QuestionState questionStage = new QuestionState(question);
        GameContext gameContext = new GameContext();
        gameContext.getStates().add(new QuestionState(new Question()));
        PowerMockito.mockStatic(PresenterService.class);
        Mockito.when(PresenterService.getInstance()).thenReturn(presenterService);
        Mockito.when(presenterService.askQuestion(question)).thenReturn(new GameSavingAction());

        questionStage.start(gameContext);
        Assert.assertTrue(gameContext.getStates().peek() instanceof GameSavingState);
    }

    private Question generateQuestion() {
        Question question = new Question();
        question.setStatement(
                "what percentage of 5 to 16 year olds in the UK have a mental health problem?");
        Map<Integer, String> choicesMap = new HashMap<>();
        choicesMap.put(1, "1%");
        choicesMap.put(2, "5%");
        choicesMap.put(3, "10%");
        choicesMap.put(4, "20%");
        question.setChoices(choicesMap);
        question.setCorrectAnswer(3);
        question.setPrize(Prize.A);
        return question;
    }
}