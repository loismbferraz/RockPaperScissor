package com.rps.entities;

import java.util.Map;

public class Result {

    private String winnersName;
    private Map<Integer,String> plays;

    public Result(String winnersName, Map<Integer, String> plays) {
        this.winnersName = winnersName;
        this.plays = plays;
    }

    public String getWinnersName() {
        return winnersName;
    }

    public void setWinnersName(String winnersName) {
        this.winnersName = winnersName;
    }

    public Map<Integer, String> getPlays() {
        return plays;
    }

    public void setPlays(Map<Integer, String> plays) {
        this.plays = plays;
    }
}
