package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Achievement;
import model.AchievementManager;
import util.AchievementVbox;
import util.BackgroundCreator;
import util.ReturnButton;
import util.UtilStringStorage;

import java.util.Properties;

public class AchievementScene extends Scene
{
    private final StringProperty valueOfSuccess = new SimpleStringProperty();
    private final Stage stage;
    private final BorderPane pane;
    private GridPane gridPane;
    private final AchievementManager achievementManager;

    private Label goldCupAchievementInfo;
    private Label silverCupAchievementInfo;
    private Label bronzeCupAchievementInfo;
    private Label perfectScoreAchievementInfo;
    private Label perfectScoreAchievement15Info;
    private Label perfectScoreAchievement20Info;
    private Label secretAchievementInfo;
    private final Properties perfectScoreFile;
    private final Properties cupFile;
    private Label secretAchievementLabel;


    public AchievementScene(BorderPane pane, AchievementManager achievementManager, Stage stage, Properties cupFile, Properties perfectScoreFile)
    {
        super(pane);
        this.pane = pane;
        pane.setPrefHeight(500);
        pane.setPrefWidth(900);
        this.stage = stage;
        this.achievementManager = achievementManager;
        this.cupFile = cupFile;
        this.perfectScoreFile = perfectScoreFile;

        createGridPane();

        createGoldAchievementArea();
        createSilverAchievementArea();
        createBronzeAchievementArea();
        createPerfectScore10Area();
        createPerfectScore15Area();
        createPerfectScore20Area();
        createSecretAchievementArea();
        checkAchievements();

        BorderPane multiPane = new BorderPane();

        Label achievementLabel = new Label(UtilStringStorage.achievementLabel);
        achievementLabel.setFont(Font.font("Impact", FontWeight.BOLD, 23));
        multiPane.setTop(achievementLabel);
        achievementLabel.setTranslateX(350);
        achievementLabel.setTranslateY(5);
        multiPane.setCenter(gridPane);
        pane.setCenter(multiPane);

        createReturnButton();

        createBackground();
    }

    public void createGridPane()
    {
        gridPane = new GridPane();
        gridPane.setTranslateX(80);
        gridPane.setTranslateY(60);
        gridPane.setHgap(30);
        gridPane.setVgap(40);
        gridPane.addColumn(3);
        gridPane.addRow(2);
    }

    public void createBackground()
    {
        BackgroundImage backgroundImage = BackgroundCreator.createMenuBackground();
        pane.setBackground(new Background(backgroundImage));
    }

    public void createReturnButton()
    {
        HBox buttonHbox = new HBox();
        ReturnButton returnButton = new ReturnButton();

        buttonHbox.getChildren().add(returnButton);
        pane.setTop(buttonHbox);
        returnButton.setOnAction(event -> backToMainMenu());
    }

    public void createGoldAchievementArea()
    {
        VBox goldCupAchievementVBox = new VBox();

        Label goldCupAchievementLabel = new Label();
        goldCupAchievementLabel.setText(UtilStringStorage.goldCupAchievementDescription);

        goldCupAchievementInfo = new Label();

        AchievementVbox.setAchievementVbox(goldCupAchievementVBox, goldCupAchievementLabel, achievementManager, 0, goldCupAchievementInfo);

        gridPane.add(goldCupAchievementVBox, 0, 0);
    }
    public void createSilverAchievementArea()
    {
        VBox silverCupAchievementVBox = new VBox();

        Label silverCupAchievementLabel = new Label();
        silverCupAchievementLabel.setText(UtilStringStorage.silverCupAchievementDescription);

        silverCupAchievementInfo = new Label();

        AchievementVbox.setAchievementVbox(silverCupAchievementVBox, silverCupAchievementLabel, achievementManager, 1, silverCupAchievementInfo);

        gridPane.add(silverCupAchievementVBox, 1, 0);
    }

    public void createBronzeAchievementArea()
    {
        VBox bronzeCupAchievementVBox = new VBox();

        Label bronzeCupAchievementLabel = new Label();
        bronzeCupAchievementLabel.setText(UtilStringStorage.bronzeCupAchievementDescription);

        bronzeCupAchievementInfo = new Label();

        AchievementVbox.setAchievementVbox(bronzeCupAchievementVBox, bronzeCupAchievementLabel, achievementManager, 2, bronzeCupAchievementInfo);

        gridPane.add(bronzeCupAchievementVBox, 2, 0);
    }

    public void createPerfectScore10Area()
    {
        VBox perfectScoreAchievementVBox = new VBox();

        Label perfectScoreAchievementLabel = new Label();
        perfectScoreAchievementLabel.setText(UtilStringStorage.perfectScore10Achievement);

        perfectScoreAchievementInfo = new Label();

        AchievementVbox.setAchievementVbox(perfectScoreAchievementVBox, perfectScoreAchievementLabel, achievementManager, 3, perfectScoreAchievementInfo);

        gridPane.add(perfectScoreAchievementVBox, 0, 1);
    }

    public void createPerfectScore15Area()
    {
        VBox perfectScoreAchievement15 = new VBox();

        Label perfectScoreAchievement15Label = new Label();
        perfectScoreAchievement15Label.setText(UtilStringStorage.perfectScore15Achievement);

        perfectScoreAchievement15Info = new Label();

        AchievementVbox.setAchievementVbox(perfectScoreAchievement15, perfectScoreAchievement15Label, achievementManager, 4, perfectScoreAchievement15Info);

        gridPane.add(perfectScoreAchievement15, 1, 1);
    }

    public void createPerfectScore20Area()
    {
        VBox perfectScoreAchievement20 = new VBox();

        Label perfectScoreAchievement20Label = new Label();
        perfectScoreAchievement20Label.setText(UtilStringStorage.perfectScore20Achievement);

        perfectScoreAchievement20Info = new Label();

        AchievementVbox.setAchievementVbox(perfectScoreAchievement20, perfectScoreAchievement20Label, achievementManager, 5, perfectScoreAchievement20Info);

        gridPane.add(perfectScoreAchievement20, 2, 1);
    }

    public void createSecretAchievementArea()
    {
        VBox secretAchievementBox = new VBox();

        secretAchievementLabel = new Label();
        secretAchievementLabel.setText(UtilStringStorage.secretLabel);

        secretAchievementInfo = new Label();

        AchievementVbox.setAchievementVbox(secretAchievementBox, secretAchievementLabel, achievementManager, 6, secretAchievementInfo);

        gridPane.add(secretAchievementBox, 1,2);

    }

    public void checkPropertyKeyNumber(Properties properties, String propertyKey, int achievementIndex, Label achievementInfo)
    {
        String checkIntInFile = properties.getProperty(propertyKey);
        String numberInKey = checkAndGetNumberInPropertyKey(checkIntInFile);
        int nbrOfCup = Integer.parseInt(numberInKey);
        achievementManager.getAchievementsList().get(achievementIndex).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(achievementIndex), nbrOfCup);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(achievementIndex), achievementInfo);
    }

    public void checkAchievements()
    {
        checkPropertyKeyNumber(cupFile, "goldCup", 0, goldCupAchievementInfo);

        checkPropertyKeyNumber(cupFile,"silverCup", 1, silverCupAchievementInfo);

        checkPropertyKeyNumber(cupFile,"bronzeCup", 2, bronzeCupAchievementInfo);

        checkPropertyKeyNumber(perfectScoreFile, "perfectScore10", 3, perfectScoreAchievementInfo);

        checkPropertyKeyNumber(perfectScoreFile, "perfectScore15", 4, perfectScoreAchievement15Info);

        checkPropertyKeyNumber(perfectScoreFile, "perfectScore20", 5, perfectScoreAchievement20Info);

        int checkNbrOfAchievementUnlock = checkSecretAchievement();
        achievementManager.getAchievementsList().get(6).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(6), checkNbrOfAchievementUnlock);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(6), secretAchievementInfo);
        if(checkNbrOfAchievementUnlock == 6)
        {
            secretAchievementLabel.setText(UtilStringStorage.secretAchievement);
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

    public String checkAndGetNumberInPropertyKey(String stringToCheck)
    {
        String numberGetter;
        numberGetter = stringToCheck;
        return numberGetter;
    }

}
