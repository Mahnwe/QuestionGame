package View;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.AchievementManager;

public class AchievementScene extends Scene
{
    private StringProperty valueOfSuccess = new SimpleStringProperty();

    public AchievementScene(TilePane tilePane, AchievementManager achievementManager) {

        super(tilePane);
        for(int i = 0; i < achievementManager.getAchievementsList().size(); i++)
        {
            if(achievementManager.getAchievementsList().get(i).isUnlock())
            {
                String unlockValue = "Succés obtenu";
                valueOfSuccess.setValue(unlockValue);
            }
            else
            {
                String startingValue = "Succés vérouillé";
                valueOfSuccess.setValue(startingValue);
            }
        }
            VBox achievementVBox = new VBox();

        Label goldCupAchievementLabel = new Label();
        goldCupAchievementLabel.setText(achievementManager.getAchievementsList().get(0).getConditionDescription());

        Label goldCupAchievementInfo = new Label();
        goldCupAchievementInfo.textProperty().bind(valueOfSuccess);
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
}
