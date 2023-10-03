package model;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class AchievementManager
{
    private final List<Achievement> achievementsList = new ArrayList<>();
    private ImageView lockImageView;
    private ImageView lockImageView2;
    private ImageView lockImageView3;
    private ImageView lockImageView4;
    private ImageView lockImageView5;
    private ImageView lockImageView6;

    public AchievementManager()
    {
        createIcons();
        Achievement goldCupAchievement = new Achievement(lockImageView, 5, false, UtilStringStorage.goldCupAchievementDescription);
        achievementsList.add(goldCupAchievement);

        Achievement silverCupAchievement = new Achievement(lockImageView2, 5, false, UtilStringStorage.silverCupAchievementDescription);
        achievementsList.add(silverCupAchievement);

        Achievement bronzeCupAchievement = new Achievement(lockImageView3, 5, false, UtilStringStorage.bronzeCupAchievementDescription);
        achievementsList.add(bronzeCupAchievement);

        Achievement onlyGoodAnswerAchievement = new Achievement(lockImageView4, 10, false, UtilStringStorage.perfectScore10Achievement);
        achievementsList.add(onlyGoodAnswerAchievement);

        Achievement onlyGoodAnswerAchievement15 = new Achievement(lockImageView5, 15, false, UtilStringStorage.perfectScore15Achievement);
        achievementsList.add(onlyGoodAnswerAchievement15);

        Achievement onlyGoodAnswerAchievement20 = new Achievement(lockImageView6, 20, false, UtilStringStorage.perfectScore20Achievement);
        achievementsList.add(onlyGoodAnswerAchievement20);

    }

    public void createIcons() {
        IconCreator lockIcon = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView = lockIcon.createImage();
        lockImageView.setFitHeight(50);
        lockImageView.setFitWidth(60);

        IconCreator lockIcon2 = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView2 = lockIcon2.createImage();
        lockImageView2.setFitHeight(50);
        lockImageView2.setFitWidth(60);

        IconCreator lockIcon3 = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView3 = lockIcon3.createImage();
        lockImageView3.setFitHeight(50);
        lockImageView3.setFitWidth(60);

        IconCreator lockIcon4 = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView4 = lockIcon4.createImage();
        lockImageView4.setFitHeight(50);
        lockImageView4.setFitWidth(60);

        IconCreator lockIcon5 = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView5 = lockIcon5.createImage();
        lockImageView5.setFitHeight(50);
        lockImageView5.setFitWidth(60);

        IconCreator lockIcon6 = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView6 = lockIcon6.createImage();
        lockImageView6.setFitHeight(50);
        lockImageView6.setFitWidth(60);
    }

    public List<Achievement> getAchievementsList() {
        return achievementsList;
    }

}
