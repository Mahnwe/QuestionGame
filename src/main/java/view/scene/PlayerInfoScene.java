package view.scene;

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
import model.handlers.GameHandler;
import model.handlers.PlayerHandler;
import model.handlers.SoundManager;
import util.*;
import util.creators.BackgroundCreator;
import util.stringutiltranslate.UtilStringStorage;
import view.customobject.CustomOption;
import view.customobject.CustomTextArea;

public class PlayerInfoScene extends Scene
{
    private VBox getPlayerName;
    private Button sendButton;
    private CustomTextArea userInputArea;
    private final BorderPane pane;
    private VBox playerInfos;
    private Label playerScoreLabel;
    private Label playerLivesLabel;
    private final PlayerHandler playerHandler;

    public static final String POLICE_LABEL = "Futura";

    public PlayerInfoScene(BorderPane pane, PlayerHandler playerHandler)
    {
        super(pane);
        this.pane = pane;
        this.playerHandler = playerHandler;

        createBackground();
        createVBoxGetPlayerName();
    }

    public void createVBoxGetPlayerName()
    {
        getPlayerName = new VBox();
        Label askPlayerName = new Label(UtilStringStorage.askPlayerName);
        askPlayerName.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 19));
        askPlayerName.setTextFill(Color.GHOSTWHITE);
        askPlayerName.setTranslateY(40);
        askPlayerName.setTranslateX(70);
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
        sendButton = new Button(UtilStringStorage.validateButton);
        stylizeSendButton(sendButton);

        userInputArea = new CustomTextArea(sendButton, 12);
        userInputArea.setMaxHeight(50);
        userInputArea.setMaxWidth(250);
        userInputArea.setTranslateY(75);
        userInputArea.setTranslateX(230);
        userInputArea.setBorder(CustomOption.createCustomBorder(1.0, 1.5, Color.BLACK));

        getPlayerName.getChildren().add(userInputArea);
        getPlayerName.getChildren().add(sendButton);
    }

    public void stylizeSendButton(Button sendButton)
    {
        sendButton.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 19));
        sendButton.setDisable(true);
        sendButton.setBorder(CustomOption.createCustomBorder(1.0, 1.5, Color.BLACK));
        sendButton.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        sendButton.setTextFill(Color.GHOSTWHITE);
        sendButton.setMinWidth(100);
        sendButton.setTranslateY(115);
        sendButton.setTranslateX(295);
    }

    public void setOnActionSendButton(BorderPane pane, QuestionInterface questionInterface, Stage popUpStage)
    {
            if(!userInputArea.getText().isEmpty())
            {
                    createPlayerInfoArea();
                    pane.setLeft(playerInfos);
                    questionInterface.setDisable(false);
                    GameTimer.startTimer();
                    popUpStage.close();
            }
    }

    public void setOnKeyTypedSendButton(BorderPane pane, QuestionInterface questionInterface, Stage popUpStage)
    {
        userInputArea.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER) && (!userInputArea.getText().substring(0,1).isBlank())) {
                createPlayerInfoArea();
                pane.setLeft(playerInfos);
                questionInterface.setDisable(false);
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
        playerInfos.setMinWidth(370);
        playerInfos.setTranslateY(280);

        playerHandler.getPlayer().setPlayerName(userInputArea.getText());
        Label playerNameLabel = new Label(UtilStringStorage.playerNameIngame + "   " + playerHandler.getPlayer().getPlayerName());
        stylizeLabel(playerNameLabel);

        playerInfos.getChildren().add(createStatArea(playerNameLabel));
        playerInfos.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        playerScoreLabel = new Label(UtilStringStorage.scoreLabelIngame + "    " + playerHandler.getPlayer().getPlayerScore());
        stylizeLabel(playerScoreLabel);

        playerInfos.getChildren().add(createStatArea(playerScoreLabel));

        if(GameHandler.gameMode != null) {
            playerLivesLabel = new Label(UtilStringStorage.playerLivesIngame + " "+ playerHandler.getPlayer().getNbrOfLives());
            stylizeLabel(playerLivesLabel);
            playerInfos.getChildren().add(createStatArea(playerLivesLabel));
        }

        createSliderArea();

    }

    public void stylizeLabel(Label label)
    {
        label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 22));
        label.setTextFill(Color.GHOSTWHITE);
        label.setTranslateX(-11);
    }

    public void createSliderArea()
    {
        Label volumeLabel = new Label(UtilStringStorage.volumeLabel);
        volumeLabel.setTranslateY(220);
        volumeLabel.setTranslateX(130);
        volumeLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 25));
        volumeLabel.setTextFill(Color.GHOSTWHITE);
        playerInfos.getChildren().add(volumeLabel);

        Button muteButton = new Button();
        CustomOption.customMuteButton(muteButton, PathUtil.WHITE_MUTE_ICON, 315, 155);
        playerInfos.getChildren().add(muteButton);

        Slider volumeSlider = new Slider(0, 10, 5);
        CustomOption.customSlider(volumeSlider, 155, 50, 205, 0);
        volumeSlider.setValue(SoundManager.soundVolume);
        if(SoundManager.soundVolume == 0.0) {
            SoundManager.isMute = true;
            volumeSlider.setDisable(true);
        }

        SoundManager.setUpMuteButtonInGame(muteButton, volumeSlider);
        playerInfos.getChildren().add(volumeSlider);
        volumeSlider.setOnDragDetected(event -> SoundManager.setVolumeFromSliderInGame(volumeSlider.getValue()));
        volumeSlider.setOnMouseClicked(event -> SoundManager.setVolumeFromSliderInGame(volumeSlider.getValue()));
        volumeSlider.setOnMouseReleased(event -> SoundManager.setVolumeFromSliderInGame(volumeSlider.getValue()));

    }

    public HBox createStatArea(Label label) {
        label.setTranslateY(12);

        HBox area = new HBox();
        area.setMinHeight(50);
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

