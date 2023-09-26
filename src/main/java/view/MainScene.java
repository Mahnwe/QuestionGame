package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import model.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class MainScene extends Scene
{
    private final BorderPane menuPane;
    private QuestionInterface questionInterface;

    private final PlayerInfoVBox playerInfoVBox;

    private final GameHandler gameHandler;

    private final Stage stage;

    private final File saveFile;

    private final TrophyHandler trophyHandler;
    private final AchievementManager achievementManager;
    private final File goldCupFile;
    private final File silverCupFile;
    private final File bronzeCupFile;
    private final File perfectScoreFile10;
    private final File perfectScoreFile15;
    private final File perfectScoreFile20;

    public MainScene(BorderPane menuPane, Player player, GameHandler gameHandler, Stage stage, File saveFile, TrophyHandler trophyHandler, AchievementManager achievementManager, File perfectScoreFile10, File perfectScoreFile15, File perfectScoreFile20, File goldCupFile, File silverCupFile, File bronzeCupFile)
    {
        super(menuPane);
        this.stage = stage;
        this.menuPane = menuPane;
        menuPane.setPrefWidth(900);
        menuPane.setPrefHeight(500);
        this.gameHandler = gameHandler;
        this.saveFile = saveFile;
        this.trophyHandler = trophyHandler;
        this.achievementManager = achievementManager;
        this.goldCupFile = goldCupFile;
        this.silverCupFile = silverCupFile;
        this.bronzeCupFile = bronzeCupFile;
        this.perfectScoreFile10 = perfectScoreFile10;
        this.perfectScoreFile15 = perfectScoreFile15;
        this.perfectScoreFile20 = perfectScoreFile20;


        BackgroundCreator mainSceneBackgroundCreator = new BackgroundCreator(PathUtil.MAIN_BACKGROUND);
        Image mainSceneImage = mainSceneBackgroundCreator.createBackground();
        BackgroundFill backgroundFill = new BackgroundFill(new ImagePattern(mainSceneImage), CornerRadii.EMPTY, Insets.EMPTY);
        menuPane.setBackground(new Background(backgroundFill));

        createNewQuestionInterface();
        setAnswersButtonListeners();
        questionInterface.setVisible(false);

        playerInfoVBox = new PlayerInfoVBox(player);
        menuPane.setTop(playerInfoVBox.createUserInputArea());
        playerInfoVBox.setOnActionSendButton(menuPane, questionInterface, stage);

    }

    private void setAnswersButtonListeners()
    {
        Button nextQuestionButton = questionInterface.getNextQuestionButton();
        nextQuestionButton.setOnAction(e -> {
            if(questionInterface.isPlayerAnswer())
            {
                playerInfoVBox.increaseScore();
            }
            playerInfoVBox.getPlayerScoreLabel().setText(UtilStringStorage.scoreLabel +playerInfoVBox.getPlayer().getPlayerScore()+"/"+gameHandler.getQuestionCount());
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
        ResultScene resultScene = new ResultScene(menuPane, playerInfoVBox.getPlayer().getPlayerScore(), gameHandler.getQuestionCount(), trophyHandler, achievementManager, stage, perfectScoreFile10, perfectScoreFile15, perfectScoreFile20, goldCupFile, silverCupFile, bronzeCupFile);
        GameTimer.stopTimer();
        GameTimer.setTimerDisplay();
        resultScene.getCongratsLabel().setText(UtilStringStorage.congratsLabel +playerInfoVBox.getPlayer().getPlayerName()+UtilStringStorage.answerAllQuestions);
        resultScene.getPlayerResult().setText(UtilStringStorage.playerResult +playerInfoVBox.getPlayer().getPlayerScore()+UtilStringStorage.scoreOn +gameHandler.getQuestionCount());
    }

    public void saveScoreInFile()
    {
        try {
            boolean append = true;
            FileWriter fw = new FileWriter(saveFile.getAbsoluteFile(), append);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(UtilStringStorage.playerNameInfile +" "+playerInfoVBox.getPlayer().getPlayerName() + "  " + UtilStringStorage.scoreLabelInfile +" "+ playerInfoVBox.getPlayer().getPlayerScore() + " "+ UtilStringStorage.scoreOn +" "+gameHandler.getQuestionCount() + " "+UtilStringStorage.gameIn +" "+ GameTimer.getElapsedMinutes() +" "+ UtilStringStorage.gameMinutes +" "+ GameTimer.getElapsedSeconds() +" "+ UtilStringStorage.gameSecondes + "\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
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
