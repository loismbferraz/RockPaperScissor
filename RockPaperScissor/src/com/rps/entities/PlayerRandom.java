package com.rps.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PlayerRandom extends Player {

    private static final List<String> possibleChoices = new ArrayList<>(Arrays.asList("ROCK","SCISSOR","PAPER"));


    public PlayerRandom(String name) {
        super(name);
    }


    @Override
    public String generateChoice() {
        Random rand = new Random();
        return possibleChoices.get(rand.nextInt(3));
    }



}
