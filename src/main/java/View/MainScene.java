package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
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


    public MainScene(BorderPane menuPane, Player player, GameHandler gameHandler, Stage stage, File saveFile, TrophyHandler trophyHandler, AchievementManager achievementManager)
    {
        super(menuPane);
        this.stage = stage;
        this.menuPane = menuPane;
        this.gameHandler = gameHandler;
        this.saveFile = saveFile;
        this.trophyHandler = trophyHandler;
        this.achievementManager = achievementManager;

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
                playerInfoVBox.IncreaseScore();
            }
            playerInfoVBox.getPlayerScoreLabel().setText("Score : "+playerInfoVBox.getPlayer().getPlayerScore()+"/"+gameHandler.getQuestionCount());
            checkGameEnding();
        });
    }

    public void createNewQuestionInterface()
    {
        questionInterface = new QuestionInterface(new BorderPane(), gameHandler.getQuestionList().get(gameHandler.getQuestionCount()));
        questionInterface.getQuestionToAsk().setText("Question n°" + (gameHandler.getQuestionCount() + 1) + " : " + questionInterface.getQuestion().getQuestionToAsk());
        setAnswersButtonListeners();
        menuPane.setCenter(questionInterface);
        gameHandler.IncreaseQuestionCount();
    }

    public void setDisplayResult()
    {
        ResultScene resultScene = new ResultScene(menuPane, playerInfoVBox.getPlayer().getPlayerScore(), gameHandler.getQuestionCount(), trophyHandler, achievementManager, stage);
        resultScene.getCongratsLabel().setText("Bravo "+playerInfoVBox.getPlayer().getPlayerName()+" vous avez répondu à toutes les questions !");
        resultScene.getPlayerResult().setText("Votre score : "+playerInfoVBox.getPlayer().getPlayerScore()+" sur "+gameHandler.getQuestionCount());
    }

    public void saveScoreInFile()
    {
        try {
            boolean append = true;
            FileWriter fw = new FileWriter(saveFile.getAbsoluteFile(), append);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Nom : "+playerInfoVBox.getPlayer().getPlayerName()+"  "+" Score : "+playerInfoVBox.getPlayer().getPlayerScore()+" sur "+gameHandler.getQuestionCount()+"\n");
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkGameEnding()
    {
        if(gameHandler.isGameEnding())
        {
            saveScoreInFile();
            setDisplayResult();
        }
        else
        {
            createNewQuestionInterface();
        }
    }

}
