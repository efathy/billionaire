package me.eslamfathy.billionaire.stages;

import me.eslamfathy.billionaire.model.Player;
import me.eslamfathy.billionaire.model.Question;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionStageTest {

    @Test
    public void executePlayerAnswerCorrect() {
        // TODO: 2019-05-23
    }

    @Test
    public void executePlayerAnswerWrong() {
        // TODO: 2019-05-23
    }

    @Test
    public void executePlayerWantedEliminateTwoOptions() {
        // TODO: 2019-05-23
    }

    @Test
    public void executePlayerWantedSaveProgress() {
        // TODO: 2019-05-23
    }

    @Test
    public void executePlayerWantedQuit() {
        // TODO: 2019-05-23
    }

    @Test
    public void display() {
        QuestionStage questionStage = new QuestionStage(new Question());
        String display = questionStage.display(new Player());
        assertTrue(display != null && !display.isEmpty());
    }
}