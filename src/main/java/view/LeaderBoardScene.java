package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import util.BackgroundCreator;
import util.CustomOption;
import util.FileUtil;
import util.UtilStringStorage;

public class LeaderBoardScene extends Scene
{
    private final StringBuilder stringBuilder;
    private final Stage stage;
    private final AchievementManager achievementManager;
    private final VBox leaderBoardVBox;
    private final GridPane gridpane;

    public LeaderBoardScene(ScrollPane scrollPane, Stage stage, AchievementManager achievementManager)
    {
        super(scrollPane);
        this.stage = stage;
        this.achievementManager = achievementManager;
        stringBuilder = FileUtil.readSaveFile(FileUtil.saveFile);

        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setFitToWidth(true);

        gridpane = new GridPane();
        gridpane.setMinHeight(1080);
        GridPane.setVgrow(gridpane, Priority.ALWAYS);

        leaderBoardVBox = new VBox();
        VBox.setVgrow(leaderBoardVBox, Priority.ALWAYS);

        createReturnButton();

        createLeaderBoard();

        gridpane.add(leaderBoardVBox, 0, 0);
        scrollPane.setContent(gridpane);

        createBackground();

    }

    public void createLeaderBoard()
    {
        Label leaderBoardLabel = new Label(UtilStringStorage.leaderBoardLabel);
        leaderBoardLabel.setTranslateX(350);
        leaderBoardLabel.setTranslateY(10);
        leaderBoardLabel.setFont(Font.font("Impact", FontWeight.BOLD, 23));

        Label leaderBoardArea = new Label();
        leaderBoardArea.setTranslateX(250);
        leaderBoardArea.setText(String.valueOf(stringBuilder));
        leaderBoardArea.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 14));
        leaderBoardArea.setTextFill(Color.BLACK);

        Button eraseSaveFileButton = new Button();
        eraseSaveFileButton.setTranslateX(10);
        eraseSaveFileButton.setTranslateY(60);
        CustomOption.setUpTrashButton(eraseSaveFileButton);
        eraseSaveFileButton.setTooltip(null);
        Tooltip eraseTooltip = new Tooltip(UtilStringStorage.eraseTooltipLabel);
        eraseSaveFileButton.setTooltip(eraseTooltip);
        eraseSaveFileButton.setOnAction(event -> {
            FileUtil.resetSaveFile();
            LeaderBoardScene leaderBoardScene = new LeaderBoardScene(new ScrollPane(), stage, achievementManager);
            stage.setScene(leaderBoardScene);
        });

        leaderBoardVBox.getChildren().add(leaderBoardLabel);
        leaderBoardVBox.getChildren().add(eraseSaveFileButton);
        leaderBoardVBox.getChildren().add(leaderBoardArea);
    }

    public void createBackground()
    {
        BackgroundImage backgroundImage = BackgroundCreator.createMenuBackground();
        gridpane.setBackground(new Background(backgroundImage));
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
