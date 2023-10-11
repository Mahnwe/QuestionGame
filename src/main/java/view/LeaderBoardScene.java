package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import model.BackgroundCreator;
import model.PathUtil;
import model.UtilStringStorage;

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

    public LeaderBoardScene(ScrollPane pane, File saveFile, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.saveFile = saveFile;
        this.stage = stage;
        this.achievementManager = achievementManager;
        readFile();

        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        pane.setFitToWidth(true);

        BorderPane borderPane = new BorderPane();

        VBox leaderBoardVBox = new VBox();
        leaderBoardVBox.setMinHeight(500);
        VBox.setVgrow(leaderBoardVBox, Priority.ALWAYS);

        HBox buttonHbox = new HBox();
        Button returnToMenu = new Button(UtilStringStorage.returnButton);
        returnToMenu.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        buttonHbox.getChildren().add(returnToMenu);
        leaderBoardVBox.getChildren().add(buttonHbox);
        returnToMenu.setOnAction(event -> backToMainMenu());

        Label leaderBoardLabel = new Label(UtilStringStorage.leaderBoardLabel);
        leaderBoardLabel.setTranslateX(300);
        leaderBoardLabel.setTranslateY(10);
        leaderBoardLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 16));

        Label leaderBoardArea = new Label();
        leaderBoardArea.setTranslateX(10);
        leaderBoardArea.setTranslateY(40);
        leaderBoardArea.setText(String.valueOf(stringBuilder));
        leaderBoardArea.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        leaderBoardArea.setTextFill(Color.BLACK);

        leaderBoardVBox.getChildren().add(leaderBoardLabel);
        leaderBoardVBox.getChildren().add(leaderBoardArea);
        borderPane.setCenter(leaderBoardVBox);
        pane.setContent(borderPane);

        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        BackgroundCreator menuBackground = new BackgroundCreator(PathUtil.MENU_BACKGROUND);
        Image menuSceneBackground = menuBackground.createBackground();
        BackgroundImage backgroundImage = new BackgroundImage(menuSceneBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize);
        borderPane.setBackground(new Background(backgroundImage));

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
