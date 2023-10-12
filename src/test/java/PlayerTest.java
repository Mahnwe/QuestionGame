import model.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest
{
    @Test
    public void testPlayer()
    {
        Player player = new Player();

        player.setPlayerName("Thierry");
        assertEquals("Thierry", player.getPlayerName());

        player.setPlayerScore(9);
        assertEquals(9, player.getPlayerScore());
    }
}
