package org.example;


public class Initialize
{
    private GameHandler gameHandler;

    public Initialize()
    {
        Player player = new Player(null, 0);
        gameHandler = new GameHandler(player);
    }

    public void launchGame()
    {


        gameHandler.playGame();
    }

    public GameHandler getGameHandler() {
        return gameHandler;
    }
}
