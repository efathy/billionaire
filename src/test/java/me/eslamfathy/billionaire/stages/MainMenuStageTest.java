package me.eslamfathy.billionaire.stages;

import me.eslamfathy.billionaire.model.Player;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MainMenuStageTest {

    @Test
    public void execute() {
        MainMenuStage mainMenuStage = new MainMenuStage();
        Player player = mainMenuStage.execute(null);
        assertTrue(player.getStages().size() > 0);
    }

    @Test
    public void executeNewGame() {
        MainMenuStage mainMenuStage = new MainMenuStage();
        Player player = mainMenuStage.execute(null);
        // TODO: 2019-05-23 add test
        assertTrue(player.getStages().size() > 0);
    }

    @Test
    public void executeLoadGame() {
        MainMenuStage mainMenuStage = new MainMenuStage();
        Player player = mainMenuStage.execute(null);
        // TODO: 2019-05-23 add test
        assertTrue(player.getStages().size() > 0);
    }

    @Test
    public void display() {
        MainMenuStage mainMenuStage = new MainMenuStage();
        String display = mainMenuStage.display(new Player());
        assertTrue(display != null && !display.isEmpty());
    }
}