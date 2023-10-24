package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.BackgroundCreator;
import util.IconCreator;
import util.PathUtil;

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
        pane.setPrefWidth(500);
        pane.setPrefHeight(400);

        vBox = new VBox();
        vBox.setTranslateX(100);
        vBox.setTranslateY(100);
        Label launcherLabel = new Label("Launcher");
        launcherLabel.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, 25));
        launcherLabel.setTranslateX(85);
        vBox.getChildren().add(launcherLabel);

        createButtons();

        createBackground();

        pane.setCenter(vBox);
    }

    public void createBackground()
    {
        BackgroundImage backgroundImage = BackgroundCreator.createMenuBackground();
        pane.setBackground(new Background(backgroundImage));
    }

    public void createButtons()
    {
        VBox englishVbox = new VBox();
        Label englishLabel = new Label("Choose a language");
        englishLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        engButton = new Button();
        IconCreator englishIcon = new IconCreator(PathUtil.ENGLISH_FLAG);
        Image englishFlag = englishIcon.createImage().getImage();
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        engButton.setBackground(new Background(new BackgroundImage(englishFlag, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        engButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        engButton.setMinWidth(60);
        engButton.setMinHeight(35);
        engButton.setTranslateX(40);
        engButton.setTranslateY(10);
        englishVbox.getChildren().add(englishLabel);
        englishVbox.getChildren().add(engButton);
        englishVbox.setTranslateY(80);
        englishVbox.setTranslateX(-50);

        VBox frenchVbox = new VBox();
        Label frenchLabel = new Label("Choisissez une langue");
        frenchLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        frButton = new Button();
        IconCreator frenchIcon = new IconCreator(PathUtil.FRENCH_FLAG);
        Image frenchFlag = frenchIcon.createImage().getImage();
        frButton.setBackground(new Background(new BackgroundImage(frenchFlag, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        frButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        frButton.setMinWidth(60);
        frButton.setMinHeight(35);
        frButton.setTranslateX(40);
        frButton.setTranslateY(10);
        frenchVbox.getChildren().add(frenchLabel);
        frenchVbox.getChildren().add(frButton);
        frenchVbox.setTranslateX(170);
        frenchVbox.setTranslateY(27);

        vBox.getChildren().add(englishVbox);
        vBox.getChildren().add(frenchVbox);
    }

    public Button getEngButton() {
        return engButton;
    }

    public Button getFrButton() {
        return frButton;
    }
}
