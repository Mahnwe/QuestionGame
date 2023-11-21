package view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import model.SoundManager;
import util.*;

import java.util.Optional;

public class OptionScene extends Scene {

    private final AchievementManager achievementManager;
    private final Stage stage;
    private final VBox optionVbox;
    private final ConfirmAlert confirmAlert;
    private final BorderPane pane;
    private LanguageButton engButton;
    private LanguageButton frButton;
    public static final String OPTION_POLICE_LABEL = "Impact";
    public OptionScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.pane = pane;
        this.stage = stage;
        this.achievementManager = achievementManager;
        pane.setPrefHeight(750);
        pane.setPrefWidth(1200);
        this.confirmAlert = new ConfirmAlert(Alert.AlertType.CONFIRMATION);

        optionVbox = new VBox();
        pane.setCenter(optionVbox);

        createSliderArea();

        createReturnButton();

        createLanguageButton();

        createResetButtonArea();

        createBackground();

    }

    public void createBackground()
    {
        BackgroundImage backgroundImage = BackgroundCreator.createMenuBackground();
        pane.setBackground(new Background(backgroundImage));
    }

    public void createReturnButton()
    {
        ReturnButton returnButton = new ReturnButton();
        pane.setTop(returnButton);
        returnButton.setOnAction(event -> backToMainMenu());
    }

    public void stylizeLabel(Label label, int translateY, int translateX)
    {
        label.setFont(Font.font(OPTION_POLICE_LABEL, FontWeight.EXTRA_BOLD, 17));
        label.setTextFill(Color.BLACK);
        label.setTranslateY(translateY);
        label.setTranslateX(translateX);
    }

    public void createSliderArea()
    {
        Label volumeLabel = new Label(UtilStringStorage.volumeLabel);
        stylizeLabel(volumeLabel, 30, 405);
        optionVbox.getChildren().add(volumeLabel);

        Button muteButton = new Button();
        CustomOption.customMuteButton(muteButton, PathUtil.MUTE_ICON, 45, 242);
        optionVbox.getChildren().add(muteButton);

        Slider volumeSlider = new Slider(0, 10, 5);
        CustomOption.customSlider(volumeSlider, 305, 60, 20, 280);
        volumeSlider.setValue(SoundManager.soundVolume);

        if(SoundManager.soundVolume == 0.0) {
            SoundManager.isMute = true;
            volumeSlider.setDisable(true);
        }
        SoundManager.setUpMuteButton(muteButton, volumeSlider);

        optionVbox.getChildren().add(volumeSlider);
        volumeSlider.setOnDragDetected(event -> setVolumeFromSlider(volumeSlider.getValue()));
        volumeSlider.setOnMouseClicked(event -> setVolumeFromSlider(volumeSlider.getValue()));
        volumeSlider.setOnMouseReleased(event -> setVolumeFromSlider(volumeSlider.getValue()));
    }


    public void createButtons()
    {
        VBox englishVbox = new VBox();
        Label englishLabel = new Label("Choose a language");
        englishLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 15));

        engButton = new LanguageButton(PathUtil.ENGLISH_FLAG, UtilStringStorage.englishLanguageTooltip);

        englishVbox.getChildren().add(englishLabel);
        englishVbox.getChildren().add(engButton);
        englishVbox.setTranslateY(65);
        englishVbox.setTranslateX(230);

        VBox frenchVbox = new VBox();
        Label frenchLabel = new Label("Choisissez une langue");
        frenchLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 15));

        frButton = new LanguageButton(PathUtil.FRENCH_FLAG, UtilStringStorage.frenchLanguageTooltip);

        frenchVbox.getChildren().add(frenchLabel);
        frenchVbox.getChildren().add(frButton);
        frenchVbox.setTranslateX(480);
        frenchVbox.setTranslateY(-32);

        Label languageLabel = new Label(UtilStringStorage.languageLabel);
        stylizeLabel(languageLabel, 55, 405);
        if(languageLabel.getText().equals("Languages"))
        {
            stylizeLabel(languageLabel, 55, 395);
        }

        optionVbox.getChildren().add(languageLabel);
        optionVbox.getChildren().add(englishVbox);
        optionVbox.getChildren().add(frenchVbox);
    }

    public void createLanguageButton()
    {
        createButtons();

        UtilTranslateString utilTranslateString = new UtilTranslateString();
        engButton.setOnAction(event -> {
            utilTranslateString.translateEngString();
            App.menuMusicToStop.stop();
            SoundManager.checkIfMusicIsPlayed(ResultScene.returnToMenuMusic);
            SoundManager.checkIfMusicIsPlayed(App.menuMusicToStop);
            App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(750);
            stage.setMinWidth(1200);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });

        frButton.setOnAction(event -> {
            utilTranslateString.translateFrString();
            App.menuMusicToStop.stop();
            SoundManager.checkIfMusicIsPlayed(ResultScene.returnToMenuMusic);
            SoundManager.checkIfMusicIsPlayed(App.menuMusicToStop);
            App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(750);
            stage.setMinWidth(1200);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });
    }

    public void createResetButtonArea()
    {
        Button resetButton = new Button();
        resetButton.setTranslateY(85);
        resetButton.setTranslateX(405);
        CustomOption.setUpTrashButton(resetButton);
        resetButton.setOnAction(event -> {
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.orElse(null) == ButtonType.OK)
            {
                resetSave();
                MenuScene menuScene = new MenuScene(new BorderPane(), stage, new AchievementManager());
                stage.setScene(menuScene);
            }
        });

        Label resetLabel = new Label(UtilStringStorage.resetLabel);
        stylizeLabel(resetLabel, 15, 10);
        placeLabelWithTranslation(resetLabel);

        optionVbox.getChildren().add(resetLabel);
        optionVbox.getChildren().add(resetButton);
    }

    public void placeLabelWithTranslation(Label label)
    {
        if(label.getText().equals("Sauvegarde")) {
            label.setTranslateY(65);
            label.setTranslateX(394);
        }
        else {
            label.setTranslateY(65);
            label.setTranslateX(417);
        }
    }

    public void setVolumeFromSlider(Double sliderValue)
    {
        SoundManager.handleMenuSceneVolume(App.menuMusicToStop, sliderValue);
        if(ResultScene.returnToMenuMusic != null)
        {
            SoundManager.handleMenuSceneVolume(ResultScene.returnToMenuMusic, sliderValue);
        }
        SoundManager.setSoundVolume(sliderValue);
    }
    public void resetSave()
    {
       FileUtil.resetSaveFile();
       FileUtil.resetGeneralSavesFile();
    }
    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }
}
