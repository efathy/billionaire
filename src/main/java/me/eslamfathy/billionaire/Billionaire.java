package me.eslamfathy.billionaire;

import me.eslamfathy.billionaire.controller.GameController;

public class Billionaire {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.start();
    }
}
