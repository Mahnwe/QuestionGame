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
import model.GameHandler;
import model.GameTimer;
import model.SoundManager;
import util.*;

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
    private final int questionCount;
    public static MediaPlayer resultSoundEffect;
    public static MediaPlayer returnToMenuMusic;

    public ResultScene(BorderPane pane, int playerFinalScore, int questionCount, AchievementManager achievementManager, Stage stage)
    {
        this.achievementManager = achievementManager;
        this.playerFinalScore = playerFinalScore;
        this.questionCount = questionCount;
        this.stage = stage;
        gameResult = new VBox();

        createIcons();
        setUpLabelAndTimer();

        if(GameHandler.gameMode == null) {
            checkPlayerResult();
        } else if (GameHandler.gameMode.equals("survival"))
        {
            checkSurvivalModeResult();
        }

        gameResult.getChildren().add(exitToMenuButton);
        pane.setCenter(gameResult);

    }

    public void stylizeLabel(Label label, int translateX, int translateY) {
        label.setTranslateX(translateX);
        label.setTranslateY(translateY);
        label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 16));
        label.setTextFill(Color.GHOSTWHITE);
    }

    public void checkSurvivalModeResult()
    {
        AchievementManager.notificationAlert = null;
        if(playerFinalScore < 50) {
            Label cupLabel = new Label(UtilStringStorage.noCupLabel);
            stylizeLabel(cupLabel, 100, 70);
            gameResult.getChildren().add(cupLabel);
        }
        achievementManager.survivalModeResult(questionCount, playerFinalScore, FileUtil.survivalFile, achievementManager);
        FileUtil.storeSurvivalFile();
    }

    public void checkPlayerResult()
    {
        AchievementManager.notificationAlert = null;
        if(playerFinalScore >= questionCount*90/100)
        {
            achievementManager.goldCupResult(questionCount, playerFinalScore, gameResult, FileUtil.perfectScoreFile, FileUtil.cupFile, achievementManager, goldCup);
        }
        if(playerFinalScore > questionCount*60/100 && playerFinalScore <= questionCount*80/100)
        {
            achievementManager.silverCupResult(gameResult, FileUtil.cupFile, achievementManager, silverCup);
        }
        if(playerFinalScore >= questionCount*50/100 && playerFinalScore < questionCount*60/100)
        {
            achievementManager.bronzeCupResult(gameResult, FileUtil.cupFile, achievementManager, bronzeCup);
        }
        if(playerFinalScore < questionCount*50/100)
        {
            Label cupLabel = new Label(UtilStringStorage.noCupLabel);
            stylizeLabel(cupLabel, 100, 70);
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
        CustomOption.customExitToMenuButton(exitToMenuButton);
        exitToMenuButton.setOnAction(event -> {
            if(resultSoundEffect != null) {
                SoundManager.stopMusic(resultSoundEffect);
            }
            backToMainMenu();
        });

        Label timeLabel = new Label();
        stylizeLabel(timeLabel, 225, 35);
        timeLabel.setText(UtilStringStorage.timeLabel + GameTimer.getElapsedMinutes() + UtilStringStorage.minLabel + GameTimer.getSecondsDisplay() +UtilStringStorage.secondesLabel);

        gameResult.getChildren().add(congratsLabel);
        gameResult.getChildren().add(playerResult);
        gameResult.getChildren().add(timeLabel);
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
