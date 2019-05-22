package me.eslamfathy.billionaire.stages;

import me.eslamfathy.billionaire.model.Player;
import me.eslamfathy.billionaire.model.Question;

public class QuestionStage implements Stage, Displayable {

    private Question question;

    public QuestionStage(Question question){

    }

    public Player execute(Player player) {
        return new Player();
    }

    public String display(Player player) {
        return null;
    }
}
