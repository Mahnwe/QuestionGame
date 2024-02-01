package view.scene;

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
import util.FileUtil;
import util.PathUtil;
import util.UtilStringStorage;
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
        gridPane.setTranslateY(70);
        gridPane.setTranslateX(250);
    }

    public void createGameSpace()
    {
        game = new VBox();
        game.setBorder(CustomOption.createCustomBorder(1.0, 1.0, Color.BLACK));
        game.setPrefWidth(830);
        game.setPrefHeight(340);
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

            questionCategory = new Label();
            questionCategory.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 19));
            questionCategory.setTextFill(Color.GHOSTWHITE);
            questionCategory.setTranslateX(50);
            questionCategory.setTranslateY(95);

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
        validateAnswerButton.setBorder(CustomOption.createCustomBorder(3.0, 2.0, Color.BLACK));
        CustomOption.setGlowEffectOnButton(validateAnswerButton);
        validateAnswerButton.setDisable(true);
        gridPane.add(validateAnswerButton, 2, 3);
        validateAnswerButton.setTranslateY(30);

        answerButton1 = new AnswerButton(false, question.getAnswerList().get(0));
        setUpAnswerButtonInScene(answerButton1, answerButtonList, validateAnswerButton, gridPane, 1, 1);

        answerButton2 = new AnswerButton(false, question.getAnswerList().get(1));
        setUpAnswerButtonInScene(answerButton2, answerButtonList, validateAnswerButton, gridPane, 2, 1);

        answerButton3 = new AnswerButton(false, question.getAnswerList().get(2));
        setUpAnswerButtonInScene(answerButton3, answerButtonList, validateAnswerButton, gridPane, 1, 3);

        answerButton4 = new AnswerButton(false, question.getAnswerList().get(3));
        setUpAnswerButtonInScene(answerButton4, answerButtonList, validateAnswerButton, gridPane, 2, 3);

        placeGridPaneWithTextLength();

        nextQuestionButton = new Button(UtilStringStorage.nextQuestionButton);
        nextQuestionButton.setFont(Font.font("Futura", FontWeight.BOLD, 17));
        nextQuestionButton.setBorder(CustomOption.createCustomBorder(3.0, 2.0, Color.BLACK));
        CustomOption.setGlowEffectOnButton(nextQuestionButton);
        nextQuestionButton.setDisable(true);
        nextQuestionButton.setTranslateY(300);
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
              FileUtil.incrementGeneralStat("goodAnswerNumber");
          }
          else
          {
              playerAnswer = false;
              soundEffectToStop = SoundManager.playMusic(PathUtil.BAD_ANSWER_SOUND_EFFECT);
              answerButtonClicked.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
              showGoodAnswer(answerButton1); showGoodAnswer(answerButton2);
              showGoodAnswer(answerButton3); showGoodAnswer(answerButton4);
              displayAnswer(UtilStringStorage.badAnswerLabel);
              FileUtil.incrementGeneralStat("badAnswerNumber");
          }
          nextQuestionButton.setDisable(false);
          disableButtons();
          FileUtil.incrementGeneralStat("questionAnswered");
    }

    private void displayAnswer(String answerLabel)
    {
        Label goodResult = new Label(answerLabel);
        goodResult.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 18));
        goodResult.setTextFill(Color.GHOSTWHITE);
        goodResult.setTranslateY(130);
        goodResult.setTranslateX(330);

        Label explanation = new Label(question.getExplanation());
        explanation.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 15));
        explanation.setTextFill(Color.GHOSTWHITE);
        explanation.setTranslateY(165);
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
