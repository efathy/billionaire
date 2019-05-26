package me.eslamfathy.billionaire.service;

import me.eslamfathy.billionaire.utils.InputUtils;

public class PlayerService {

    private InputUtils inputUtils = new InputUtils();

    public Integer choose() {
        return inputUtils.readInteger();
    }

    public String reply() {
        return inputUtils.readString();
    }
}
