package view;

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
        pane.setPrefWidth(750);
        pane.setPrefHeight(650);

        createTitleArea();

        createButtons();
        setUpButton();

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

    public void createButtons()
    {
        VBox englishVbox = new VBox();
        Label englishLabel = new Label("Choose a language");
        englishLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 20));

        engButton = new LanguageButton(PathUtil.ENGLISH_FLAG, UtilStringStorage.englishLanguageTooltip);

        englishVbox.getChildren().add(englishLabel);
        englishVbox.getChildren().add(engButton);
        englishVbox.setTranslateY(10);
        englishVbox.setTranslateX(-100);

        VBox frenchVbox = new VBox();
        Label frenchLabel = new Label("Choisissez une langue");
        frenchLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 20));

        frButton = new LanguageButton(PathUtil.FRENCH_FLAG, UtilStringStorage.frenchLanguageTooltip);

        frenchVbox.getChildren().add(frenchLabel);
        frenchVbox.getChildren().add(frButton);
        frenchVbox.setTranslateX(200);
        frenchVbox.setTranslateY(-91);

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
            stage.setMinHeight(750);
            stage.setMinWidth(1200);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });

        frButton.setOnAction(event -> {
            utilTranslateString.translateFrString();
            App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(750);
            stage.setMinWidth(1200);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });
    }
}
