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

        Achievement onlyGoodAnswerAchievement = new Achievement(10, false, "Faire un score parfait (10 questions)");
        achievementsList.add(onlyGoodAnswerAchievement);

        Achievement onlyGoodAnswerAchievement15 = new Achievement(15, false, "Faire un score parfait(15 questions)");
        achievementsList.add(onlyGoodAnswerAchievement15);

        Achievement onlyGoodAnswerAchievement20 = new Achievement(20, false, "Faire un score parfait (20 questions)");
        achievementsList.add(onlyGoodAnswerAchievement20);

    }

    public ArrayList<Achievement> getAchievementsList() {
        return achievementsList;
    }

}
