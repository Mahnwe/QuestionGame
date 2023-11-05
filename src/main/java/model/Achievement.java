package model;

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
    private NotificationAlert notificationAlert;

    public Achievement(int condition, boolean isUnlock, NotificationAlert notificationAlert)
    {
        createIcons();
        this.condition = condition;
        this.isUnlock = isUnlock;
        this.notificationAlert = notificationAlert;
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

    public void setUnlock(boolean unlock) {
        isUnlock = unlock;
    }

    public NotificationAlert getNotificationAlert() {
        return notificationAlert;
    }

    public void setNotificationAlert(NotificationAlert notificationAlert) {
        this.notificationAlert = notificationAlert;
    }
}
