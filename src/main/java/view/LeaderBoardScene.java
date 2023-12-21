package view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.BackgroundCreator;
import util.CustomOption;
import util.FileUtil;
import util.UtilStringStorage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class LeaderBoardScene extends Scene
{
    private static final Logger logger = LogManager.getLogger(LeaderBoardScene.class);
    private final Stage stage;
    private final AchievementManager achievementManager;
    private final VBox leaderBoardVBox;
    private final ConfirmAlert confirmAlert;
    private VBox bestScoresVbox;
    private final BorderPane borderPane;
    private GridPane scoreGridPane;

    public LeaderBoardScene(ScrollPane scrollPane, Stage stage, AchievementManager achievementManager)
    {
        super(scrollPane);
        this.stage = stage;
        this.achievementManager = achievementManager;
        confirmAlert = new ConfirmAlert(Alert.AlertType.CONFIRMATION);
        confirmAlert.modifyConfirmAlertForSaveDelete(confirmAlert);

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

        borderPane.setLeft(bestScoresVbox);
        gridpane.add(leaderBoardVBox, 0, 0);
        borderPane.setCenter(gridpane);
        scrollPane.setContent(borderPane);

        createBackground();

    }

    public void readSaveFile(int rowIndex)
    {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FileUtil.saveFile))){
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                Label label = new Label();
                 label.setText(line);
                label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 17));
                scoreGridPane.add(label, 0, rowIndex);
                rowIndex++;
            }
        } catch (IOException e) {
            logger.error("Save file can't be read");
        }
    }

    public void createLeaderBoard()
    {
        Label leaderBoardLabel = new Label(UtilStringStorage.leaderBoardLabel);

        leaderBoardLabel.setTranslateX(420);
        leaderBoardLabel.setTranslateY(10);
        leaderBoardLabel.setFont(Font.font("Impact", FontWeight.BOLD, 30));

        scoreGridPane = new GridPane();
        scoreGridPane.setVgap(35);
        readSaveFile(0);
        scoreGridPane.setTranslateX(110);
        scoreGridPane.setTranslateY(60);

        leaderBoardVBox.getChildren().add(leaderBoardLabel);
        leaderBoardVBox.getChildren().add(scoreGridPane);
    }

    public void createBestScoresLabel()
    {
        bestScoresVbox = new VBox();

        Label bestScoreIn10Questions = new Label(UtilStringStorage.bestScoreIn10Label+  " "+FileUtil.generalSavesFile.getProperty("perfectScore10"));
        stylizeBestScoreLabel(bestScoresVbox, bestScoreIn10Questions, 10, 0);

        Label bestScoreIn15Questions = new Label(UtilStringStorage.bestScoreIn15Label+  " "+FileUtil.generalSavesFile.getProperty("perfectScore15"));
        stylizeBestScoreLabel(bestScoresVbox, bestScoreIn15Questions, 10, 20);

        Label bestScoreIn20Questions = new Label(UtilStringStorage.bestScoreIn20Label+  " "+FileUtil.generalSavesFile.getProperty("perfectScore20"));
        stylizeBestScoreLabel(bestScoresVbox, bestScoreIn20Questions, 10, 40);

        Label bestScoreInSurvivalMode = new Label();
        checkForBestSurvivalScore(bestScoreInSurvivalMode);
        stylizeBestScoreLabel(bestScoresVbox, bestScoreInSurvivalMode, 10, 60);

        Label numberOfGamesStat = new Label(UtilStringStorage.numberOfGamesLabel +" "+FileUtil.generalSavesFile.getProperty("numberOfGames"));
        stylizeBestScoreLabel(bestScoresVbox, numberOfGamesStat, 10, 80);
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

    public void stylizeBestScoreLabel(VBox vBox, Label label, int translateX, int translateY)
    {
        label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 15));
        label.setTextFill(Color.BLACK);
        label.setTranslateX(translateX);
        label.setTranslateY(translateY);
        vBox.getChildren().add(label);
    }

    public void createEraseFileButton()
    {
        Button eraseSaveFileButton = new Button();
        eraseSaveFileButton.setTranslateX(50);
        eraseSaveFileButton.setTranslateY(170);
        CustomOption.setUpTrashButton(eraseSaveFileButton, UtilStringStorage.eraseTooltipLabel);

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
