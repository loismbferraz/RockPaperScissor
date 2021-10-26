package com.rps.service;

import com.rps.entities.*;

import java.util.*;

public class GameServerImpl implements GameServer{


    @Override
    public String welcomeMessage() {

        return "=====================================\n"
                + "Welcome to Rock Paper Scissors Game";
    }


    public String playerInitMessage(int i){
        return "=====================================\n"
                + "Welcome Player " + i +"\n"
                + "=====================================\n";
    }


    @Override
    public String pleaseEnterUsername(){
        return  "Please enter your username (must be at least three characters):";
    }

    @Override
    public String pleaseEnterUsernameAgain(){
        return  "Please enter your username again (don't forget must be at least three characters):";
    }

    @Override
    public String pleaseEnterUsernameAgainAlreadyInUse(){
        return  "Please enter your username again (the desired username is already in use):";
    }


    @Override
    public String pleaseEnterGameOption(){
        return  "Please enter your game profile (only the options shown are allowed):\n"+
                "R  - RANDOM\n"+
                "AR - ALWAYS ROCK\n"+
                "AP - ALWAYS PAPER\n"+
                "AS - ALWAYS SCISSOR";
    }

    @Override
    public String pleaseEnterGameOptionAgain(){
        return  "Please enter your game profile again (don't forget only the options shown are allowed):\n"+
                "R  - RANDOM\n"+
                "AR - ALWAYS ROCK\n"+
                "AP - ALWAYS PAPER\n"+
                "AS - ALWAYS SCISSOR";
    }


    @Override
    public String pleaseEnterNumberOfRounds(){
        return  "Please enter how many rounds you want to play (number of rounds must be between one and nine):";
    }

    @Override
    public String pleaseEnterNumberOfRoundsAgain(){
        return  "Please enter how many rounds you want to play again (number of rounds must be between one and nine):";
    }


    @Override
    public Player getPlayer(final String name, final String profile){

        return switch (profile.toUpperCase()) {
            case "AR" -> new PlayerRock(name);
            case "AS" -> new PlayerScissor(name);
            case "AP" -> new PlayerPaper(name);
            default -> new PlayerRandom(name);
        };
    }

    @Override
    public Game createGame(final Player player1, final Player player2, final String nrRoundsStr){
        Integer nrRounds = Integer.parseInt(nrRoundsStr);
        return new Game(player1, player2, nrRounds);

    }


    private String whoIsTheWinner(final Player player1, final Player player2){
        String retVal = "The result is a TIE!";
        if(!(player1.getWins().equals(player2.getWins()))) {
            retVal = player1.getWins() > player2.getWins() ? player1.getName() : player2.getName();
        }
        return retVal;
    }

    @Override
    public Result playGame(final Game game){
        Result retVal;
        int i = 1;
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        Map<Integer,String> plays = new HashMap<>();

        while (i<=game.getRounds()){
            System.out.println("=============Round "+ i + "=================");

            String pl1Choice = player1.generateChoice();
            String pl2Choice = player2.generateChoice();

            System.out.println(player1.getName() + " chose " + pl1Choice);
            System.out.println(player2.getName() + " chose " + pl2Choice);

            if(pl1Choice.equals(pl2Choice)){
                System.out.println("The result is a tie!!");
            }else{
                boolean isPl2Winner = Choice.getChoiceById(pl1Choice).isWonBy(pl2Choice);
                if(isPl2Winner)
                {
                    System.out.println(player2.getName() + " won!!");
                    player2.setWins(player2.getWins()+1);
                }else{

                    System.out.println(player1.getName() + " won!!");
                    player1.setWins(player1.getWins()+1);
                }
            }

            plays.put(i, pl1Choice + "  -  " + pl2Choice);
            i++;
        }

        String winner = this.whoIsTheWinner(player1, player2);
        retVal = new Result(winner, plays);
        return retVal;
    }

    @Override
    public void resumeGame(final Game game){
        Result res = game.getResult();

        String winner = res.getWinnersName();
        System.out.println("=====================================");
        System.out.println("             GAME RESUME             ");
        System.out.println("=====================================");
        System.out.println("Round"+ " - " + game.getPlayer1().getName() + " - " + game.getPlayer2().getName());
        for(Integer round : res.getPlays().keySet())
        {
            System.out.println( "  " + round + "  " + " - " + res.getPlays().get(round));
        }
        System.out.println("=====================================");
        System.out.println("                WINNER               ");
        System.out.println("=====================================");

        System.out.println(winner);
        System.out.println("=====================================\n");
    }

    @Override
    public String playAgainMessage(){
        return "Do you want to play again? (Y=Yes, N=No)";
    }

    @Override
    public String goodbyeMessage(){
        return "Goodbyee, see you next time!!";
    }


}
