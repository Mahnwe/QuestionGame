package model;

import java.util.ArrayList;

public class AchievementManager
{
    private final ArrayList<Achievement> achievementsList = new ArrayList<>();

    public AchievementManager()
    {
        Achievement goldCupAchievement = new Achievement(5, false, "Gagnez 5 coupes d'or", "Bien joué !");
        achievementsList.add(goldCupAchievement);

        Achievement silverCupAchievement = new Achievement(5, false, "Win 5 silver cups", "Bien joué !");
        achievementsList.add(silverCupAchievement);

        Achievement bronzeCupAchievement = new Achievement(5, false, "Win 5 bronze cups", "Bien joué !");
        achievementsList.add(bronzeCupAchievement);

        Achievement onlyGoodAnswerAchievement = new Achievement(10, false, "Win a game without a false answer", "Wow perfect score !");
        achievementsList.add(onlyGoodAnswerAchievement);
    }

    public void checkIfAchievementIsUnlock(Achievement achievement, int numberToCompareWithCondition)
    {
        if(achievement.getCondition() == numberToCompareWithCondition)
        {
            if(!achievement.isUnlock())
            {
                achievement.setUnlock(true);
                achievement.setSuccessMessage("Succés débloqué, bien joué !");
                System.out.println("Achievement unlocked");
            }
        }
    }

    public ArrayList<Achievement> getAchievementsList() {
        return achievementsList;
    }
}
