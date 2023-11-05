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
import util.*;

import java.util.Properties;

public class ResultScene extends VBox
{
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
            placeLabels(cupLabel, 200, 70);
            cupLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 16));
            cupLabel.setTextFill(Color.GHOSTWHITE);
            gameResult.getChildren().add(cupLabel);
        }
        FileUtil.storePerfectFile();
        FileUtil.storeCupFile();
    }

    public void setUpLabelAndTimer()
    {
        congratsLabel = new Label();
        placeLabels(congratsLabel, 120, 10);
        congratsLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 16));
        congratsLabel.setTextFill(Color.GHOSTWHITE);

        playerResult = new Label();
        placeLabels(playerResult, 225, 30);
        playerResult.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 16));
        playerResult.setTextFill(Color.GHOSTWHITE);

        exitToMenuButton = new Button(UtilStringStorage.returnToMenuButton);
        exitToMenuButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 16));
        exitToMenuButton.setTranslateY(160);
        exitToMenuButton.setTranslateX(240);

        Label timeLabel = new Label();
        placeLabels(timeLabel, 225, 35);
        timeLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 16));
        timeLabel.setTextFill(Color.GHOSTWHITE);
        timeLabel.setText(UtilStringStorage.timeLabel + GameTimer.getElapsedMinutes() + UtilStringStorage.minLabel + GameTimer.getSecondsDisplay() +UtilStringStorage.secondesLabel);

        gameResult.getChildren().add(congratsLabel);
        gameResult.getChildren().add(playerResult);
        gameResult.getChildren().add(timeLabel);
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

        achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(0), nbrOfGoldCup);
        cupFile.setProperty("goldCup", String.valueOf(nbrOfGoldCup));

        resultSoundEffect = SoundManager.playMusic(PathUtil.RESULT_SOUND_EFFECT);
        Label cupLabel = new Label(UtilStringStorage.goldCupLabel);
        placeLabels(cupLabel, 200, 70);
        cupLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 16));
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

        achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(1), nbrOfSilverCup);
        cupFile.setProperty("silverCup", String.valueOf(nbrOfSilverCup));

        resultSoundEffect = SoundManager.playMusic(PathUtil.RESULT_SOUND_EFFECT);
        Label cupLabel = new Label(UtilStringStorage.silverCupLabel);
        placeLabels(cupLabel, 200, 70);
        cupLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 16));
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

        achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(2), nbrOfBronzeCup);
        cupFile.setProperty("bronzeCup", String.valueOf(nbrOfBronzeCup));

        resultSoundEffect = SoundManager.playMusic(PathUtil.RESULT_SOUND_EFFECT);
        Label cupLabel = new Label(UtilStringStorage.bronzeCupLabel);
        placeLabels(cupLabel, 200, 70);
        cupLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 16));
        cupLabel.setTextFill(Color.GHOSTWHITE);
        vBox.getChildren().add(cupLabel);
        vBox.getChildren().add(bronzeCup);
    }

    public void checkPerfectScoreAchievement(int numberOfQuestion, Properties perfectScoreFile, String propertyKey, String numberToCompare, int achievementIndex)
    {
        if(questionCount == numberOfQuestion) {
            String checkIntInPerfectFile = String.valueOf(perfectScoreFile.getProperty(propertyKey));
            if(checkIntInPerfectFile.equals(numberToCompare)) {
                achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(achievementIndex), playerFinalScore);
            } else {
                String perfectScoreString = String.valueOf(playerFinalScore);
                perfectScoreFile.setProperty(propertyKey, perfectScoreString);
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
        stylizeIcon(goldCup);

        IconCreator bronzeCupImage = new IconCreator(PathUtil.BRONZE_CUP_PATH);
        bronzeCup = bronzeCupImage.createImage();
        stylizeIcon(bronzeCup);

        IconCreator silverCupImage = new IconCreator(PathUtil.SILVER_CUP_PATH);
        silverCup = silverCupImage.createImage();
        stylizeIcon(silverCup);
    }

    public void stylizeIcon (ImageView imageView)
    {
        imageView.setFitHeight(100);
        imageView.setFitWidth(80);
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
