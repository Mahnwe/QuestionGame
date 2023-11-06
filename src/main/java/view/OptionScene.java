package view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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
    private final Alert confirmAlert;
    private Slider volumeSlider;
    private Button muteButton;
    private boolean isMute;
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
        pane.setPrefHeight(500);
        pane.setPrefWidth(1000);
        this.confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        modifyConfirmAlert();

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

    public void createSliderArea()
    {
        Label volumeLabel = new Label(UtilStringStorage.volumeLabel);
        volumeLabel.setTranslateY(20);
        volumeLabel.setTranslateX(388);
        volumeLabel.setFont(Font.font(OPTION_POLICE_LABEL, FontWeight.EXTRA_BOLD, 17));
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
        muteButton.setTranslateY(35);
        muteButton.setTranslateX(232);


        volumeSlider = new Slider(0, 10, 5);
        volumeSlider.setMaxWidth(305);
        volumeSlider.setMaxHeight(60);
        volumeSlider.setTranslateY(10);
        volumeSlider.setTranslateX(270);
        volumeSlider.setShowTickMarks(true);
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setMajorTickUnit(1f);
        volumeSlider.setBlockIncrement(1f);
        volumeSlider.setValue(SoundManager.soundVolume);
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
                SoundManager.handleMenuSceneVolume(App.menuMusicToStop, 0.0);
                if(ResultScene.returnToMenuMusic != null) {
                    SoundManager.handleMenuSceneVolume(ResultScene.returnToMenuMusic, 0.0);
                }
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

    public void createButtons()
    {
        VBox englishVbox = new VBox();
        Label englishLabel = new Label("Choose a language");
        englishLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 15));

        engButton = new LanguageButton(PathUtil.ENGLISH_FLAG, UtilStringStorage.englishLanguageTooltip);

        englishVbox.getChildren().add(englishLabel);
        englishVbox.getChildren().add(engButton);
        englishVbox.setTranslateY(50);
        englishVbox.setTranslateX(220);


        VBox frenchVbox = new VBox();
        Label frenchLabel = new Label("Choisissez une langue");
        frenchLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 15));

        frButton = new LanguageButton(PathUtil.FRENCH_FLAG, UtilStringStorage.frenchLanguageTooltip);

        frenchVbox.getChildren().add(frenchLabel);
        frenchVbox.getChildren().add(frButton);
        frenchVbox.setTranslateX(470);
        frenchVbox.setTranslateY(-20);

        Label languageLabel = new Label(UtilStringStorage.languageLabel);
        languageLabel.setFont(Font.font(OPTION_POLICE_LABEL, FontWeight.EXTRA_BOLD, 17));
        languageLabel.setTextFill(Color.BLACK);
        languageLabel.setTranslateY(40);
        languageLabel.setTranslateX(390);

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
            SoundManager.checkIfMusicIsPlayed(App.menuMusicToStop);
            App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(500);
            stage.setMinWidth(1000);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });

        frButton.setOnAction(event -> {
            utilTranslateString.translateFrString();
            App.menuMusicToStop.stop();
            SoundManager.checkIfMusicIsPlayed(App.menuMusicToStop);
            App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(500);
            stage.setMinWidth(1000);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });
    }

    public void createResetButtonArea()
    {
        Button resetButton = new Button(UtilStringStorage.resetButton);
        placeButtonWithTranslation(resetButton);
        resetButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 15));
        Tooltip resetTooltip = new Tooltip(UtilStringStorage.resetTooltip);
        resetButton.setTooltip(resetTooltip);

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
        resetLabel.setFont(Font.font(OPTION_POLICE_LABEL, FontWeight.EXTRA_BOLD, 17));
        resetLabel.setTextFill(Color.BLACK);
        placeLabelWithTranslation(resetLabel);

        optionVbox.getChildren().add(resetLabel);
        optionVbox.getChildren().add(resetButton);
    }

    public void placeButtonWithTranslation(Button button)
    {
        if(button.getText().equals("Réinitialiser sauvegarde"))
        {
            button.setTranslateY(70);
            button.setTranslateX(310);
        }
        else {
            button.setTranslateY(90);
            button.setTranslateX(365);
        }
    }

    public void placeLabelWithTranslation(Label label)
    {
        if(label.getText().equals("Sauvegarde")) {
            label.setTranslateY(50);
            label.setTranslateX(375);
        }
        else {
            label.setTranslateY(50);
            label.setTranslateX(400);
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

    public void modifyConfirmAlert()
    {
        confirmAlert.setTitle(UtilStringStorage.confirmAlertWindow);
        confirmAlert.setHeaderText(UtilStringStorage.askConfirmReset);

        IconCreator iconCreator = new IconCreator(PathUtil.QUESTION_MARK_TEST);
        ImageView backgroundImage = iconCreator.createImage();
        backgroundImage.setFitHeight(150);
        confirmAlert.setGraphic(backgroundImage);

        Button confirmButton = (Button) confirmAlert.getDialogPane().lookupButton(ButtonType.OK);
        confirmButton.setText(UtilStringStorage.yesButton);
        placeButton(confirmButton, -20, -120);

        Button cancelButton = (Button) confirmAlert.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setText(UtilStringStorage.noButton);
        placeButton(cancelButton, -20, -20);
    }

    public void placeButton(Button button, int translateY, int translateX)
    {
        button.setTranslateY(translateY);
        button.setTranslateX(translateX);
    }

    public void resetSave()
    {
       FileUtil.resetSaveFile();
       FileUtil.resetCupFile();
       FileUtil.resetPerfectFile();
    }

    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }


}
