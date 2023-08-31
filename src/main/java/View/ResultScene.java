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

    public ResultScene(BorderPane pane, int playerFinalScore, int questionCount)
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
            Label cupLabel = new Label("Vous avez gagné la coupe d'or !");
            gameResult.getChildren().add(cupLabel);
            gameResult.getChildren().add(goldCup);
        }
        if(playerFinalScore >= questionCount*60/100 && playerFinalScore <= questionCount*80/100)
        {
            Label cupLabel = new Label("Vous avez gagné la coupe d'argent !");
            gameResult.getChildren().add(cupLabel);
            gameResult.getChildren().add(silverCup);
        }
        if(playerFinalScore >= questionCount*40/100 && playerFinalScore <= questionCount*50/100)
        {
            Label cupLabel = new Label("Vous avez gagné la coupe de bronze !");
            gameResult.getChildren().add(cupLabel);
            gameResult.getChildren().add(bronzeCup);
        }
        if(playerFinalScore < questionCount*40/100)
        {
            Label cupLabel = new Label("Aucune coupe débloqué, retentez votre chance pour gagner une coupe");
            gameResult.getChildren().add(cupLabel);
        }
        gameResult.getChildren().add(exitToMenuButton);
        pane.setCenter(gameResult);
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
