package View;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.AchievementManager;

public class AchievementScene extends Scene
{
    private final AchievementManager achievementManager;
    private Label goldCupAchievementSuccessMessage;

    public AchievementScene(TilePane tilePane, AchievementManager achievementManager) {

        super(tilePane);
        this.achievementManager = achievementManager;
        VBox achievementVBox = new VBox();

        Label goldCupAchievementLabel = new Label();
        goldCupAchievementLabel.setText(achievementManager.getAchievementsList().get(0).getConditionDescription());

        goldCupAchievementSuccessMessage = new Label();
        goldCupAchievementSuccessMessage.setText(achievementManager.getAchievementsList().get(0).getSuccessMessage());

        achievementVBox.getChildren().add(goldCupAchievementLabel);
        achievementVBox.getChildren().add(goldCupAchievementSuccessMessage);
        tilePane.getChildren().add(achievementVBox);

    }

    public void displayAchievementScene()
    {
        Stage stage = new Stage();
        stage.setTitle("Succés");
        stage.setMinWidth(400);
        stage.setMinHeight(400);
        stage.setScene(this);
        stage.show();
    }
}
