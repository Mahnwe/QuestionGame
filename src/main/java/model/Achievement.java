package model;

import javafx.scene.image.ImageView;

public class Achievement
{
    private final int condition;
    private boolean isUnlock;
    private final String conditionDescription;

    private ImageView lockImageView;
    private ImageView unlockImageView;

    public Achievement(ImageView achievementImage, int condition, boolean isUnlock, String conditionDescription)
    {
        createIcons();
        this.lockImageView = achievementImage;
        this.condition = condition;
        this.isUnlock = isUnlock;
        this.conditionDescription = conditionDescription;
    }

    public void checkIfAchievementIsUnlock(Achievement achievement, int numberToCompareWithCondition)
    {
        if(achievement.getCondition() <= numberToCompareWithCondition)
        {
            achievement.isUnlock = true;
            achievement.getLockImageView().setImage(unlockImageView.getImage());
            System.out.println("LE SUCCES EST DEVEROUILLE PUTAIN");
        }
    }

    public void createIcons() {
        IconCreator LockIcon = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView = LockIcon.createImage();
        lockImageView.setFitHeight(50);
        lockImageView.setFitWidth(50);

        IconCreator UnlockIcon = new IconCreator(PathUtil.UNLOCK_ICON);
        unlockImageView = UnlockIcon.createImage();
        unlockImageView.setFitHeight(40);
        unlockImageView.setFitWidth(80);
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

    public ImageView getLockImageView() {
        return lockImageView;
    }

    public void setLockImageView(ImageView lockImageView) {
        this.lockImageView = lockImageView;
    }

    public ImageView getUnlockImageView()
    {
        return unlockImageView;
    }
}
