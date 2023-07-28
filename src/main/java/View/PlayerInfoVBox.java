package View;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class PlayerInfoVBox extends VBox
{
    private VBox getPlayerName;
    private Button sendButton;
    private TextArea userInputArea;
    private int playerScore;
    private VBox playerInfos;
    private Label playerNameLabel;
    private Label playerScoreLabel;

    private Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    private Background background = new Background(new BackgroundFill(Color.SADDLEBROWN,
            CornerRadii.EMPTY, Insets.EMPTY));

    public PlayerInfoVBox()
    {
        getPlayerName = new VBox();
        Label askPlayerName = new Label("Bienvenue dans le jeu des questions ! Entrez votre nom et cliquez sur le bouton 'Send'");
        getPlayerName.getChildren().add(askPlayerName);

    }

    public VBox createUserInputArea()
    {
        userInputArea = new TextArea();
        userInputArea.setBorder(border);
        userInputArea.setBackground(background);
        userInputArea.setMaxHeight(50);

        sendButton = new Button("Send");
        sendButton.setBorder(border);
        sendButton.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        sendButton.setTextFill(Color.GHOSTWHITE);
        sendButton.setPrefWidth(50);
        getPlayerName.getChildren().add(sendButton);
        getPlayerName.getChildren().add(userInputArea);
        return getPlayerName;
    }

    public void setOnActionSendButton(BorderPane pane)
    {

        sendButton.setOnAction(event -> {
            if (!userInputArea.getText().isEmpty())
            {
                playerInfos = new VBox();
                playerNameLabel = new Label("Nom : " + userInputArea.getText());
                playerInfos.getChildren().add(createStatArea(playerNameLabel));
                playerInfos.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                playerScoreLabel = new Label("Score : "+playerScore);
                playerInfos.getChildren().add(createStatArea(playerScoreLabel));
                playerInfos.setMinWidth(150);
                playerInfos.setMinHeight(50);
                pane.setLeft(playerInfos);
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

}

