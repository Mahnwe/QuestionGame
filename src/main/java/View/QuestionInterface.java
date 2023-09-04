package View;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.IconCreator;
import model.PathUtil;
import model.Question;
import model.QuestionStorage;

import java.util.Optional;

public class QuestionInterface extends BorderPane
{
    private final QuestionStorage questionList;
    private final BorderPane questionPane;
    private VBox game;
    private final Question question;
    private Label questionToAsk;
    private final Alert confirmAlert;
    private Button answerButton1;
    private Button answerButton2;
    private Button answerButton3;
    private Button answerButton4;
    private Button nextQuestionButton;

    private VBox displayingResult;

    private Boolean playerAnswer;
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
        confirmAlert.setTitle("Fenêtre de confirmation");
        confirmAlert.setHeaderText("Êtes-vous sûr ?");

        IconCreator iconCreator = new IconCreator(PathUtil.QUESTION_MARK_TEST);
        ImageView backgroundImage = iconCreator.createImage();
        backgroundImage.setFitHeight(150);
        confirmAlert.setGraphic(backgroundImage);

        Button confirmButton = (Button) confirmAlert.getDialogPane().lookupButton(ButtonType.OK);
        confirmButton.setText("Oui");
        placeButton(confirmButton, -20, -160);

        Button cancelButton = (Button) confirmAlert.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setText("Non");
        placeButton(cancelButton, -20, -20);

        createView();
    }

    public void createGameSpace()
    {
        game = new VBox();
        game.setBorder(border);
        game.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        game.setMinWidth(700);
        game.setMinHeight(250);
    }

    public void createQuestionLabel()
    {
        for(int i = 0; i<questionList.getQuestionList().size(); i++)
        {
            questionToAsk = new Label();
            questionToAsk.setTranslateX(30);
            questionToAsk.setTranslateY(5);
        }
    }

    public void setAnswerButtonOnAction(Button button)
    {
        button.setOnAction(event -> {
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.orElse(null) == ButtonType.OK)
            {
                checkAnswer(button);
            }
        });
    }

    public void createAnswerButton()
    {
            answerButton1 = new Button(question.getAnswerList().get(0));
            setAnswerButtonOnAction(answerButton1);
            placeButton(answerButton1, 20, 40);

            answerButton2 = new Button(question.getAnswerList().get(1));
            setAnswerButtonOnAction(answerButton2);
            placeButton(answerButton2, 35, 40);

            answerButton3 = new Button(question.getAnswerList().get(2));
            setAnswerButtonOnAction(answerButton3);
            placeButton(answerButton3, -29, 225);

            answerButton4 = new Button(question.getAnswerList().get(3));
            setAnswerButtonOnAction(answerButton4);
            placeButton(answerButton4, -15, 225);

            nextQuestionButton = new Button("Question suivante");
            placeButton(nextQuestionButton, 50, 150);
    }

    public void placeButton(Button button, int translateY, int translateX)
    {
        button.setTranslateY(translateY);
        button.setTranslateX(translateX);
    }

    public void initGameSpace()
    {
        game.getChildren().add(createStatArea(questionToAsk));
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
              showGoodAnswer(answerButton1); showGoodAnswer(answerButton2);
              showGoodAnswer(answerButton3); showGoodAnswer(answerButton4);
              displayBadAnswer();
          }
          disableButtons();
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

    public void showGoodAnswer(Button button)
    {
        if(button.getText().equals(question.getGoodAnswer()))
        {
            button.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }
    public void disableButtons()
    {
        answerButton1.setDisable(true);
        answerButton2.setDisable(true);
        answerButton3.setDisable(true);
        answerButton4.setDisable(true);
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

    public Label getQuestionToAsk() {
        return questionToAsk;
    }

    public Question getQuestion() {
        return question;
    }

}
