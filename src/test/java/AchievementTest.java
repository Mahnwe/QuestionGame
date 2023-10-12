import model.AchievementManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class AchievementTest
{
    @Test
    public void testAchievement()
    {
        AchievementManager achievementManager = new AchievementManager();
        assertFalse(achievementManager.getAchievementsList().isEmpty());
        assertEquals(6, achievementManager.getAchievementsList().size());
        assertFalse(achievementManager.getAchievementsList().get(0).isUnlock());
    }

}
