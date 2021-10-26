package com.rps.entities;

public class PlayerScissor extends Player {

    public PlayerScissor(String name) {
        super(name);
    }


    @Override
    public String generateChoice() {

        return "SCISSOR";
    }

}
