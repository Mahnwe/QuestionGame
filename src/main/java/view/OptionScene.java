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
import model.*;
import util.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class OptionScene extends Scene {

    private final AchievementManager achievementManager;
    private final Stage stage;
    private final File saveFile;
    private final Properties cupFile;
    private final Properties perfectFile;
    private final VBox optionVbox;
    private final Alert confirmAlert;
    private Slider volumeSlider;
    private Button muteButton;
    private boolean isMute;
    private final BorderPane pane;

    private Button engButton;
    private Button frButton;

    public static final String OPTION_POLICE_LABEL = "Impact";
    public OptionScene(BorderPane pane, Stage stage, AchievementManager achievementManager, File saveFile, Properties cupFile, Properties perfectFile)
    {
        super(pane);
        this.pane = pane;
        this.stage = stage;
        this.achievementManager = achievementManager;
        pane.setPrefHeight(500);
        pane.setPrefWidth(900);
        this.saveFile = saveFile;
        this.cupFile = cupFile;
        this.perfectFile = perfectFile;
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
        returnButton.setOnAction(event -> backToMainMenu());
    }

    public void createSliderArea()
    {
        Label volumeLabel = new Label(UtilStringStorage.volumeLabel);
        volumeLabel.setTranslateY(20);
        volumeLabel.setTranslateX(368);
        volumeLabel.setFont(Font.font(OPTION_POLICE_LABEL, FontWeight.EXTRA_BOLD, 16));
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
        muteButton.setTranslateX(212);


        volumeSlider = new Slider(0, 10, 5);
        volumeSlider.setMaxWidth(305);
        volumeSlider.setMaxHeight(60);
        volumeSlider.setTranslateY(10);
        volumeSlider.setTranslateX(250);
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
        englishLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        engButton = new Button();
        IconCreator englishIcon = new IconCreator(PathUtil.ENGLISH_FLAG);
        Image englishFlag = englishIcon.createImage().getImage();
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        engButton.setBackground(new Background(new BackgroundImage(englishFlag, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        engButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        engButton.setMinWidth(60);
        engButton.setMinHeight(35);
        engButton.setTranslateX(40);
        engButton.setTranslateY(10);
        englishVbox.getChildren().add(englishLabel);
        englishVbox.getChildren().add(engButton);
        englishVbox.setTranslateY(70);
        englishVbox.setTranslateX(200);


        VBox frenchVbox = new VBox();
        Label frenchLabel = new Label("Choisissez une langue");
        frenchLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        frButton = new Button();
        IconCreator frenchIcon = new IconCreator(PathUtil.FRENCH_FLAG);
        Image frenchFlag = frenchIcon.createImage().getImage();
        frButton.setBackground(new Background(new BackgroundImage(frenchFlag, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        frButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        frButton.setMinWidth(60);
        frButton.setMinHeight(35);
        frButton.setTranslateX(40);
        frButton.setTranslateY(10);
        frenchVbox.getChildren().add(frenchLabel);
        frenchVbox.getChildren().add(frButton);
        frenchVbox.setTranslateX(450);
        frenchVbox.setTranslateY(17);


        Label languageLabel = new Label(UtilStringStorage.languageLabel);
        languageLabel.setFont(Font.font(OPTION_POLICE_LABEL, FontWeight.EXTRA_BOLD, 16));
        languageLabel.setTextFill(Color.BLACK);
        languageLabel.setTranslateY(60);
        languageLabel.setTranslateX(365);

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
            if(ResultScene.returnToMenuMusic != null)
            {
                ResultScene.returnToMenuMusic.stop();
            }
            App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(500);
            stage.setMinWidth(900);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });

        frButton.setOnAction(event -> {
            utilTranslateString.translateFrString();
            App.menuMusicToStop.stop();
            if(ResultScene.returnToMenuMusic != null)
            {
                ResultScene.returnToMenuMusic.stop();
            }
            App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(500);
            stage.setMinWidth(900);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });
    }

    public void createResetButtonArea()
    {
        Button resetButton = new Button(UtilStringStorage.resetButton);
        if(resetButton.getText().equals("Réinitialiser sauvegarde"))
        {
            resetButton.setTranslateY(100);
            resetButton.setTranslateX(290);
        }
        else {
            resetButton.setTranslateY(120);
            resetButton.setTranslateX(340);
        }
        resetButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
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
        resetLabel.setFont(Font.font(OPTION_POLICE_LABEL, FontWeight.EXTRA_BOLD, 16));
        resetLabel.setTextFill(Color.BLACK);
        resetLabel.setTranslateY(70);
        resetLabel.setTranslateX(355);
        optionVbox.getChildren().add(resetLabel);
        optionVbox.getChildren().add(resetButton);
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
        placeButton(confirmButton, -20, -140);

        Button cancelButton = (Button) confirmAlert.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setText(UtilStringStorage.noButton);
        placeButton(cancelButton, -20, -40);
    }

    public void placeButton(Button button, int translateY, int translateX)
    {
        button.setTranslateY(translateY);
        button.setTranslateX(translateX);
    }

    public void resetSave()
    {
       resetSaveFile();
       resetCupFile();
       resetPerfectFile();
    }

    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }

    public void resetSaveFile()
    {
        try {
            FileWriter fw = new FileWriter(saveFile.getAbsoluteFile());
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write("");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resetCupFile()
    {
        cupFile.setProperty("goldCup", "0");
        cupFile.setProperty("silverCup", "0");
        cupFile.setProperty("bronzeCup", "0");
        try {
            cupFile.store(new FileWriter(PathUtil.CUP_FILE), "");
        } catch (IOException e) {

        }
    }

    public void resetPerfectFile()
    {
        perfectFile.setProperty("perfectScore10", "0");
        perfectFile.setProperty("perfectScore15", "0");
        perfectFile.setProperty("perfectScore20", "0");
        try {
            perfectFile.store(new FileWriter(PathUtil.PERFECT_SCORE_FILE), "");
        } catch (IOException e) {

        }
    }
}
