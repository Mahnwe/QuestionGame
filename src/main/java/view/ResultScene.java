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
import model.*;

import java.io.*;
import java.util.Properties;

public class ResultScene extends VBox
{
    private final Label congratsLabel;
    private final Label playerResult;

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
        VBox gameResult = new VBox();
        createIcons();

        congratsLabel = new Label();
        placeLabels(congratsLabel, 120, 10);
        congratsLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        congratsLabel.setTextFill(Color.GHOSTWHITE);

        playerResult = new Label();
        placeLabels(playerResult, 200, 30);
        playerResult.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        playerResult.setTextFill(Color.GHOSTWHITE);

        Button exitToMenuButton = new Button(UtilStringStorage.returnToMenuButton);
        exitToMenuButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        exitToMenuButton.setTranslateY(70);

        Label timeLabel = new Label();
        placeLabels(timeLabel, 200, 30);
        timeLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        timeLabel.setTextFill(Color.GHOSTWHITE);
        timeLabel.setText(UtilStringStorage.timeLabel + GameTimer.getElapsedMinutes() + UtilStringStorage.minLabel + GameTimer.getSecondsDisplay() +UtilStringStorage.secondesLabel);

        gameResult.getChildren().add(congratsLabel);
        gameResult.getChildren().add(playerResult);
        gameResult.getChildren().add(timeLabel);

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
            placeLabels(cupLabel, 200, 50);
            cupLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
            cupLabel.setTextFill(Color.GHOSTWHITE);
            gameResult.getChildren().add(cupLabel);
        }
        gameResult.getChildren().add(exitToMenuButton);
        pane.setCenter(gameResult);
        exitToMenuButton.setOnAction(event -> {
            SoundManager.stopMusic(resultSoundEffect);
            backToMainMenu();
        });
    }

    public void goldCupResult(VBox vBox)
    {
        String checkIntInFile = cupFile.getProperty("goldCup");
        String numberOfGoldCup = checkAndGetNumberOfCup(checkIntInFile);

        int nbrOfGoldCup = Integer.parseInt(numberOfGoldCup);
        nbrOfGoldCup++;

        checkPerfectScoreAchievement(10, perfectScoreFile, "perfectScore10", "10", 3);
        checkPerfectScoreAchievement(15, perfectScoreFile, "perfectScore15", "15", 4);
        checkPerfectScoreAchievement(20, perfectScoreFile, "perfectScore20", "20", 5);

        achievementManager.getAchievementsList().get(0).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(0), nbrOfGoldCup);
        cupFile.setProperty("goldCup", String.valueOf(nbrOfGoldCup));
        try {
            cupFile.store(new FileWriter(PathUtil.CUP_FILE), "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        resultSoundEffect = SoundManager.playMusic(PathUtil.RESULT_SOUND_EFFECT);
        Label cupLabel = new Label(UtilStringStorage.goldCupLabel);
        placeLabels(cupLabel, 200, 50);
        cupLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        cupLabel.setTextFill(Color.GHOSTWHITE);
        vBox.getChildren().add(cupLabel);
        vBox.getChildren().add(goldCup);
    }

    public void silverCupResult(VBox vBox)
    {
        String checkIntInFile = cupFile.getProperty("silverCup");
        String numberOfSilverCup = checkAndGetNumberOfCup(checkIntInFile);

        int nbrOfSilverCup = Integer.parseInt(numberOfSilverCup);
        nbrOfSilverCup++;

        achievementManager.getAchievementsList().get(1).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(1), nbrOfSilverCup);
        cupFile.setProperty("silverCup", String.valueOf(nbrOfSilverCup));
        try {
            cupFile.store(new FileWriter(PathUtil.CUP_FILE), "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        resultSoundEffect = SoundManager.playMusic(PathUtil.RESULT_SOUND_EFFECT);
        Label cupLabel = new Label(UtilStringStorage.silverCupLabel);
        placeLabels(cupLabel, 200, 50);
        cupLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        cupLabel.setTextFill(Color.GHOSTWHITE);
        vBox.getChildren().add(cupLabel);
        vBox.getChildren().add(silverCup);
    }

    public void bronzeCupResult(VBox vBox)
    {
        String checkIntInFile = cupFile.getProperty("bronzeCup");
        String numberOfBronzeCup = checkAndGetNumberOfCup(checkIntInFile);

        int nbrOfBronzeCup = Integer.parseInt(numberOfBronzeCup);
        nbrOfBronzeCup++;

        achievementManager.getAchievementsList().get(2).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(2), nbrOfBronzeCup);
        cupFile.setProperty("bronzeCup", String.valueOf(nbrOfBronzeCup));
        try {
            cupFile.store(new FileWriter(PathUtil.CUP_FILE), "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        resultSoundEffect = SoundManager.playMusic(PathUtil.RESULT_SOUND_EFFECT);
        Label cupLabel = new Label(UtilStringStorage.bronzeCupLabel);
        placeLabels(cupLabel, 200, 50);
        cupLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        cupLabel.setTextFill(Color.GHOSTWHITE);
        vBox.getChildren().add(cupLabel);
        vBox.getChildren().add(bronzeCup);
    }

    public void checkPerfectScoreAchievement(int numberOfQuestion, Properties perfectScoreFile, String propertyKey, String numberToCompare, int achievementIndex)
    {
        if(questionCount == numberOfQuestion) {
            String checkIntInPerfectFile = String.valueOf(perfectScoreFile.getProperty(propertyKey));
            if(checkIntInPerfectFile.equals(numberToCompare)) {
                achievementManager.getAchievementsList().get(achievementIndex).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(achievementIndex), playerFinalScore);
            } else {
                String perfectScoreString = String.valueOf(playerFinalScore);
                perfectScoreFile.setProperty(propertyKey, perfectScoreString);
                try {
                    perfectScoreFile.store(new FileWriter(PathUtil.PERFECT_SCORE_FILE), "");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

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
        IconCreator goldCupImage = new IconCreator(PathUtil.GOLD_CUP_PATH);
        goldCup = goldCupImage.createImage();
        goldCup.setFitHeight(100);
        goldCup.setFitWidth(80);
        goldCup.setTranslateY(50);
        goldCup.setTranslateX(260);

        IconCreator bronzeCupImage = new IconCreator(PathUtil.BRONZE_CUP_PATH);
        bronzeCup = bronzeCupImage.createImage();
        bronzeCup.setFitHeight(100);
        bronzeCup.setFitWidth(80);
        bronzeCup.setTranslateY(50);
        bronzeCup.setTranslateX(260);

        IconCreator silverCupImage = new IconCreator(PathUtil.SILVER_CUP_PATH);
        silverCup = silverCupImage.createImage();
        silverCup.setFitHeight(100);
        silverCup.setFitWidth(80);
        silverCup.setTranslateY(50);
        silverCup.setTranslateX(260);
    }

    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
        returnToMenuMusic = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
    }

    public void placeLabels(Label label, int x, int y)
    {
        label.setTranslateX(x);
        label.setTranslateY(y);
    }

    public Label getPlayerResult() {
        return playerResult;
    }

    public Label getCongratsLabel() {
        return congratsLabel;
    }

}
