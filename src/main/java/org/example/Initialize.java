package org.example;


public class Initialize
{
    private GameHandler gameHandler;

    public Initialize()
    {

    }

    public void launchGame()
    {


        gameHandler.playGame();
    }

    public GameHandler getGameHandler() {
        return gameHandler;
    }
}
