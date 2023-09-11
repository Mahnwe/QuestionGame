package model;

public class Achievement
{
    private final int condition;
    private boolean isUnlock;
    private final String conditionDescription;

    public Achievement(int condition, boolean isUnlock, String conditionDescription)
    {
        this.condition = condition;
        this.isUnlock = isUnlock;
        this.conditionDescription = conditionDescription;
    }

    public void checkIfAchievementIsUnlock(Achievement achievement, int numberToCompareWithCondition)
    {
        if(achievement.getCondition() == numberToCompareWithCondition)
        {
            isUnlock = true;
            System.out.println("LE SUCCES EST DEVEROUILLE PUTAIN");
        }
    }

    public int getCondition() {
        return condition;
    }

    public boolean isUnlock() {
        return isUnlock;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }
}
