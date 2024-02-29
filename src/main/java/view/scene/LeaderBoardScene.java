package view.scene;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.handlers.AchievementManager;
import org.json.simple.JSONObject;
import util.creators.BackgroundCreator;
import util.CustomOption;
import util.FileUtil;
import util.stringUtilTranslate.UtilStringStorage;
import view.customobject.ConfirmAlert;
import view.customobject.ReturnButton;

import java.util.List;
import java.util.Optional;

public class LeaderBoardScene extends Scene
{
    private final Stage stage;
    private final AchievementManager achievementManager;
    private final VBox leaderBoardVBox;
    private final ConfirmAlert confirmAlert;
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
        createEraseFileButton();

        gridpane.add(leaderBoardVBox, 0, 0);
        borderPane.setCenter(gridpane);
        scrollPane.setContent(borderPane);

        createBackground();

    }

    public Button createIndividualDeleteButton(List<JSONObject> jsonArrayList, int jsonIndex)
    {
        Button individualDeleteButton = new Button();
        CustomOption.setUpTrashButton(individualDeleteButton, UtilStringStorage.individualDeleteTooltip);
        individualDeleteButton.setPrefSize(50, 50);

        individualDeleteButton.setOnAction(event -> {
            confirmAlert.modifyConfirmAlert(UtilStringStorage.confirmIndividualDeleteGame);
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.orElse(null) == ButtonType.OK) {
                jsonArrayList.remove(jsonIndex);
                FileUtil.actualizeJsonFile(jsonArrayList);
                LeaderBoardScene leaderBoardScene = new LeaderBoardScene(new ScrollPane(), stage, achievementManager);
                stage.setScene(leaderBoardScene);
            }
        });
        return individualDeleteButton;
    }

    public void readSaveFile(int rowIndex)
    {
        List<JSONObject> jsonArrayList = FileUtil.readJsonFile();
        for(int i = 0; i < jsonArrayList.size(); i++)
        {
            JSONObject jsonObject = jsonArrayList.get(i);

            Button individualDeleteButton = createIndividualDeleteButton(jsonArrayList, i);

            Label gameModLabel = new Label((String) jsonObject.get("gameMod"));
            gameModLabel.setFont(Font.font("Impact", FontWeight.NORMAL, 28));

            Label playerName = new Label((String) jsonObject.get("playerName"));
            playerName.setFont(Font.font("Impact", FontWeight.NORMAL, 28));

            Label playerScore = new Label((String) jsonObject.get("playerScore"));
            playerScore.setFont(Font.font("Impact", FontWeight.NORMAL, 28));

            Label playerTimer = new Label((String) jsonObject.get("playerTimer"));
            playerTimer.setFont(Font.font("Impact", FontWeight.NORMAL, 28));

            scoreGridPane.add(individualDeleteButton, 0, rowIndex);
            scoreGridPane.add(gameModLabel, 1, rowIndex);
            scoreGridPane.add(playerName, 2, rowIndex);
            scoreGridPane.add(playerScore, 3, rowIndex);
            scoreGridPane.add(playerTimer, 4, rowIndex);
            rowIndex++;
        }
    }

    public void createLeaderBoard()
    {
        Label leaderBoardLabel = new Label(UtilStringStorage.leaderBoardLabel);

        leaderBoardLabel.setTranslateX(720);
        leaderBoardLabel.setTranslateY(10);
        leaderBoardLabel.setFont(Font.font("Impact", FontWeight.BOLD, 40));

        scoreGridPane = new GridPane();
        scoreGridPane.setVgap(50);
        scoreGridPane.setHgap(50);

        createGridPaneBoard();

        readSaveFile(1);
        scoreGridPane.setTranslateX(470);
        scoreGridPane.setTranslateY(100);

        leaderBoardVBox.getChildren().add(leaderBoardLabel);
        leaderBoardVBox.getChildren().add(scoreGridPane);
    }

    public void createGridPaneBoard()
    {
        Label gameModLabel = new Label(UtilStringStorage.gameModLabel);
        gameModLabel.setFont(Font.font("Impact", FontWeight.BOLD, 34));

        Label playerName = new Label(UtilStringStorage.playerNameInfile);
        playerName.setFont(Font.font("Impact", FontWeight.BOLD, 34));

        Label playerScore = new Label(UtilStringStorage.scoreLabelInfile);
        playerScore.setFont(Font.font("Impact", FontWeight.BOLD, 34));

        Label playerTimer = new Label(UtilStringStorage.timerLabelInfile);
        playerTimer.setFont(Font.font("Impact", FontWeight.BOLD, 34));

        scoreGridPane.add(gameModLabel, 1, 0);
        scoreGridPane.add(playerName, 2, 0);
        scoreGridPane.add(playerScore, 3, 0);
        scoreGridPane.add(playerTimer, 4, 0);
    }

    public void createEraseFileButton()
    {
        Button eraseSaveFileButton = new Button();
        CustomOption.setUpTrashButton(eraseSaveFileButton, UtilStringStorage.eraseTooltipLabel);
        borderPane.setLeft(eraseSaveFileButton);
        eraseSaveFileButton.setTranslateY(150);
        eraseSaveFileButton.setTranslateX(45);

        eraseSaveFileButton.setOnAction(event -> {
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.orElse(null) == ButtonType.OK) {
                FileUtil.resetJsonFile();
                LeaderBoardScene leaderBoardScene = new LeaderBoardScene(new ScrollPane(), stage, achievementManager);
                stage.setScene(leaderBoardScene);
            }
        });
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
