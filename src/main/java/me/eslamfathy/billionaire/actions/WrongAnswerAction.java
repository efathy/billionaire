package me.eslamfathy.billionaire.actions;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.model.Question;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.service.PresenterService;

public class WrongAnswerAction implements Action {
    @Override
    public void doAction(GameContext gameContext, Question question) {
        PresenterService.getInstance().respondWrongAnswer();
        GameContextService.getInstance().gotToResult(gameContext);
    }
}
