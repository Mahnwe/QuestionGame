package View;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import org.example.Question;
import org.example.QuestionStorage;

public class QuestionInterface extends BorderPane
{
    private QuestionStorage questionList;
    VBox game;
    Question question;
    Label questionToAsk;

    Label questionCount;
    Popup confirmPopUp;

    Alert confirmAlert;
    Button answerButton1;
    Button answerButton2;
    Button answerButton3;
    Button answerButton4;

    Label askConfirm;
    Button yesButton;
    Button noButton;

    public QuestionInterface(Question question)
    {
        this.question = question;
        this.questionList = new QuestionStorage();
        confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmPopUp = new Popup();
        VBox confirmBox = new VBox();
        askConfirm = new Label("Etes vous certain de votre réponse ?");
        yesButton = new Button("Oui");
        noButton = new Button("Non");
        confirmBox.getChildren().add(askConfirm);
        confirmBox.getChildren().add(yesButton);
        confirmBox.getChildren().add(noButton);
        confirmPopUp.getContent().add(confirmBox);

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
        for(int i = 0; i<questionList.getQuestionList().size(); i++) {
            questionToAsk = new Label(questionList.getQuestionList().get(i).getQuestionToAsk());
        }
    }

    public void createAnswerButton() {
        for (int i = 0; i < questionList.getQuestionList().size(); i++) {
            //for (int y = 0; y < questionList.getQuestionList().get(i).getAnswerList().size(); y++) {
                answerButton1 = new Button(questionList.getQuestionList().get(i).getAnswerList().get(0));
            //}

            answerButton1.setTranslateY(5);
            answerButton1.setTranslateX(5);


            for (int y = 0; y < questionList.getQuestionList().get(i).getAnswerList().size(); y++) {
                answerButton2 = new Button(questionList.getQuestionList().get(i).getAnswerList().get(1));
            }

            answerButton2.setTranslateY(10);
            answerButton2.setTranslateX(5);

            for (int y = 0; y < questionList.getQuestionList().get(i).getAnswerList().size(); y++) {
                answerButton3 = new Button(questionList.getQuestionList().get(i).getAnswerList().get(2));
            }

            answerButton3.setTranslateY(15);
            answerButton3.setTranslateX(5);


            for (int y = 0; y < questionList.getQuestionList().get(i).getAnswerList().size(); y++) {
                answerButton4 = new Button(questionList.getQuestionList().get(i).getAnswerList().get(3));
            }

            answerButton4.setTranslateY(20);
            answerButton4.setTranslateX(5);
        }

    }

    public void initGameSpace()
    {
        game.getChildren().add(createStatArea(questionToAsk));
        game.getChildren().add(answerButton1);
        game.getChildren().add(answerButton2);
        game.getChildren().add(answerButton3);
        game.getChildren().add(answerButton4);
        this.setCenter(game);
    }

    public void createView()
    {
        createGameSpace();
        createQuestionLabel();
        createAnswerButton();
        initGameSpace();
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

    public Button getAnswerButton1() {
    return answerButton1;
    }

    public Button getAnswerButton2() {
        return answerButton2;
    }
    public Button getAnswerButton3() {
        return answerButton3;
    }

    public Button getAnswerButton4() {
        return answerButton4;
    }

    public Popup getConfirmPopUp() {
        return confirmPopUp;
    }

    public Button getYesButton() {
        return yesButton;
    }

    public Button getNoButton() {
        return noButton;
    }

    public Alert getConfirmAlert() {
        return confirmAlert;
    }

    public Label getQuestionToAsk() {
        return questionToAsk;
    }

    public void setQuestionToAsk(Label questionToAsk) {
        this.questionToAsk = questionToAsk;
    }
}
