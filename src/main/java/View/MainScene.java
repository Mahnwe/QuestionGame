package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.example.QuestionStorage;


public class MainScene extends Scene
{
    private BorderPane menuPane;
    private QuestionStorage questionStorage;
    private QuestionInterface questionInterface;

    private VBox getPlayerName;
    private TextArea userInputArea;
    private Button sendButton;
    private Label playerNameLabel;
    private Label playerScoreLabel;

    private int playerScore;

    private Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    private Background background = new Background(new BackgroundFill(Color.SADDLEBROWN,
            CornerRadii.EMPTY, Insets.EMPTY));

    private int questionCount = 0;

    private Label askPlayerName;

    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;

    public MainScene(BorderPane menuPane)
    {
        super(menuPane);
        this.menuPane = menuPane;
        this.questionStorage = new QuestionStorage();

        createPlayerNameBox();
        menuPane.setTop(getPlayerName);

        createNewQuestionInterface();
        setAnswersButtonListeners();
    }

    private void setAnswersButtonListeners()
    {
        answer1 = questionInterface.getAnswerButton1();
        //answer1.setOnAction(e -> createNewQuestionInterface());
    }

    private void createPlayerNameBox()
    {
        getPlayerName = new VBox();
        askPlayerName = new Label("Bienvenue dans le jeu des questions ! Entrez votre nom");
        getPlayerName.getChildren().add(askPlayerName);

        createUserInputArea();
        getPlayerName.getChildren().add(userInputArea);

        createSendButton();
        getPlayerName.getChildren().add(sendButton);
    }

    private void createUserInputArea()
    {
        userInputArea = new TextArea();
        userInputArea.setBorder(border);
        userInputArea.setBackground(background);
        userInputArea.setMaxHeight(50);
    }

    private void createSendButton()
    {
        sendButton = new Button("Send");
        sendButton.setBorder(border);
        sendButton.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        sendButton.setTextFill(Color.GHOSTWHITE);
        sendButton.setPrefWidth(50);

        sendButton.setOnAction(event -> {
            if (!userInputArea.getText().isEmpty())
            {
                VBox playerInfos = new VBox();
                playerNameLabel = new Label("Nom : " + userInputArea.getText());
                playerInfos.getChildren().add(createStatArea(playerNameLabel));
                playerInfos.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                playerScoreLabel = new Label("Score : "+playerScore);
                playerInfos.getChildren().add(createStatArea(playerScoreLabel));
                playerInfos.setMinWidth(150);
                playerInfos.setMinHeight(50);
                menuPane.setLeft(playerInfos);
            }
            getPlayerName.setMaxHeight(0);
            getPlayerName.setMinHeight(0);
            getPlayerName.setVisible(false);
        });
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

    public void createNewQuestionInterface()
    {
            menuPane.setCenter(null);
            // Should be in class "questionInterface"
            // Label questionCountLabel = new Label("Question numéro : " + questionCount);
            questionInterface = new QuestionInterface(questionStorage.getQuestionList().get(questionCount));
            // createView() should be called directly in the constructor because why not
            questionInterface.createView(questionStorage.getQuestionList().get(questionCount));
            setAnswersButtonListeners();
            menuPane.setCenter(questionInterface);
            questionCount++;
    }

}
