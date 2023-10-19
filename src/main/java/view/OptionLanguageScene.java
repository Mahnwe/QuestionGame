package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.*;

import java.io.File;
import java.util.Properties;

public class OptionLanguageScene extends Scene
{

    private final AchievementManager achievementManager;
    private final Stage stage;
    private final File saveFile;
    private final Properties cupFile;
    private final Properties perfectFile;
    private final BorderPane pane;
    private Button engButton;
    private Button frButton;
    private final VBox vBox;

    public OptionLanguageScene(BorderPane pane, Stage stage, AchievementManager achievementManager, File saveFile, Properties cupFile, Properties perfectFile)
    {
        super(pane);
        this.pane = pane;
        this.stage = stage;
        this.achievementManager = achievementManager;
        this.saveFile = saveFile;
        this.cupFile = cupFile;
        this.perfectFile = perfectFile;
        pane.setPrefWidth(400);
        pane.setPrefHeight(200);

        vBox = new VBox();
        vBox.setTranslateX(100);
        vBox.setTranslateY(10);

        createReturnButton();
        createSceneBackground();
        createButtons();

    }

    public void createSceneBackground()
    {
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        BackgroundCreator menuBackground = new BackgroundCreator(PathUtil.MENU_BACKGROUND);
        Image menuSceneBackground = menuBackground.createBackground();
        BackgroundImage backgroundImage = new BackgroundImage(menuSceneBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize);
        pane.setBackground(new Background(backgroundImage));
    }

    public void createReturnButton()
    {
        IconCreator returnArrow = new IconCreator(PathUtil.BACK_ARROW);
        Image backArrow = returnArrow.createImage().getImage();

        HBox hBox = new HBox();
        Button returnToOptionButton = new Button();
        Tooltip returnTooltip = new Tooltip(UtilStringStorage.returnButton);
        returnToOptionButton.setTooltip(returnTooltip);
        returnToOptionButton.setPrefHeight(50);
        returnToOptionButton.setPrefWidth(50);
        hBox.getChildren().add(returnToOptionButton);

        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        returnToOptionButton.setBackground(new Background(new BackgroundImage(backArrow, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));

        pane.setTop(hBox);
        returnToOptionButton.setOnAction(event -> backToOption());
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
        pane.setCenter(vBox);
    }

    public void backToOption()
    {
        OptionScene optionScene = new OptionScene(new BorderPane(), stage, achievementManager, saveFile, cupFile, perfectFile);
        stage.setScene(optionScene);
    }

    public Button getEngButton() {
        return engButton;
    }

    public Button getFrButton() {
        return frButton;
    }

}
