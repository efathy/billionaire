package me.eslamfathy.billionaire.service;

import me.eslamfathy.billionaire.utils.InputUtils;

public class PlayerService {

    private InputUtils inputUtils = new InputUtils();
    private static PlayerService playerService;

    private PlayerService() {
    }

    public static PlayerService getInstance() {
        if (playerService == null) {
            playerService = new PlayerService();
        }
        return playerService;
    }

    public Integer choose() {
        return inputUtils.readInteger();
    }

    public String reply() {
        return inputUtils.readString();
    }
}
