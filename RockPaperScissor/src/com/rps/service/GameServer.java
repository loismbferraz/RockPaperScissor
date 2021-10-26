package com.rps.service;


import com.rps.entities.Game;
import com.rps.entities.Player;
import com.rps.entities.Result;

public interface GameServer {

    public String welcomeMessage();

    public String playerInitMessage(int i);

    public String pleaseEnterUsername();

    public String pleaseEnterUsernameAgain();

    public String pleaseEnterGameOption();

    public String pleaseEnterGameOptionAgain();

    public String pleaseEnterUsernameAgainAlreadyInUse();

    public Player getPlayer(final String name, final String profile);

    public String pleaseEnterNumberOfRounds();

    public String pleaseEnterNumberOfRoundsAgain();

    public Game createGame(final Player player1, final Player player2, final String nrRounds);

    public Result playGame(final Game game);

    public void resumeGame(final Game game);

    public String playAgainMessage();

    public String goodbyeMessage();

}
