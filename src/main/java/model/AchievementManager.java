package model;

import java.util.ArrayList;

public class AchievementManager
{
    private final ArrayList<Achievement> achievementsList = new ArrayList<>();

    public AchievementManager()
    {

        Achievement goldCupAchievement = new Achievement(5, false, "Gagnez 5 coupes d'or", "Succés obtenu");
        achievementsList.add(goldCupAchievement);

        Achievement silverCupAchievement = new Achievement(5, false, "Win 5 silver cups", "Succés vérouillé");
        achievementsList.add(silverCupAchievement);

        Achievement bronzeCupAchievement = new Achievement(5, false, "Win 5 bronze cups", "Succés vérouillé");
        achievementsList.add(bronzeCupAchievement);

        Achievement onlyGoodAnswerAchievement = new Achievement(10, false, "Win a game without a false answer", "Succés vérouillé");
        achievementsList.add(onlyGoodAnswerAchievement);

    }

    public void checkIfAchievementIsUnlock(Achievement achievement, int numberToCompareWithCondition)
    {
        if(achievement.getCondition() == numberToCompareWithCondition)
        {
            if(!achievement.isUnlock())
            {
                achievement.setUnlock(true);
            }
        }
    }

    public ArrayList<Achievement> getAchievementsList() {
        return achievementsList;
    }

}
