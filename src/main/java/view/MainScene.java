package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.*;
import util.BackgroundCreator;
import util.FileUtil;
import util.PathUtil;
import util.UtilStringStorage;


public class MainScene extends Scene
{
    private final BorderPane menuPane;
    private QuestionInterface questionInterface;
    private PlayerInfoScene playerInfoScene;
    private final GameHandler gameHandler;
    private final Stage stage;
    private final AchievementManager achievementManager;
    public static MediaPlayer inGameMusicToStop = SoundManager.playMusicRepeat(PathUtil.IN_GAME_MUSIC);
    private final Player player;
    private static final String SURVIVAL_MODE = "survival";

    public MainScene(Player player, GameHandler gameHandler, Stage stage, AchievementManager achievementManager)
    {
        super(new BorderPane());
        this.stage = stage;
        this.menuPane = (BorderPane) this.getRoot();
        this.player = player;
        menuPane.setPrefWidth(1000);
        menuPane.setPrefHeight(550);
        this.gameHandler = gameHandler;
        this.achievementManager = achievementManager;

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
        Button validateAnswerButton = questionInterface.getValidateAnswerButton();
        validateAnswerButton.setOnAction(e -> {
            questionInterface.checkAnswer();
            if(questionInterface.isPlayerAnswer())
            {
                playerInfoScene.increaseScore();
            }
            else {
                playerInfoScene.removePlayerLife();
                if(playerInfoScene.getPlayerLivesLabel() != null) {
                    playerInfoScene.getPlayerLivesLabel().setText(UtilStringStorage.playerLivesIngame + " " + playerInfoScene.getPlayer().getNbrOfLives());
                }
            }
            playerInfoScene.getPlayerScoreLabel().setText(UtilStringStorage.scoreLabel + " " +playerInfoScene.getPlayer().getPlayerScore()+"/"+gameHandler.getQuestionCount());
            setNextQuestionButton();
        });
    }

    private void setNextQuestionButton()
    {
        questionInterface.getNextQuestionButton().setOnAction(event -> {
            SoundManager.stopMusic(QuestionInterface.soundEffectToStop);
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

        ResultScene resultScene = new ResultScene(menuPane, playerInfoScene.getPlayer().getPlayerScore(), gameHandler.getQuestionCount(), achievementManager, stage);

        SoundManager.checkIfMusicIsPlayed(MenuScene.relaunchGame);
        SoundManager.stopMusic(inGameMusicToStop);

        resultScene.getCongratsLabel().setText(UtilStringStorage.congratsLabel +" "+ playerInfoScene.getPlayer().getPlayerName()+" "+UtilStringStorage.answerAllQuestions);

        if(GameHandler.gameMode == null) {
            resultScene.getPlayerResult().setText(UtilStringStorage.playerResult + playerInfoScene.getPlayer().getPlayerScore() + " " + UtilStringStorage.scoreOn + " " + gameHandler.getQuestionCount());
        }
        else if(GameHandler.gameMode.equals(SURVIVAL_MODE)) {
            resultScene.getPlayerResult().setText(UtilStringStorage.survivalLabel +" "+playerInfoScene.getPlayer().getPlayerScore() + " questions");
        }
    }

    public void saveScoreInFile()
    {
        if(GameHandler.gameMode == null) {
            FileUtil.writeInSaveFile(FileUtil.saveFile, UtilStringStorage.classicModeLabelInfile+ " "+UtilStringStorage.playerNameInfile + " " + playerInfoScene.getPlayer().getPlayerName() + "   " + UtilStringStorage.scoreLabelInfile + " " + playerInfoScene.getPlayer().getPlayerScore() + " " + UtilStringStorage.scoreOn + " " + gameHandler.getQuestionCount() +
                    "  " + UtilStringStorage.timerLabelInfile + " " + GameTimer.getElapsedMinutes() + " " + UtilStringStorage.gameMinutes + " " + GameTimer.getSecondsDisplay() + " " + UtilStringStorage.gameSecondes + "\n");
        }
        else if(GameHandler.gameMode.equals(SURVIVAL_MODE)) {
            FileUtil.writeInSaveFile(FileUtil.saveFile,  UtilStringStorage.survivalLabelInfile +"  "+ UtilStringStorage.playerNameInfile +" "+ playerInfoScene.getPlayer().getPlayerName() +"  "+ UtilStringStorage.scoreLabelInfile +" "+ playerInfoScene.getPlayer().getPlayerScore()+ " questions"+
                    "  " + UtilStringStorage.timerLabelInfile + " " + GameTimer.getElapsedMinutes() + " " + UtilStringStorage.gameMinutes + " " + GameTimer.getSecondsDisplay() + " " + UtilStringStorage.gameSecondes +"\n");
        }
    }

    public void checkGameEnding()
    {
        if(GameHandler.gameMode == null) {
            if (gameHandler.isGameEnding()) {
                setDisplayResult();
                saveScoreInFile();
            } else {
                createNewQuestionInterface();
            }
        }
        else if(GameHandler.gameMode.equals(SURVIVAL_MODE))
        {
            if(questionInterface.isPlayerAnswer())
            {
                createNewQuestionInterface();
            }
            else {
                if(playerInfoScene.getPlayer().getNbrOfLives() == 0) {
                    setDisplayResult();
                    saveScoreInFile();
                } else {
                    createNewQuestionInterface();
                }
            }
        }
    }

}
