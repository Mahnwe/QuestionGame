package model.handlers;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.FileUtil;
import util.PathUtil;
import util.stringutiltranslate.UtilStringStorage;
import view.scene.MenuScene;
import view.scene.ResultScene;

public class ResultHandler
{
    public static void survivalBronzeResult(AchievementManager achievementManager, int questionCount, int playerFinalScore, VBox gameResult, ImageView bronzeCup)
    {
        achievementManager.survivalModeResult(questionCount, FileUtil.getGeneralSavesFile(), achievementManager);
        achievementManager.bronzeCupResult(questionCount, playerFinalScore, gameResult, FileUtil.getGeneralSavesFile(), achievementManager, bronzeCup);
        setTextToCupLabel(gameResult, UtilStringStorage.surviveEnoughBronzeLabel);
        FileUtil.storeGeneralSavesFile();
    }
    public static void survivalSilverResult(AchievementManager achievementManager, int questionCount, int playerFinalScore, VBox gameResult, ImageView silverCup)
    {
        achievementManager.survivalModeResult(questionCount, FileUtil.getGeneralSavesFile(), achievementManager);
        achievementManager.silverCupResult(questionCount, playerFinalScore, gameResult, FileUtil.getGeneralSavesFile(), achievementManager, silverCup);
        setTextToCupLabel(gameResult, UtilStringStorage.surviveEnoughSilverLabel);
        FileUtil.storeGeneralSavesFile();
    }
    public static void survivalGoldResult(AchievementManager achievementManager, int questionCount, int playerFinalScore, VBox gameResult, ImageView goldCup)
    {
        achievementManager.survivalModeResult(questionCount, FileUtil.getGeneralSavesFile(), achievementManager);
        achievementManager.goldCupResult(questionCount, playerFinalScore, gameResult, FileUtil.getGeneralSavesFile(), achievementManager, goldCup);
        setTextToCupLabel(gameResult, UtilStringStorage.surviveEnoughGoldLabel);
        FileUtil.storeGeneralSavesFile();
    }
    public static void survivalNoCupResult(int questionCount, VBox gameResult)
    {
        FileUtil.getGeneralSavesFile().setProperty("bestSurvivalScore", String.valueOf(questionCount));
        FileUtil.storeGeneralSavesFile();
        Label cupLabel = new Label(UtilStringStorage.noSurviveLabel);
        stylizeLabel(cupLabel, 80, 90);
        gameResult.getChildren().add(cupLabel);
    }
    public static void normalGoldResult(AchievementManager achievementManager, int questionCount, int playerFinalScore, VBox gameResult, ImageView goldCup)
    {
        achievementManager.goldCupResult(questionCount, playerFinalScore, gameResult, FileUtil.getGeneralSavesFile(), achievementManager, goldCup);
        setTextToCupLabel(gameResult, UtilStringStorage.goldCupLabel);
    }
    public static void normalSilverResult(AchievementManager achievementManager, int questionCount, int playerFinalScore, VBox gameResult, ImageView silverCup)
    {
        achievementManager.silverCupResult(questionCount, playerFinalScore, gameResult, FileUtil.getGeneralSavesFile(), achievementManager, silverCup);
        setTextToCupLabel(gameResult, UtilStringStorage.silverCupLabel);
    }
    public static void normalBronzeResult(AchievementManager achievementManager, int questionCount, int playerFinalScore, VBox gameResult, ImageView bronzeCup)
    {
        achievementManager.bronzeCupResult(questionCount, playerFinalScore, gameResult, FileUtil.getGeneralSavesFile(), achievementManager, bronzeCup);
        setTextToCupLabel(gameResult, UtilStringStorage.bronzeCupLabel);
    }
    public static void normalNoCupResult(AchievementManager achievementManager, int questionCount, int playerFinalScore, VBox gameResult)
    {
        achievementManager.checkIfPerfectScoreAchievementIsUnlock(questionCount, playerFinalScore, FileUtil.getGeneralSavesFile(), achievementManager);
        Label cupLabel = new Label(UtilStringStorage.noCupLabel);
        stylizeLabel(cupLabel, 130, 90);
        gameResult.getChildren().add(cupLabel);
    }
    public static void stylizeLabel(Label label, int translateX, int translateY) {
        label.setTranslateX(translateX);
        label.setTranslateY(translateY);
        label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 28));
        label.setTextFill(Color.GHOSTWHITE);
    }

    public static void setTextToCupLabel(VBox vBox, String textForCupLabel)
    {
        Label cupLabel = new Label(textForCupLabel);
        vBox.getChildren().add(cupLabel);
        if(GameHandler.gameMode == null)
        {
            setUpCupResultLabel(cupLabel);
        } else {
            setUpSurviveResultLabel(cupLabel);
        }
    }

    public static void setUpCupResultLabel(Label label) {
        ResultScene.resultSoundEffect = SoundManager.playMusic(PathUtil.RESULT_SOUND_EFFECT);
        stylizeLabel(label, 230, 130);
    }
    public static void setUpSurviveResultLabel(Label label) {
        ResultScene.resultSoundEffect = SoundManager.playMusic(PathUtil.RESULT_SOUND_EFFECT);
        stylizeLabel(label, 230, 130);
    }

}
