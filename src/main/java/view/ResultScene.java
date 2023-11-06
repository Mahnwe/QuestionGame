package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import model.SoundManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.*;

import java.util.Properties;

public class ResultScene extends VBox
{
    private static final Logger logger = LogManager.getLogger(ResultScene.class);
    private final VBox gameResult;
    private Button exitToMenuButton;
    private Label congratsLabel;
    private Label playerResult;

    private ImageView goldCup;
    private ImageView bronzeCup;
    private ImageView silverCup;
    private final AchievementManager achievementManager;
    private final int playerFinalScore;
    private final Stage stage;
    private final Properties cupFile;
    private final Properties perfectScoreFile;
    private final int questionCount;
    private MediaPlayer resultSoundEffect;
    public static MediaPlayer returnToMenuMusic;

    public ResultScene(BorderPane pane, int playerFinalScore, int questionCount, AchievementManager achievementManager, Stage stage, Properties cupFile, Properties perfectScoreFile)
    {
        this.achievementManager = achievementManager;
        this.playerFinalScore = playerFinalScore;
        this.questionCount = questionCount;
        this.stage = stage;
        this.cupFile = cupFile;
        this.perfectScoreFile = perfectScoreFile;
        gameResult = new VBox();

        createIcons();
        setUpLabelAndTimer();

        checkPlayerResult();

        gameResult.getChildren().add(exitToMenuButton);
        pane.setCenter(gameResult);

        exitToMenuButton.setOnAction(event -> {
            if(resultSoundEffect != null) {
                SoundManager.stopMusic(resultSoundEffect);
            }
                backToMainMenu();
        });
    }

    public void stylizeLabel(Label label, int translateX, int translateY)
    {
        label.setTranslateX(translateX);
        label.setTranslateY(translateY);
        label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 16));
        label.setTextFill(Color.GHOSTWHITE);
    }

    public void checkPlayerResult()
    {
        AchievementManager.notificationAlert = null;
        if(playerFinalScore >= questionCount*90/100)
        {
            goldCupResult(gameResult);
        }
        if(playerFinalScore >= questionCount*60/100 && playerFinalScore <= questionCount*80/100)
        {
            silverCupResult(gameResult);
        }
        if(playerFinalScore >= questionCount*40/100 && playerFinalScore <= questionCount*50/100)
        {
            bronzeCupResult(gameResult);
        }
        if(playerFinalScore < questionCount*40/100)
        {
            Label cupLabel = new Label(UtilStringStorage.noCupLabel);
            stylizeLabel(cupLabel, 200, 70);
            gameResult.getChildren().add(cupLabel);
        }
        FileUtil.storePerfectFile();
        FileUtil.storeCupFile();
    }

    public void setUpLabelAndTimer()
    {
        congratsLabel = new Label();
        stylizeLabel(congratsLabel, 120, 10);

        playerResult = new Label();
        stylizeLabel(playerResult, 225, 30);

        exitToMenuButton = new Button(UtilStringStorage.returnToMenuButton);
        exitToMenuButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 16));
        exitToMenuButton.setTranslateY(160);
        exitToMenuButton.setTranslateX(240);

        Label timeLabel = new Label();
        stylizeLabel(timeLabel, 225, 35);
        timeLabel.setText(UtilStringStorage.timeLabel + GameTimer.getElapsedMinutes() + UtilStringStorage.minLabel + GameTimer.getSecondsDisplay() +UtilStringStorage.secondesLabel);

        gameResult.getChildren().add(congratsLabel);
        gameResult.getChildren().add(playerResult);
        gameResult.getChildren().add(timeLabel);
    }

    public void setUpResultLabel(Label label)
    {
        resultSoundEffect = SoundManager.playMusic(PathUtil.RESULT_SOUND_EFFECT);
        stylizeLabel(label, 200, 70);
    }

    public void goldCupResult(VBox vBox)
    {
        switch (questionCount) {
            case 10 -> checkPerfectScoreAchievement(10, perfectScoreFile, "perfectScore10", "10", 3);
            case 15 -> checkPerfectScoreAchievement(15, perfectScoreFile, "perfectScore15", "15", 4);
            case 20 -> checkPerfectScoreAchievement(20, perfectScoreFile, "perfectScore20", "20", 5);
            default -> logger.error("Question count bug");
        }

        String checkIntInFile = cupFile.getProperty("goldCup");
        String numberOfGoldCup = checkAndGetNumberOfCup(checkIntInFile);

        int nbrOfGoldCup = Integer.parseInt(numberOfGoldCup);
        nbrOfGoldCup++;

        achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(0), nbrOfGoldCup);
        cupFile.setProperty("goldCup", String.valueOf(nbrOfGoldCup));

        Label cupLabel = new Label(UtilStringStorage.goldCupLabel);
        setUpResultLabel(cupLabel);

        vBox.getChildren().add(cupLabel);
        vBox.getChildren().add(goldCup);
    }

    public void silverCupResult(VBox vBox)
    {
        String checkIntInFile = cupFile.getProperty("silverCup");
        String numberOfSilverCup = checkAndGetNumberOfCup(checkIntInFile);

        int nbrOfSilverCup = Integer.parseInt(numberOfSilverCup);
        nbrOfSilverCup++;

        achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(1), nbrOfSilverCup);
        cupFile.setProperty("silverCup", String.valueOf(nbrOfSilverCup));

        Label cupLabel = new Label(UtilStringStorage.silverCupLabel);
        setUpResultLabel(cupLabel);

        vBox.getChildren().add(cupLabel);
        vBox.getChildren().add(silverCup);
    }

    public void bronzeCupResult(VBox vBox)
    {
        String checkIntInFile = cupFile.getProperty("bronzeCup");
        String numberOfBronzeCup = checkAndGetNumberOfCup(checkIntInFile);

        int nbrOfBronzeCup = Integer.parseInt(numberOfBronzeCup);
        nbrOfBronzeCup++;

        achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(2), nbrOfBronzeCup);
        cupFile.setProperty("bronzeCup", String.valueOf(nbrOfBronzeCup));

        Label cupLabel = new Label(UtilStringStorage.bronzeCupLabel);
        setUpResultLabel(cupLabel);

        vBox.getChildren().add(cupLabel);
        vBox.getChildren().add(bronzeCup);
    }

    public void checkPerfectScoreAchievement(int playerFinalScore, Properties perfectScoreFile, String propertyKey, String numberToCompare, int achievementIndex)
    {
        if(playerFinalScore == Integer.parseInt(numberToCompare)) {
                String perfectScoreString = String.valueOf(playerFinalScore);
                perfectScoreFile.setProperty(propertyKey, perfectScoreString);
                achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(achievementIndex), playerFinalScore);
        }
    }

    public String checkAndGetNumberOfCup(String stringToCheck)
    {
        String numberGetter;
        numberGetter = stringToCheck;
        return numberGetter;
    }

    public void createIcons()
    {
        goldCup = IconCreator.createCupIcon(PathUtil.GOLD_CUP_PATH);
        stylizeIcon(goldCup);

        bronzeCup = IconCreator.createCupIcon(PathUtil.BRONZE_CUP_PATH);
        stylizeIcon(bronzeCup);

        silverCup = IconCreator.createCupIcon(PathUtil.SILVER_CUP_PATH);
        stylizeIcon(silverCup);
    }

    public void stylizeIcon (ImageView imageView)
    {
        imageView.setTranslateY(80);
        imageView.setTranslateX(280);
    }

    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
        returnToMenuMusic = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);

        if(AchievementManager.notificationAlert != null) {
            NotificationAlert notificationAlert = AchievementManager.notificationAlert;
            notificationAlert.showAlert();
        }
    }

    public Label getPlayerResult() {
        return playerResult;
    }

    public Label getCongratsLabel() {
        return congratsLabel;
    }

}
