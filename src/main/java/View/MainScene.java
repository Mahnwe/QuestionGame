package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import org.example.GameHandler;
import org.example.Player;


public class MainScene extends Scene
{
    private BorderPane menuPane;
    private QuestionInterface questionInterface;
    private int questionCount = 0;

    private int playerScore;

    private boolean playerAnswer;

    private PlayerInfoVBox playerInfoVBox;

    private final GameHandler gameHandler;


    public MainScene(BorderPane menuPane, Player player, GameHandler gameHandler)
    {
        super(menuPane);
        this.menuPane = menuPane;
        this.gameHandler = gameHandler;

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
            if(playerAnswer)
            {
                playerScore++;
                playerInfoVBox.getPlayerScoreLabel().setText("Score : "+playerScore+"/"+questionCount);
            }
            else
            {
                playerInfoVBox.getPlayerScoreLabel().setText("Score : "+playerScore+"/"+questionCount);
            }
            createNewQuestionInterface();
        });
    }


    public void createNewQuestionInterface()
    {
            menuPane.setCenter(null);
            questionInterface = new QuestionInterface(new BorderPane(), gameHandler.getQuestionList().get(questionCount));
            questionInterface.getQuestionToAsk().setText("Question n°"+(questionCount+1)+" : "+questionInterface.getQuestion().getQuestionToAsk());
            setAnswersButtonListeners();
            menuPane.setCenter(questionInterface);
            questionCount++;
    }

}
