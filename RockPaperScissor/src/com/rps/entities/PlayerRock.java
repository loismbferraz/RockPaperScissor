package com.rps.entities;


public class PlayerRock extends Player {

    public PlayerRock(String name) {
        super(name);
    }

    @Override
    public Choice generateChoice() {

        return Choice.ROCK;
    }

}
