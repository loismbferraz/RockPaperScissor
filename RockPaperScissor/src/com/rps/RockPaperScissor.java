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
            //TO CHOOSE OPPONENTS STRATEGY
            String pl2GameProfile = reader.nextLine();
            boolean validPl2Profile = InputHandler.profileIsValid(pl2GameProfile);

            while (!validPl2Profile) {

                System.out.println(gameServer.pleaseEnterGameOptionAgain());
                pl2GameProfile = reader.nextLine();
                validPl2Profile = InputHandler.profileIsValid(pl2GameProfile);
            }



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

            validPl2Username = !pl2Name.equals(pl1Name);

            while (!validPl2Username) {

                System.out.println(gameServer.pleaseEnterUsernameAgainAlreadyInUse());
                pl2Name = reader.nextLine();
                validPl2Username = InputHandler.usernameIsValid(pl2Name);

            }


            System.out.println(gameServer.pleaseEnterGameOption());
            //TO CHOOSE OPPONENTS STRATEGY
            String pl1GameProfile = reader.nextLine();
            boolean validPl1Profile = InputHandler.profileIsValid(pl1GameProfile);

            while (!validPl1Profile) {

                System.out.println(gameServer.pleaseEnterGameOptionAgain());
                pl2GameProfile = reader.nextLine();
                validPl1Profile = InputHandler.profileIsValid(pl1GameProfile);
            }

            Player pl1 = gameServer.getPlayer(pl1Name, pl1GameProfile);
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
            gameServer.createGame(pl1, pl2, nrRoundsStr);
            gameServer.playGame();

            //GAME RESUME
            gameServer.resumeGame();

            System.out.println(gameServer.playAgainMessage());
            exitFlag = reader.nextLine();
            i = 1;

        }while(exitFlag.toUpperCase().equals("Y"));

        reader.close();
        System.out.println(gameServer.goodbyeMessage());

    }



}
