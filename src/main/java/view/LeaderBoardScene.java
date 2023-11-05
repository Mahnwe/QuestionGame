package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import util.BackgroundCreator;
import util.FileUtil;
import util.ReturnButton;
import util.UtilStringStorage;

import java.io.File;

public class LeaderBoardScene extends Scene
{

    private final StringBuilder stringBuilder;
    private final Stage stage;
    private final AchievementManager achievementManager;
    private final VBox leaderBoardVBox;
    private final BorderPane borderPane;

    public LeaderBoardScene(ScrollPane pane, File saveFile, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.stage = stage;
        this.achievementManager = achievementManager;
        stringBuilder = FileUtil.readSaveFile(saveFile);

        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        pane.setFitToWidth(true);

        borderPane = new BorderPane();
        borderPane.setMinHeight(1080);

        leaderBoardVBox = new VBox();
        VBox.setVgrow(leaderBoardVBox, Priority.ALWAYS);

        createReturnButton();

        createLeaderBoard();

        borderPane.setCenter(leaderBoardVBox);
        pane.setContent(borderPane);

        createBackground();

    }

    public void createLeaderBoard()
    {
        Label leaderBoardLabel = new Label(UtilStringStorage.leaderBoardLabel);
        leaderBoardLabel.setTranslateX(350);
        leaderBoardLabel.setTranslateY(10);
        leaderBoardLabel.setFont(Font.font("Impact", FontWeight.BOLD, 23));

        Label leaderBoardArea = new Label();
        leaderBoardArea.setTranslateX(180);
        leaderBoardArea.setTranslateY(40);
        leaderBoardArea.setText(String.valueOf(stringBuilder));
        leaderBoardArea.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 14));
        leaderBoardArea.setTextFill(Color.BLACK);
        leaderBoardVBox.getChildren().add(leaderBoardLabel);
        leaderBoardVBox.getChildren().add(leaderBoardArea);
    }

    public void createBackground()
    {
        BackgroundImage backgroundImage = BackgroundCreator.createMenuBackground();
        borderPane.setBackground(new Background(backgroundImage));
    }

    public void createReturnButton()
    {
        HBox buttonHbox = new HBox();
        ReturnButton returnButton = new ReturnButton();

        buttonHbox.getChildren().add(returnButton);
        leaderBoardVBox.getChildren().add(buttonHbox);
        returnButton.setOnAction(event -> backToMainMenu());
    }

    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }
}
