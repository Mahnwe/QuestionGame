package view.scene;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import util.*;
import view.customobject.LanguageButton;

public class LanguageScene extends Scene
{
    private VBox vBox;
    private final BorderPane pane;
    private final Stage stage;
    private final AchievementManager achievementManager;

    public LanguageScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.pane = pane;
        this.stage = stage;
        this.achievementManager = achievementManager;
        pane.setPrefWidth(750);
        pane.setPrefHeight(650);

        createTitleArea();
        setUpVbox();
        createBackground();
    }
    public void createTitleArea()
    {
        vBox = new VBox();
        vBox.setTranslateX(220);
        vBox.setTranslateY(100);

        IconCreator iconCreator = new IconCreator(PathUtil.LOGO_ICON);
        ImageView logoIcon = iconCreator.createImage();
        logoIcon.setFitWidth(400);
        logoIcon.setFitHeight(300);
        logoIcon.setTranslateY(-40);
        logoIcon.setTranslateX(-50);

        vBox.getChildren().add(logoIcon);
        pane.setCenter(vBox);
    }

    public void createBackground()
    {
        BackgroundImage backgroundImage = BackgroundCreator.createMenuBackground();
        pane.setBackground(new Background(backgroundImage));
    }

    public void setUpVbox()
    {
        UtilTranslateString utilTranslateString = new UtilTranslateString();

        VBox englishVbox = new VBox();
        createEngVbox(englishVbox, utilTranslateString);

        VBox frenchVbox = new VBox();
        createFrenchVbox(frenchVbox, utilTranslateString);

        vBox.getChildren().add(englishVbox);
        vBox.getChildren().add(frenchVbox);
    }

    public void createEngVbox(VBox vBox, UtilTranslateString utilTranslateString)
    {
        Label englishLabel = new Label("Choose a language");
        englishLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 20));

        LanguageButton engButton = new LanguageButton(PathUtil.ENGLISH_FLAG, UtilStringStorage.englishLanguageTooltip);
        engButton.setUpEnglishLanguageButton(engButton, utilTranslateString, stage, achievementManager, false);

        vBox.getChildren().add(englishLabel);
        vBox.getChildren().add(engButton);
        vBox.setTranslateY(10);
        vBox.setTranslateX(-100);
    }

    public void createFrenchVbox(VBox vBox, UtilTranslateString utilTranslateString)
    {
        Label frenchLabel = new Label("Choisissez une langue");
        frenchLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 20));

        LanguageButton frButton = new LanguageButton(PathUtil.FRENCH_FLAG, UtilStringStorage.frenchLanguageTooltip);
        frButton.setUpFrenchLanguageButton(frButton, utilTranslateString, stage, achievementManager, false);

        vBox.getChildren().add(frenchLabel);
        vBox.getChildren().add(frButton);
        vBox.setTranslateX(200);
        vBox.setTranslateY(-91);
    }
}
