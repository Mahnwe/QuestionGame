package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.PathUtil;
import util.UtilStringStorage;
import view.MenuScene;
import view.NotificationAlert;
import view.ResultScene;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AchievementManager
{
    private static final Logger logger = LogManager.getLogger(AchievementManager.class);
    public static NotificationAlert notificationAlert = null;
    private final List<Achievement> achievementsList = new ArrayList<>();

    public AchievementManager()
    {
        Achievement goldCupAchievement = new Achievement(3, false);
        achievementsList.add(goldCupAchievement);

        Achievement silverCupAchievement = new Achievement(3, false);
        achievementsList.add(silverCupAchievement);

        Achievement bronzeCupAchievement = new Achievement(3, false);
        achievementsList.add(bronzeCupAchievement);

        Achievement onlyGoodAnswerAchievement = new Achievement(10, false);
        achievementsList.add(onlyGoodAnswerAchievement);

        Achievement onlyGoodAnswerAchievement15 = new Achievement(15, false);
        achievementsList.add(onlyGoodAnswerAchievement15);

        Achievement onlyGoodAnswerAchievement20 = new Achievement(20, false);
        achievementsList.add(onlyGoodAnswerAchievement20);

        Achievement survivalAchievement20 = new Achievement(20, false);
        achievementsList.add(survivalAchievement20);

        Achievement survivalAchievement30 = new Achievement(30, false);
        achievementsList.add(survivalAchievement30);

        Achievement survivalAchievement50 = new Achievement(50, false);
        achievementsList.add(survivalAchievement50);

        Achievement secretAchievement = new Achievement(9, false);
        achievementsList.add(secretAchievement);

    }

    public void checkIfAchievementIsUnlock(Achievement achievement, int numberToCompareWithCondition)
    {
        if (!achievement.isUnlock() && achievement.getCondition() <= numberToCompareWithCondition) {
            achievement.setUnlock(true);
            achievement.getLockImageView().setImage(achievement.getUnlockImageView().getImage());
            notificationAlert = new NotificationAlert(Alert.AlertType.INFORMATION);
        } else {
            achievement.setUnlock(false);
            achievement.getLockImageView().setImage(achievement.getLockImageView().getImage());
        }
    }
    public void checkPerfectScoreAchievement(AchievementManager achievementManager, int playerFinalScore, Properties generalSavesFile, String propertyKey, int numberToCompare, int achievementIndex)
    {
        if(playerFinalScore == numberToCompare) {
            String perfectScoreString = String.valueOf(playerFinalScore);
            generalSavesFile.setProperty(propertyKey, perfectScoreString);
            achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(achievementIndex), playerFinalScore);
        }
    }

    public void checkSurvivalScoreAchievement(AchievementManager achievementManager, int playerFinalScore, Properties generalSavesFile, String propertyKey, int numberToCompare, int achievementIndex)
    {
        if(playerFinalScore >= numberToCompare) {
            String perfectScoreString = String.valueOf(playerFinalScore);
            generalSavesFile.setProperty(propertyKey, perfectScoreString);
            achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(achievementIndex), playerFinalScore);
        }
    }

    public void survivalModeResult(int questionCount, Properties generalSavesFile, AchievementManager achievementManager)
    {
        if(questionCount >= 20)
        {
            checkSurvivalScoreAchievement(achievementManager, questionCount, generalSavesFile, "survivalScore20", achievementsList.get(6).getCondition(), 6);
        }
        if(questionCount >= 30)
        {
            checkSurvivalScoreAchievement(achievementManager, questionCount, generalSavesFile, "survivalScore30", achievementsList.get(7).getCondition(), 7);
        }
        if(questionCount >= 50)
        {
            checkSurvivalScoreAchievement(achievementManager, questionCount, generalSavesFile, "survivalScore50", achievementsList.get(8).getCondition(), 8);
        }
    }

    public void goldCupResult(int questionCount, int playerScore, VBox vBox, Properties generalSavesFile, AchievementManager achievementManager, ImageView imageView)
    {
        if(GameHandler.gameMode == null) {
            switch (questionCount) {
                case 10 -> checkPerfectScoreAchievement(achievementManager, playerScore, generalSavesFile, "perfectScore10", achievementsList.get(3).getCondition(), 3);
                case 15 -> checkPerfectScoreAchievement(achievementManager, playerScore, generalSavesFile, "perfectScore15", achievementsList.get(4).getCondition(), 4);
                case 20 -> checkPerfectScoreAchievement(achievementManager, playerScore, generalSavesFile, "perfectScore20", achievementsList.get(5).getCondition(), 5);
                default -> logger.error("Question count bug");
            }
        }

        int nbrOfGoldCup = Integer.parseInt(generalSavesFile.getProperty("goldCup"));
        nbrOfGoldCup++;

        achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(0), nbrOfGoldCup);
        generalSavesFile.setProperty("goldCup", String.valueOf(nbrOfGoldCup));

        Label cupLabel;
        if(GameHandler.gameMode == null) {
            cupLabel = new Label(UtilStringStorage.goldCupLabel);
            setUpCupResultLabel(cupLabel);
        } else {
            cupLabel = new Label(UtilStringStorage.surviveEnoughGoldLabel);
            setUpSurviveResultLabel(cupLabel);
        }

        vBox.getChildren().add(cupLabel);
        vBox.getChildren().add(imageView);
    }

    public void silverCupResult(VBox vBox, Properties generalSavesFile, AchievementManager achievementManager, ImageView imageView)
    {
        int nbrOfSilverCup = Integer.parseInt(generalSavesFile.getProperty("silverCup"));
        nbrOfSilverCup++;

        achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(1), nbrOfSilverCup);
        generalSavesFile.setProperty("silverCup", String.valueOf(nbrOfSilverCup));

        Label cupLabel;
        if(GameHandler.gameMode == null) {
            cupLabel = new Label(UtilStringStorage.silverCupLabel);
            setUpCupResultLabel(cupLabel);
        } else {
            cupLabel = new Label(UtilStringStorage.surviveEnoughSilverLabel);
            setUpSurviveResultLabel(cupLabel);
        }

        vBox.getChildren().add(cupLabel);
        vBox.getChildren().add(imageView);
    }

    public void bronzeCupResult(VBox vBox, Properties generalSavesFile, AchievementManager achievementManager, ImageView imageView)
    {
        int nbrOfBronzeCup = Integer.parseInt(generalSavesFile.getProperty("bronzeCup"));
        nbrOfBronzeCup++;

        achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(2), nbrOfBronzeCup);
        generalSavesFile.setProperty("bronzeCup", String.valueOf(nbrOfBronzeCup));

        Label cupLabel;
        if(GameHandler.gameMode == null) {
            cupLabel = new Label(UtilStringStorage.bronzeCupLabel);
            setUpCupResultLabel(cupLabel);
        } else {
            cupLabel = new Label(UtilStringStorage.surviveEnoughBronzeLabel);
            setUpSurviveResultLabel(cupLabel);
        }

        vBox.getChildren().add(cupLabel);
        vBox.getChildren().add(imageView);
    }

    public void setUpCupResultLabel(Label label)
    {
        ResultScene.resultSoundEffect = SoundManager.playMusic(PathUtil.RESULT_SOUND_EFFECT);
        stylizeLabel(label, 200, 70);
    }
    public void setUpSurviveResultLabel(Label label)
    {
        ResultScene.resultSoundEffect = SoundManager.playMusic(PathUtil.RESULT_SOUND_EFFECT);
        stylizeLabel(label, 100, 70);
    }
    public void stylizeLabel(Label label, int translateX, int translateY)
    {
        label.setTranslateX(translateX);
        label.setTranslateY(translateY);
        label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 16));
        label.setTextFill(Color.GHOSTWHITE);
    }

    public List<Achievement> getAchievementsList() {
        return achievementsList;
    }

}
