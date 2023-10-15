package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.*;

import java.util.Properties;

public class AchievementScene extends Scene
{
    private final StringProperty valueOfSuccess = new SimpleStringProperty();
    private final Stage stage;
    private final GridPane gridPane;
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
    private VBox secretAchievementBox;
    private Label secretAchievementLabel;
    private ImageView secretAchievementImage;


    public AchievementScene(BorderPane pane, AchievementManager achievementManager, Stage stage, Properties cupFile, Properties perfectScoreFile)
    {
        super(pane);
        pane.setPrefHeight(500);
        pane.setPrefWidth(900);
        this.stage = stage;
        this.achievementManager = achievementManager;
        this.cupFile = cupFile;
        this.perfectScoreFile = perfectScoreFile;

        gridPane = new GridPane();
        gridPane.setTranslateX(80);
        gridPane.setTranslateY(40);
        gridPane.setHgap(30);
        gridPane.setVgap(40);
        gridPane.addColumn(3);
        gridPane.addRow(2);

        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        BackgroundCreator menuBackground = new BackgroundCreator(PathUtil.MENU_BACKGROUND);
        Image menuSceneBackground = menuBackground.createBackground();
        BackgroundImage backgroundImage = new BackgroundImage(menuSceneBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize);
        pane.setBackground(new Background(backgroundImage));

        createGoldAchievementArea();
        createSilverAchievementArea();
        createBronzeAchievementArea();
        createPerfectScore10Area();
        createPerfectScore15Area();
        createPerfectScore20Area();
        createSecretAchievementArea();
        checkAchievements();

        pane.setCenter(gridPane);

        IconCreator returnArrow = new IconCreator(PathUtil.BACK_ARROW);
        Image backArrow = returnArrow.createImage().getImage();

        HBox buttonHbox = new HBox();
        Button returnToMenu = new Button();
        Tooltip returnTooltip = new Tooltip(UtilStringStorage.returnButton);
        returnToMenu.setTooltip(returnTooltip);
        returnToMenu.setBackground(new Background(new BackgroundImage(backArrow, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        returnToMenu.setPrefHeight(50);
        returnToMenu.setPrefWidth(50);
        buttonHbox.getChildren().add(returnToMenu);
        pane.setTop(buttonHbox);
        returnToMenu.setOnAction(event -> backToMainMenu());

    }

    public void createGoldAchievementArea()
    {
        VBox goldCupAchievementVBox = new VBox();
        Label goldCupAchievementLabel = new Label();
        ImageView goldCupImage = achievementManager.getAchievementsList().get(0).getLockImageView();
        goldCupAchievementInfo = new Label();
        goldCupAchievementLabel.setText(achievementManager.getAchievementsList().get(0).getConditionDescription());
        goldCupAchievementVBox.getChildren().add(goldCupAchievementLabel);
        goldCupAchievementVBox.getChildren().add(goldCupImage);
        goldCupAchievementVBox.getChildren().add(goldCupAchievementInfo);
        gridPane.add(goldCupAchievementVBox, 0, 0);
    }
    public void createSilverAchievementArea()
    {
        VBox silverCupAchievementVBox = new VBox();
        Label silverCupAchievementLabel = new Label();
        ImageView silverCupImage = achievementManager.getAchievementsList().get(1).getLockImageView();
        silverCupAchievementInfo = new Label();
        silverCupAchievementLabel.setText(achievementManager.getAchievementsList().get(1).getConditionDescription());
        silverCupAchievementVBox.getChildren().add(silverCupAchievementLabel);
        silverCupAchievementVBox.getChildren().add(silverCupImage);
        silverCupAchievementVBox.getChildren().add(silverCupAchievementInfo);
        gridPane.add(silverCupAchievementVBox, 1, 0);
    }

    public void createBronzeAchievementArea()
    {
        VBox bronzeCupAchievementVBox = new VBox();
        Label bronzeCupAchievementLabel = new Label();
        ImageView bronzeCupImage = achievementManager.getAchievementsList().get(2).getLockImageView();
        bronzeCupAchievementInfo = new Label();
        bronzeCupAchievementLabel.setText(achievementManager.getAchievementsList().get(2).getConditionDescription());
        bronzeCupAchievementVBox.getChildren().add(bronzeCupAchievementLabel);
        bronzeCupAchievementVBox.getChildren().add(bronzeCupImage);
        bronzeCupAchievementVBox.getChildren().add(bronzeCupAchievementInfo);
        gridPane.add(bronzeCupAchievementVBox, 2, 0);
    }

    public void createPerfectScore10Area()
    {
        VBox perfectScoreAchievementVBox = new VBox();
        Label perfectScoreAchievementLabel = new Label();
        ImageView perfectScoreImage = achievementManager.getAchievementsList().get(3).getLockImageView();
        perfectScoreAchievementInfo = new Label();
        perfectScoreAchievementLabel.setText(achievementManager.getAchievementsList().get(3).getConditionDescription());
        perfectScoreAchievementVBox.getChildren().add(perfectScoreAchievementLabel);
        perfectScoreAchievementVBox.getChildren().add(perfectScoreImage);
        perfectScoreAchievementVBox.getChildren().add(perfectScoreAchievementInfo);
        gridPane.add(perfectScoreAchievementVBox, 0, 1);
    }

    public void createPerfectScore15Area()
    {
        VBox perfectScoreAchievement15 = new VBox();
        Label perfectScoreAchievement15Label = new Label();
        ImageView perfectScore15Image = achievementManager.getAchievementsList().get(4).getLockImageView();
        perfectScoreAchievement15Info = new Label();
        perfectScoreAchievement15Label.setText(achievementManager.getAchievementsList().get(4).getConditionDescription());
        perfectScoreAchievement15.getChildren().add(perfectScoreAchievement15Label);
        perfectScoreAchievement15.getChildren().add(perfectScore15Image);
        perfectScoreAchievement15.getChildren().add(perfectScoreAchievement15Info);
        gridPane.add(perfectScoreAchievement15, 1, 1);
    }

    public void createPerfectScore20Area()
    {
        VBox perfectScoreAchievement20 = new VBox();
        Label perfectScoreAchievement20Label = new Label();
        ImageView perfectScore20Image = achievementManager.getAchievementsList().get(5).getLockImageView();
        perfectScoreAchievement20Info = new Label();
        perfectScoreAchievement20Label.setText(achievementManager.getAchievementsList().get(5).getConditionDescription());
        perfectScoreAchievement20.getChildren().add(perfectScoreAchievement20Label);
        perfectScoreAchievement20.getChildren().add(perfectScore20Image);
        perfectScoreAchievement20.getChildren().add(perfectScoreAchievement20Info);
        gridPane.add(perfectScoreAchievement20, 2, 1);
    }

    public void createSecretAchievementArea()
    {
        secretAchievementBox = new VBox();
        secretAchievementLabel = new Label();
        secretAchievementImage = achievementManager.getAchievementsList().get(6).getLockImageView();
        secretAchievementInfo = new Label();
        secretAchievementLabel.setText(UtilStringStorage.secretLabel);
        secretAchievementBox.getChildren().add(secretAchievementLabel);
        secretAchievementBox.getChildren().add(secretAchievementImage);
        secretAchievementBox.getChildren().add(secretAchievementInfo);
        gridPane.add(secretAchievementBox, 1,2);
        secretAchievementImage.setVisible(false);
        secretAchievementInfo.setVisible(false);

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
            secretAchievementLabel.setText(achievementManager.getAchievementsList().get(6).getConditionDescription());
            secretAchievementBox.setVisible(true);
            secretAchievementImage.setVisible(true);
            secretAchievementInfo.setVisible(true);
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
