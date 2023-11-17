import model.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest
{
    @Test
     void testPlayer()
    {
        Player player = new Player();
        player.setPlayerName("Thierry");
        player.setPlayerScore(9);

        assertEquals("Thierry", player.getPlayerName());
        assertThat(player.getPlayerName()).isEqualTo("Thierry");

        assertEquals(9, player.getPlayerScore());
    }
}
