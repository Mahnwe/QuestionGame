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
import model.handlers.AchievementManager;
import util.*;
import util.creators.BackgroundCreator;
import util.creators.IconCreator;
import util.stringUtilTranslate.UtilStringStorage;
import util.stringUtilTranslate.UtilTranslateString;
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

        createTitleArea();
        setUpVbox();
        createBackground();
    }
    public void createTitleArea()
    {
        vBox = new VBox();
        vBox.setTranslateX(650);
        vBox.setTranslateY(170);

        IconCreator iconCreator = new IconCreator(PathUtil.LOGO_ICON);
        ImageView logoIcon = iconCreator.createImage();
        logoIcon.setFitWidth(510);
        logoIcon.setFitHeight(410);

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

        VBox languageVbox = new VBox();
        languageVbox.setTranslateX(100);
        languageVbox.setTranslateY(80);

        languageVbox.getChildren().add(englishVbox);
        languageVbox.getChildren().add(frenchVbox);

        vBox.getChildren().add(languageVbox);
    }

    public void createEngVbox(VBox vBox, UtilTranslateString utilTranslateString)
    {
        Label englishLabel = new Label("Choose a language");
        englishLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 24));

        LanguageButton engButton = new LanguageButton(PathUtil.ENGLISH_FLAG, UtilStringStorage.englishLanguageTooltip);
        engButton.setUpEnglishLanguageButton(engButton, utilTranslateString, stage, achievementManager, false);

        vBox.getChildren().add(englishLabel);
        vBox.getChildren().add(engButton);
        vBox.setTranslateY(10);
        vBox.setTranslateX(-160);
    }

    public void createFrenchVbox(VBox vBox, UtilTranslateString utilTranslateString)
    {
        Label frenchLabel = new Label("Choisissez une langue");
        frenchLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 24));

        LanguageButton frButton = new LanguageButton(PathUtil.FRENCH_FLAG, UtilStringStorage.frenchLanguageTooltip);
        frButton.setUpFrenchLanguageButton(frButton, utilTranslateString, stage, achievementManager, false);

        vBox.getChildren().add(frenchLabel);
        vBox.getChildren().add(frButton);
        vBox.setTranslateX(230);
        vBox.setTranslateY(-105);
    }
}
