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
        gridPane.setTranslateY(40);
        gridPane.setTranslateX(90);
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
            questionToAsk = new Label();
            questionToAsk.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
            questionToAsk.setTextFill(Color.GHOSTWHITE);
            questionToAsk.setTranslateX(25);
            questionToAsk.setTranslateY(5);
        }
    }

    public void createAnswerButton()
    {
        validateAnswerButton = new Button(UtilStringStorage.validateAnswerButton);
        validateAnswerButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        validateAnswerButton.setTranslateX(35);
        if(validateAnswerButton.getText().equals("Validate"))
        {
            validateAnswerButton.setTranslateX(20);
        }
        CustomOption.setGlowEffectOnButton(validateAnswerButton);
        validateAnswerButton.setDisable(true);
        gridPane.add(validateAnswerButton, 2, 3);

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

        nextQuestionButton = new Button(UtilStringStorage.nextQuestionButton);
        nextQuestionButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        CustomOption.setGlowEffectOnButton(nextQuestionButton);
        gridPane.add(nextQuestionButton, 2, 4);
        nextQuestionButton.setDisable(true);
    }

    public void initGameSpace()
    {
        game.getChildren().add(createStatArea(questionToAsk));
        game.getChildren().add(gridPane);
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
          if(answerButtonClicked.getText().equals(question.getGoodAnswer()))
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
        goodResult.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        goodResult.setTextFill(Color.GHOSTWHITE);
        goodResult.setTranslateY(100);

        Label explanation = new Label(question.getExplanation());
        explanation.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 13));
        explanation.setTextFill(Color.GHOSTWHITE);
        explanation.setTranslateY(120);

        game.getChildren().add(goodResult);
        game.getChildren().add(explanation);
    }

    public void showGoodAnswer(AnswerButton button)
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

    public Button getValidateAnswerButton() {
        return validateAnswerButton;
    }
}
