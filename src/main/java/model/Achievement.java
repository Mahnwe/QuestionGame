package model;

import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import view.NotificationAlert;

public class Achievement
{
    private final int condition;
    private boolean isUnlock;
    private final String conditionDescription;
    private ImageView lockImageView;
    private ImageView unlockImageView;
    public static NotificationAlert notificationAlert;

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
            notificationAlert = new NotificationAlert(Alert.AlertType.INFORMATION);
        }
        else {
            achievement.isUnlock = false;
            achievement.getLockImageView().setImage(lockImageView.getImage());
        }
    }

    public void createIcons() {
        IconCreator lockIcon = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView = lockIcon.createImage();
        lockImageView.setFitHeight(50);
        lockImageView.setFitWidth(60);

        IconCreator unlockIcon = new IconCreator(PathUtil.UNLOCK_ICON);
        unlockImageView = unlockIcon.createImage();
        unlockImageView.setFitHeight(50);
        unlockImageView.setFitWidth(60);
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

    public ImageView getUnlockImageView()
    {
        return unlockImageView;
    }
}
