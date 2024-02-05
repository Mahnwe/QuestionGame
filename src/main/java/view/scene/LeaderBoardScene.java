package view.scene;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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
import view.customobject.ConfirmAlert;
import view.customobject.ReturnButton;

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
    private Button eraseSaveFileButton;
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

        borderPane.setLeft(eraseSaveFileButton);
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
                label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 20));
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

        leaderBoardLabel.setTranslateX(720);
        leaderBoardLabel.setTranslateY(10);
        leaderBoardLabel.setFont(Font.font("Impact", FontWeight.BOLD, 40));

        scoreGridPane = new GridPane();
        scoreGridPane.setVgap(50);
        readSaveFile(0);
        scoreGridPane.setTranslateX(320);
        scoreGridPane.setTranslateY(90);

        leaderBoardVBox.getChildren().add(leaderBoardLabel);
        leaderBoardVBox.getChildren().add(scoreGridPane);
    }

    public void createEraseFileButton()
    {
        eraseSaveFileButton = new Button();
        eraseSaveFileButton.setTranslateY(150);
        eraseSaveFileButton.setTranslateX(45);
        CustomOption.setUpTrashButton(eraseSaveFileButton, UtilStringStorage.eraseTooltipLabel);

        eraseSaveFileButton.setOnAction(event -> {
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.orElse(null) == ButtonType.OK) {
                FileUtil.resetSaveFile();
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
