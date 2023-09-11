package View;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.AchievementManager;

public class AchievementScene extends Scene
{
    public Label goldCupAchievementInfo;

    public AchievementScene(TilePane tilePane, AchievementManager achievementManager) {

        super(tilePane);
        VBox achievementVBox = new VBox();

        Label goldCupAchievementLabel = new Label();
        goldCupAchievementLabel.setText(achievementManager.getAchievementsList().get(0).getConditionDescription());

        goldCupAchievementInfo = new Label();
        goldCupAchievementInfo.setText(achievementManager.getAchievementsList().get(0).getSuccessMessage());
        goldCupAchievementInfo.setVisible(false);
        System.out.println(goldCupAchievementInfo);

        achievementVBox.getChildren().add(goldCupAchievementLabel);
        achievementVBox.getChildren().add(goldCupAchievementInfo);
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

    public Label getGoldCupAchievementInfo() {
        return goldCupAchievementInfo;
    }
}
