package me.eslamfathy.billionaire.model;

import java.io.Serializable;

public class Presenter extends Human implements Serializable {
    private static final long serialVersionUID = 1L;

    public Presenter(String name) {
        setName(name);
    }

}
