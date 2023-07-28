package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import org.example.Player;
import org.example.QuestionStorage;


public class MainScene extends Scene
{
    private BorderPane menuPane;
    private QuestionStorage questionStorage;
    private QuestionInterface questionInterface;
    private Player player;
    private int questionCount = 0;

    private int playerScore;

    private boolean playerAnswer;

    PlayerInfoVBox playerInfoVBox;


    public MainScene(BorderPane menuPane, Player player)
    {
        super(menuPane);
        this.menuPane = menuPane;
        this.player = player;
        this.questionStorage = new QuestionStorage();

        playerInfoVBox = new PlayerInfoVBox(player);
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
                playerInfoVBox.getPlayerScoreLabel().setText("Score : "+ playerScore);
            }
            createNewQuestionInterface();
        });
    }


    public void createNewQuestionInterface()
    {
            menuPane.setCenter(null);
            questionInterface = new QuestionInterface(questionStorage.getQuestionList().get(questionCount));
            setAnswersButtonListeners();
            menuPane.setCenter(questionInterface);
            questionCount++;
    }

}
