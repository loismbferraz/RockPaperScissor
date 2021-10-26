package com.rps.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PlayerRandom extends Player {

//    private static final List<String> possibleChoices = new ArrayList<>(Arrays.asList("ROCK","SCISSOR","PAPER"));
    private static final List<Choice> possibleChoices = new ArrayList<>(Arrays.asList(Choice.values()));


    public PlayerRandom(String name) {
        super(name);
    }


    @Override
    public Choice generateChoice() {
        Random rand = new Random();
        return possibleChoices.get(rand.nextInt(3));
    }



}
