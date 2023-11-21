package view;

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
import model.AchievementManager;
import util.BackgroundCreator;
import util.FileUtil;
import util.UtilStringStorage;

import java.util.Properties;

public class AchievementScene extends Scene
{
    private final StringProperty valueOfSuccess = new SimpleStringProperty();
    private final Stage stage;
    private GridPane gridPane;
    private final BorderPane takeMultiPane;
    private final AchievementManager achievementManager;
    private Label goldCupAchievementInfo;
    private Label silverCupAchievementInfo;
    private Label bronzeCupAchievementInfo;
    private Label perfectScoreAchievementInfo;
    private Label perfectScoreAchievement15Info;
    private Label perfectScoreAchievement20Info;
    private Label survivalAchievement20Info;
    private Label survivalAchievement30Info;
    private Label survivalAchievement50Info;
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

        createGridPane();

        createGoldAchievementArea();
        createSilverAchievementArea();
        createBronzeAchievementArea();
        createPerfectScore10Area();
        createPerfectScore15Area();
        createPerfectScore20Area();
        createSurvive20AchievementArea();
        createSurvive30AchievementArea();
        createSurvive50AchievementArea();
        createSecretAchievementArea();
        checkAchievements();

        BorderPane multiPane = new BorderPane();
        multiPane.setMinHeight(750);
        takeMultiPane = new BorderPane();

        Label achievementLabel = new Label(UtilStringStorage.achievementLabel);
        achievementLabel.setFont(Font.font("Impact", FontWeight.BOLD, 30));
        multiPane.setTop(achievementLabel);
        achievementLabel.setTranslateX(400);
        achievementLabel.setTranslateY(5);
        multiPane.setCenter(gridPane);
        takeMultiPane.setCenter(multiPane);
        scrollPane.setContent(takeMultiPane);
        multiPane.setTranslateX(120);
        multiPane.setTranslateY(50);

        createReturnButton();
        createBackground();
    }

    public void createGridPane()
    {
        gridPane = new GridPane();
        gridPane.setTranslateY(60);
        gridPane.setHgap(30);
        gridPane.setVgap(40);
        gridPane.addColumn(3);
        gridPane.addRow(3);
    }

    public void createBackground()
    {
        BackgroundImage backgroundImage = BackgroundCreator.createMenuBackground();
        takeMultiPane.setBackground(new Background(backgroundImage));
    }

    public void createReturnButton()
    {
        HBox buttonHbox = new HBox();
        ReturnButton returnButton = new ReturnButton();
        buttonHbox.getChildren().add(returnButton);
        takeMultiPane.setTop(buttonHbox);
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

    public void createSurvive20AchievementArea()
    {
        VBox survive20AchievementVBox = new VBox();
        Label survive20AchievementLabel = new Label();
        survive20AchievementLabel.setText(UtilStringStorage.survivalAchievement20Description);
        survivalAchievement20Info = new Label();
        AchievementVbox.setAchievementVbox(survive20AchievementVBox, survive20AchievementLabel, achievementManager, 6, survivalAchievement20Info);
        gridPane.add(survive20AchievementVBox, 0, 2);
    }
    public void createSurvive30AchievementArea()
    {
        VBox survive30AchievementVBox = new VBox();
        Label survive30AchievementLabel = new Label();
        survive30AchievementLabel.setText(UtilStringStorage.survivalAchievement30Description);
        survivalAchievement30Info = new Label();
        AchievementVbox.setAchievementVbox(survive30AchievementVBox, survive30AchievementLabel, achievementManager, 7, survivalAchievement30Info);
        gridPane.add(survive30AchievementVBox, 1, 2);
    }

    public void createSurvive50AchievementArea()
    {
        VBox survive50AchievementVBox = new VBox();
        Label survive50AchievementLabel = new Label();
        survive50AchievementLabel.setText(UtilStringStorage.survivalAchievement50Description);
        survivalAchievement50Info = new Label();
        AchievementVbox.setAchievementVbox(survive50AchievementVBox, survive50AchievementLabel, achievementManager, 8, survivalAchievement50Info);
        gridPane.add(survive50AchievementVBox, 2, 2);
    }

    public void createSecretAchievementArea()
    {
        VBox secretAchievementBox = new VBox();
        secretAchievementLabel = new Label();
        secretAchievementLabel.setText(UtilStringStorage.secretLabel);
        secretAchievementInfo = new Label();
        AchievementVbox.setAchievementVbox(secretAchievementBox, secretAchievementLabel, achievementManager, 9, secretAchievementInfo);
        gridPane.add(secretAchievementBox, 1,3);

    }

    public void checkPropertyKeyNumber(Properties properties, String propertyKey, int achievementIndex, Label achievementInfo)
    {
        int nbrOfCup = Integer.parseInt(properties.getProperty(propertyKey));
        achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(achievementIndex), nbrOfCup);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(achievementIndex), achievementInfo);
    }

    public void checkAchievements()
    {
        checkPropertyKeyNumber(FileUtil.generalSavesFile, "goldCup", 0, goldCupAchievementInfo);
        checkPropertyKeyNumber(FileUtil.generalSavesFile,"silverCup", 1, silverCupAchievementInfo);
        checkPropertyKeyNumber(FileUtil.generalSavesFile,"bronzeCup", 2, bronzeCupAchievementInfo);

        checkPropertyKeyNumber(FileUtil.generalSavesFile, "perfectScore10", 3, perfectScoreAchievementInfo);
        checkPropertyKeyNumber(FileUtil.generalSavesFile, "perfectScore15", 4, perfectScoreAchievement15Info);
        checkPropertyKeyNumber(FileUtil.generalSavesFile, "perfectScore20", 5, perfectScoreAchievement20Info);

        checkPropertyKeyNumber(FileUtil.generalSavesFile, "survivalScore20", 6, survivalAchievement20Info);
        checkPropertyKeyNumber(FileUtil.generalSavesFile, "survivalScore30", 7, survivalAchievement30Info);
        checkPropertyKeyNumber(FileUtil.generalSavesFile, "survivalScore50", 8, survivalAchievement50Info);

        int checkNbrOfAchievementUnlock = checkSecretAchievement();
        achievementManager.checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(9), checkNbrOfAchievementUnlock);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(9), secretAchievementInfo);
        if(checkNbrOfAchievementUnlock == 9)
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

}
