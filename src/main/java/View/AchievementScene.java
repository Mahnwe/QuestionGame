package View;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private StringProperty valueOfSuccess = new SimpleStringProperty();
    private final Stage stage;
    private final AchievementManager achievementManager;
    private int nbrPerfectScore10;
    private int nbrPerfectScore15;
    private int nbrPerfectScore20;


    public AchievementScene(BorderPane pane, AchievementManager achievementManager, Stage stage, File goldCupFile, File silverCupFile, File bronzeCupFile, File perfectScoreFile, File perfectScoreFile15, File perfectScoreFile20)
    {
        super(pane);
        pane.setPrefHeight(500);
        pane.setPrefWidth(900);
        this.stage = stage;
        this.achievementManager = achievementManager;

        TilePane tilePane = new TilePane();
        tilePane.setHgap(10);
        tilePane.setVgap(10);
        tilePane.setPrefColumns(4);
        tilePane.setPrefRows(2);

        VBox goldCupAchievementVBox = new VBox();
        Label goldCupAchievementLabel = new Label();
        Label goldCupAchievementInfo = new Label();

        VBox silverCupAchievementVBox = new VBox();
        Label silverCupAchievementLabel = new Label();
        Label silverCupAchievementInfo = new Label();

        VBox bronzeCupAchievementVBox = new VBox();
        Label bronzeCupAchievementLabel = new Label();
        Label bronzeCupAchievementInfo = new Label();

        VBox perfectScoreAchievementVBox = new VBox();
        Label perfectScoreAchievementLabel = new Label();
        Label perfectScoreAchievementInfo = new Label();

        VBox perfectScoreAchievement15 = new VBox();
        Label perfectScoreAchievement15Label = new Label();
        Label perfectScoreAchievement15Info = new Label();

        VBox perfectScoreAchievement20 = new VBox();
        Label perfectScoreAchievement20Label = new Label();
        Label perfectScoreAchievement20Info = new Label();

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

        goldCupAchievementLabel.setText(achievementManager.getAchievementsList().get(0).getConditionDescription());
        goldCupAchievementVBox.getChildren().add(goldCupAchievementLabel);
        goldCupAchievementVBox.getChildren().add(goldCupAchievementInfo);
        tilePane.getChildren().add(goldCupAchievementVBox);

        silverCupAchievementLabel.setText(achievementManager.getAchievementsList().get(1).getConditionDescription());
        silverCupAchievementVBox.getChildren().add(silverCupAchievementLabel);
        silverCupAchievementVBox.getChildren().add(silverCupAchievementInfo);
        tilePane.getChildren().add(silverCupAchievementVBox);

        bronzeCupAchievementLabel.setText(achievementManager.getAchievementsList().get(2).getConditionDescription());
        bronzeCupAchievementVBox.getChildren().add(bronzeCupAchievementLabel);
        bronzeCupAchievementVBox.getChildren().add(bronzeCupAchievementInfo);
        tilePane.getChildren().add(bronzeCupAchievementVBox);

        perfectScoreAchievementLabel.setText(achievementManager.getAchievementsList().get(3).getConditionDescription());
        perfectScoreAchievementVBox.getChildren().add(perfectScoreAchievementLabel);
        perfectScoreAchievementVBox.getChildren().add(perfectScoreAchievementInfo);
        tilePane.getChildren().add(perfectScoreAchievementVBox);

        perfectScoreAchievement15Label.setText(achievementManager.getAchievementsList().get(4).getConditionDescription());
        perfectScoreAchievement15.getChildren().add(perfectScoreAchievement15Label);
        perfectScoreAchievement15.getChildren().add(perfectScoreAchievement15Info);
        tilePane.getChildren().add(perfectScoreAchievement15);

        perfectScoreAchievement20Label.setText(achievementManager.getAchievementsList().get(5).getConditionDescription());
        perfectScoreAchievement20.getChildren().add(perfectScoreAchievement20Label);
        perfectScoreAchievement20.getChildren().add(perfectScoreAchievement20Info);
        tilePane.getChildren().add(perfectScoreAchievement20);

        pane.setCenter(tilePane);

        HBox buttonHbox = new HBox();
        buttonHbox.setPrefHeight(50);
        Button returnToMenu = new Button("Retour");
        buttonHbox.getChildren().add(returnToMenu);
        pane.setTop(buttonHbox);
        returnToMenu.setOnAction(event -> backToMainMenu());

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
