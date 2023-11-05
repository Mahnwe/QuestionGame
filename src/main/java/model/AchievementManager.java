package model;

import javafx.scene.control.Alert;
import view.NotificationAlert;

import java.util.ArrayList;
import java.util.List;

public class AchievementManager
{
    public static NotificationAlert notificationAlert = null;
    private final List<Achievement> achievementsList = new ArrayList<>();

    public AchievementManager()
    {
        Achievement goldCupAchievement = new Achievement(3, false, null);
        achievementsList.add(goldCupAchievement);

        Achievement silverCupAchievement = new Achievement(3, false, null);
        achievementsList.add(silverCupAchievement);

        Achievement bronzeCupAchievement = new Achievement(3, false, null);
        achievementsList.add(bronzeCupAchievement);

        Achievement onlyGoodAnswerAchievement = new Achievement(10, false, null);
        achievementsList.add(onlyGoodAnswerAchievement);

        Achievement onlyGoodAnswerAchievement15 = new Achievement(15, false, null);
        achievementsList.add(onlyGoodAnswerAchievement15);

        Achievement onlyGoodAnswerAchievement20 = new Achievement(20, false, null);
        achievementsList.add(onlyGoodAnswerAchievement20);

        Achievement secretAchievement = new Achievement(6, false, null);
        achievementsList.add(secretAchievement);

    }

    public void checkIfAchievementIsUnlock(Achievement achievement, int numberToCompareWithCondition)
    {
        if(achievement.getCondition() <= numberToCompareWithCondition)
        {
            achievement.setUnlock(true);
            achievement.getLockImageView().setImage(achievement.getUnlockImageView().getImage());
            achievement.setNotificationAlert(new NotificationAlert(Alert.AlertType.INFORMATION));
            notificationAlert = new NotificationAlert(Alert.AlertType.INFORMATION);
        }
        else {
            achievement.setUnlock(false);
            achievement.getLockImageView().setImage(achievement.getLockImageView().getImage());
        }
    }

    public List<Achievement> getAchievementsList() {
        return achievementsList;
    }

}
