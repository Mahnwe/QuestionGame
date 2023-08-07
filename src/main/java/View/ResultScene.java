package View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ResultScene extends VBox
{
    private final Button exitToMenuButton;
    private final Label congratsLabel;
    private final Label playerResult;

    public ResultScene(BorderPane pane)
    {
        VBox gameResult = new VBox();

        congratsLabel = new Label();
        playerResult = new Label();
        exitToMenuButton = new Button("Return to menu");

        gameResult.getChildren().add(congratsLabel);
        gameResult.getChildren().add(playerResult);
        gameResult.getChildren().add(exitToMenuButton);
        pane.setCenter(gameResult);
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
