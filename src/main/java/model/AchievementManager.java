package model;

import java.util.ArrayList;

public class AchievementManager
{
    private final ArrayList<Achievement> achievementsList = new ArrayList<>();

    public AchievementManager()
    {

        Achievement goldCupAchievement = new Achievement(5, false, "Gagnez 5 coupes d'or");
        achievementsList.add(goldCupAchievement);

        Achievement silverCupAchievement = new Achievement(5, false, "Win 5 silver cups");
        achievementsList.add(silverCupAchievement);

        Achievement bronzeCupAchievement = new Achievement(5, false, "Win 5 bronze cups");
        achievementsList.add(bronzeCupAchievement);

        Achievement onlyGoodAnswerAchievement = new Achievement(10, false, "Win a game without a false answer");
        achievementsList.add(onlyGoodAnswerAchievement);

    }

    public ArrayList<Achievement> getAchievementsList() {
        return achievementsList;
    }

}
