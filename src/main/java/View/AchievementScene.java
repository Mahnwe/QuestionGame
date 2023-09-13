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
    private int nbrPerfectScore;


    public AchievementScene(BorderPane pane, AchievementManager achievementManager, Stage stage, File goldCupFile, File silverCupFile, File bronzeCupFile, File perfectScoreFile)
    {
        super(pane);
        pane.setPrefHeight(500);
        pane.setPrefWidth(900);
        this.stage = stage;
        this.achievementManager = achievementManager;

        TilePane tilePane = new TilePane();
        tilePane.setHgap(10);

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
            nbrPerfectScore = Integer.parseInt(numberOfPerfectScore);
        }
        achievementManager.getAchievementsList().get(3).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(3), nbrPerfectScore);
        checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(3), perfectScoreAchievementInfo);

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
