package me.eslamfathy.billionaire.model;

public enum Prize {
    A(100000),
    B(500000),
    C(1000000),
    D(16000000),
    E(32000000),
    F(64000000),
    G(500000000),
    H(1000000000);

    private long prizeValue;

    Prize(long prizeValue) {
        this.prizeValue = prizeValue;
    }

    public long getPrizeValue() {
        return prizeValue;
    }
}
