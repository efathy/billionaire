package me.eslamfathy.billionaire.actions;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.model.Question;
import me.eslamfathy.billionaire.service.PresenterService;

public class CorrectAnswerAction implements Action {
    @Override
    public void doAction(GameContext gameContext, Question question) {
        PresenterService.getInstance().respondCorrectAnswer(question);
    }
}
