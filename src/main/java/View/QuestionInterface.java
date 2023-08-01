package View;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.example.Question;
import org.example.QuestionStorage;

import java.util.Optional;

public class QuestionInterface extends BorderPane
{
    private QuestionStorage questionList;
    private BorderPane questionPane;
    private VBox game;
    private Question question;
    private Label questionToAsk;
    private Alert confirmAlert;
    private Button answerButton1;
    private Button answerButton2;
    private Button answerButton3;
    private Button answerButton4;
    private Button nextQuestionButton;

    private VBox displayingResult;

    private boolean playerAnswer;
    private final Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    private Label explanation;


    public QuestionInterface(BorderPane questionPane, Question question)
    {
        super(questionPane);
        this.questionPane = questionPane;
        this.question = question;
        this.questionList = new QuestionStorage();
        this.confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        createView();

    }

    public void createGameSpace()
    {
        game = new VBox();
        game.setBorder(border);
        game.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        game.setMinWidth(600);
        game.setMinHeight(200);

    }

    public void createQuestionLabel()
    {
        for(int i = 0; i<questionList.getQuestionList().size(); i++)
        {
            questionToAsk = new Label("Question n°"+question.getQuestionNumber()+" : "+question.getQuestionToAsk());
            questionToAsk.setTranslateX(45);
            questionToAsk.setTranslateY(5);
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
            answerButton1.setTranslateY(20);
            answerButton1.setTranslateX(20);

            answerButton2 = new Button(question.getAnswerList().get(1));
            setAnswerButtonOnAction(answerButton2);
            answerButton2.setTranslateY(35);
            answerButton2.setTranslateX(20);

            answerButton3 = new Button(question.getAnswerList().get(2));
            setAnswerButtonOnAction(answerButton3);
            answerButton3.setTranslateX(205);
            answerButton3.setTranslateY(-29);


            answerButton4 = new Button(question.getAnswerList().get(3));
            setAnswerButtonOnAction(answerButton4);
            answerButton4.setTranslateX(205);
            answerButton4.setTranslateY(-15);

            nextQuestionButton = new Button("Question suivante");
            nextQuestionButton.setTranslateY(55);
            nextQuestionButton.setTranslateX(125);

    }

    public void initGameSpace()
    {
        game.getChildren().add(questionToAsk);
        game.getChildren().add(answerButton1);
        game.getChildren().add(answerButton2);
        game.getChildren().add(answerButton3);
        game.getChildren().add(answerButton4);
        game.getChildren().add(nextQuestionButton);
        questionPane.setCenter(game);
    }

    public void createView()
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
              playerAnswer = true;
              button.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
              displayGoodAnswer();
          }

          else
          {
              playerAnswer = false;
              button.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
              displayBadAnswer();
          }
        answerButton1.setDisable(true);
        answerButton2.setDisable(true);
        answerButton3.setDisable(true);
        answerButton4.setDisable(true);
    }

    private void displayGoodAnswer()
    {
        displayingResult = new VBox();
        displayingResult.setMinHeight(60);
        Label goodResult = new Label("Bonne réponse !");
        explanation = new Label(question.getExplanation());
        displayingResult.getChildren().add(goodResult);
        displayingResult.getChildren().add(explanation);
        questionPane.setBottom(displayingResult);
    }

    private void displayBadAnswer()
    {
        displayingResult = new VBox();
        displayingResult.setMinHeight(60);
        Label badResult = new Label("Mauvaise réponse !");
        explanation = new Label(question.getExplanation());
        displayingResult.getChildren().add(badResult);
        displayingResult.getChildren().add(explanation);
        questionPane.setBottom(displayingResult);
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

    public boolean isPlayerAnswer() {
        return playerAnswer;
    }
}
