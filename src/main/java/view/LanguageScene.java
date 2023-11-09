package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import model.SoundManager;
import util.*;

public class LanguageScene extends Scene
{

    private VBox vBox;
    private LanguageButton engButton;
    private LanguageButton frButton;
    private final BorderPane pane;
    private final Stage stage;
    private final AchievementManager achievementManager;

    public LanguageScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.pane = pane;
        this.stage = stage;
        this.achievementManager = achievementManager;
        pane.setPrefWidth(500);
        pane.setPrefHeight(400);

        createTitleArea();

        createButtons();
        setUpButton();

        createBackground();

    }

    public void createTitleArea()
    {
        vBox = new VBox();
        vBox.setTranslateX(100);
        vBox.setTranslateY(100);
        Label launcherLabel = new Label("LOGO");
        launcherLabel.setFont(Font.font("Impact", FontWeight.BOLD, 25));
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
        englishLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 15));

        engButton = new LanguageButton(PathUtil.ENGLISH_FLAG, UtilStringStorage.englishLanguageTooltip);

        englishVbox.getChildren().add(englishLabel);
        englishVbox.getChildren().add(engButton);
        englishVbox.setTranslateY(80);
        englishVbox.setTranslateX(-50);

        VBox frenchVbox = new VBox();
        Label frenchLabel = new Label("Choisissez une langue");
        frenchLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 15));

        frButton = new LanguageButton(PathUtil.FRENCH_FLAG, UtilStringStorage.frenchLanguageTooltip);

        frenchVbox.getChildren().add(frenchLabel);
        frenchVbox.getChildren().add(frButton);
        frenchVbox.setTranslateX(170);
        frenchVbox.setTranslateY(12.5);

        vBox.getChildren().add(englishVbox);
        vBox.getChildren().add(frenchVbox);
    }

    public void setUpButton()
    {
        UtilTranslateString utilTranslateString = new UtilTranslateString();
        engButton.setOnAction(event -> {
            utilTranslateString.translateEngString();
            App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(550);
            stage.setMinWidth(1000);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });

        frButton.setOnAction(event -> {
            utilTranslateString.translateFrString();
            App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(550);
            stage.setMinWidth(1000);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });
    }
}
