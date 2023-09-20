package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Achievement;
import model.AchievementManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AchievementScene extends Scene
{
    private final StringProperty valueOfSuccess = new SimpleStringProperty();
    private final Stage stage;
    private final TilePane tilePane;
    private final AchievementManager achievementManager;

    private Label goldCupAchievementInfo;
    private Label silverCupAchievementInfo;
    private Label bronzeCupAchievementInfo;
    private Label perfectScoreAchievementInfo;
    private Label perfectScoreAchievement15Info;
    private Label perfectScoreAchievement20Info;
    private int nbrPerfectScore10;
    private int nbrPerfectScore15;
    private int nbrPerfectScore20;

    private final File goldCupFile;
    private final File silverCupFile;
    private final File bronzeCupFile;
    private final File perfectScoreFile;
    private final File perfectScoreFile15;
    private final File perfectScoreFile20;


    public AchievementScene(BorderPane pane, AchievementManager achievementManager, Stage stage, File goldCupFile, File silverCupFile, File bronzeCupFile, File perfectScoreFile, File perfectScoreFile15, File perfectScoreFile20)
    {
        super(pane);
        pane.setPrefHeight(500);
        pane.setPrefWidth(900);
        this.stage = stage;
        this.achievementManager = achievementManager;
        this.goldCupFile = goldCupFile;
        this.silverCupFile = silverCupFile;
        this.bronzeCupFile = bronzeCupFile;
        this.perfectScoreFile = perfectScoreFile;
        this.perfectScoreFile15 = perfectScoreFile15;
        this.perfectScoreFile20 = perfectScoreFile20;

        tilePane = new TilePane();
        tilePane.setHgap(10);
        tilePane.setVgap(10);
        tilePane.setPrefColumns(4);
        tilePane.setPrefRows(2);

        createGoldAchievementArea();
        createSilverAchievementArea();
        createBronzeAchievementArea();
        createPerfectScore10Area();
        createPerfectScore15Area();
        createPerfectScore20Area();
        checkAchievements();

        pane.setCenter(tilePane);

        HBox buttonHbox = new HBox();
        buttonHbox.setPrefHeight(50);
        Button returnToMenu = new Button("Retour");
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
        tilePane.getChildren().add(goldCupAchievementVBox);
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
        tilePane.getChildren().add(silverCupAchievementVBox);
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
        tilePane.getChildren().add(bronzeCupAchievementVBox);
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
        tilePane.getChildren().add(perfectScoreAchievementVBox);
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
        tilePane.getChildren().add(perfectScoreAchievement15);
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
        tilePane.getChildren().add(perfectScoreAchievement20);
    }

    public void checkAchievements()
    {
        String checkIntInGoldFile = String.valueOf(readInCupFile(goldCupFile));
        String numberOfGoldCup = checkAndGetNumberOfCup(checkIntInGoldFile);
        int nbrOfGoldCup = Integer.parseInt(numberOfGoldCup);
        achievementManager.getAchievementsList().get(0).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(0), nbrOfGoldCup);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(0), goldCupAchievementInfo);

        String checkIntInSilverFile = String.valueOf(readInCupFile(silverCupFile));
        String numberOfSilverCup = checkAndGetNumberOfCup(checkIntInSilverFile);
        int nbrOfSilverCup = Integer.parseInt(numberOfSilverCup);
        achievementManager.getAchievementsList().get(1).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(1), nbrOfSilverCup);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(1), silverCupAchievementInfo);

        String checkIntInBronzeFile = String.valueOf(readInCupFile(bronzeCupFile));
        String numberOfBronzeCup = checkAndGetNumberOfCup(checkIntInBronzeFile);
        int nbrOfBronzeCup = Integer.parseInt(numberOfBronzeCup);
        achievementManager.getAchievementsList().get(2).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(2), nbrOfBronzeCup);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(2), bronzeCupAchievementInfo);

        String checkPerfectScoreFile = String.valueOf(readInCupFile(perfectScoreFile));
        if(!checkPerfectScoreFile.isEmpty()) {
            String numberOfPerfectScore = checkAndGetNumberOfPerfectScore(checkPerfectScoreFile);
            nbrPerfectScore10 = Integer.parseInt(numberOfPerfectScore);
        }
        achievementManager.getAchievementsList().get(3).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(3), nbrPerfectScore10);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(3), perfectScoreAchievementInfo);

        String checkPerfectScoreFile15 = String.valueOf(readInCupFile(perfectScoreFile15));
        if(!checkPerfectScoreFile15.isEmpty()) {
            String numberOfPerfectScore15 = checkAndGetNumberOfPerfectScore(checkPerfectScoreFile15);
            nbrPerfectScore15 = Integer.parseInt(numberOfPerfectScore15);
        }
        achievementManager.getAchievementsList().get(4).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(4), nbrPerfectScore15);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(4), perfectScoreAchievement15Info);

        String checkPerfectScoreFile20 = String.valueOf(readInCupFile(perfectScoreFile20));
        if(!checkPerfectScoreFile20.isEmpty()) {
            String numberOfPerfectScore20 = checkAndGetNumberOfPerfectScore(checkPerfectScoreFile20);
            nbrPerfectScore20 = Integer.parseInt(numberOfPerfectScore20);
        }
        achievementManager.getAchievementsList().get(5).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(5), nbrPerfectScore20);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(5), perfectScoreAchievement20Info);
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
            unlockValue = "Succés obtenu";
            achievement.setLockImageView(achievement.getUnlockImageView());
        }
        else
        {
            unlockValue = "Succés vérouillé";
        }
        valueOfSuccess.setValue(unlockValue);
        label.setText(unlockValue);
    }

    public StringBuilder readInCupFile(File file)
    {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder;
    }

    public String checkAndGetNumberOfCup(String stringToCheck)
    {
        String numberGetter;
        if(stringToCheck.length() == 15) {
            numberGetter = stringToCheck.substring(stringToCheck.length() - 3, stringToCheck.length() - 1);
        }
        else {
            numberGetter = String.valueOf(stringToCheck.charAt(stringToCheck.length() -2));
        }
        return numberGetter;
    }
    public String checkAndGetNumberOfPerfectScore(String stringToCheck)
    {
        String numberGetter;
        numberGetter = stringToCheck.substring(stringToCheck.length() - 3, stringToCheck.length() - 1);
        return numberGetter;
    }

}
