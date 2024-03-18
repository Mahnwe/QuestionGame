package view.scene;

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
import model.handlers.*;
import util.*;
import util.creators.IconCreator;
import util.stringutiltranslate.UtilStringStorage;
import view.App;
import view.customobject.CustomOption;
import view.customobject.NotificationAlert;

public class ResultScene extends VBox
{
    private final VBox gameResult;
    private Button exitToMenuButton;
    private Label congratsLabel;
    private Label playerResult;
    private ImageView goldCupImage;
    private ImageView bronzeCupImage;
    private ImageView silverCupImage;
    private final AchievementManager achievementManager;
    private final int playerFinalScore;
    private final Stage stage;
    private final int questionCount;
    public static MediaPlayer resultSoundEffect;
    private final GameHandler gameHandler;

    public ResultScene(BorderPane pane, int playerFinalScore, int questionCount, AchievementManager achievementManager, Stage stage, GameHandler gameHandler)
    {
        this.achievementManager = achievementManager;
        this.playerFinalScore = playerFinalScore;
        this.questionCount = questionCount;
        this.gameHandler = gameHandler;
        this.stage = stage;
        gameResult = new VBox();
        pane.getLeft().setVisible(false);
        pane.getTop().setVisible(false);

        createIcons();
        setUpLabelAndTimer();
        AnswerHandler.storeStatsInFile();

        if(GameHandler.gameMode == null)
        {
            checkPlayerResultNormalMod();
        } else if (GameHandler.gameMode.equals("survival"))
        {
            checkSurvivalModeResult();
        }

        gameResult.getChildren().add(exitToMenuButton);
        pane.setCenter(gameResult);
        gameResult.setTranslateY(100);
        gameResult.setTranslateX(100);

    }

    public void stylizeLabel(Label label, int translateX, int translateY) {
        label.setTranslateX(translateX);
        label.setTranslateY(translateY);
        label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 28));
        label.setTextFill(Color.GHOSTWHITE);
    }

    public void checkSurvivalModeResult()
    {
        AchievementManager.notificationAlert = null;
        if(questionCount < 10)
        {
            ResultHandler.survivalNoCupResult(questionCount, gameResult);
        }
        if(questionCount >= 10 && questionCount <= 19)
        {
            ResultHandler.survivalBronzeResult(achievementManager, questionCount, playerFinalScore, gameResult, bronzeCupImage);
        }
        if(questionCount >= 20 && questionCount <= 29)
        {
            ResultHandler.survivalSilverResult(achievementManager, questionCount, playerFinalScore, gameResult, silverCupImage);
        }
        if(questionCount >= 30)
        {
            ResultHandler.survivalGoldResult(achievementManager, questionCount, playerFinalScore, gameResult, goldCupImage);
            if(questionCount == gameHandler.getQuestionList().size())
            {
                int numberOfSecretCup = Integer.parseInt(FileUtil.getGeneralSavesFile().getProperty("secretCup"));
                numberOfSecretCup++;
                FileUtil.getGeneralSavesFile().setProperty("secretCup", String.valueOf(numberOfSecretCup));
                FileUtil.storeGeneralSavesFile();
            }
        }

        achievementManager.checkNumberOfGamesAchievement(achievementManager, FileUtil.getGeneralSavesFile());
        FileUtil.incrementGeneralStat("numberOfSurvivalGames");
        FileUtil.storeGeneralSavesFile();
    }

    public void checkPlayerResultNormalMod()
    {
        AchievementManager.notificationAlert = null;
        if(playerFinalScore >= questionCount*90/100)
        {
            ResultHandler.normalGoldResult(achievementManager, questionCount, playerFinalScore, gameResult, goldCupImage);
        }
        else if(playerFinalScore >= questionCount*70/100 && playerFinalScore < questionCount*90/100)
        {
            ResultHandler.normalSilverResult(achievementManager, questionCount, playerFinalScore, gameResult, silverCupImage);
        }
        else if(playerFinalScore >= questionCount*50/100 && playerFinalScore < questionCount*70/100)
        {
            ResultHandler.normalBronzeResult(achievementManager, questionCount, playerFinalScore, gameResult, bronzeCupImage);
        }
        else
        {
            ResultHandler.normalNoCupResult(achievementManager, questionCount, playerFinalScore, gameResult);
        }
        achievementManager.checkNumberOfGamesAchievement(achievementManager, FileUtil.getGeneralSavesFile());
        FileUtil.incrementGeneralStat("numberOfNormalGames");
        FileUtil.storeGeneralSavesFile();
    }

    public void setUpLabelAndTimer()
    {
        congratsLabel = new Label();
        stylizeLabel(congratsLabel, 200, 10);

        playerResult = new Label();
        stylizeLabel(playerResult, 235, 50);

        exitToMenuButton = new Button(UtilStringStorage.returnToMenuButton);
        CustomOption.customExitToMenuButton(exitToMenuButton);
        exitToMenuButton.setOnAction(event -> {
            SoundManager.checkIfMusicIsPlayed(resultSoundEffect);
            backToMainMenu();
            GameHandler.gameMode = null;
        });

        Label timeLabel = new Label();
        stylizeLabel(timeLabel, 230, 55);
        timeLabel.setText(UtilStringStorage.timeLabel +"  "+ GameTimer.getElapsedMinutes() + UtilStringStorage.minLabel + GameTimer.getSecondsDisplay() +UtilStringStorage.secondesLabel);

        gameResult.getChildren().add(congratsLabel);
        gameResult.getChildren().add(playerResult);
        gameResult.getChildren().add(timeLabel);
    }

    public void createIcons()
    {
        goldCupImage = IconCreator.createCupIcon(PathUtil.GOLD_CUP_PATH);
        stylizeIcon(goldCupImage);

        bronzeCupImage = IconCreator.createCupIcon(PathUtil.BRONZE_CUP_PATH);
        stylizeIcon(bronzeCupImage);

        silverCupImage = IconCreator.createCupIcon(PathUtil.SILVER_CUP_PATH);
        stylizeIcon(silverCupImage);
    }

    public void stylizeIcon (ImageView imageView)
    {
        imageView.setFitHeight(200);
        imageView.setFitWidth(180);
        imageView.setTranslateY(120);
        imageView.setTranslateX(340);
    }

    public void backToMainMenu()
    {
        SoundManager.stopMusic(MainScene.inGameMusicToStop);
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
        App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);

        if(AchievementManager.notificationAlert != null) {
            NotificationAlert notificationAlert = AchievementManager.notificationAlert;
            NotificationAlert.hideAlertAfter5Sec(notificationAlert);
        }
    }

    public Label getPlayerResult() {
        return playerResult;
    }

    public Label getCongratsLabel() {
        return congratsLabel;
    }

}
