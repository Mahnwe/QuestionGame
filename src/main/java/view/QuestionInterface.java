package view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.*;
import util.IconCreator;
import util.PathUtil;
import util.UtilStringStorage;

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
    private Boolean playerAnswer;
    private final Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    private Label explanation;
    public static MediaPlayer soundEffectToStop;
    private GridPane gridPane;

    public QuestionInterface(BorderPane questionPane, Question question)
    {
        super(questionPane);
        this.questionPane = questionPane;
        this.question = question;
        this.questionList = new QuestionStorage();
        this.confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);

        modifyConfirmAlert();

        createGridPane();
        createView();
    }

    public void createGridPane()
    {
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(40);
        gridPane.addColumn(5);
        gridPane.addRow(4);
        gridPane.setTranslateY(40);
        gridPane.setTranslateX(100);
    }

    public void createGameSpace()
    {
        game = new VBox();
        game.setBorder(border);
        game.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        game.setPrefWidth(750);
        game.setPrefHeight(250);
    }

    public void modifyConfirmAlert()
    {
        confirmAlert.setTitle(UtilStringStorage.confirmAlertWindow);
        confirmAlert.setHeaderText(UtilStringStorage.askToConfirm);

        IconCreator iconCreator = new IconCreator(PathUtil.QUESTION_MARK_TEST);
        ImageView backgroundImage = iconCreator.createImage();
        backgroundImage.setFitHeight(150);
        confirmAlert.setGraphic(backgroundImage);

        Button confirmButton = (Button) confirmAlert.getDialogPane().lookupButton(ButtonType.OK);
        confirmButton.setText(UtilStringStorage.yesButton);
        placeButton(confirmButton, -20, -140);

        Button cancelButton = (Button) confirmAlert.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setText(UtilStringStorage.noButton);
        placeButton(cancelButton, -20, -40);
    }

    public void createQuestionLabel()
    {
        for(int i = 0; i<questionList.getQuestionList().size(); i++)
        {
            questionToAsk = new Label();
            questionToAsk.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
            questionToAsk.setTextFill(Color.GHOSTWHITE);
            questionToAsk.setTranslateX(25);
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
            answerButton1.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
            setAnswerButtonOnAction(answerButton1);
            gridPane.add(answerButton1, 1, 1);

            answerButton2 = new Button(question.getAnswerList().get(1));
            answerButton2.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
            setAnswerButtonOnAction(answerButton2);
            gridPane.add(answerButton2, 1, 2);

            answerButton3 = new Button(question.getAnswerList().get(2));
            answerButton3.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
            setAnswerButtonOnAction(answerButton3);
            gridPane.add(answerButton3, 5, 1);

            answerButton4 = new Button(question.getAnswerList().get(3));
            answerButton4.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
            setAnswerButtonOnAction(answerButton4);
            gridPane.add(answerButton4, 5, 2);

            nextQuestionButton = new Button(UtilStringStorage.nextQuestionButton);
            nextQuestionButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
            gridPane.add(nextQuestionButton, 3, 3);
            nextQuestionButton.setDisable(true);
    }

    public void placeButton(Button button, int translateY, int translateX)
    {
        button.setTranslateY(translateY);
        button.setTranslateX(translateX);
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

    public void checkAnswer(Button button)
    {
          if(button.getText().equals(question.getGoodAnswer()))
          {
              playerAnswer = true;
              button.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
              soundEffectToStop = SoundManager.playMusic(PathUtil.GOOD_ANSWER_SOUND_EFFECT);
              displayGoodAnswer();
          }
          else
          {
              playerAnswer = false;
              soundEffectToStop = SoundManager.playMusic(PathUtil.BAD_ANSWER_SOUND_EFFECT);
              button.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
              showGoodAnswer(answerButton1); showGoodAnswer(answerButton2);
              showGoodAnswer(answerButton3); showGoodAnswer(answerButton4);
              displayBadAnswer();
          }
          nextQuestionButton.setDisable(false);
          disableButtons();
    }

    private void displayGoodAnswer()
    {
        VBox displayResult = new VBox();
        displayResult.setTranslateY(160);
        displayResult.setPrefHeight(80);
        displayResult.setBorder(border);

        Label goodResult = new Label(UtilStringStorage.goodAnswerLabel);
        goodResult.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        goodResult.setTextFill(Color.GHOSTWHITE);

        explanation = new Label(question.getExplanation());
        explanation.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 13));
        explanation.setTextFill(Color.GHOSTWHITE);
        explanation.setTranslateY(20);

        displayResult.getChildren().add(goodResult);
        displayResult.getChildren().add(explanation);
        game.getChildren().add(displayResult);

    }

    private void displayBadAnswer()
    {
        Label badResult = new Label(UtilStringStorage.badAnswerLabel);
        badResult.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        badResult.setTextFill(Color.GHOSTWHITE);
        badResult.setTranslateY(100);

        explanation = new Label(question.getExplanation());
        explanation.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 13));
        explanation.setTextFill(Color.GHOSTWHITE);
        explanation.setTranslateY(120);

        game.getChildren().add(badResult);
        game.getChildren().add(explanation);
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
