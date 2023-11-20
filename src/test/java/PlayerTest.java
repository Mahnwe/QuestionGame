import model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest
{
   private Player player;

    @BeforeEach
    void setUpPlayer()
    {
        player = new Player();
    }

    @Test
     void testPlayerName()
    {
        player.setPlayerName("Thierry");

        assertThat(player.getPlayerName()).isEqualTo("Thierry");
    }

    @Test
    void testPlayerScore()
    {
        player.setPlayerScore(9);

        assertEquals(9, player.getPlayerScore());
    }
}
