package view.customvbox;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.CustomOption;
import view.scene.MenuScene;

public class StatsVbox extends VBox {

    Label statScoreLabel;

    public StatsVbox(String statsDescriptionLabel, String statsScoreLabel)
    {
        this.setPadding(new Insets(10.0, 5.0, 10.0, 5.0));
        this.setBorder(CustomOption.createCustomBorder(2.0, 2.0, Color.BLACK));
        Label statDescriptionLabel = new Label(statsDescriptionLabel);
        statDescriptionLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 23));

        statScoreLabel = new Label(statsScoreLabel);
        statScoreLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 25));
        statScoreLabel.setTranslateX(80);
        statScoreLabel.setTranslateY(10);

        this.getChildren().add(statDescriptionLabel);
        this.getChildren().add(statScoreLabel);
    }

    public Label getStatScoreLabel() {
        return statScoreLabel;
    }
}
