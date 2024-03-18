import model.Player;
import model.handlers.PlayerHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest
{
    private PlayerHandler playerHandler;
    @BeforeEach
    void setUpPlayer()
    {
        Player player = new Player();
        playerHandler = new PlayerHandler(player);
    }

    @Test
     void testPlayerName()
    {
        playerHandler.getPlayer().setPlayerName("Thierry");

        assertThat(playerHandler.getPlayer().getPlayerName()).isEqualTo("Thierry");
    }

    @Test
    void testPlayerScore()
    {
        playerHandler.getPlayer().setPlayerScore(9);

        assertEquals(9, playerHandler.getPlayer().getPlayerScore());
    }

    @Test
    void testIncreasePlayerScore()
    {
        playerHandler.increaseScore();
        assertEquals(1, playerHandler.getPlayer().getPlayerScore());
    }

    @Test
    void testRemovePlayerLife()
    {
        assertEquals(3, playerHandler.getPlayer().getNbrOfLives());

        playerHandler.removePlayerLife();

        assertEquals(2, playerHandler.getPlayer().getNbrOfLives());
    }
}
