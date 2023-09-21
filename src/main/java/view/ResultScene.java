package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import model.GameTimer;
import model.IconCreator;
import model.PathUtil;

import java.io.*;

public class ResultScene extends VBox
{
    private final Label congratsLabel;
    private final Label playerResult;

    private ImageView goldCup;
    private ImageView bronzeCup;
    private ImageView silverCup;
    private final AchievementManager achievementManager;
    private final int playerFinalScore;

    private final Stage stage;
    private final File perfectScoreFile10;
    private final File perfectScoreFile15;
    private final File perfectScoreFile20;
    private final File goldCupFile;
    private final File silverCupFile;
    private final File bronzeCupFile;
    private final int questionCount;

    public ResultScene(BorderPane pane, int playerFinalScore, int questionCount, TrophyHandler trophyHandler, AchievementManager achievementManager, Stage stage, File perfectScoreFile, File perfectScoreFile15, File perfectScoreFile20, File goldCupFile, File silverCupFile, File bronzeCupFile)
    {
        this.achievementManager = achievementManager;
        this.playerFinalScore = playerFinalScore;
        this.questionCount = questionCount;
        this.stage = stage;
        this.perfectScoreFile10 = perfectScoreFile;
        this.perfectScoreFile15 = perfectScoreFile15;
        this.perfectScoreFile20 = perfectScoreFile20;
        this.goldCupFile = goldCupFile;
        this.silverCupFile = silverCupFile;
        this.bronzeCupFile = bronzeCupFile;
        VBox gameResult = new VBox();
        createIcons();

        congratsLabel = new Label();
        congratsLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        congratsLabel.setTextFill(Color.GHOSTWHITE);

        playerResult = new Label();
        playerResult.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        playerResult.setTextFill(Color.GHOSTWHITE);
        Button exitToMenuButton = new Button("Return to menu");

        Label timeLabel = new Label();
        timeLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        timeLabel.setTextFill(Color.GHOSTWHITE);
        timeLabel.setText("Votre chrono : "+ GameTimer.getElapsedMinutes() + "min "+ GameTimer.getSecondsDisplay() +"sec");

        gameResult.getChildren().add(congratsLabel);
        gameResult.getChildren().add(playerResult);
        gameResult.getChildren().add(timeLabel);

        if(playerFinalScore >= questionCount*90/100)
        {
            goldCupResult(trophyHandler, gameResult);
        }
        if(playerFinalScore >= questionCount*60/100 && playerFinalScore <= questionCount*80/100)
        {
            silverCupResult(trophyHandler, gameResult);
        }
        if(playerFinalScore >= questionCount*40/100 && playerFinalScore <= questionCount*50/100)
        {
            bronzeCupResult(trophyHandler, gameResult);
        }
        if(playerFinalScore < questionCount*40/100)
        {
            Label cupLabel = new Label("Aucune coupe débloqué, retentez votre chance pour gagner une coupe");
            cupLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
            cupLabel.setTextFill(Color.GHOSTWHITE);
            gameResult.getChildren().add(cupLabel);
        }
        gameResult.getChildren().add(exitToMenuButton);
        pane.setCenter(gameResult);
        exitToMenuButton.setOnAction(event -> backToMainMenu());
    }

    public void goldCupResult(TrophyHandler trophyHandler, VBox vBox)
    {
        String checkIntInFile = String.valueOf(trophyHandler.readInCupFile(goldCupFile));
        String numberOfGoldCup = checkAndGetNumberOfCup(checkIntInFile);

        int nbrOfGoldCup = Integer.parseInt(numberOfGoldCup);
        nbrOfGoldCup++;
        String howManyGoldCup = "Gold Cups : "+ nbrOfGoldCup;

        if(questionCount == 10) {
            String checkIntInPerfectFile = String.valueOf(readInPerfectCupFile(perfectScoreFile10));
            if (checkIntInPerfectFile.equals("10")) {
                achievementManager.getAchievementsList().get(3).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(3), playerFinalScore);
            } else {
                String perfectScoreString = String.valueOf(playerFinalScore);
                writeInPerfectCupFile(perfectScoreFile10, perfectScoreString, checkIntInPerfectFile);
            }
        }
        if(questionCount == 15) {
            String checkIntInPerfectFile15 = String.valueOf(readInPerfectCupFile(perfectScoreFile15));
            if (checkIntInPerfectFile15.equals("15")) {
                achievementManager.getAchievementsList().get(4).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(4), playerFinalScore);
            } else {
                String perfectScoreString15 = String.valueOf(playerFinalScore);
                writeInPerfectCupFile(perfectScoreFile15, perfectScoreString15, checkIntInPerfectFile15);
            }
        }

        if(questionCount == 20) {
            String checkIntInPerfectFile20 = String.valueOf(readInPerfectCupFile(perfectScoreFile20));
            if (checkIntInPerfectFile20.equals("20")) {
                achievementManager.getAchievementsList().get(5).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(5), playerFinalScore);
            } else {
                String perfectScoreString20 = String.valueOf(playerFinalScore);
                writeInPerfectCupFile(perfectScoreFile20, perfectScoreString20, checkIntInPerfectFile20);
            }
        }

        achievementManager.getAchievementsList().get(0).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(0), nbrOfGoldCup);
        trophyHandler.writeInCupFile(goldCupFile, howManyGoldCup, checkIntInFile);

        Label cupLabel = new Label("Vous avez gagné la coupe d'or !");
        cupLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        cupLabel.setTextFill(Color.GHOSTWHITE);
        vBox.getChildren().add(cupLabel);
        vBox.getChildren().add(goldCup);
    }

    public void silverCupResult(TrophyHandler trophyHandler, VBox vBox)
    {
        String checkIntInFile = String.valueOf(trophyHandler.readInCupFile(silverCupFile));
        String numberOfSilverCup = checkAndGetNumberOfCup(checkIntInFile);

        int nbrOfSilverCup = Integer.parseInt(numberOfSilverCup);
        nbrOfSilverCup++;
        String howManySilverCup = "Silver Cups : "+ nbrOfSilverCup;

        achievementManager.getAchievementsList().get(1).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(1), nbrOfSilverCup);
        trophyHandler.writeInCupFile(silverCupFile, howManySilverCup, checkIntInFile);

        Label cupLabel = new Label("Vous avez gagné la coupe d'argent !");
        cupLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        cupLabel.setTextFill(Color.GHOSTWHITE);
        vBox.getChildren().add(cupLabel);
        vBox.getChildren().add(silverCup);
    }

    public void bronzeCupResult(TrophyHandler trophyHandler, VBox vBox)
    {
        String checkIntInFile = String.valueOf(trophyHandler.readInCupFile(bronzeCupFile));
        String numberOfBronzeCup = checkAndGetNumberOfCup(checkIntInFile);

        int nbrOfBronzeCup = Integer.parseInt(numberOfBronzeCup);
        nbrOfBronzeCup++;
        String howManyBronzeCup = "Bronze Cups : "+ nbrOfBronzeCup;

        achievementManager.getAchievementsList().get(2).checkIfAchievementIsUnlock(achievementManager.getAchievementsList().get(2), nbrOfBronzeCup);
        trophyHandler.writeInCupFile(bronzeCupFile, howManyBronzeCup, checkIntInFile);

        Label cupLabel = new Label("Vous avez gagné la coupe de bronze !");
        cupLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        cupLabel.setTextFill(Color.GHOSTWHITE);
        vBox.getChildren().add(cupLabel);
        vBox.getChildren().add(bronzeCup);
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

    public void createIcons()
    {
        IconCreator goldCupImage = new IconCreator(PathUtil.GOLD_CUP_PATH);
        goldCup = goldCupImage.createImage();
        goldCup.setFitHeight(100);
        goldCup.setFitWidth(80);

        IconCreator bronzeCupImage = new IconCreator(PathUtil.BRONZE_CUP_PATH);
        bronzeCup = bronzeCupImage.createImage();
        bronzeCup.setFitHeight(100);
        bronzeCup.setFitWidth(80);

        IconCreator silverCupImage = new IconCreator(PathUtil.SILVER_CUP_PATH);
        silverCup = silverCupImage.createImage();
        silverCup.setFitHeight(100);
        silverCup.setFitWidth(80);
    }

    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }
    public StringBuilder readInPerfectCupFile(File file)
    {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder;
    }

    public void writeInPerfectCupFile(File file, String stringToUse, String lineToReplace)
    {
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            String lineReplacement = lineToReplace.replace(lineToReplace, stringToUse);
            bw.write(lineReplacement);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Label getPlayerResult() {
        return playerResult;
    }

    public Label getCongratsLabel() {
        return congratsLabel;
    }

}
