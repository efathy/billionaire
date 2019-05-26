package me.eslamfathy.billionaire.service;

import me.eslamfathy.billionaire.model.Question;
import org.junit.Test;

import java.util.Queue;

import static org.junit.Assert.*;

public class QuestionsGeneratorTest {

    @Test
    public void generate() {
        Queue<Question> questions = QuestionsGenerator.getInstance().generate();
        assertFalse(questions.isEmpty());
    }
}