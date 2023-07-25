package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.GameHandler;
import org.example.Question;
import org.example.QuestionStorage;

import java.util.Optional;


public class MainScene extends Scene
{
    private BorderPane menuPane;
    private QuestionStorage questionStorage;
    private QuestionInterface questionInterface;
    private TextArea userInputArea;
    private Button sendButton;
    private Label playerName;
    private Label playerScore;

    private Label askName;

    private Label questionToAsk;

    private Label questionCount;

    private Label goodAnswer;

    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private GameHandler gameHandler;

    private Question question;

    private Stage stage;

    public MainScene(BorderPane menuPane, Stage stage)
    {
        super(menuPane);
        this.menuPane = menuPane;
        this.stage = stage;
        this.questionStorage = new QuestionStorage();
        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
        Background background = new Background(new BackgroundFill(Color.SADDLEBROWN, CornerRadii.EMPTY, Insets.EMPTY));

        VBox getPlayerName = new VBox();
        askName = new Label("Bienvenue dans le jeu des questions ! Entrez votre nom");
        getPlayerName.getChildren().add(askName);


        userInputArea = new TextArea();
        userInputArea.setBorder(border);
        userInputArea.setBackground(background);
        userInputArea.setMaxHeight(50);
        getPlayerName.getChildren().add(userInputArea);

        sendButton = new Button("Send");
        sendButton.setBorder(border);
        sendButton.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        sendButton.setTextFill(Color.GHOSTWHITE);
        sendButton.setPrefWidth(50);
        getPlayerName.getChildren().add(sendButton);
        menuPane.setTop(getPlayerName);
        sendButton.setOnAction(event -> {
            if (!userInputArea.getText().isEmpty()) {
                VBox playerInfos = new VBox();
                playerName = new Label("Nom : " + userInputArea.getText());
                playerInfos.getChildren().add(createStatArea(playerName));
                playerInfos.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                playerScore = new Label("Score : ");
                playerInfos.getChildren().add(createStatArea(playerScore));
                playerInfos.setMinWidth(150);
                playerInfos.setMinHeight(50);
                menuPane.setLeft(playerInfos);
            }
            getPlayerName.setMaxHeight(0);
            getPlayerName.setMinHeight(0);
            getPlayerName.setVisible(false);
        });

        switchQuestion(0);
        createNewQuestionInterface(1);

    }

    public HBox createStatArea(Label label) {
        label.setTranslateY(3);

        HBox area = new HBox();
        area.setMinHeight(30);
        area.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


        Label emptySpace = new Label();
        emptySpace.setMinWidth(20);
        area.getChildren().add(emptySpace);
        area.getChildren().add(label);

        return area;
    }

    public void switchQuestion(int i) {

        questionCount = new Label("Question numéro : ");
        questionInterface = new QuestionInterface(questionStorage.getQuestionList().get(i));
        questionInterface.createView(questionStorage.getQuestionList().get(i));

        menuPane.setCenter(questionInterface);
    }

    public void createNewQuestionInterface(int i){
            if (questionInterface.getAnswerButton1().isPressed()|| questionInterface.getAnswerButton2().isPressed()
                || questionInterface.getAnswerButton3().isPressed() || questionInterface.getAnswerButton4().isPressed())
            {

                //Optional<ButtonType> result = questionInterface.getConfirmAlert().showAndWait();

                //if (result.get() == ButtonType.OK)
               // {
                    menuPane.setCenter(null);
                    questionInterface.getGame().getChildren().clear();
                    questionInterface = new QuestionInterface(questionStorage.getQuestionList().get(i+1));
                    questionInterface.createView(questionStorage.getQuestionList().get(i+1));
                    menuPane.setCenter(questionInterface);
               // }
               // else
               // {

                //}
            }
    }
    public Label getPlayerScore()
    {
        return playerScore;
    }

    public void setPlayerScore (Label playerScore)
    {
        this.playerScore = playerScore;
    }

}
