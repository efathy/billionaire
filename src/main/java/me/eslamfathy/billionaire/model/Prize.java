package me.eslamfathy.billionaire.model;

public enum Prize {
    A(100),
    B(500),
    C(1000),
    D(16000),
    E(32000),
    F(64000),
    G(500000),
    H(1000000);

    private int prizeValue;

    Prize(int prizeValue) {
        this.prizeValue = prizeValue;
    }

    public int getPrizeValue() {
        return prizeValue;
    }
}
