package me.eslamfathy.billionaire.stages;

import me.eslamfathy.billionaire.model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResultStageTest {

    @Test
    public void execute() {
        ResultStage resultStage = new ResultStage();
        Player player = resultStage.execute(new Player());
        assertTrue(player.getStages().isEmpty());
    }

    @Test
    public void display() {
        ResultStage resultStage = new ResultStage();
        String display = resultStage.display(new Player());
        assertTrue(display != null && !display.isEmpty());
    }
}