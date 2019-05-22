package me.eslamfathy.billionaire.stages;

import me.eslamfathy.billionaire.model.Player;

public class MainMenuStage implements Stage, Displayable {
    public Player execute(Player player) {
        return new Player();
    }

    public String display(Player player) {
        return null;
    }
}
