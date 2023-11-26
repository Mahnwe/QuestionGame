package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

import java.util.Optional;

public class LeaderBoardScene extends Scene
{
    private final StringBuilder stringBuilder;
    private final Stage stage;
    private final AchievementManager achievementManager;
    private final VBox leaderBoardVBox;
    private final ConfirmAlert confirmAlert;
    private VBox bestScoresVbox;
    private final BorderPane borderPane;
    private GridPane gridPaneBestScore;

    public LeaderBoardScene(ScrollPane scrollPane, Stage stage, AchievementManager achievementManager)
    {
        super(scrollPane);
        this.stage = stage;
        this.achievementManager = achievementManager;
        confirmAlert = new ConfirmAlert(Alert.AlertType.CONFIRMATION);
        confirmAlert.modifyConfirmAlertForSaveDelete(confirmAlert);
        stringBuilder = FileUtil.readSaveFile(FileUtil.saveFile);

        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setFitToWidth(true);

        GridPane gridpane = new GridPane();
        gridpane.setMinHeight(1080);
        GridPane.setVgrow(gridpane, Priority.ALWAYS);

        leaderBoardVBox = new VBox();
        VBox.setVgrow(leaderBoardVBox, Priority.ALWAYS);

        borderPane = new BorderPane();

        createReturnButton();

        createLeaderBoard();
        createBestScoresLabel();
        createEraseFileButton();

        gridpane.add(leaderBoardVBox, 0, 0);

        borderPane.setLeft(bestScoresVbox);
        borderPane.setCenter(gridpane);
        scrollPane.setContent(borderPane);
        gridpane.setTranslateX(-210);

        createBackground();

    }

    public void createLeaderBoard()
    {
        Label leaderBoardLabel = new Label(UtilStringStorage.leaderBoardLabel);

        leaderBoardLabel.setTranslateX(570);
        leaderBoardLabel.setTranslateY(10);
        leaderBoardLabel.setFont(Font.font("Impact", FontWeight.BOLD, 30));

        Label leaderBoardArea = new Label();

        leaderBoardArea.setText(String.valueOf(stringBuilder));
        leaderBoardArea.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 17));
        leaderBoardArea.setTextFill(Color.BLACK);
        leaderBoardArea.setTranslateX(340);
        leaderBoardArea.setTranslateY(60);

        leaderBoardVBox.getChildren().add(leaderBoardLabel);
        leaderBoardVBox.getChildren().add(leaderBoardArea);
    }

    public void createGridPaneBestScore()
    {
        gridPaneBestScore = new GridPane();
        gridPaneBestScore.addColumn(1);
        gridPaneBestScore.addRow(4);
        gridPaneBestScore.setVgap(20);
        gridPaneBestScore.setAlignment(Pos.CENTER);
        gridPaneBestScore.setTranslateY(50);
        gridPaneBestScore.setTranslateX(5);
    }

    public void createBestScoresLabel()
    {
        bestScoresVbox = new VBox();

        createGridPaneBestScore();

        Label bestScoreIn10Questions = new Label(UtilStringStorage.bestScoreIn10Label+  " "+FileUtil.generalSavesFile.getProperty("perfectScore10"));
        stylizeBestScoreLabel(bestScoreIn10Questions, 0, 0);

        Label bestScoreIn15Questions = new Label(UtilStringStorage.bestScoreIn15Label+  " "+FileUtil.generalSavesFile.getProperty("perfectScore15"));
        stylizeBestScoreLabel(bestScoreIn15Questions, 0, 1);

        Label bestScoreIn20Questions = new Label(UtilStringStorage.bestScoreIn20Label+  " "+FileUtil.generalSavesFile.getProperty("perfectScore20"));
        stylizeBestScoreLabel(bestScoreIn20Questions, 0, 2);

        Label bestScoreInSurvivalMode = new Label();
        checkForBestSurvivalScore(bestScoreInSurvivalMode);
        stylizeBestScoreLabel(bestScoreInSurvivalMode, 0, 3);

        bestScoresVbox.getChildren().add(gridPaneBestScore);
    }

    public void checkForBestSurvivalScore(Label bestScoreInSurvivalMode)
    {
        int survivalScore = Integer.parseInt(FileUtil.generalSavesFile.getProperty("survivalScore50"));
        if(survivalScore != 0)
        {
            bestScoreInSurvivalMode.setText(UtilStringStorage.bestScoreSurvivalLabel+ " "+survivalScore);
        }
        if(survivalScore == 0) {
            survivalScore = Integer.parseInt(FileUtil.generalSavesFile.getProperty("survivalScore30"));
            if (survivalScore != 0) {
                bestScoreInSurvivalMode.setText(UtilStringStorage.bestScoreSurvivalLabel + " " + survivalScore);
            }
            if (survivalScore == 0) {
                survivalScore = Integer.parseInt(FileUtil.generalSavesFile.getProperty("survivalScore20"));
                bestScoreInSurvivalMode.setText(UtilStringStorage.bestScoreSurvivalLabel + " " + survivalScore);
            }
        }
    }

    public void stylizeBestScoreLabel(Label label, int column, int row)
    {
        label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 15));
        label.setTextFill(Color.BLACK);
        gridPaneBestScore.add(label, column, row);
    }

    public void createEraseFileButton()
    {
        Button eraseSaveFileButton = new Button();
        eraseSaveFileButton.setTranslateX(50);
        eraseSaveFileButton.setTranslateY(220);
        CustomOption.setUpTrashButton(eraseSaveFileButton);

        eraseSaveFileButton.setTooltip(null);
        Tooltip eraseTooltip = new Tooltip(UtilStringStorage.eraseTooltipLabel);
        eraseSaveFileButton.setTooltip(eraseTooltip);

        eraseSaveFileButton.setOnAction(event -> {
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.orElse(null) == ButtonType.OK) {
                FileUtil.resetSaveFile();
                LeaderBoardScene leaderBoardScene = new LeaderBoardScene(new ScrollPane(), stage, achievementManager);
                stage.setScene(leaderBoardScene);
            }
        });

        bestScoresVbox.getChildren().add(eraseSaveFileButton);
        bestScoresVbox.setTranslateY(80);
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
        borderPane.setTop(buttonHbox);
        returnButton.setOnAction(event -> backToMainMenu());
    }

    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }
}
