package me.eslamfathy.billionaire.model;

import java.io.Serializable;

public class Human implements Serializable {
    protected static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
