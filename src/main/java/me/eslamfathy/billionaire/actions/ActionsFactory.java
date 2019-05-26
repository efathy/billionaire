package me.eslamfathy.billionaire.actions;

import me.eslamfathy.billionaire.model.Question;
import me.eslamfathy.billionaire.service.PresenterService;
import me.eslamfathy.billionaire.utils.Constants;
import me.eslamfathy.billionaire.utils.LoggerUtils;

public class ActionsFactory {
    private LoggerUtils loggerUtils = new LoggerUtils();

    private static ActionsFactory actionsFactory;

    private ActionsFactory() {
    }

    public static ActionsFactory getInstance() {
        if (actionsFactory == null) {
            actionsFactory = new ActionsFactory();
        }
        return actionsFactory;
    }

    public Action getAction(Question question, String choice) {
        if (Constants.SAVE_KEY.equalsIgnoreCase(choice)) {
            return new GameSavingAction();
        } else if (Constants.QUIT_KEY.equalsIgnoreCase(choice)) {
            return new GameQuitingAction();
        } else if (question.getChoices().containsKey(choice)) {
            if (PresenterService.getInstance().isCorrectAnswer(question, Integer.parseInt(choice))) {
                return new CorrectAnswerAction();
            } else {
                return new WrongAnswerAction();
            }
        }
        throw new IllegalArgumentException(choice);
    }

    private boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            loggerUtils.logDebug("choice wasn't number");
            return false;
        }
    }
}
