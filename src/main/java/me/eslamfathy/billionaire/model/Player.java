package me.eslamfathy.billionaire.model;

public class Player extends Human {

    private Prize lastPrize;

    public Prize getLastPrize() {
        return lastPrize;
    }

    public void setLastPrize(Prize lastPrize) {
        this.lastPrize = lastPrize;
    }
}
