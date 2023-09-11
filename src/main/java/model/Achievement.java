package model;

public class Achievement
{
    private final int condition;
    private boolean isUnlock;
    private final String conditionDescription;
    private String successMessage;

    public Achievement(int condition, boolean isUnlock, String conditionDescription, String successMessage)
    {
        this.condition = condition;
        this.isUnlock = isUnlock;
        this.conditionDescription = conditionDescription;
        this.successMessage = successMessage;
    }

    public int getCondition() {
        return condition;
    }

    public boolean isUnlock() {
        return isUnlock;
    }

    public void setUnlock(boolean unlock) {
        isUnlock = unlock;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public String getSuccessMessage() {
        return successMessage;
    }
}
