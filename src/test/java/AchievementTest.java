import model.AchievementManager;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AchievementTest
{
    @Test
    void testAchievement()
    {
        AchievementManager achievementManager = new AchievementManager();

        assertFalse(achievementManager.getAchievementsList().isEmpty());
        assertThat(achievementManager.getAchievementsList()).hasSize(10);
        assertFalse(achievementManager.getAchievementsList().get(0).isUnlock());
    }

}
