package view.scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Question;
import model.QuestionStorage;
import model.handlers.AnswerHandler;
import view.customobject.CustomOption;
import util.stringutiltranslate.UtilStringStorage;
import view.customobject.AnswerButton;

import java.util.ArrayList;
import java.util.List;

public class QuestionInterface extends BorderPane
{
    private final QuestionStorage questionList;
    private final BorderPane questionPane;
    private VBox game;
    private final Question question;
    private Label questionNumber;
    private Label questionCategory;
    private Label questionToAsk;
    private AnswerButton answerButton1;
    private AnswerButton answerButton2;
    private AnswerButton answerButton3;
    private AnswerButton answerButton4;
    private Button validateAnswerButton;
    private final List<AnswerButton> answerButtonList;
    private Button nextQuestionButton;
    private Boolean playerAnswer;
    public static MediaPlayer soundEffectToStop;
    private GridPane gridPane;

    public QuestionInterface(BorderPane questionPane, Question question)
    {
        super(questionPane);
        this.questionPane = questionPane;
        this.question = question;
        this.questionList = new QuestionStorage();
        answerButtonList = new ArrayList<>();

        createGridPane();
        createView();
    }

    public void createGridPane()
    {
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(40);
        gridPane.addColumn(4);
        gridPane.addRow(5);
        gridPane.setTranslateY(200);
        gridPane.setTranslateX(500);
    }

    public void createGameSpace()
    {
        game = new VBox();
        game.setBorder(CustomOption.createCustomBorder(1.0, 1.0, Color.BLACK));
    }

    public void createQuestionLabel()
    {
        for(int i = 0; i<questionList.getQuestionList().size(); i++)
        {
            questionNumber = new Label();
            questionNumber.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 22));
            questionNumber.setTextFill(Color.GHOSTWHITE);
            questionNumber.setTranslateX(60);
            questionNumber.setTranslateY(55);

            questionCategory = new Label();
            questionCategory.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 22));
            questionCategory.setTextFill(Color.GHOSTWHITE);
            questionCategory.setTranslateX(70);
            questionCategory.setTranslateY(105);

            questionToAsk = new Label();
            questionToAsk.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 22));
            questionToAsk.setTextFill(Color.GHOSTWHITE);
            questionToAsk.setTranslateY(105);
        }
    }

    public void placeQuestionLabelIfNecessary(Label questionLabelToPlace)
    {
        if(questionLabelToPlace.getText().length() >= 50) {
            questionLabelToPlace.setTranslateX(300);
        }
        else {
            questionLabelToPlace.setTranslateX(400);
        }
    }

    public void createAnswerButton()
    {
        validateAnswerButton = new Button(UtilStringStorage.validateAnswerButton);
        validateAnswerButton.setFont(Font.font("Futura", FontWeight.BOLD, 20));
        validateAnswerButton.setBorder(CustomOption.createCustomBorder(3.0, 2.0, Color.BLACK));
        CustomOption.setGlowEffectOnButton(validateAnswerButton);
        validateAnswerButton.setDisable(true);
        gridPane.add(validateAnswerButton, 2, 3);
        validateAnswerButton.setTranslateY(50);

        answerButton1 = new AnswerButton(false, question.getAnswerList().get(0));
        setUpAnswerButtonInScene(answerButton1, answerButtonList, validateAnswerButton, gridPane, 1, 1);

        answerButton2 = new AnswerButton(false, question.getAnswerList().get(1));
        setUpAnswerButtonInScene(answerButton2, answerButtonList, validateAnswerButton, gridPane, 2, 1);

        answerButton3 = new AnswerButton(false, question.getAnswerList().get(2));
        setUpAnswerButtonInScene(answerButton3, answerButtonList, validateAnswerButton, gridPane, 1, 3);

        answerButton4 = new AnswerButton(false, question.getAnswerList().get(3));
        setUpAnswerButtonInScene(answerButton4, answerButtonList, validateAnswerButton, gridPane, 2, 3);

        placeGridPaneWithTextLength();

        createNextQuestionButton();
    }

    public void createNextQuestionButton()
    {
        nextQuestionButton = new Button(UtilStringStorage.nextQuestionButton);
        nextQuestionButton.setFont(Font.font("Futura", FontWeight.BOLD, 20));
        nextQuestionButton.setBorder(CustomOption.createCustomBorder(3.0, 2.0, Color.BLACK));
        CustomOption.setGlowEffectOnButton(nextQuestionButton);
        nextQuestionButton.setDisable(true);
        nextQuestionButton.setTranslateY(500);
        nextQuestionButton.setTranslateX(700);
    }
    public void setUpAnswerButtonInScene(AnswerButton answerButton, List<AnswerButton> answerButtonList, Button validateAnswerButton, GridPane gridPane, int rowIndex, int columnIndex)
    {
        AnswerButton.setAnswerButtonOnAction(answerButton, answerButtonList, validateAnswerButton);
        gridPane.add(answerButton, columnIndex, rowIndex);
        answerButtonList.add(answerButton);
    }

    public void placeGridPaneWithTextLength()
    {
        for (AnswerButton answerButton : answerButtonList) {
            if (answerButton.getText().length() >= 15) {
                gridPane.setTranslateX(400);
                break;
            }
        }
    }

    public void initGameSpace()
    {
        game.getChildren().add(questionNumber);
        game.getChildren().add(questionToAsk);
        game.getChildren().add(gridPane);
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

    public void checkAnswer()
    {
        validateAnswerButton.setDisable(true);
        Button answerButtonClicked = new Button();
        answerButtonClicked = AnswerHandler.checkWhichButtonIsClicked(answerButtonList, answerButtonClicked);
        String upperGoodAnswer = question.getGoodAnswer().toUpperCase();

          if(answerButtonClicked.getText().equals(upperGoodAnswer))
          {
             playerAnswer = AnswerHandler.playerAnswerIsGood(answerButtonClicked, question, game);
          }
          else
          {
              playerAnswer = AnswerHandler.playerAnswerIsWrong(answerButtonClicked, answerButton1, answerButton2, answerButton3, answerButton4, question, game);
          }

          nextQuestionButton.setDisable(false);
          disableButtons();
          AnswerHandler.setQuestionsAnswered(AnswerHandler.incrementStat(AnswerHandler.getQuestionsAnswered()));
    }

    public void disableButtons()
    {
        answerButton1.setDisable(true);
        answerButton2.setDisable(true);
        answerButton3.setDisable(true);
        answerButton4.setDisable(true);
    }

    public Button getNextQuestionButton() {
        return nextQuestionButton;
    }

    public boolean isPlayerAnswer() {
        return playerAnswer;
    }

    public Label getQuestionNumber() {
        return questionNumber;
    }

    public Label getQuestionCategory() {
        return questionCategory;
    }

    public Label getQuestionToAsk() {
        return questionToAsk;
    }

    public Question getQuestion() {
        return question;
    }

    public Button getValidateAnswerButton() {
        return validateAnswerButton;
    }

    public VBox getGame() {
        return game;
    }
}
