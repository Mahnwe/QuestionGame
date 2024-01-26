package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import model.TimePlayedTimer;
import util.BackgroundCreator;
import util.FileUtil;
import util.UtilStringStorage;

public class StatsScene extends Scene
{
    private final BorderPane borderPane;
    private final Stage stage;
    private final AchievementManager achievementManager;
    private GridPane gridPane;
    public StatsScene (BorderPane borderPane, Stage stage, AchievementManager achievementManager)
    {
        super(borderPane);
        this.borderPane = borderPane;
        this.stage = stage;
        this.achievementManager = achievementManager;

        createBackground();
        createGridPane();
        create1stRowStatistic();
        create2ndRowStatistic();
        create3rdRowStatistic();
        createTitleScene();
        createReturnButton();

        borderPane.setCenter(gridPane);
    }

    public void createGridPane()
    {
        gridPane = new GridPane();
        gridPane.setVgap(25);
        gridPane.setHgap(55);
        gridPane.setTranslateX(80);
        gridPane.setTranslateY(50);
    }

    public void create1stRowStatistic()
    {
        StatsVbox statsVbox1 = new StatsVbox(UtilStringStorage.bestScoreIn10Label, FileUtil.getGeneralSavesFile().getProperty("perfectScore10"));
        gridPane.add(statsVbox1, 0, 2);

        StatsVbox statsVbox2 = new StatsVbox(UtilStringStorage.bestScoreIn15Label, FileUtil.getGeneralSavesFile().getProperty("perfectScore15"));
        gridPane.add(statsVbox2, 0, 3);

        StatsVbox statsVbox3 = new StatsVbox(UtilStringStorage.bestScoreIn20Label, FileUtil.getGeneralSavesFile().getProperty("perfectScore20"));
        gridPane.add(statsVbox3, 0, 4);

        StatsVbox statsVbox4 = new StatsVbox(UtilStringStorage.bestScoreSurvivalLabel, checkForBestSurvivalScore());
        gridPane.add(statsVbox4, 0, 5);
    }

    public void create2ndRowStatistic()
    {
        StatsVbox statsVbox5 = new StatsVbox(UtilStringStorage.questionAnsweredLabel, FileUtil.getGeneralSavesFile().getProperty("questionAnswered"));
        gridPane.add(statsVbox5, 2, 2);

        StatsVbox statsVbox6 = new StatsVbox(UtilStringStorage.goodAnswerNumberLabel, FileUtil.getGeneralSavesFile().getProperty("goodAnswerNumber"));
        gridPane.add(statsVbox6, 2, 3);

        StatsVbox statsVbox7 = new StatsVbox(UtilStringStorage.badAnswerNumberLabel, FileUtil.getGeneralSavesFile().getProperty("badAnswerNumber"));
        gridPane.add(statsVbox7, 2, 4);

        StatsVbox statsVbox8 = new StatsVbox(UtilStringStorage.successPercentageLabel, calculateSuccessPercentage());
        gridPane.add(statsVbox8, 2, 5);
    }

    public void create3rdRowStatistic()
    {
        StatsVbox statsVbox9 = new StatsVbox(UtilStringStorage.numberOfGamesLabel, FileUtil.getGeneralSavesFile().getProperty("numberOfGames"));
        gridPane.add(statsVbox9, 4, 2);

        StatsVbox statsVbox10 = new StatsVbox(UtilStringStorage.normalGameModeLabel, FileUtil.getGeneralSavesFile().getProperty("numberOfNormalGames"));
        gridPane.add(statsVbox10, 4, 3);

        StatsVbox statsVbox11 = new StatsVbox(UtilStringStorage.survivalGameModeLabel, FileUtil.getGeneralSavesFile().getProperty("numberOfSurvivalGames"));
        gridPane.add(statsVbox11, 4, 4);

        StatsVbox statsVbox12 = new StatsVbox(UtilStringStorage.timePlayedLabel, calculateTimePlayed());
        gridPane.add(statsVbox12, 4, 5);
        statsVbox12.getStatScoreLabel().setTranslateX(-1);
    }

    public String calculateTimePlayed()
    {
        TimePlayedTimer.setTimerDisplay(Long.parseLong(FileUtil.getGeneralSavesFile().getProperty("timePlayed")));
        return TimePlayedTimer.getHoursDisplay()+"Hrs"+TimePlayedTimer.getMinutesDisplay()+"Min"+TimePlayedTimer.getSecondsDisplay()+"Sec";
    }

    public String calculateSuccessPercentage()
    {
        int questionAnswered = Integer.parseInt(FileUtil.getGeneralSavesFile().getProperty("questionAnswered"));
        int goodAnswerNumber = Integer.parseInt(FileUtil.getGeneralSavesFile().getProperty("goodAnswerNumber"));
        int successPercentage;
        if(questionAnswered != 0) {
            successPercentage = (goodAnswerNumber * 100 / questionAnswered);
        }
        else {
          successPercentage = 0;
        }
        return successPercentage+"%";
    }

    public String checkForBestSurvivalScore()
    {
        String checkBestSurvivalScore = null;
        int survivalScore = Integer.parseInt(FileUtil.getGeneralSavesFile().getProperty("survivalScore50"));
        if(survivalScore != 0)
        {
            checkBestSurvivalScore = String.valueOf(survivalScore);
        }
        if(survivalScore == 0)
        {
            survivalScore = Integer.parseInt(FileUtil.getGeneralSavesFile().getProperty("survivalScore30"));
            if (survivalScore != 0)
            {
                checkBestSurvivalScore = String.valueOf(survivalScore);
            }
            if (survivalScore == 0)
            {
                survivalScore = Integer.parseInt(FileUtil.getGeneralSavesFile().getProperty("survivalScore20"));
                checkBestSurvivalScore = String.valueOf(survivalScore);
            }
        }
        return checkBestSurvivalScore;
    }

    public void createTitleScene()
    {
        Label achievementLabel = new Label(UtilStringStorage.statisticLabel);
        achievementLabel.setFont(Font.font("Impact", FontWeight.BOLD, 35));
        gridPane.add(achievementLabel, 2, 0);
        achievementLabel.setTranslateX(10);
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
    public void createBackground()
    {
        BackgroundImage backgroundImage = BackgroundCreator.createMenuBackground();
        borderPane.setBackground(new Background(backgroundImage));
    }
}
