package me.eslamfathy.billionaire.states;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.model.Question;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.service.PresenterService;

public class QuestionState implements State {
    private PresenterService presenterService = new PresenterService();
    private GameContextService gameContextService = new GameContextService();

    private Question question;

    public Question getQuestion() {
        return question;
    }

    public QuestionState(Question question) {
        this.question = question;
    }

    @Override
    public void start(GameContext gameContext) {
        Integer choice = presenterService.askQBillionaireQuestionChoice(this.question, gameContext);
        boolean correctAnswer = presenterService.respondQuestionAnswer(this.question, choice);
        if (!correctAnswer) {
            gameContextService.gotToResult(gameContext);
        }
    }

}
