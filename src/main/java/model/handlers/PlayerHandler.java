package model.handlers;

import model.Player;

public class PlayerHandler
{
    private static Player player;
    public PlayerHandler(Player player)
    {
        PlayerHandler.player = player;
    }
    public static void increaseScore()
    {
        player.setPlayerScore(player.getPlayerScore()+1);
    }

    public static void removePlayerLife()
    {
        player.setNbrOfLives(player.getNbrOfLives()-1);
    }

    public Player getPlayer() {
        return player;
    }
}
