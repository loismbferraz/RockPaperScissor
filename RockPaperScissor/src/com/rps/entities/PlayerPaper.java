package com.rps.entities;

public class PlayerPaper extends Player {

    public PlayerPaper(String name) {
        super(name);
    }


    @Override
    public String generateChoice() {

        return "PAPER";
    }
}
