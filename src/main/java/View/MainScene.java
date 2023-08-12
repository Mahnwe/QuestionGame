package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.GameHandler;
import org.example.Player;


public class MainScene extends Scene
{
    private final BorderPane menuPane;
    private QuestionInterface questionInterface;

    // Enlever ces trois variables "intermédiaires"
    private int questionCount = 0;
    private int playerScore;
    private boolean playerAnswer;

    private final PlayerInfoVBox playerInfoVBox;

    private final GameHandler gameHandler;

    private final Stage stage;

    private final SaveFile saveFile;


    public MainScene(BorderPane menuPane, Player player, GameHandler gameHandler, Stage stage, SaveFile saveFile)
    {
        super(menuPane);
        this.menuPane = menuPane;
        this.gameHandler = gameHandler;
        this.stage = stage;
        this.saveFile = saveFile;

        playerInfoVBox = new PlayerInfoVBox(player);
        playerInfoVBox.getPlayer().setPlayerScore(playerScore);
        menuPane.setTop(playerInfoVBox.createUserInputArea());
        playerInfoVBox.setOnActionSendButton(menuPane);

        createNewQuestionInterface();
        setAnswersButtonListeners();
    }

    private void setAnswersButtonListeners()
    {
        Button nextQuestionButton = questionInterface.getNextQuestionButton();
        nextQuestionButton.setOnAction(e -> {
            playerAnswer = questionInterface.isPlayerAnswer();
            // Faire une fonction dans playerInfoVBox et factoriser le setText pour l'appeller qu'une fois
            if(playerAnswer)
            {
                playerScore++;
                playerInfoVBox.getPlayerScoreLabel().setText("Score : "+playerScore+"/"+questionCount);
            }
            else
            {
                playerInfoVBox.getPlayerScoreLabel().setText("Score : "+playerScore+"/"+questionCount);
            }
            checkGameEnding();
        });
    }


    public void createNewQuestionInterface()
    {
                questionInterface = new QuestionInterface(new BorderPane(), gameHandler.getQuestionList().get(questionCount));
                questionInterface.getQuestionToAsk().setText("Question n°" + (questionCount + 1) + " : " + questionInterface.getQuestion().getQuestionToAsk());
                setAnswersButtonListeners();
                menuPane.setCenter(questionInterface);
                questionCount++;
    }

    public void setDisplayResult()
    {
        ResultScene resultScene = new ResultScene(menuPane);
        resultScene.getCongratsLabel().setText("Bravo "+playerInfoVBox.getPlayer().getPlayerName()+" vous avez répondu à toutes les questions !");
        resultScene.getPlayerResult().setText("Votre score : "+playerScore+" sur "+questionCount);

        resultScene.getExitToMenuButton().setOnAction(event -> backToMainMenu());
    }

    public void saveScoreInFile()
    {
        String result = "Nom : " + playerInfoVBox.getPlayer().getPlayerName() + "  " + " Score : " + playerScore + " sur " + questionCount + "\n";
        saveFile.getScoreArea().appendText(result);
    }

    public void checkGameEnding()
    {
        // Déplacer ce check dans game handler isGameEnded() or some shit ?
        if(questionCount >= gameHandler.getQuestionList().size())
        {
            saveScoreInFile();
            setDisplayResult();
        }
        else
        {
            createNewQuestionInterface();
        }
    }

    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage);
        stage.setMinHeight(500);
        stage.setMinWidth(750);
        stage.setScene(menuScene);
    }

}
