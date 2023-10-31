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

    public void checkAchievements()
    {
        String checkIntInGoldFile = cupFile.getProperty("goldCup");
        String numberOfGoldCup = checkAndGetNumberOfCup(checkIntInGoldFile);
        int nbrOfGoldCup = Integer.parseInt(numberOfGoldCup);
        achievementManager.getAchievementsList().get(0).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(0), nbrOfGoldCup);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(0), goldCupAchievementInfo);

        String checkIntInSilverFile = cupFile.getProperty("silverCup");
        String numberOfSilverCup = checkAndGetNumberOfCup(checkIntInSilverFile);
        int nbrOfSilverCup = Integer.parseInt(numberOfSilverCup);
        achievementManager.getAchievementsList().get(1).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(1), nbrOfSilverCup);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(1), silverCupAchievementInfo);

        String checkIntInBronzeFile = cupFile.getProperty("bronzeCup");
        String numberOfBronzeCup = checkAndGetNumberOfCup(checkIntInBronzeFile);
        int nbrOfBronzeCup = Integer.parseInt(numberOfBronzeCup);
        achievementManager.getAchievementsList().get(2).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(2), nbrOfBronzeCup);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(2), bronzeCupAchievementInfo);

        String checkPerfectScoreFile10 = String.valueOf(perfectScoreFile.getProperty("perfectScore10"));
        String numberOfPerfectScore10 = checkAndGetNumberOfPerfectScore(checkPerfectScoreFile10);
        int nbrPerfectScore10 = Integer.parseInt(numberOfPerfectScore10);
        achievementManager.getAchievementsList().get(3).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(3), nbrPerfectScore10);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(3), perfectScoreAchievementInfo);

        String checkPerfectScoreFile15 = String.valueOf(perfectScoreFile.getProperty("perfectScore15"));
        String numberOfPerfectScore15 = checkAndGetNumberOfPerfectScore(checkPerfectScoreFile15);
        int nbrPerfectScore15 = Integer.parseInt(numberOfPerfectScore15);
        achievementManager.getAchievementsList().get(4).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(4), nbrPerfectScore15);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(4), perfectScoreAchievement15Info);

        String checkPerfectScoreFile20 = String.valueOf(perfectScoreFile.getProperty("perfectScore20"));
        String numberOfPerfectScore20 = checkAndGetNumberOfPerfectScore(checkPerfectScoreFile20);
        int nbrPerfectScore20 = Integer.parseInt(numberOfPerfectScore20);
        achievementManager.getAchievementsList().get(5).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(5), nbrPerfectScore20);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(5), perfectScoreAchievement20Info);

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

    public String checkAndGetNumberOfCup(String stringToCheck)
    {
        String numberGetter;
        numberGetter = stringToCheck;
        return numberGetter;
    }
    public String checkAndGetNumberOfPerfectScore(String stringToCheck)
    {
        // THIS IS FOR PERFECT SCORE
        String numberGetter;
        numberGetter = stringToCheck;
        return numberGetter;
    }

}
