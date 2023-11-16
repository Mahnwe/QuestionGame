package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.*;
import util.*;

public class PlayerInfoScene extends Scene
{
    private VBox getPlayerName;
    private Button sendButton;
    private TextArea userInputArea;
    private final BorderPane pane;

    private VBox playerInfos;
    private Label playerScoreLabel;
    private Label playerLivesLabel;
    private final Player player;

    private final BorderWidths borderWidths = new BorderWidths(1.5);
    private final CornerRadii cornerRadii = new CornerRadii(1.0);
    private final Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, cornerRadii, borderWidths));

    public PlayerInfoScene(BorderPane pane, Player player)
    {
        super(pane);
        this.pane = pane;
        this.player = player;

        createBackground();

        createVBoxGetPlayerName();

    }

    public void createVBoxGetPlayerName()
    {
        getPlayerName = new VBox();
        Label askPlayerName = new Label(UtilStringStorage.askPlayerName);
        askPlayerName.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        askPlayerName.setTextFill(Color.GHOSTWHITE);
        askPlayerName.setTranslateY(40);
        getPlayerName.getChildren().add(askPlayerName);
        createUserInputArea();
        pane.setCenter(getPlayerName);
    }

    public void createBackground()
    {
        BackgroundFill backgroundFill = BackgroundCreator.createGameBackground();
        pane.setBackground(new Background(backgroundFill));
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
        userInputArea.setMaxHeight(50);
        userInputArea.setTranslateY(60);

        sendButton = new Button(UtilStringStorage.validateButton);
        stylizeSendButton(sendButton);


        getPlayerName.getChildren().add(userInputArea);
        getPlayerName.getChildren().add(sendButton);
    }

    public void stylizeSendButton(Button sendButton)
    {
        sendButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        sendButton.setDisable(true);
        sendButton.setBorder(border);
        sendButton.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        sendButton.setTextFill(Color.GHOSTWHITE);
        sendButton.setMinWidth(80);
        sendButton.setTranslateY(60);
    }

    public void setOnActionSendButton(BorderPane pane, QuestionInterface questionInterface, Stage stage, Stage popUpStage)
    {
            if(!userInputArea.getText().isEmpty())
            {
                    createPlayerInfoArea();
                    pane.setLeft(playerInfos);
                    questionInterface.setDisable(false);
                    stage.setMinWidth(900);
                    stage.setMinHeight(500);
                    GameTimer.startTimer();
                    popUpStage.close();
            }
    }

    public void setOnKeyTypedSendButton(BorderPane pane, QuestionInterface questionInterface, Stage stage, Stage popUpStage)
    {
        userInputArea.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER) && (!userInputArea.getText().substring(0,1).isBlank())) {
                createPlayerInfoArea();
                pane.setLeft(playerInfos);
                questionInterface.setDisable(false);
                stage.setMinWidth(900);
                stage.setMinHeight(500);
                GameTimer.startTimer();
                popUpStage.close();
            }
            if (keyEvent.getCode().equals(KeyCode.ENTER) && (userInputArea.getText().isBlank())) {
                userInputArea.clear();
            }
        });
    }

    public void createPlayerInfoArea()
    {
        playerInfos = new VBox();
        playerInfos.setTranslateY(60);

        player.setPlayerName(userInputArea.getText());
        Label playerNameLabel = new Label(UtilStringStorage.playerNameIngame + " " + player.getPlayerName());
        stylizeLabel(playerNameLabel);

        playerInfos.getChildren().add(createStatArea(playerNameLabel));
        playerInfos.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        playerScoreLabel = new Label(UtilStringStorage.scoreLabelIngame + " " + player.getPlayerScore());
        stylizeLabel(playerScoreLabel);

        playerInfos.getChildren().add(createStatArea(playerScoreLabel));

        if(GameHandler.gameMode != null) {
            playerLivesLabel = new Label(UtilStringStorage.playerLivesIngame + " "+ player.getNbrOfLives());
            stylizeLabel(playerLivesLabel);
            playerInfos.getChildren().add(createStatArea(playerLivesLabel));
        }
        playerInfos.setMinWidth(170);
        playerInfos.setMaxWidth(150);

        createSliderArea();

    }

    public void stylizeLabel(Label label)
    {
        label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        label.setTextFill(Color.GHOSTWHITE);
        label.setTranslateX(-11);
    }

    public void createSliderArea()
    {
        Button muteButton;

        Label volumeLabel = new Label(UtilStringStorage.volumeLabel);
        volumeLabel.setTranslateY(120);
        volumeLabel.setTranslateX(50);
        volumeLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 18));
        volumeLabel.setTextFill(Color.GHOSTWHITE);
        playerInfos.getChildren().add(volumeLabel);

        muteButton = new Button();
        CustomOption.customMuteButton(muteButton, PathUtil.WHITE_MUTE_ICON, 185, 75);
        playerInfos.getChildren().add(muteButton);

        Slider volumeSlider = new Slider(0, 10, 5);
        CustomOption.customSlider(volumeSlider, 200, 40, 105, 0);

        if(SoundManager.soundVolume == 0.0) {
            VolumeInGameHandler.isMute = true;
            volumeSlider.setDisable(true);
        }
        volumeSlider.setValue(SoundManager.soundVolume);
        VolumeInGameHandler.setUpMuteButton(muteButton, volumeSlider);
        playerInfos.getChildren().add(volumeSlider);
        volumeSlider.setOnDragDetected(event -> VolumeInGameHandler.setVolumeFromSlider(volumeSlider.getValue()));
        volumeSlider.setOnMouseClicked(event -> VolumeInGameHandler.setVolumeFromSlider(volumeSlider.getValue()));
        volumeSlider.setOnMouseReleased(event -> VolumeInGameHandler.setVolumeFromSlider(volumeSlider.getValue()));

    }
    public void increaseScore()
    {
        player.setPlayerScore(player.getPlayerScore()+1);
    }

    public void removePlayerLife()
    {
        player.setNbrOfLives(player.getNbrOfLives()-1);
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

    public Button getSendButton() {
        return sendButton;
    }

    public TextArea getUserInputArea() {
        return userInputArea;
    }

    public Label getPlayerLivesLabel() {
        return playerLivesLabel;
    }
}

