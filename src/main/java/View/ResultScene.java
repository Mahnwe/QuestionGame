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

    public ResultScene(BorderPane pane, int playerFinalScore, int questionCount)
    {
        VBox gameResult = new VBox();

        createIcons();

        congratsLabel = new Label();
        playerResult = new Label();
        exitToMenuButton = new Button("Return to menu");

        gameResult.getChildren().add(congratsLabel);
        gameResult.getChildren().add(playerResult);
        if(playerFinalScore >= questionCount /2)
        {
            Label cupLabel = new Label("Vous avez gagné la coupe d'or !");
            gameResult.getChildren().add(cupLabel);
            gameResult.getChildren().add(goldCup);
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
