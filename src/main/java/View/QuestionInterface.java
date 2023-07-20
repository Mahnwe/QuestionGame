package View;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.example.Question;
import org.example.QuestionStorage;

public class QuestionInterface extends BorderPane
{
    private QuestionStorage questionList;
    private VBox game;
    private Question question;
    private Label questionToAsk;

    private Label questionCount;

    private Alert confirmAlert;
    private Button answerButton1;
    private Button answerButton2;
    private Button answerButton3;
    private Button answerButton4;


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
            questionToAsk = new Label(question.getQuestionToAsk());
        }
    }

    public void createAnswerButton()
    {
            answerButton1 = new Button(question.getAnswerList().get(0));
            answerButton1.setTranslateY(10);
            answerButton1.setTranslateX(15);

            answerButton2 = new Button(question.getAnswerList().get(1));
            answerButton2.setTranslateY(20);
            answerButton2.setTranslateX(15);

            answerButton3 = new Button(question.getAnswerList().get(2));
            answerButton3.setTranslateY(30);
            answerButton3.setTranslateX(15);

            answerButton4 = new Button(question.getAnswerList().get(3));
            answerButton4.setTranslateY(40);
            answerButton4.setTranslateX(15);

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
