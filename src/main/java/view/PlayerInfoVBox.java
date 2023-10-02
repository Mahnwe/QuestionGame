package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.*;

public class PlayerInfoVBox extends VBox
{
    private final VBox getPlayerName;
    private Button sendButton;
    private TextArea userInputArea;

    private VBox playerInfos;
    private Label playerScoreLabel;

    private final Player player;
    public static MediaPlayer inGameMusicToStop;

    private final Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    private final Background background = new Background(new BackgroundFill(Color.SADDLEBROWN,
            CornerRadii.EMPTY, Insets.EMPTY));

    public PlayerInfoVBox(Player player)
    {
        this.player = player;

        getPlayerName = new VBox();
        Label askPlayerName = new Label(UtilStringStorage.askPlayerName);
        askPlayerName.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        askPlayerName.setTextFill(Color.GHOSTWHITE);
        getPlayerName.getChildren().add(askPlayerName);
    }

    public VBox createUserInputArea()
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

        sendButton = new Button(UtilStringStorage.validateButton);
        sendButton.setDisable(true);
        sendButton.setBorder(border);
        sendButton.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        sendButton.setTextFill(Color.GHOSTWHITE);
        sendButton.setMinWidth(80);
        getPlayerName.getChildren().add(userInputArea);
        getPlayerName.getChildren().add(sendButton);
        return getPlayerName;
    }

    public void setOnActionSendButton(BorderPane pane, QuestionInterface questionInterface, Stage stage)
    {
        sendButton.setOnAction(event -> {
            if (!userInputArea.getText().isEmpty())
            {
                createPlayerInfoArea();
                pane.setLeft(playerInfos);
                questionInterface.setVisible(true);
                stage.setMinWidth(900);
                stage.setMinHeight(500);
                GameTimer.startTimer();
                inGameMusicToStop = SoundManager.playMusicRepeat(PathUtil.IN_GAME_MUSIC);
            }
            getPlayerName.setMaxHeight(0);
            getPlayerName.setMinHeight(0);
            getPlayerName.setVisible(false);
        });
    }

    public void createPlayerInfoArea()
    {
        playerInfos = new VBox();
        player.setPlayerName(userInputArea.getText());
        Label playerNameLabel = new Label(UtilStringStorage.playerNameIngame + player.getPlayerName());
        playerNameLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 13));
        playerNameLabel.setTextFill(Color.GHOSTWHITE);
        playerInfos.getChildren().add(createStatArea(playerNameLabel));
        playerInfos.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        playerScoreLabel = new Label(UtilStringStorage.scoreLabelIngame +player.getPlayerScore());
        playerScoreLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 13));
        playerScoreLabel.setTextFill(Color.GHOSTWHITE);
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

