package com.rps.entities;

public class Game {

    private Player player1;
    private Player player2;
    private Integer rounds;
    private Result result;


    public Game(Player player1, Player player2, Integer rounds) {
        this.player1 = player1;
        this.player2 = player2;
        this.rounds = rounds;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Integer getRounds() {
        return rounds;
    }

    public void setRounds(Integer rounds) {
        this.rounds = rounds;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
