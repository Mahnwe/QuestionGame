package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.AchievementManager;
import model.SoundManager;
import model.UtilStringStorage;

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

        gridPane.addColumn(10);
        gridPane.addRow(2);
        this.stage = stage;
        this.achievementManager = achievementManager;

        Label volumeLabel = new Label(UtilStringStorage.volumeLabel);
        volumeLabel.setTranslateY(25);
        volumeLabel.setFont(Font.font(MenuScene.POLICE_LABEL));
        gridPane.add(volumeLabel, 4, 0);

        createVolumeButton(0);

        Button returnButton = new Button(UtilStringStorage.returnButton);
        pane.setTop(returnButton);
        returnButton.setOnAction(event -> backToMainMenu());
    }

    public void createVolumeButton(int columnNumber)
    {
        for(int i = 0; i < 10; i++)
        {
            Button volumeButton = new Button(String.valueOf(buttonNumber));
            volumeButton.setTranslateY(30);
            gridPane.add(volumeButton, columnNumber, 1);
            buttonNumber++;
            columnNumber++;
            setVolumeFromButton(volumeButton);
        }
    }

    public void setVolumeFromButton(Button button)
    {
        button.setOnAction(event -> SoundManager.setSoundVolume(Integer.parseInt(button.getText())));
    }

    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }
}
