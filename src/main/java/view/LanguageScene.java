package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.BackgroundCreator;
import util.LanguageButton;
import util.PathUtil;

public class LanguageScene extends Scene
{

    private VBox vBox;
    private LanguageButton engButton;
    private LanguageButton frButton;
    private final BorderPane pane;

    public LanguageScene(BorderPane pane)
    {
        super(pane);
        this.pane = pane;
        pane.setPrefWidth(500);
        pane.setPrefHeight(400);

        createTitleArea();

        createButtons();

        createBackground();

    }

    public void createTitleArea()
    {
        vBox = new VBox();
        vBox.setTranslateX(100);
        vBox.setTranslateY(100);
        Label launcherLabel = new Label("Launcher");
        launcherLabel.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, 25));
        launcherLabel.setTranslateX(85);
        vBox.getChildren().add(launcherLabel);
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

        engButton = new LanguageButton(PathUtil.ENGLISH_FLAG);

        englishVbox.getChildren().add(englishLabel);
        englishVbox.getChildren().add(engButton);
        englishVbox.setTranslateY(80);
        englishVbox.setTranslateX(-50);

        VBox frenchVbox = new VBox();
        Label frenchLabel = new Label("Choisissez une langue");
        frenchLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));

        frButton = new LanguageButton(PathUtil.FRENCH_FLAG);

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
