package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.*;

public class PlayerInfoScene extends Scene
{
    private final VBox getPlayerName;
    private Button sendButton;
    private TextArea userInputArea;

    private VBox playerInfos;
    private Label playerScoreLabel;

    private final Player player;

    private final Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    private final Background background = new Background(new BackgroundFill(Color.SADDLEBROWN,
            CornerRadii.EMPTY, Insets.EMPTY));

    public PlayerInfoScene(BorderPane pane, Player player)
    {
        super(pane);
        this.player = player;

        BackgroundCreator mainSceneBackgroundCreator = new BackgroundCreator(PathUtil.MAIN_BACKGROUND);
        Image mainSceneImage = mainSceneBackgroundCreator.createBackground();
        BackgroundFill backgroundFill = new BackgroundFill(new ImagePattern(mainSceneImage), CornerRadii.EMPTY, Insets.EMPTY);
        pane.setBackground(new Background(backgroundFill));

        getPlayerName = new VBox();
        Label askPlayerName = new Label(UtilStringStorage.askPlayerName);
        askPlayerName.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        askPlayerName.setTextFill(Color.GHOSTWHITE);
        askPlayerName.setTranslateY(40);
        getPlayerName.getChildren().add(askPlayerName);
        createUserInputArea();
        pane.setCenter(getPlayerName);
    }

    public void createUserInputArea()
    {
        userInputArea = new TextArea();
        userInputArea.setOnKeyTyped(event -> {
            int maxCharacters = 10;
            if(!userInputArea.getText().isEmpty())
            {
                sendButton.setDisable(false);
            }
            if (userInputArea.getText().length() > maxCharacters)
            {
                userInputArea.deletePreviousChar();
            }
        });

        userInputArea.setBorder(border);
        userInputArea.setBackground(background);
        userInputArea.setMaxHeight(50);
        userInputArea.setTranslateY(60);

        sendButton = new Button(UtilStringStorage.validateButton);
        sendButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        sendButton.setDisable(true);
        sendButton.setBorder(border);
        sendButton.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        sendButton.setTextFill(Color.GHOSTWHITE);
        sendButton.setMinWidth(80);
        sendButton.setTranslateY(60);
        getPlayerName.getChildren().add(userInputArea);
        getPlayerName.getChildren().add(sendButton);
    }

    public void setOnActionSendButton(BorderPane pane, QuestionInterface questionInterface, Stage stage, Stage popUpStage)
    {
        sendButton.setOnAction(event -> {
            if (!userInputArea.getText().isEmpty())
            {
                createPlayerInfoArea();
                pane.setLeft(playerInfos);
                questionInterface.setDisable(false);
                stage.setMinWidth(900);
                stage.setMinHeight(500);
                GameTimer.startTimer();
                popUpStage.close();
            }
        });
    }

    public void createPlayerInfoArea()
    {
        playerInfos = new VBox();
        playerInfos.setTranslateY(50);
        player.setPlayerName(userInputArea.getText());
        Label playerNameLabel = new Label(UtilStringStorage.playerNameIngame + player.getPlayerName());
        playerNameLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 13));
        playerNameLabel.setTextFill(Color.GHOSTWHITE);
        playerNameLabel.setTranslateX(-11);
        playerInfos.getChildren().add(createStatArea(playerNameLabel));
        playerInfos.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        playerScoreLabel = new Label(UtilStringStorage.scoreLabelIngame +player.getPlayerScore());
        playerScoreLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 13));
        playerScoreLabel.setTextFill(Color.GHOSTWHITE);
        playerScoreLabel.setTranslateX(-11);
        playerInfos.getChildren().add(createStatArea(playerScoreLabel));
        playerInfos.setMinWidth(150);
        playerInfos.setMaxWidth(150);
    }

    public void increaseScore()
    {
        player.setPlayerScore(player.getPlayerScore()+1);
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

    public Label getPlayerScoreLabel() {
        return playerScoreLabel;
    }

    public Player getPlayer() {
        return player;
    }

}

