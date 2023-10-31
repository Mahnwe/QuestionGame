package model;

import java.util.ArrayList;
import java.util.List;

public class AchievementManager
{
    private final List<Achievement> achievementsList = new ArrayList<>();

    public AchievementManager()
    {
        Achievement goldCupAchievement = new Achievement(3, false);
        achievementsList.add(goldCupAchievement);

        Achievement silverCupAchievement = new Achievement(3, false);
        achievementsList.add(silverCupAchievement);

        Achievement bronzeCupAchievement = new Achievement(3, false);
        achievementsList.add(bronzeCupAchievement);

        Achievement onlyGoodAnswerAchievement = new Achievement(10, false);
        achievementsList.add(onlyGoodAnswerAchievement);

        Achievement onlyGoodAnswerAchievement15 = new Achievement(15, false);
        achievementsList.add(onlyGoodAnswerAchievement15);

        Achievement onlyGoodAnswerAchievement20 = new Achievement(20, false);
        achievementsList.add(onlyGoodAnswerAchievement20);

        Achievement secretAchievement = new Achievement(6, false);
        achievementsList.add(secretAchievement);

    }

    public List<Achievement> getAchievementsList() {
        return achievementsList;
    }

}
