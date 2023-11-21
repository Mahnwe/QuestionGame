package model;

import javafx.scene.image.ImageView;
import util.IconCreator;
import util.PathUtil;

public class Achievement
{
    private final int condition;
    private boolean isUnlock;
    private ImageView lockImageView;
    private ImageView unlockImageView;

    public Achievement(int condition, boolean isUnlock)
    {
        createIcons();
        this.condition = condition;
        this.isUnlock = isUnlock;
    }

    public void createIcons()
    {
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
}
