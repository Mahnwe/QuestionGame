package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.*;
import util.BackgroundCreator;
import util.IconCreator;
import util.PathUtil;
import util.UtilStringStorage;

public class VolumeInGameScene extends Scene
{
    private final VBox optionVbox;
    private Slider volumeSlider;
    private Button muteButton;
    private boolean isMute;
    private final BorderPane pane;
    private final Stage volumeStage;

    public VolumeInGameScene(BorderPane pane, Stage volumeStage)
    {
        super(pane);
        this.pane = pane;
        this.volumeStage = volumeStage;
        optionVbox = new VBox();
        pane.setCenter(optionVbox);

        createSliderArea();
        createReturnButton();
        createBackground();
    }

    public void createBackground()
    {
        BackgroundCreator menuBackground = new BackgroundCreator(PathUtil.MENU_BACKGROUND);
        Image menuSceneBackground = menuBackground.createBackground();
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(menuSceneBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize);
        pane.setBackground(new Background(backgroundImage));
    }


    public void createReturnButton()
    {
        IconCreator returnArrow = new IconCreator(PathUtil.BACK_ARROW);
        Image backArrow = returnArrow.createImage().getImage();

        Button returnButton = new Button();
        Tooltip returnTooltip = new Tooltip(UtilStringStorage.returnButton);
        returnButton.setTooltip(returnTooltip);
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        returnButton.setBackground(new Background(new BackgroundImage(backArrow, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        returnButton.setPrefHeight(50);
        returnButton.setPrefWidth(50);
        pane.setTop(returnButton);
        returnButton.setOnAction(event -> volumeStage.close());
    }

    public void createSliderArea()
    {
        Label volumeLabel = new Label(UtilStringStorage.volumeLabel);
        volumeLabel.setTranslateY(40);
        volumeLabel.setTranslateX(365);
        volumeLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 18));
        volumeLabel.setTextFill(Color.BLACK);
        optionVbox.getChildren().add(volumeLabel);

        IconCreator muteIcon = new IconCreator(PathUtil.MUTE_ICON);
        Image muteImage = muteIcon.createImage().getImage();
        muteButton = new Button();
        muteButton.setPrefSize(30,30);
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        muteButton.setBackground(new Background(new BackgroundImage(muteImage, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        optionVbox.getChildren().add(muteButton);
        muteButton.setTranslateY(67);
        muteButton.setTranslateX(160);


        volumeSlider = new Slider(0, 10, 5);
        volumeSlider.setMaxWidth(400);
        volumeSlider.setMaxHeight(70);
        volumeSlider.setTranslateY(45);
        volumeSlider.setTranslateX(200);
        volumeSlider.setShowTickMarks(true);
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setMajorTickUnit(1f);
        volumeSlider.setBlockIncrement(1f);
        if(SoundManager.soundVolume == 0.0) {
            isMute = true;
            volumeSlider.setDisable(true);
        }
        setUpMuteButton();
        optionVbox.getChildren().add(volumeSlider);
        volumeSlider.setOnDragDetected(event -> setVolumeFromSlider(volumeSlider.getValue()));
        volumeSlider.setOnMouseClicked(event -> setVolumeFromSlider(volumeSlider.getValue()));
        volumeSlider.setOnMouseReleased(event -> setVolumeFromSlider(volumeSlider.getValue()));

    }
    public void setUpMuteButton()
    {
        muteButton.setOnAction(event -> {
            if (!isMute) {
                SoundManager.soundVolume = 0.0;
                SoundManager.handleMenuSceneVolume(MainScene.inGameMusicToStop, 0.0);
                isMute = true;
                volumeSlider.setDisable(true);
            }
            else {
                volumeSlider.setDisable(false);
                setVolumeFromSlider(volumeSlider.getValue());
                isMute = false;
            }
        });
    }

    public void setVolumeFromSlider(Double sliderValue)
    {
        SoundManager.handleMenuSceneVolume(MainScene.inGameMusicToStop, sliderValue);
        SoundManager.setSoundVolume(sliderValue);
    }


}
