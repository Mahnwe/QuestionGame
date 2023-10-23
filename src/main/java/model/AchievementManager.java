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
    private ImageView lockImageView7;

    public AchievementManager()
    {
        createIcons();
        Achievement goldCupAchievement = new Achievement(lockImageView, 3, false);
        achievementsList.add(goldCupAchievement);

        Achievement silverCupAchievement = new Achievement(lockImageView2, 3, false);
        achievementsList.add(silverCupAchievement);

        Achievement bronzeCupAchievement = new Achievement(lockImageView3, 3, false);
        achievementsList.add(bronzeCupAchievement);

        Achievement onlyGoodAnswerAchievement = new Achievement(lockImageView4, 10, false);
        achievementsList.add(onlyGoodAnswerAchievement);

        Achievement onlyGoodAnswerAchievement15 = new Achievement(lockImageView5, 15, false);
        achievementsList.add(onlyGoodAnswerAchievement15);

        Achievement onlyGoodAnswerAchievement20 = new Achievement(lockImageView6, 20, false);
        achievementsList.add(onlyGoodAnswerAchievement20);

        Achievement secretAchievement = new Achievement(lockImageView7, 6, false);
        achievementsList.add(secretAchievement);

    }

    public void createIcons() {
        IconCreator lockIcon = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView = lockIcon.createImage();
        lockImageView.setFitHeight(40);
        lockImageView.setFitWidth(50);

        lockImageView2 = lockIcon.createImage();
        lockImageView2.setFitHeight(40);
        lockImageView2.setFitWidth(50);

        lockImageView3 = lockIcon.createImage();
        lockImageView3.setFitHeight(40);
        lockImageView3.setFitWidth(50);

        lockImageView4 = lockIcon.createImage();
        lockImageView4.setFitHeight(40);
        lockImageView4.setFitWidth(50);

        lockImageView5 = lockIcon.createImage();
        lockImageView5.setFitHeight(40);
        lockImageView5.setFitWidth(50);

        lockImageView6 = lockIcon.createImage();
        lockImageView6.setFitHeight(40);
        lockImageView6.setFitWidth(50);

        lockImageView7 = lockIcon.createImage();
        lockImageView7.setFitHeight(40);
        lockImageView7.setFitWidth(50);
    }

    public List<Achievement> getAchievementsList() {
        return achievementsList;
    }

}
