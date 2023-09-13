package model;

import java.util.ArrayList;

public class AchievementManager
{
    private final ArrayList<Achievement> achievementsList = new ArrayList<>();

    public AchievementManager()
    {

        Achievement goldCupAchievement = new Achievement(5, false, "Gagnez 5 coupes d'or");
        achievementsList.add(goldCupAchievement);

        Achievement silverCupAchievement = new Achievement(5, false, "Gagnez 5 coupes d'argent");
        achievementsList.add(silverCupAchievement);

        Achievement bronzeCupAchievement = new Achievement(5, false, "Gagnez 5 coupes de bronze");
        achievementsList.add(bronzeCupAchievement);

        Achievement onlyGoodAnswerAchievement = new Achievement(10, false, "Faire un score parfait");
        achievementsList.add(onlyGoodAnswerAchievement);

    }

    public ArrayList<Achievement> getAchievementsList() {
        return achievementsList;
    }

}
