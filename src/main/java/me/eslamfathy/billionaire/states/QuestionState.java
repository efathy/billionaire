package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.actions.Action;
import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.model.Question;
import me.eslamfathy.billionaire.service.PresenterService;

public class QuestionState implements State {

    private Question question;

    public Question getQuestion() {
        return question;
    }

    public QuestionState(Question question) {
        this.question = question;
    }

    @Override
    public void start(GameContext gameContext) {
        Action choiceAction = PresenterService.getInstance().askQuestion(this.question);
        choiceAction.doAction(gameContext, question);
    }
}
