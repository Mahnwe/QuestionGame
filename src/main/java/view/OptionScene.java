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
    public OptionScene(BorderPane pane, Stage stage, AchievementManager achievementManager, File saveFile, Properties cupFile, Properties perfectFile)
    {
        super(pane);
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

        Button returnButton = new Button(UtilStringStorage.returnButton);
        returnButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        pane.setTop(returnButton);
        returnButton.setOnAction(event -> backToMainMenu());

        createLanguageButton();

        createResetButtonArea();

        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        BackgroundCreator menuBackground = new BackgroundCreator(PathUtil.MENU_BACKGROUND);
        Image menuSceneBackground = menuBackground.createBackground();
        BackgroundImage backgroundImage = new BackgroundImage(menuSceneBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize);
        pane.setBackground(new Background(backgroundImage));

    }

    public void createSliderArea()
    {
        Label volumeLabel = new Label(UtilStringStorage.volumeLabel);
        volumeLabel.setTranslateY(40);
        volumeLabel.setTranslateX(365);
        volumeLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 18));
        volumeLabel.setTextFill(Color.BLACK);
        optionVbox.getChildren().add(volumeLabel);

        Slider volumeSlider = new Slider(0, 1, 0.5);
        volumeSlider.setMaxWidth(400);
        volumeSlider.setMaxHeight(50);
        volumeSlider.setTranslateY(60);
        volumeSlider.setTranslateX(200);
        volumeSlider.setShowTickMarks(true);
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setMajorTickUnit(0.10f);
        volumeSlider.setBlockIncrement(0.1f);
        optionVbox.getChildren().add(volumeSlider);
        volumeSlider.setOnDragDetected(event -> setVolumeFromSlider(volumeSlider.getValue()));
        volumeSlider.setOnMouseClicked(event -> setVolumeFromSlider(volumeSlider.getValue()));
    }

    public void createLanguageButton()
    {
        LanguageScene languageScene;
        languageScene = new LanguageScene(new BorderPane());
        Button languageButton = new Button(UtilStringStorage.languageLabel);
        languageButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        languageButton.setTranslateY(150);
        languageButton.setTranslateX(350);
        optionVbox.getChildren().add(languageButton);
        languageButton.setOnAction(event -> {
            stage.setMinWidth(400);
            stage.setMinHeight(400);
            stage.setTitle(UtilStringStorage.languageLabel);
            stage.setScene(languageScene);
        });

        UtilTranslateString utilTranslateString = new UtilTranslateString();

        languageScene.getEngButton().setOnAction(event -> {
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

        languageScene.getFrButton().setOnAction(event -> {
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
        resetButton.setTranslateY(250);
        resetButton.setTranslateX(350);
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
