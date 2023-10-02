package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.*;

public class OptionScene extends Scene {

    private final GridPane gridPane;
    private final AchievementManager achievementManager;
    private final Stage stage;
    private int buttonNumber = 1;
    public OptionScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        pane.setPrefHeight(500);
        pane.setPrefWidth(900);
        gridPane = new GridPane();
        pane.setCenter(gridPane);

        gridPane.addColumn(9);
        gridPane.addRow(2);
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

    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }
}
