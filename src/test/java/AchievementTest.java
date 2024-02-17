import model.handlers.AchievementManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AchievementTest
{
    private AchievementManager achievementManager;

    @BeforeEach
    void createAchievementList()
    {
        achievementManager = new AchievementManager();
    }

    @Test
    void testAchievementsCreationAndLock()
    {
        assertTrue(achievementManager.getAchievementsList().size() >= 1);
        assertFalse(achievementManager.getAchievementsList().get(0).isUnlock());
    }

    @Test
    void testAchievementUnlock()
    {
        achievementManager.getAchievementsList().get(0).setUnlock(true);
        assertTrue(achievementManager.getAchievementsList().get(0).isUnlock());
    }

}
