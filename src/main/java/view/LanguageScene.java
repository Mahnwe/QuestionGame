package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.BackgroundCreator;
import model.PathUtil;

public class LanguageScene extends Scene
{

    private final Button engButton;
    private final Button frButton;

    public LanguageScene(BorderPane pane)
    {
        super(pane);
        pane.setPrefWidth(400);
        pane.setPrefHeight(400);

        VBox vBox = new VBox();
        vBox.setTranslateX(100);
        vBox.setTranslateY(100);


        Label englishLabel = new Label("Choose a language");
        englishLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        engButton = new Button("English");
        engButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        engButton.setMinWidth(60);
        engButton.setTranslateX(20);

        Label frenchLabel = new Label("Choisissez une langue");
        frenchLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        frenchLabel.setTranslateY(50);
        frButton = new Button("Francais");
        frButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        frButton.setMinWidth(60);
        frButton.setTranslateY(50);
        frButton.setTranslateX(20);


        vBox.getChildren().add(englishLabel);
        vBox.getChildren().add(engButton);
        vBox.getChildren().add(frenchLabel);
        vBox.getChildren().add(frButton);

        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        BackgroundCreator menuBackground = new BackgroundCreator(PathUtil.MENU_BACKGROUND);
        Image menuSceneBackground = menuBackground.createBackground();
        BackgroundImage backgroundImage = new BackgroundImage(menuSceneBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize);
        pane.setBackground(new Background(backgroundImage));

        pane.setCenter(vBox);
    }

    public Button getEngButton() {
        return engButton;
    }

    public Button getFrButton() {
        return frButton;
    }
}
