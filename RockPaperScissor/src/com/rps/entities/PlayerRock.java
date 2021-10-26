package com.rps.entities;


public class PlayerRock extends Player {

    public PlayerRock(String name) {
        super(name);
    }

    @Override
    public String generateChoice() {

        return "ROCK";
    }

}
