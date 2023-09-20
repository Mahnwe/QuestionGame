package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.AchievementManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeaderBoardScene extends Scene
{

    private final File saveFile;

    private StringBuilder stringBuilder;
    private final Stage stage;
    private final AchievementManager achievementManager;

    public LeaderBoardScene(BorderPane pane, File saveFile, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        pane.setPrefHeight(500);
        pane.setPrefWidth(900);
        this.saveFile = saveFile;
        this.stage = stage;
        this.achievementManager = achievementManager;
        readFile();
        VBox leaderBoardVBox = new VBox();
        leaderBoardVBox.setMinSize(400, 400);
        TextArea leaderBoardArea = new TextArea();
        leaderBoardArea.setMinSize(400, 400);
        leaderBoardArea.setText(String.valueOf(stringBuilder));
        leaderBoardVBox.getChildren().add(leaderBoardArea);
        leaderBoardArea.setEditable(false);
        pane.setCenter(leaderBoardVBox);

        HBox buttonHbox = new HBox();
        buttonHbox.setPrefHeight(50);
        Button returnToMenu = new Button("Retour");
        buttonHbox.getChildren().add(returnToMenu);
        pane.setTop(buttonHbox);
        returnToMenu.setOnAction(event -> backToMainMenu());
    }

    public void readFile()
    {
        stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(saveFile));
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }
}
