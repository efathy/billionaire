package me.eslamfathy.billionaire.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionServiceTest {

    @Test
    public void generateNotNull() {
        QuestionService questionService = new QuestionService();
        assertNotNull(questionService.generate());
    }

    @Test
    public void generateNotEmpty() {
        QuestionService questionService = new QuestionService();
        assertTrue(questionService.generate().size() > 0);
    }
}