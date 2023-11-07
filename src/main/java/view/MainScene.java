package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.AchievementManager;
import model.GameHandler;
import model.Player;
import model.SoundManager;
import util.*;

import java.io.File;
import java.util.Properties;


public class MainScene extends Scene
{
    private final BorderPane menuPane;
    private QuestionInterface questionInterface;

    private PlayerInfoScene playerInfoScene;

    private final GameHandler gameHandler;

    private final Stage stage;

    private final File saveFile;
    private final AchievementManager achievementManager;
    private final Properties perfectScoreFile;
    private final Properties cupFile;
    public static MediaPlayer inGameMusicToStop = SoundManager.playMusicRepeat(PathUtil.IN_GAME_MUSIC);
    private final Player player;

    public MainScene(Player player, GameHandler gameHandler, Stage stage, File saveFile, AchievementManager achievementManager, Properties cupFile, Properties perfectScoreFile)
    {
        super(new BorderPane());
        this.stage = stage;
        this.menuPane = (BorderPane) this.getRoot();
        this.player = player;
        menuPane.setPrefWidth(1000);
        menuPane.setPrefHeight(500);
        this.gameHandler = gameHandler;
        this.saveFile = saveFile;
        this.achievementManager = achievementManager;
        this.cupFile = cupFile;
        this.perfectScoreFile = perfectScoreFile;

        createBackground();

        createNewQuestionInterface();
        setAnswersButtonListeners();
        questionInterface.setDisable(true);

        createPopup();

    }

    public void createBackground()
    {
        BackgroundFill backgroundFill = BackgroundCreator.createGameBackground();
        menuPane.setBackground(new Background(backgroundFill));
    }

    public void createPopup()
    {
        playerInfoScene = new PlayerInfoScene(new BorderPane(), player);
        playerInfoScene = PopUp.createPopup(player, menuPane, questionInterface, stage);
    }

    private void setAnswersButtonListeners()
    {
        Button nextQuestionButton = questionInterface.getNextQuestionButton();
        nextQuestionButton.setOnAction(e -> {
            if(questionInterface.isPlayerAnswer())
            {
                SoundManager.stopMusic(QuestionInterface.soundEffectToStop);
                playerInfoScene.increaseScore();
            }
            playerInfoScene.getPlayerScoreLabel().setText(UtilStringStorage.scoreLabel + playerInfoScene.getPlayer().getPlayerScore()+"/"+gameHandler.getQuestionCount());
            checkGameEnding();
        });
    }

    public void createNewQuestionInterface()
    {
        questionInterface = new QuestionInterface(new BorderPane(), gameHandler.getQuestionList().get(gameHandler.getQuestionCount()));
        questionInterface.getQuestionToAsk().setText(UtilStringStorage.questionNumber + (gameHandler.getQuestionCount() + 1) + " : " + questionInterface.getQuestion().getQuestionToAsk());
        setAnswersButtonListeners();
        menuPane.setCenter(questionInterface);
        gameHandler.increaseQuestionCount();
    }

    public void setDisplayResult()
    {
        GameTimer.stopTimer();
        GameTimer.setTimerDisplay();
        ResultScene resultScene = new ResultScene(menuPane, playerInfoScene.getPlayer().getPlayerScore(), gameHandler.getQuestionCount(), achievementManager, stage, cupFile, perfectScoreFile);
        if(MenuScene.relaunchGame !=null) {
            SoundManager.stopMusic(MenuScene.relaunchGame);
        }
        SoundManager.stopMusic(inGameMusicToStop);
        resultScene.getCongratsLabel().setText(UtilStringStorage.congratsLabel +" "+ playerInfoScene.getPlayer().getPlayerName()+" "+UtilStringStorage.answerAllQuestions);
        resultScene.getPlayerResult().setText(UtilStringStorage.playerResult + playerInfoScene.getPlayer().getPlayerScore()+" "+UtilStringStorage.scoreOn +" "+gameHandler.getQuestionCount());
    }

    public void saveScoreInFile()
    {
        FileUtil.writeInSaveFile(saveFile,UtilStringStorage.playerNameInfile +" "+ playerInfoScene.getPlayer().getPlayerName() + "   " + UtilStringStorage.scoreLabelInfile +" "+ playerInfoScene.getPlayer().getPlayerScore() + " "+ UtilStringStorage.scoreOn +" "+gameHandler.getQuestionCount() +
                "  "+UtilStringStorage.timerLabelInfile +" "+ GameTimer.getElapsedMinutes() +" "+ UtilStringStorage.gameMinutes +" "+ GameTimer.getSecondsDisplay() +" "+ UtilStringStorage.gameSecondes + "\n");
    }

    public void checkGameEnding()
    {
        if(gameHandler.isGameEnding())
        {
            setDisplayResult();
            saveScoreInFile();
        }
        else
        {
            createNewQuestionInterface();
        }
    }

}
