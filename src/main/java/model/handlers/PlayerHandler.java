package model.handlers;

import model.Player;

public class PlayerHandler
{
    private final Player player;
    public PlayerHandler(Player player)
    {
        this.player = player;
    }
    public void increaseScore()
    {
        player.setPlayerScore(player.getPlayerScore()+1);
    }

    public void removePlayerLife()
    {
        player.setNbrOfLives(player.getNbrOfLives()-1);
    }

    public Player getPlayer() {
        return player;
    }
}
