package view;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.AchievementManager;

public class AchievementVbox {

    public static void setAchievementVbox (VBox vBox, Label titleLabel, AchievementManager achievementManager, int indexAchievement, Label infoLabel)
    {
        titleLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.NORMAL, 18));

        ImageView achievementImage = achievementManager.getAchievementsList().get(indexAchievement).getLockImageView();

        infoLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.NORMAL, 18));

        vBox.getChildren().add(titleLabel);
        vBox.getChildren().add(achievementImage);
        vBox.getChildren().add(infoLabel);
    }
}
