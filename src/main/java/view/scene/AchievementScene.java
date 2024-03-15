package view.scene;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Achievement;
import model.handlers.AchievementManager;
import util.creators.BackgroundCreator;
import util.FileUtil;
import util.stringutiltranslate.UtilStringStorage;
import view.bootstrap.BootstrapPane;
import view.customobject.ReturnButton;
import view.customvbox.AchievementVbox;

import java.util.Properties;

public class AchievementScene extends Scene
{
    private final StringProperty valueOfSuccess = new SimpleStringProperty();
    private final Stage stage;
    private BootstrapPane gridPane;
    private final BorderPane multiPane;
    private final AchievementManager achievementManager;
    private final Label goldCupAchievementInfo = new Label();
    private final Label silverCupAchievementInfo = new Label();
    private final Label bronzeCupAchievementInfo = new Label();
    private final Label perfectScoreAchievementInfo= new Label();
    private final Label perfectScoreAchievement15Info= new Label();
    private final Label perfectScoreAchievement20Info= new Label();
    private final Label survivalAchievement20Info= new Label();
    private final Label survivalAchievement30Info= new Label();
    private final Label survivalAchievement40Info = new Label();
    private final Label numberOfGamesPlayed5Info = new Label();
    private final Label numberOfGamesPlayed10Info = new Label();
    private final Label numberOfGamesPlayed20Info = new Label();
    private final Label numberOfGoodAnswer50 = new Label();
    private final Label numberOfGoodAnswer100 = new Label();
    private final Label numberOfGoodAnswer150 = new Label();
    private Label secretAchievementInfo;
    private Label secretAchievementLabel;


    public AchievementScene(ScrollPane scrollPane, AchievementManager achievementManager, Stage stage)
    {
        super(scrollPane);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setFitToWidth(true);

        this.stage = stage;
        this.achievementManager = achievementManager;
        multiPane = new BorderPane();

        createGridPane();

        createTitle();
        putAchievementsInGridPane();
        createSecretAchievementArea();
        checkAchievements();

        multiPane.setMinHeight(1400);
        multiPane.setCenter(gridPane);

        scrollPane.setContent(multiPane);

        createReturnButton();
        createBackground();
    }

    public void createTitle()
    {
        Label achievementLabel = new Label(UtilStringStorage.achievementLabel);
        achievementLabel.setFont(Font.font("Impact", FontWeight.BOLD, 40));
        achievementLabel.setTranslateX(50);
        gridPane.add(achievementLabel, 1, 0);
    }

    public void createGridPane()
    {
        gridPane = new BootstrapPane(3);
        gridPane.setTranslateY(50);
        gridPane.setTranslateX(120);
        gridPane.setVgap(60);
        gridPane.addRow(3);
    }

    public void putAchievementsInGridPane()
    {
        createAchievementArea(UtilStringStorage.goldCupAchievementDescription, goldCupAchievementInfo, 0, 0, 1);

        createAchievementArea(UtilStringStorage.silverCupAchievementDescription, silverCupAchievementInfo, 1, 1, 1);

        createAchievementArea(UtilStringStorage.bronzeCupAchievementDescription, bronzeCupAchievementInfo, 2, 2,1);

        createAchievementArea(UtilStringStorage.perfectScore10Achievement, perfectScoreAchievementInfo, 3, 0, 2);

        createAchievementArea(UtilStringStorage.perfectScore15Achievement, perfectScoreAchievement15Info, 4, 1, 2);

        createAchievementArea(UtilStringStorage.perfectScore20Achievement, perfectScoreAchievement20Info, 5, 2, 2);

        createAchievementArea(UtilStringStorage.survivalAchievement20Description, survivalAchievement20Info, 6, 0, 3);

        createAchievementArea(UtilStringStorage.survivalAchievement30Description, survivalAchievement30Info, 7, 1, 3);

        createAchievementArea(UtilStringStorage.survivalAchievement40Description, survivalAchievement40Info, 8, 2, 3);

        createAchievementArea(UtilStringStorage.numberOfGamesPlayed5Description, numberOfGamesPlayed5Info, 9, 0, 4);

        createAchievementArea(UtilStringStorage.numberOfGamesPlayed10Description, numberOfGamesPlayed10Info, 10, 1, 4);

        createAchievementArea(UtilStringStorage.numberOfGamesPlayed20Description, numberOfGamesPlayed20Info, 11, 2, 4);

        createAchievementArea(UtilStringStorage.numberOfGoodAnswer50Description, numberOfGoodAnswer50, 12, 0, 5);

        createAchievementArea(UtilStringStorage.numberOfGoodAnswer100Description, numberOfGoodAnswer100, 13, 1, 5);

        createAchievementArea(UtilStringStorage.numberOfGoodAnswer150Description, numberOfGoodAnswer150, 14, 2, 5);
    }

    public void createBackground()
    {
        BackgroundImage backgroundImage = BackgroundCreator.createMenuBackground();
        multiPane.setBackground(new Background(backgroundImage));
    }

    public void createReturnButton()
    {
        HBox buttonHbox = new HBox();
        ReturnButton returnButton = new ReturnButton();
        buttonHbox.getChildren().add(returnButton);
        multiPane.setTop(buttonHbox);
        returnButton.setOnAction(event -> backToMainMenu());
    }

    public void createAchievementArea(String achievementDescription, Label achievementInfo, int achievementIndex, int gridColumn, int gridRow)
    {
        VBox achievementVbox = new VBox();
        Label achievementLabel = new Label();
        achievementLabel.setText(achievementDescription);
        AchievementVbox.setAchievementVbox(achievementVbox, achievementLabel, achievementManager, achievementIndex, achievementInfo);
        gridPane.add(achievementVbox, gridColumn, gridRow);
    }

    public void createSecretAchievementArea()
    {
        VBox secretAchievementBox = new VBox();
        secretAchievementLabel = new Label();
        secretAchievementLabel.setText(UtilStringStorage.secretLabel);
        secretAchievementInfo = new Label();
        AchievementVbox.setAchievementVbox(secretAchievementBox, secretAchievementLabel, achievementManager, 15, secretAchievementInfo);
        gridPane.add(secretAchievementBox, 1,6);

    }

    public void checkPropertyKeyNumber(Properties properties, String propertyKey, int achievementIndex, Label achievementInfo)
    {
        int nbrOfCup = Integer.parseInt(properties.getProperty(propertyKey));
        achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(achievementIndex), nbrOfCup);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(achievementIndex), achievementInfo);
    }

    public void checkAchievements()
    {
        checkPropertyKeyNumber(FileUtil.getGeneralSavesFile(), "goldCup", 0, goldCupAchievementInfo);
        checkPropertyKeyNumber(FileUtil.getGeneralSavesFile(),"silverCup", 1, silverCupAchievementInfo);
        checkPropertyKeyNumber(FileUtil.getGeneralSavesFile(),"bronzeCup", 2, bronzeCupAchievementInfo);

        checkPropertyKeyNumber(FileUtil.getGeneralSavesFile(), "perfectScore10", 3, perfectScoreAchievementInfo);
        checkPropertyKeyNumber(FileUtil.getGeneralSavesFile(), "perfectScore15", 4, perfectScoreAchievement15Info);
        checkPropertyKeyNumber(FileUtil.getGeneralSavesFile(), "perfectScore20", 5, perfectScoreAchievement20Info);

        checkPropertyKeyNumber(FileUtil.getGeneralSavesFile(), "bestSurvivalScore", 6, survivalAchievement20Info);
        checkPropertyKeyNumber(FileUtil.getGeneralSavesFile(), "bestSurvivalScore", 7, survivalAchievement30Info);
        checkPropertyKeyNumber(FileUtil.getGeneralSavesFile(), "bestSurvivalScore", 8, survivalAchievement40Info);

        checkPropertyKeyNumber(FileUtil.getGeneralSavesFile(), "numberOfGames", 9, numberOfGamesPlayed5Info);
        checkPropertyKeyNumber(FileUtil.getGeneralSavesFile(), "numberOfGames", 10, numberOfGamesPlayed10Info);
        checkPropertyKeyNumber(FileUtil.getGeneralSavesFile(), "numberOfGames", 11, numberOfGamesPlayed20Info);

        checkPropertyKeyNumber(FileUtil.getGeneralSavesFile(), "goodAnswerNumber", 12, numberOfGoodAnswer50);
        checkPropertyKeyNumber(FileUtil.getGeneralSavesFile(), "goodAnswerNumber", 13, numberOfGoodAnswer100);
        checkPropertyKeyNumber(FileUtil.getGeneralSavesFile(), "goodAnswerNumber", 14, numberOfGoodAnswer150);

        int checkNbrOfAchievementUnlock = checkSecretAchievement();
        achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(15), checkNbrOfAchievementUnlock);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(15), secretAchievementInfo);

        int nbrOfSecretCup = Integer.parseInt(FileUtil.getGeneralSavesFile().getProperty("secretCup"));
        if(checkNbrOfAchievementUnlock == 15 && nbrOfSecretCup == 0)
        {
            secretAchievementLabel.setText(UtilStringStorage.secretAchievement);
            TrophyScene.setAllAchievementAreUnlocked(true);
            nbrOfSecretCup++;
            FileUtil.getGeneralSavesFile().setProperty("secretCup", String.valueOf(nbrOfSecretCup));
        }
    }

    public int checkSecretAchievement()
    {
        int numberOfAchievementUnlock = 0;
        for(int i = 0; i < achievementManager.getAchievementsList().size(); i++)
        {
            if (achievementManager.getAchievementsList().get(i).isUnlock())
            {
                numberOfAchievementUnlock++;
            }
        }
        return numberOfAchievementUnlock;
    }
    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }

    public void checkIfAchievementIsUnlock(Achievement achievement, Label label)
    {
        String unlockValue;
        if(achievement.isUnlock())
        {
            unlockValue = UtilStringStorage.successUnlock;
            achievement.getLockImageView().setImage(achievement.getUnlockImageView().getImage());
        }
        else
        {
            unlockValue = UtilStringStorage.successLock;
            achievement.getLockImageView().setImage(achievement.getLockImageView().getImage());
        }
        valueOfSuccess.setValue(unlockValue);
        label.setText(unlockValue);
    }

}
