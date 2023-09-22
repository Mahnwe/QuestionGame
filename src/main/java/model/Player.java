package model;

public class Player
{
    private String playerName;
    private int playerScore;

    public Player()
    {
        // No need to instantiate or create something
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }

    public int getPlayerScore()
    {
        return playerScore;
    }

    public void setPlayerScore(int playerScore)
    {
        this.playerScore = playerScore;
    }
}
