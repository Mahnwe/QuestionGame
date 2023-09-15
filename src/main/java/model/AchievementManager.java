package model;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class AchievementManager
{
    private final ArrayList<Achievement> achievementsList = new ArrayList<>();
    private ImageView lockImageView;
    private ImageView lockImageView2;
    private ImageView lockImageView3;
    private ImageView lockImageView4;
    private ImageView lockImageView5;
    private ImageView lockImageView6;

    public AchievementManager()
    {
        createIcons();
        Achievement goldCupAchievement = new Achievement(lockImageView, 5, false, "Gagnez 5 coupes d'or");
        achievementsList.add(goldCupAchievement);

        Achievement silverCupAchievement = new Achievement(lockImageView2, 5, false, "Gagnez 5 coupes d'argent");
        achievementsList.add(silverCupAchievement);

        Achievement bronzeCupAchievement = new Achievement(lockImageView3, 5, false, "Gagnez 5 coupes de bronze");
        achievementsList.add(bronzeCupAchievement);

        Achievement onlyGoodAnswerAchievement = new Achievement(lockImageView4, 10, false, "Faire un score parfait (10 questions)");
        achievementsList.add(onlyGoodAnswerAchievement);

        Achievement onlyGoodAnswerAchievement15 = new Achievement(lockImageView5, 15, false, "Faire un score parfait(15 questions)");
        achievementsList.add(onlyGoodAnswerAchievement15);

        Achievement onlyGoodAnswerAchievement20 = new Achievement(lockImageView6, 20, false, "Faire un score parfait (20 questions)");
        achievementsList.add(onlyGoodAnswerAchievement20);

    }

    public void createIcons() {
        IconCreator LockIcon = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView = LockIcon.createImage();
        lockImageView.setFitHeight(50);
        lockImageView.setFitWidth(50);

        IconCreator LockIcon2 = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView2 = LockIcon2.createImage();
        lockImageView2.setFitHeight(50);
        lockImageView2.setFitWidth(50);

        IconCreator LockIcon3 = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView3 = LockIcon3.createImage();
        lockImageView3.setFitHeight(50);
        lockImageView3.setFitWidth(50);

        IconCreator LockIcon4 = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView4 = LockIcon4.createImage();
        lockImageView4.setFitHeight(50);
        lockImageView4.setFitWidth(50);

        IconCreator LockIcon5 = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView5 = LockIcon5.createImage();
        lockImageView5.setFitHeight(50);
        lockImageView5.setFitWidth(50);

        IconCreator LockIcon6 = new IconCreator(PathUtil.LOCK_ICON);
        lockImageView6 = LockIcon6.createImage();
        lockImageView6.setFitHeight(50);
        lockImageView6.setFitWidth(50);
    }

    public ArrayList<Achievement> getAchievementsList() {
        return achievementsList;
    }

}
