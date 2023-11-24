package model;

import javafx.scene.image.ImageView;
import util.IconCreator;
import util.PathUtil;

public class Achievement
{
    private final int condition;
    private boolean isUnlock;
    private final ImageView achievementImage;
    private ImageView lockImageView;
    private ImageView unlockImageView;

    public Achievement(int condition, boolean isUnlock)
    {
        createIcons();
        this.condition = condition;
        this.isUnlock = isUnlock;
        this.achievementImage = new ImageView();
    }

    public void createIcons()
    {
        IconCreator lockIcon = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView = lockIcon.createImage();
        lockImageView.setFitHeight(60);
        lockImageView.setFitWidth(70);
        lockImageView.setTranslateX(20);

        IconCreator unlockIcon = new IconCreator(PathUtil.UNLOCK_ICON);
        unlockImageView = unlockIcon.createImage();
        unlockImageView.setFitHeight(60);
        unlockImageView.setFitWidth(70);
        unlockImageView.setTranslateX(20);
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

    public ImageView getAchievementImage() {
        return achievementImage;
    }
}
