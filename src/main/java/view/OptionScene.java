package view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import model.ImportFileHandler;
import model.SoundManager;
import model.TimePlayedTimer;
import util.*;

import java.util.Optional;

public class OptionScene extends Scene {

    private final AchievementManager achievementManager;
    private final Stage stage;
    private GridPane gridPane;
    private final VBox optionVbox;
    private final VBox importFileVbox;
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
        confirmAlert.modifyConfirmAlert(UtilStringStorage.askConfirmReset);

        optionVbox = new VBox();
        optionVbox.setTranslateX(-80);
        optionVbox.setTranslateY(50);
        importFileVbox = new VBox();
        importFileVbox.setTranslateX(50);
        importFileVbox.setTranslateY(90);
        createGridPane();
        pane.setCenter(gridPane);


        createSliderArea();
        createReturnButton();
        createLanguageButton();
        createResetButtonArea();
        createImportVbox();
        createBackground();
    }

    public void createImportVbox()
    {
        Label copyPersoQuestionFileLabel = new Label(UtilStringStorage.exportLabel);
        copyPersoQuestionFileLabel.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 22));

        HBox hBox1 = new HBox();
        hBox1.setTranslateY(15);

        Button copyPersoQuestionFileButton = new Button(UtilStringStorage.exportButtonLabel);
        ImportFileHandler.setUpOpenDirectoryButton(copyPersoQuestionFileButton, ImportFileHandler.getPersonalizeQuestionPath());
        CustomOption.setGlowEffectOnButton(copyPersoQuestionFileButton);
        copyPersoQuestionFileButton.setTranslateX(50);
        copyPersoQuestionFileButton.setFont(Font.font("Futura", FontWeight.BOLD, 20));

        InfoButton copyInfoButton = new InfoButton(UtilStringStorage.exportInfoButton);

        hBox1.getChildren().add(copyPersoQuestionFileButton);
        hBox1.getChildren().add(copyInfoButton);

        importFileVbox.getChildren().add(copyPersoQuestionFileLabel);
        importFileVbox.getChildren().add(hBox1);

        Label createNewFileWithImportLabel = new Label(UtilStringStorage.importLabel);
        createNewFileWithImportLabel.setTranslateY(50);
        createNewFileWithImportLabel.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 22));

        HBox hBox2 = new HBox();
        hBox2.setTranslateY(65);

        Button pasteFileFromImportButton = new Button(UtilStringStorage.importButtonLabel);
        ImportFileHandler.setUpButtonFileFromImport(pasteFileFromImportButton);
        pasteFileFromImportButton.setTranslateX(50);
        pasteFileFromImportButton.setFont(Font.font("Futura", FontWeight.BOLD, 20));

        InfoButton importInfoButton = new InfoButton(UtilStringStorage.importInfoButton);

        hBox2.getChildren().add(pasteFileFromImportButton);
        hBox2.getChildren().add(importInfoButton);

        importFileVbox.getChildren().add(createNewFileWithImportLabel);
        importFileVbox.getChildren().add(hBox2);

        Label importFileManagementLabel = new Label(UtilStringStorage.importDirectoryLabel);
        importFileManagementLabel.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 22));
        importFileManagementLabel.setTranslateY(100);

        HBox hBox3 = new HBox();
        hBox3.setTranslateY(115);

        Button openImportFileDirectoryButton = new Button(UtilStringStorage.importDirectoryButtonLabel);
        ImportFileHandler.setUpOpenDirectoryButton(openImportFileDirectoryButton, ImportFileHandler.getImportPath());
        CustomOption.setGlowEffectOnButton(openImportFileDirectoryButton);
        openImportFileDirectoryButton.setTranslateX(50);
        openImportFileDirectoryButton.setFont(Font.font("Futura", FontWeight.BOLD, 20));

        InfoButton openDirectoryInfoButton = new InfoButton(UtilStringStorage.importDirectoryInfoButton);

        hBox3.getChildren().add(openImportFileDirectoryButton);
        hBox3.getChildren().add(openDirectoryInfoButton);

        importFileVbox.getChildren().add(importFileManagementLabel);
        importFileVbox.getChildren().add(hBox3);
    }

    public void createGridPane()
    {
        gridPane = new GridPane();
        gridPane.setHgap(50);
        gridPane.add(optionVbox, 0, 0);
        gridPane.add(importFileVbox, 7, 0);
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
        label.setFont(Font.font(OPTION_POLICE_LABEL, FontWeight.EXTRA_BOLD, 25));
        label.setTextFill(Color.BLACK);
        label.setTranslateY(translateY);
        label.setTranslateX(translateX);
    }

    public void createSliderArea()
    {
        Label volumeLabel = new Label(UtilStringStorage.volumeLabel);
        stylizeLabel(volumeLabel, 20, 405);
        optionVbox.getChildren().add(volumeLabel);

        Button muteButton = new Button();
        CustomOption.customMuteButton(muteButton, PathUtil.MUTE_ICON, 52, 252);
        optionVbox.getChildren().add(muteButton);

        Slider volumeSlider = new Slider(0, 10, 5);
        CustomOption.customSlider(volumeSlider, 350, 150, 20, 300);
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
        Label englishLabel = new Label("English");
        englishLabel.setFont(Font.font("Futura", FontWeight.BOLD, 20));
        englishLabel.setTranslateX(60);
        englishLabel.setTranslateY(10);

        engButton = new LanguageButton(PathUtil.ENGLISH_FLAG, UtilStringStorage.englishLanguageTooltip);

        englishVbox.getChildren().add(englishLabel);
        englishVbox.getChildren().add(engButton);
        englishVbox.setTranslateY(95);
        englishVbox.setTranslateX(230);

        VBox frenchVbox = new VBox();
        Label frenchLabel = new Label("Français");
        frenchLabel.setFont(Font.font("Futura", FontWeight.BOLD, 20));
        frenchLabel.setTranslateX(60);
        frenchLabel.setTranslateY(10);

        frButton = new LanguageButton(PathUtil.FRENCH_FLAG, UtilStringStorage.frenchLanguageTooltip);

        frenchVbox.getChildren().add(frenchLabel);
        frenchVbox.getChildren().add(frButton);
        frenchVbox.setTranslateX(480);
        frenchVbox.setTranslateY(-12);

        Label languageLabel = new Label(UtilStringStorage.languageLabel);
        stylizeLabel(languageLabel, 85, 405);
        if(languageLabel.getText().equals("Languages"))
        {
            stylizeLabel(languageLabel, 85, 395);
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
        resetButton.setTranslateY(105);
        resetButton.setTranslateX(410);
        CustomOption.setUpTrashButton(resetButton, UtilStringStorage.resetTooltip);
        resetButton.setOnAction(event -> {
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.orElse(null) == ButtonType.OK)
            {
                TimePlayedTimer.stopTimer();
                resetSave();
                TimePlayedTimer.startTimer();
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
        if(label.getText().equals("Supprimer sauvegardes")) {
            label.setTranslateY(85);
            label.setTranslateX(330);
        }
        else {
            label.setTranslateY(85);
            label.setTranslateX(393);
        }
    }

    public void setVolumeFromSlider(Double sliderValue)
    {
        SoundManager.handleMenuSceneVolume(App.menuMusicToStop, sliderValue);
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
