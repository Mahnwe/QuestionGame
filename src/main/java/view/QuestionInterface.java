package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Question;
import model.QuestionStorage;
import model.SoundManager;
import util.CustomOption;
import util.PathUtil;
import util.UtilStringStorage;

import java.util.ArrayList;
import java.util.List;

public class QuestionInterface extends BorderPane
{
    private final QuestionStorage questionList;
    private final BorderPane questionPane;
    private VBox game;
    private final Question question;
    private Label questionNumber;
    private Label questionToAsk;
    private AnswerButton answerButton1;
    private AnswerButton answerButton2;
    private AnswerButton answerButton3;
    private AnswerButton answerButton4;
    private Button validateAnswerButton;
    private final List<AnswerButton> answerButtonList;
    private Button nextQuestionButton;
    private Boolean playerAnswer;
    private final Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

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
        gridPane.setTranslateY(70);
        gridPane.setTranslateX(250);
    }

    public void createGameSpace()
    {
        game = new VBox();
        game.setBorder(border);
        game.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        game.setPrefWidth(830);
        game.setPrefHeight(300);
    }

    public void createQuestionLabel()
    {
        for(int i = 0; i<questionList.getQuestionList().size(); i++)
        {
            questionNumber = new Label();
            questionNumber.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 19));
            questionNumber.setTextFill(Color.GHOSTWHITE);
            questionNumber.setTranslateX(40);
            questionNumber.setTranslateY(35);

            questionToAsk = new Label();
            questionToAsk.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 18));
            questionToAsk.setTextFill(Color.GHOSTWHITE);
            questionToAsk.setTranslateY(35);
        }
    }

    public void placeQuestionLabelIfNecessary(Label questionLabelToPlace)
    {
        if(questionLabelToPlace.getText().length() >= 50) {
            questionLabelToPlace.setTranslateX(100);
        }
        else {
            questionLabelToPlace.setTranslateX(160);
        }
    }

    public void createAnswerButton()
    {
        validateAnswerButton = new Button(UtilStringStorage.validateAnswerButton);
        validateAnswerButton.setFont(Font.font("Futura", FontWeight.BOLD, 17));
        CustomOption.setGlowEffectOnButton(validateAnswerButton);
        validateAnswerButton.setDisable(true);
        gridPane.add(validateAnswerButton, 2, 3);
        validateAnswerButton.setTranslateY(30);

        answerButton1 = new AnswerButton(false, question.getAnswerList().get(0));
        answerButton1.setAnswerButtonOnAction(answerButton1, answerButtonList, validateAnswerButton);
        gridPane.add(answerButton1, 1, 1);
        answerButtonList.add(answerButton1);

        answerButton2 = new AnswerButton(false, question.getAnswerList().get(1));
        answerButton2.setAnswerButtonOnAction(answerButton2, answerButtonList, validateAnswerButton);
        gridPane.add(answerButton2, 1, 2);
        answerButtonList.add(answerButton2);

        answerButton3 = new AnswerButton(false, question.getAnswerList().get(2));
        answerButton3.setAnswerButtonOnAction(answerButton3, answerButtonList, validateAnswerButton);
        gridPane.add(answerButton3, 3, 1);
        answerButtonList.add(answerButton3);

        answerButton4 = new AnswerButton(false, question.getAnswerList().get(3));
        answerButton4.setAnswerButtonOnAction(answerButton4, answerButtonList, validateAnswerButton);
        gridPane.add(answerButton4, 3, 2);
        answerButtonList.add(answerButton4);
        placeGridPaneWithTextLength();

        nextQuestionButton = new Button(UtilStringStorage.nextQuestionButton);
        nextQuestionButton.setFont(Font.font("Futura", FontWeight.BOLD, 17));
        CustomOption.setGlowEffectOnButton(nextQuestionButton);
        nextQuestionButton.setDisable(true);
        nextQuestionButton.setTranslateY(320);
        nextQuestionButton.setTranslateX(700);
    }

    public void placeGridPaneWithTextLength()
    {
        for (AnswerButton answerButton : answerButtonList) {
            if (answerButton.getText().length() >= 15) {
                gridPane.setTranslateX(170);
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
        for (AnswerButton answerButton : answerButtonList) {
            if (answerButton.isClicked()) {
                answerButtonClicked = answerButton;
            }
        }
        String upperGoodAnswer = question.getGoodAnswer().toUpperCase();
          if(answerButtonClicked.getText().equals(upperGoodAnswer))
          {
              playerAnswer = true;
              answerButtonClicked.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
              soundEffectToStop = SoundManager.playMusic(PathUtil.GOOD_ANSWER_SOUND_EFFECT);
              displayAnswer(UtilStringStorage.goodAnswerLabel);
          }
          else
          {
              playerAnswer = false;
              soundEffectToStop = SoundManager.playMusic(PathUtil.BAD_ANSWER_SOUND_EFFECT);
              answerButtonClicked.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
              showGoodAnswer(answerButton1); showGoodAnswer(answerButton2);
              showGoodAnswer(answerButton3); showGoodAnswer(answerButton4);
              displayAnswer(UtilStringStorage.badAnswerLabel);
          }
          nextQuestionButton.setDisable(false);
          disableButtons();
    }

    private void displayAnswer(String answerLabel)
    {
        Label goodResult = new Label(answerLabel);
        goodResult.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 18));
        goodResult.setTextFill(Color.GHOSTWHITE);
        goodResult.setTranslateY(160);
        goodResult.setTranslateX(250);

        Label explanation = new Label(question.getExplanation());
        explanation.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 15));
        explanation.setTextFill(Color.GHOSTWHITE);
        explanation.setTranslateY(180);
        explanation.setTranslateX(50);

        game.getChildren().add(goodResult);
        game.getChildren().add(explanation);
    }

    public void showGoodAnswer(AnswerButton button)
    {
        String upperGoodAnswer = question.getGoodAnswer().toUpperCase();
        if(button.getText().equals(upperGoodAnswer))
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

    public Button getNextQuestionButton() {
        return nextQuestionButton;
    }

    public boolean isPlayerAnswer() {
        return playerAnswer;
    }

    public Label getQuestionNumber() {
        return questionNumber;
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
}
