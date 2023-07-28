package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import org.example.QuestionStorage;


public class MainScene extends Scene
{
    private BorderPane menuPane;
    private QuestionStorage questionStorage;
    private QuestionInterface questionInterface;

    private int questionCount = 0;


    public MainScene(BorderPane menuPane)
    {
        super(menuPane);
        this.menuPane = menuPane;
        this.questionStorage = new QuestionStorage();

        PlayerInfoVBox playerInfoVBox = new PlayerInfoVBox();
        menuPane.setTop(playerInfoVBox.createUserInputArea());
        playerInfoVBox.setOnActionSendButton(menuPane);

        createNewQuestionInterface();
        setAnswersButtonListeners();
    }

    private void setAnswersButtonListeners()
    {
        Button nextQuestionButton = questionInterface.getNextQuestionButton();
        nextQuestionButton.setOnAction(e -> createNewQuestionInterface());
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
