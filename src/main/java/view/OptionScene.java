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
    public OptionScene(BorderPane pane, Stage stage, AchievementManager achievementManager, File saveFile, Properties cupFile, Properties perfectFile)
    {
        super(pane);
        this.pane = pane;
        pane.setPrefHeight(500);
        pane.setPrefWidth(900);
        optionVbox = new VBox();
        pane.setCenter(optionVbox);
        this.saveFile = saveFile;
        this.cupFile = cupFile;
        this.perfectFile = perfectFile;
        this.confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        modifyConfirmAlert();

        this.stage = stage;
        this.achievementManager = achievementManager;

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
                SoundManager.handleMenuSceneVolume(App.menuMusicToStop, 0.0);
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

    public void createLanguageButton()
    {
        OptionLanguageScene optionLanguageScene = new OptionLanguageScene(new BorderPane(), stage, achievementManager, saveFile, cupFile, perfectFile);
        Button languageButton = new Button(UtilStringStorage.languageLabel);
        Tooltip languageTooltip = new Tooltip(UtilStringStorage.languageTooltip);
        languageButton.setTooltip(languageTooltip);
        languageButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        if(languageButton.getText().equals("Langues"))
        {
            languageButton.setTranslateY(140);
            languageButton.setTranslateX(360);
        }
        else {
            languageButton.setTranslateY(140);
            languageButton.setTranslateX(350);
        }
        optionVbox.getChildren().add(languageButton);
        languageButton.setOnAction(event -> {
            stage.setMinWidth(400);
            stage.setMinHeight(400);
            stage.setTitle(UtilStringStorage.languageLabel);
            stage.setScene(optionLanguageScene);
        });

        UtilTranslateString utilTranslateString = new UtilTranslateString();
        optionLanguageScene.getEngButton().setOnAction(event -> {
            utilTranslateString.loadEngTradFile();
            utilTranslateString.translateEngString();
            App.menuMusicToStop.stop();
            App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(500);
            stage.setMinWidth(900);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });

        optionLanguageScene.getFrButton().setOnAction(event -> {
            utilTranslateString.loadFrTradFile();
            utilTranslateString.translateFrString();
            App.menuMusicToStop.stop();
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
            resetButton.setTranslateY(240);
            resetButton.setTranslateX(310);
        }
        else {
            resetButton.setTranslateY(240);
            resetButton.setTranslateX(350);
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

        optionVbox.getChildren().add(resetButton);
    }

    public void setVolumeFromSlider(Double sliderValue)
    {
        SoundManager.handleMenuSceneVolume(App.menuMusicToStop, sliderValue);
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
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        }
    }
}
