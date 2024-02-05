package view.scene;

import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.AchievementManager;
import model.ImportFileHandler;
import model.SoundManager;
import util.*;
import view.*;
import view.customobject.*;

public class OptionScene extends Scene {

    private final AchievementManager achievementManager;
    private final Stage stage;
    private GridPane gridPane;
    private VBox optionVbox;
    private VBox importFileVbox;
    private final ConfirmAlert confirmAlert;
    private final BorderPane pane;
    public static final String OPTION_POLICE_LABEL = "Impact";
    public OptionScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.pane = pane;
        this.stage = stage;
        this.achievementManager = achievementManager;
        this.confirmAlert = new ConfirmAlert(Alert.AlertType.CONFIRMATION);
        confirmAlert.modifyConfirmAlert(UtilStringStorage.askConfirmReset);

        createOptionAndImportVbox();
        createGridPane();
        pane.setCenter(gridPane);

        createSliderArea();
        createReturnButton();
        createButtons();
        createResetButtonArea();
        createCopyFileBox();
        createPasteFileBox();
        createImportedFileBox();
        createBackground();
    }

    public void createOptionAndImportVbox()
    {
        optionVbox = new VBox();
        optionVbox.setTranslateX(30);
        optionVbox.setTranslateY(80);
        importFileVbox = new VBox();
        importFileVbox.setTranslateX(250);
        importFileVbox.setTranslateY(180);
    }

    public void createCopyFileBox()
    {
        Label copyPersoQuestionFileLabel = new Label(UtilStringStorage.exportLabel);
        copyPersoQuestionFileLabel.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 24));

        HBox hBox1 = new HBox();
        hBox1.setTranslateY(10);

        Label confirmCopyFileInClipboard = new Label(UtilStringStorage.confirmCopyFileLabel);
        confirmCopyFileInClipboard.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 24));
        confirmCopyFileInClipboard.setTextFill(Color.GREEN);
        confirmCopyFileInClipboard.setVisible(false);
        confirmCopyFileInClipboard.setTranslateY(10);

        Button copyPersoQuestionFileButton = new Button(UtilStringStorage.exportButtonLabel);
        copyPersoQuestionFileButton.setOnAction(event -> {
            ImportFileHandler.setUpCopyFileButton();
            displayLabelAfterImport(confirmCopyFileInClipboard);
        });
        CustomOption.setGlowEffectOnButton(copyPersoQuestionFileButton);
        copyPersoQuestionFileButton.setTranslateX(50);
        copyPersoQuestionFileButton.setFont(Font.font("Futura", FontWeight.BOLD, 22));

        InfoButton copyInfoButton = new InfoButton(UtilStringStorage.exportInfoButton);

        hBox1.getChildren().add(copyPersoQuestionFileButton);
        hBox1.getChildren().add(copyInfoButton);

        importFileVbox.getChildren().add(copyPersoQuestionFileLabel);
        importFileVbox.getChildren().add(hBox1);
        importFileVbox.getChildren().add(confirmCopyFileInClipboard);
    }
    public void createPasteFileBox()
    {
        Label createNewFileWithImportLabel = new Label(UtilStringStorage.importLabel);
        createNewFileWithImportLabel.setTranslateY(80);
        createNewFileWithImportLabel.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 24));

        HBox hBox2 = new HBox();
        hBox2.setTranslateY(95);

        Label confirmImportLabel = new Label(UtilStringStorage.confirmImportLabel);
        confirmImportLabel.setFont(Font.font("Futura", FontWeight.BOLD, 22));
        confirmImportLabel.setTextFill(Color.GREEN);
        confirmImportLabel.setVisible(false);

        Button pasteFileFromImportButton = new Button(UtilStringStorage.importButtonLabel);
        pasteFileFromImportButton.setOnAction(event -> ImportFileHandler.setUpButtonFileFromImport(confirmImportLabel));
        pasteFileFromImportButton.setTranslateX(50);
        pasteFileFromImportButton.setFont(Font.font("Futura", FontWeight.BOLD, 22));

        InfoButton importInfoButton = new InfoButton(UtilStringStorage.importInfoButton);

        hBox2.getChildren().add(pasteFileFromImportButton);
        hBox2.getChildren().add(importInfoButton);

        importFileVbox.getChildren().add(createNewFileWithImportLabel);
        importFileVbox.getChildren().add(hBox2);
        importFileVbox.getChildren().add(confirmImportLabel);
        confirmImportLabel.setTranslateY(105);
    }
    public void createImportedFileBox()
    {
        Label importFileManagementLabel = new Label(UtilStringStorage.importDirectoryLabel);
        importFileManagementLabel.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 24));
        importFileManagementLabel.setTranslateY(140);

        HBox hBox3 = new HBox();
        hBox3.setTranslateY(165);

        Button openImportFileDirectoryButton = new Button(UtilStringStorage.importDirectoryButtonLabel);
        openImportFileDirectoryButton.setOnAction(event -> ImportFileHandler.setUpOpenDirectoryButton(ImportFileHandler.getImportPath()));
        CustomOption.setGlowEffectOnButton(openImportFileDirectoryButton);
        openImportFileDirectoryButton.setTranslateX(50);
        openImportFileDirectoryButton.setFont(Font.font("Futura", FontWeight.BOLD, 22));

        InfoButton openDirectoryInfoButton = new InfoButton(UtilStringStorage.importDirectoryInfoButton);

        hBox3.getChildren().add(openImportFileDirectoryButton);
        hBox3.getChildren().add(openDirectoryInfoButton);

        importFileVbox.getChildren().add(importFileManagementLabel);
        importFileVbox.getChildren().add(hBox3);
    }
    public static void displayLabelAfterImport(Label label)
    {
        label.setVisible(true);
        PauseTransition visiblePause = new PauseTransition(Duration.seconds(5));
        visiblePause.setOnFinished(event -> label.setVisible(false));
        visiblePause.play();
    }

    public void createGridPane()
    {
        gridPane = new GridPane();
        gridPane.setTranslateX(100);
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
        label.setFont(Font.font(OPTION_POLICE_LABEL, FontWeight.EXTRA_BOLD, 28));
        label.setTextFill(Color.BLACK);
        label.setTranslateY(translateY);
        label.setTranslateX(translateX);
    }

    public void createSliderArea()
    {
        Label volumeLabel = new Label(UtilStringStorage.volumeLabel);
        stylizeLabel(volumeLabel, 40, 405);
        optionVbox.getChildren().add(volumeLabel);

        Button muteButton = new Button();
        CustomOption.customMuteButton(muteButton, PathUtil.MUTE_ICON, 72, 245);
        optionVbox.getChildren().add(muteButton);

        Slider volumeSlider = new Slider(0, 10, 5);
        CustomOption.customSlider(volumeSlider, 380, 150, 40, 300);
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
        UtilTranslateString utilTranslateString = new UtilTranslateString();

        VBox englishVbox = new VBox();
        createEngVbox(englishVbox, utilTranslateString);

        VBox frenchVbox = new VBox();
        createFrVbox(frenchVbox, utilTranslateString);

        Label languageLabel = new Label(UtilStringStorage.languageLabel);
        stylizeLabel(languageLabel, 115, 405);
        if(languageLabel.getText().equals("Languages"))
        {
            stylizeLabel(languageLabel, 115, 395);
        }

        optionVbox.getChildren().add(languageLabel);
        optionVbox.getChildren().add(englishVbox);
        optionVbox.getChildren().add(frenchVbox);

    }

    public void createEngVbox(VBox vBox, UtilTranslateString utilTranslateString)
    {
        Label englishLabel = new Label("English");
        englishLabel.setFont(Font.font("Futura", FontWeight.BOLD, 24));
        englishLabel.setTranslateX(60);
        englishLabel.setTranslateY(20);

        LanguageButton engButton = new LanguageButton(PathUtil.ENGLISH_FLAG, UtilStringStorage.englishLanguageTooltip);
        engButton.setUpEnglishLanguageButton(engButton, utilTranslateString, stage, achievementManager, true);

        vBox.getChildren().add(englishLabel);
        vBox.getChildren().add(engButton);
        vBox.setTranslateY(125);
        vBox.setTranslateX(230);
    }

    public void createFrVbox(VBox vBox, UtilTranslateString utilTranslateString)
    {
        Label frenchLabel = new Label("Français");
        frenchLabel.setFont(Font.font("Futura", FontWeight.BOLD, 24));
        frenchLabel.setTranslateX(60);
        frenchLabel.setTranslateY(20);

        LanguageButton frButton = new LanguageButton(PathUtil.FRENCH_FLAG, UtilStringStorage.frenchLanguageTooltip);
        frButton.setUpFrenchLanguageButton(frButton, utilTranslateString, stage, achievementManager, true);

        vBox.getChildren().add(frenchLabel);
        vBox.getChildren().add(frButton);
        vBox.setTranslateX(480);
    }

    public void createResetButtonArea()
    {
        ResetAllSavesButton resetButton = new ResetAllSavesButton(confirmAlert, stage);

        Label resetLabel = new Label(UtilStringStorage.resetLabel);
        stylizeLabel(resetLabel, 100, 10);
        placeLabelWithTranslation(resetLabel);

        optionVbox.getChildren().add(resetLabel);
        optionVbox.getChildren().add(resetButton);
    }

    public void placeLabelWithTranslation(Label label)
    {
        if(label.getText().equals("Supprimer sauvegardes")) {
            label.setTranslateY(160);
            label.setTranslateX(330);
        }
        else {
            label.setTranslateY(160);
            label.setTranslateX(393);
        }
    }

    public void setVolumeFromSlider(Double sliderValue)
    {
        SoundManager.handleMenuSceneVolume(App.menuMusicToStop, sliderValue);
        SoundManager.setSoundVolume(sliderValue);
    }
    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }
}
