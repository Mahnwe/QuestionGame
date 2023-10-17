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

    private final VBox vBox;
    private Button engButton;
    private Button frButton;
    private final BorderPane pane;

    public LanguageScene(BorderPane pane)
    {
        super(pane);
        this.pane = pane;
        pane.setPrefWidth(400);
        pane.setPrefHeight(400);

        vBox = new VBox();
        vBox.setTranslateX(100);
        vBox.setTranslateY(100);

        createButtons();

        createBackground();

        pane.setCenter(vBox);
    }

    public void createBackground()
    {
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        BackgroundCreator menuBackground = new BackgroundCreator(PathUtil.MENU_BACKGROUND);
        Image menuSceneBackground = menuBackground.createBackground();
        BackgroundImage backgroundImage = new BackgroundImage(menuSceneBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize);
        pane.setBackground(new Background(backgroundImage));
    }

    public void createButtons()
    {
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
    }

    public Button getEngButton() {
        return engButton;
    }

    public Button getFrButton() {
        return frButton;
    }
}
