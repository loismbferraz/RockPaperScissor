package com.rps.entities;

public abstract class Player {

    private String name;
    private Integer wins;


    public Player(String name) {
        this.name = name;
        this.wins = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public abstract String generateChoice();

}
