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

public class AchievementScene extends Scene
{
    private StringProperty valueOfSuccess = new SimpleStringProperty();
    private final Stage stage;
    private Label goldCupAchievementInfo;

    public AchievementScene(BorderPane pane, AchievementManager achievementManager, Stage stage)
    {
        super(pane);
        pane.setPrefHeight(500);
        pane.setPrefWidth(900);
        this.stage = stage;

        TilePane tilePane = new TilePane();
        VBox achievementVBox = new VBox();

        Label goldCupAchievementLabel = new Label();
        goldCupAchievementLabel.setText(achievementManager.getAchievementsList().get(0).getConditionDescription());

        goldCupAchievementInfo = new Label();
        //goldCupAchievementInfo.textProperty().bind(valueOfSuccess);

        achievementVBox.getChildren().add(goldCupAchievementLabel);
        achievementVBox.getChildren().add(goldCupAchievementInfo);
        tilePane.getChildren().add(achievementVBox);
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
        MenuScene menuScene = new MenuScene(new BorderPane(), stage);
        stage.setScene(menuScene);
    }

    public void checkIfAchievementIsUnlock(Achievement achievement)
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
        goldCupAchievementInfo.setText(unlockValue);
        System.out.println(goldCupAchievementInfo);
    }
}
