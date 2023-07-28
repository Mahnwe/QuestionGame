package View;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.example.Question;
import org.example.QuestionStorage;

import java.util.Optional;

public class QuestionInterface extends BorderPane
{
    private QuestionStorage questionList;
    private VBox game;
    private Question question;
    private Label questionToAsk;

    private Alert confirmAlert;
    private Button answerButton1;
    private Button answerButton2;
    private Button answerButton3;
    private Button answerButton4;
    private Button nextQuestionButton;

    private HBox displayingResult;

    private int playerScore;


    public QuestionInterface(Question question)
    {
        this.question = question;
        this.questionList = new QuestionStorage();
        this.confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);

    }

    public void createGameSpace()
    {
        game = new VBox();
        game.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        game.setMinWidth(200);
        game.setMinHeight(200);

    }

    public void createQuestionLabel()
    {
        for(int i = 0; i<questionList.getQuestionList().size(); i++)
        {
            questionToAsk = new Label("Question n°"+question.getQuestionNumber()+" : "+question.getQuestionToAsk());
        }
    }

    public void setAnswerButtonOnAction(Button button)
    {
        button.setOnAction(event -> {
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.get() == ButtonType.OK)
            {
                checkAnswer(button);
            }

        });

    }

    public void createAnswerButton()
    {
            answerButton1 = new Button(question.getAnswerList().get(0));
            setAnswerButtonOnAction(answerButton1);
            answerButton1.setTranslateY(15);
            answerButton1.setTranslateX(15);

            answerButton2 = new Button(question.getAnswerList().get(1));
            setAnswerButtonOnAction(answerButton2);
            answerButton2.setTranslateY(30);
            answerButton2.setTranslateX(15);

            answerButton3 = new Button(question.getAnswerList().get(2));
            setAnswerButtonOnAction(answerButton3);
            answerButton3.setTranslateY(-35);
            answerButton3.setTranslateX(180);

            answerButton4 = new Button(question.getAnswerList().get(3));
            setAnswerButtonOnAction(answerButton4);
            answerButton4.setTranslateY(-20);
            answerButton4.setTranslateX(180);

            nextQuestionButton = new Button("Question suivante");
            nextQuestionButton.setTranslateX(50);

    }

    public void initGameSpace()
    {
        game.getChildren().add(createStatArea(questionToAsk));
        game.getChildren().add(answerButton1);
        game.getChildren().add(answerButton2);
        game.getChildren().add(answerButton3);
        game.getChildren().add(answerButton4);
        game.getChildren().add(nextQuestionButton);
        this.setCenter(game);
    }

    public void createView(Question question)
    {
        createGameSpace();
        createQuestionLabel();
        createAnswerButton();
        initGameSpace();
    }

    public void checkAnswer(Button button)
    {
          if(button.getText().equals(question.getGoodAnswer()))
          {
              button.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
              displayGoodAnswer();
              answerButton1.setDisable(true);
              answerButton2.setDisable(true);
              answerButton3.setDisable(true);
              answerButton4.setDisable(true);

          }
          else
          {
              button.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
              displayBadAnswer();
              answerButton1.setDisable(true);
              answerButton2.setDisable(true);
              answerButton3.setDisable(true);
              answerButton4.setDisable(true);
          }
    }

    private void displayGoodAnswer()
    {
        displayingResult = new HBox();
        displayingResult.setMinHeight(40);
        Label goodResult = new Label("Bonne réponse !");
        playerScore++;
        displayingResult.getChildren().add(goodResult);
        this.setBottom(displayingResult);
    }

    private void displayBadAnswer()
    {
        displayingResult = new HBox();
        displayingResult.setMinHeight(40);
        Label badResult = new Label("Mauvaise réponse !");
        displayingResult.getChildren().add(badResult);
        this.setBottom(displayingResult);
    }

    public HBox createStatArea(Label label)
    {
        label.setTranslateY(3);

        HBox area = new HBox();
        area.setMinHeight(30);
        area.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));


        Label emptySpace = new Label();
        emptySpace.setMinWidth(20);
        area.getChildren().add(emptySpace);
        area.getChildren().add(label);

        return area;
    }

    public Button getNextQuestionButton() {
        return nextQuestionButton;
    }

    public int getPlayerScore() {
        return playerScore;
    }

}
