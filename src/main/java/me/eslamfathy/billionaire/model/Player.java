package me.eslamfathy.billionaire.model;

import me.eslamfathy.billionaire.stages.Stage;

import java.util.Queue;

public class Player {
    private String name;
    private Queue<Stage> stages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Queue<Stage> getStages() {
        return stages;
    }

    public void setStages(Queue<Stage> stages) {
        this.stages = stages;
    }
}
