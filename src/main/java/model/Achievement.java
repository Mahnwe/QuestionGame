package model;

import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import util.IconCreator;
import util.PathUtil;
import view.NotificationAlert;

public class Achievement
{
    private final int condition;
    private boolean isUnlock;
    private ImageView lockImageView;
    private ImageView unlockImageView;
    public static NotificationAlert notificationAlert;

    public Achievement(int condition, boolean isUnlock)
    {
        createIcons();
        this.condition = condition;
        this.isUnlock = isUnlock;
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
        lockImageView.setFitHeight(40);
        lockImageView.setFitWidth(50);

        IconCreator unlockIcon = new IconCreator(PathUtil.UNLOCK_ICON);
        unlockImageView = unlockIcon.createImage();
        unlockImageView.setFitHeight(40);
        unlockImageView.setFitWidth(50);
    }

    public int getCondition() {
        return condition;
    }

    public boolean isUnlock() {
        return isUnlock;
    }

    public ImageView getLockImageView() {
        return lockImageView;
    }

    public ImageView getUnlockImageView()
    {
        return unlockImageView;
    }
}
