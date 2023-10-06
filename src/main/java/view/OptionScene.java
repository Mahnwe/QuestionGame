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

    private final GridPane gridPane;
    private final AchievementManager achievementManager;
    private final Stage stage;
    private final File saveFile;
    private final Properties cupFile;
    private final Properties perfectFile;
    private int buttonNumber = 1;

    private final Alert confirmAlert;
    public OptionScene(BorderPane pane, Stage stage, AchievementManager achievementManager, File saveFile, Properties cupFile, Properties perfectFile)
    {
        super(pane);
        pane.setPrefHeight(500);
        pane.setPrefWidth(900);
        gridPane = new GridPane();
        pane.setCenter(gridPane);
        this.saveFile = saveFile;
        this.cupFile = cupFile;
        this.perfectFile = perfectFile;
        this.confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        modifyConfirmAlert();

        gridPane.addColumn(9);
        gridPane.addRow(5);
        gridPane.setVgap(0);
        gridPane.setHgap(0);
        this.stage = stage;
        this.achievementManager = achievementManager;

        Label volumeLabel = new Label(UtilStringStorage.volumeLabel);
        volumeLabel.setTranslateX(65);
        volumeLabel.setTranslateY(25);
        volumeLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 22));
        volumeLabel.setTextFill(Color.GHOSTWHITE);
        gridPane.add(volumeLabel, 4, 0);

        createVolumeButton(0);

        Button returnButton = new Button(UtilStringStorage.returnButton);
        pane.setTop(returnButton);
        returnButton.setOnAction(event -> backToMainMenu());

        Button resetButton = new Button(UtilStringStorage.resetButton);
        resetButton.setTranslateY(200);
        resetButton.setTranslateX(-20);
        resetButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        Tooltip resetTooltip = new Tooltip(UtilStringStorage.resetTooltip);
        resetButton.setTooltip(resetTooltip);
        resetButton.setOnAction(event -> {
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.orElse(null) == ButtonType.OK)
            {
                resetSave();
            }
        });

        Label adviceResetLabel = new Label(UtilStringStorage.adviceResetLabel);
        adviceResetLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        adviceResetLabel.setTranslateY(230);
        adviceResetLabel.setTranslateX(-130);
        gridPane.add(resetButton, 5, 5);
        gridPane.add(adviceResetLabel, 5, 5);


        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        BackgroundCreator menuBackground = new BackgroundCreator(PathUtil.MENU_BACKGROUND);
        Image menuSceneBackground = menuBackground.createBackground();
        BackgroundImage backgroundImage = new BackgroundImage(menuSceneBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize);
        pane.setBackground(new Background(backgroundImage));

    }

    public void createVolumeButton(int columnNumber)
    {
        for(int i = 0; i < 10; i++)
        {
            Button volumeButton = new Button(String.valueOf(buttonNumber));
            volumeButton.setMinSize(83,93);
            volumeButton.setTranslateY(70);
            volumeButton.setTranslateX(25);
            gridPane.add(volumeButton, columnNumber, 1);
            buttonNumber++;
            columnNumber++;
            setVolumeFromButton(volumeButton);
        }
    }

    public void setVolumeFromButton(Button button)
    {
        button.setOnAction(event -> {
            SoundManager.handleMenuSceneVolume(App.menuMusicToStop, Integer.parseInt(button.getText()));
            SoundManager.setSoundVolume(Integer.parseInt(button.getText()));
        });
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
