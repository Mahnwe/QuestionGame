package View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.IconCreator;
import model.PathUtil;

public class ResultScene extends VBox
{
    private final Button exitToMenuButton;
    private final Label congratsLabel;
    private final Label playerResult;

    private ImageView goldCup;
    private ImageView bronzeCup;
    private ImageView silverCup;

    public ResultScene(BorderPane pane, int playerFinalScore, int questionCount, TrophyHandler trophyHandler)
    {
        VBox gameResult = new VBox();
        createIcons();

        congratsLabel = new Label();
        playerResult = new Label();
        exitToMenuButton = new Button("Return to menu");

        gameResult.getChildren().add(congratsLabel);
        gameResult.getChildren().add(playerResult);

        if(playerFinalScore >= questionCount*90/100)
        {
           GoldCupResult(trophyHandler, gameResult);
        }
        if(playerFinalScore >= questionCount*60/100 && playerFinalScore <= questionCount*80/100)
        {
            SilverCupResult(trophyHandler, gameResult);
        }
        if(playerFinalScore >= questionCount*40/100 && playerFinalScore <= questionCount*50/100)
        {
            BronzeCupResult(trophyHandler, gameResult);
        }
        if(playerFinalScore < questionCount*40/100)
        {
            Label cupLabel = new Label("Aucune coupe débloqué, retentez votre chance pour gagner une coupe");
            gameResult.getChildren().add(cupLabel);
        }
        gameResult.getChildren().add(exitToMenuButton);
        pane.setCenter(gameResult);
    }

    public void GoldCupResult(TrophyHandler trophyHandler, VBox vBox)
    {
        String checkIntInFile = String.valueOf(trophyHandler.ReadInGoldCupFile());
        String numberOfGoldCup = checkAndGetNumberOfCup(checkIntInFile);

        int nbrOfGoldCup = Integer.parseInt(numberOfGoldCup);
        nbrOfGoldCup++;
        String howManyGoldCup = "Gold Cups : "+ nbrOfGoldCup;
        trophyHandler.WriteInGoldCupFile(howManyGoldCup, checkIntInFile);

        Label cupLabel = new Label("Vous avez gagné la coupe d'or !");
        vBox.getChildren().add(cupLabel);
        vBox.getChildren().add(goldCup);
    }

    public void SilverCupResult(TrophyHandler trophyHandler, VBox vBox)
    {
        String checkIntInFile = String.valueOf(trophyHandler.ReadInSilverCupFile());
        String numberOfSilverCup = checkAndGetNumberOfCup(checkIntInFile);

        int nbrOfSilverCup = Integer.parseInt(numberOfSilverCup);
        nbrOfSilverCup++;
        String howManySilverCup = "Silver Cups : "+ nbrOfSilverCup;
        trophyHandler.WriteInSilverCupFile(howManySilverCup, checkIntInFile);

        Label cupLabel = new Label("Vous avez gagné la coupe d'argent !");
        vBox.getChildren().add(cupLabel);
        vBox.getChildren().add(silverCup);
    }

    public void BronzeCupResult(TrophyHandler trophyHandler, VBox vBox)
    {
        String checkIntInFile = String.valueOf(trophyHandler.ReadInBronzeCupFile());
        String numberOfBronzeCup = checkAndGetNumberOfCup(checkIntInFile);

        int nbrOfBronzeCup = Integer.parseInt(numberOfBronzeCup);
        nbrOfBronzeCup++;
        String howManyBronzeCup = "Bronze Cups : "+ nbrOfBronzeCup;
        trophyHandler.WriteInBronzeCupFile(howManyBronzeCup, checkIntInFile);

        Label cupLabel = new Label("Vous avez gagné la coupe de bronze !");
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

    public Button getExitToMenuButton() {
        return exitToMenuButton;
    }

    public Label getPlayerResult() {
        return playerResult;
    }

    public Label getCongratsLabel() {
        return congratsLabel;
    }

}
