package com.rps;

import com.rps.entities.Game;
import com.rps.entities.Player;
import com.rps.entities.Result;
import com.rps.service.GameServer;
import com.rps.service.GameServerImpl;
import com.rps.util.InputHandler;

import java.util.*;

public class RockPaperScissor {


    public static void main(String[] args) {


        //INIT APP
        GameServer gameServer = new GameServerImpl();
        Scanner reader = new Scanner(System.in);
        System.out.println(gameServer.welcomeMessage());
        String exitFlag;

        do {
            //GET PLAYER1 INFO
            int i = 1;
            System.out.println(gameServer.playerInitMessage(i));
            System.out.println(gameServer.pleaseEnterUsername());
            String pl1Name = reader.nextLine();
            boolean validPl1Username = InputHandler.usernameIsValid(pl1Name);

            while (!validPl1Username) {

                System.out.println(gameServer.pleaseEnterUsernameAgain());
                pl1Name = reader.nextLine();
                validPl1Username = InputHandler.usernameIsValid(pl1Name);

            }

            System.out.println(gameServer.pleaseEnterGameOption());
            String pl1GameProfile = reader.nextLine();
            boolean validPl1Profile = InputHandler.profileIsValid(pl1GameProfile);

            while (!validPl1Profile) {

                System.out.println(gameServer.pleaseEnterGameOptionAgain());
                pl1GameProfile = reader.nextLine();
                validPl1Profile = InputHandler.profileIsValid(pl1GameProfile);
            }

            Player pl1 = gameServer.getPlayer(pl1Name, pl1GameProfile);

            //GET PLAYER2 INFO
            i++;
            System.out.println(gameServer.playerInitMessage(i));
            System.out.println(gameServer.pleaseEnterUsername());
            String pl2Name = reader.nextLine();

            boolean validPl2Username = InputHandler.usernameIsValid(pl2Name);
            while (!validPl2Username) {

                System.out.println(gameServer.pleaseEnterUsernameAgain());
                pl2Name = reader.nextLine();
                validPl2Username = InputHandler.usernameIsValid(pl2Name);

            }

            validPl2Username = !pl2Name.equals(pl1.getName());

            while (!validPl2Username) {

                System.out.println(gameServer.pleaseEnterUsernameAgainAlreadyInUse());
                pl2Name = reader.nextLine();
                validPl2Username = InputHandler.usernameIsValid(pl2Name);

            }


            System.out.println(gameServer.pleaseEnterGameOption());
            String pl2GameProfile = reader.nextLine();
            boolean validPl2Profile = InputHandler.profileIsValid(pl2GameProfile);

            while (!validPl2Profile) {

                System.out.println(gameServer.pleaseEnterGameOptionAgain());
                pl2GameProfile = reader.nextLine();
                validPl2Profile = InputHandler.profileIsValid(pl2GameProfile);
            }

            Player pl2 = gameServer.getPlayer(pl2Name, pl2GameProfile);

            //GET NUMBER OF ROUNDS
            System.out.println(gameServer.pleaseEnterNumberOfRounds());
            String nrRoundsStr = reader.nextLine();
            boolean validNrRounds = InputHandler.nrRoundsIsValid(nrRoundsStr);

            while (!validNrRounds) {

                System.out.println(gameServer.pleaseEnterNumberOfRoundsAgain());
                nrRoundsStr = reader.nextLine();
                validNrRounds = InputHandler.nrRoundsIsValid(nrRoundsStr);
            }

            //CREATE AND PLAY GAME
            Game game = gameServer.createGame(pl1, pl2, nrRoundsStr);
            Result result = gameServer.playGame(game);
            game.setResult(result);

            //GAME RESUME
            gameServer.resumeGame(game);

            System.out.println(gameServer.playAgainMessage());
            exitFlag = reader.nextLine();
            i = 1;

        }while(exitFlag.toUpperCase().equals("Y"));

        reader.close();
        System.out.println(gameServer.goodbyeMessage());

//        Scanner reader = new Scanner(System.in);
//        System.out.println("Introduza o seu nome!");
//        Player pl1 = new Player();
//        String nome = reader.nextLine();
//        pl1.setName(nome);
//
//
//        System.out.println("Introduza o seu nome!");
//        Player pl2 = new Player();
//        nome = reader.nextLine();
//        pl2.setName(nome);
//
//        System.out.println("Introduza o nr de jogadas pretendidas");
//        String roundsStr = reader.nextLine();
//
//        int rounds = Integer.parseInt(roundsStr);
//
//        List<Player> playerList = new ArrayList<>(Arrays.asList(pl1,pl2));
//
//
//
//
//        Game game = new Game(playerList,rounds);
//
//
//
//
//
//
//        int i = 0;
//
//        Map<Integer,String> plays = new HashMap<>();
//        while(i< rounds)
//        {
//            System.out.println( pl1.getName() + " introduza a sua jogada!");
//            System.out.println("R - ROCK");
//            System.out.println("P - PAPER");
//            System.out.println("S - SCISSOR");
//            String choice = reader.nextLine();
//
//
//            pl1.setChoice(choice);
////            System.out.println(pl1.toString());
//
//            System.out.println( pl2.getName() + " introduza a sua jogada!");
//            System.out.println("R - ROCK");
//            System.out.println("P - PAPER");
//            System.out.println("S - SCISSOR");
//            choice = reader.nextLine();
//            pl2.setChoice(choice);
////            System.out.println(pl2.toString());
//
//            int winner = 0;
//            if(pl1.getChoice().equalsIgnoreCase(pl2.getChoice()))
//            {
//                System.out.println("The result of this round is a draw!");
//            }
//            else if (pl1.getChoice().equalsIgnoreCase("R")) {
//                 winner = pl2.getChoice().equalsIgnoreCase("S") ? 1 : 2;
//
//
//            } else if (pl1.getChoice().equalsIgnoreCase("P")) {
//                 winner = pl2.getChoice().equalsIgnoreCase("R") ? 1 : 2;
//            } else {
//                 winner = pl2.getChoice().equalsIgnoreCase("P") ? 1 : 2;
//            }
//
//            if( 1 == winner)
//            {
//                pl1.setWins(pl1.getWins()+1);
//                System.out.println("The winner of this round is "+ pl1.getName());
//            }
//            else if( 2 == winner)
//            {
//                pl2.setWins(pl2.getWins()+1);
//                System.out.println("The winner of this round is "+ pl2.getName());
//            }
//
//            winner = 0 ;
//            plays.put(i, pl1.getChoice() + "-" + pl2.getChoice());
//            game.setPlays(plays);
//            i++;
//        }
//
//        System.out.println(game.toString());


    }



}
