package me.eslamfathy.billionaire.actions;

import me.eslamfathy.billionaire.model.GameContext;
import me.eslamfathy.billionaire.model.Question;
import me.eslamfathy.billionaire.service.GameContextService;
import me.eslamfathy.billionaire.states.GameSavingState;
import me.eslamfathy.billionaire.states.QuestionState;

public class GameSavingAction implements Action {
    @Override
    public void doAction(GameContext gameContext, Question question) {
        GameContextService.getInstance().addNextState(gameContext, new QuestionState(question));
        GameContextService.getInstance().addNextState(gameContext, new GameSavingState());
    }
}
