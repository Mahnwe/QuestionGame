package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.*;

import java.util.Properties;

public class TrophyScene extends Scene
{
    private ImageView goldCup;
    private ImageView bronzeCup;
    private ImageView silverCup;
    private final Stage stage;
    private final AchievementManager achievementManager;

    public TrophyScene(BorderPane pane, Stage stage, AchievementManager achievementManager, Properties cupFile)
    {
        super(pane);
        pane.setPrefHeight(500);
        pane.setPrefWidth(900);
        this.stage = stage;
        this.achievementManager = achievementManager;
        createIcons();

        VBox cupsImages = new VBox();
        cupsImages.getChildren().add(goldCup);
        goldCup.setTranslateY(10);
        cupsImages.getChildren().add(silverCup);
        silverCup.setTranslateY(30);
        cupsImages.getChildren().add(bronzeCup);
        bronzeCup.setTranslateY(50);

        pane.setLeft(cupsImages);

        VBox nbrOfCups = new VBox();

        Label nbrOfGoldCupLabel = new Label();
        stylizeLabel(nbrOfGoldCupLabel, UtilStringStorage.goldCupTrophy, cupFile, "goldCup", 20, 50);

        Label nbrOfSilverCupLabel = new Label();
        stylizeLabel(nbrOfSilverCupLabel, UtilStringStorage.silverCupTrophy, cupFile, "silverCup", 20, 150);

        Label nbrOfBronzeCupLabel = new Label();
        stylizeLabel(nbrOfBronzeCupLabel, UtilStringStorage.bronzeCupTrophy, cupFile, "bronzeCup", 20, 250);

        nbrOfCups.getChildren().add(nbrOfGoldCupLabel);
        nbrOfCups.getChildren().add(nbrOfSilverCupLabel);
        nbrOfCups.getChildren().add(nbrOfBronzeCupLabel);
        pane.setCenter(nbrOfCups);

        HBox buttonHbox = new HBox();
        buttonHbox.setPrefHeight(50);
        Button returnToMenu = new Button(UtilStringStorage.returnButton);
        returnToMenu.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        buttonHbox.getChildren().add(returnToMenu);
        pane.setTop(buttonHbox);
        returnToMenu.setOnAction(event -> backToMainMenu());

        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        BackgroundCreator menuBackground = new BackgroundCreator(PathUtil.MENU_BACKGROUND);
        Image menuSceneBackground = menuBackground.createBackground();
        BackgroundImage backgroundImage = new BackgroundImage(menuSceneBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize);
        pane.setBackground(new Background(backgroundImage));

    }

    public void placeLabel(Label label, int x, int y)
    {
        label.setTranslateX(x);
        label.setTranslateY(y);
    }

    public void stylizeLabel(Label label, String string, Properties properties, String propertyKey, int translateX, int translateY)
    {
        label.setText(string +" "+ properties.getProperty(propertyKey));
        label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        placeLabel(label, translateX, translateY);
    }

    public void createIcons()
    {
        IconCreator goldCupImage = new IconCreator(PathUtil.GOLD_CUP_PATH);
        goldCup = goldCupImage.createImage();
        goldCup.setFitHeight(100);
        goldCup.setFitWidth(80);

        IconCreator bronzeCupImage = new IconCreator(PathUtil.BRONZE_CUP_PATH);
        bronzeCup = bronzeCupImage.createImage();
        bronzeCup.setFitHeight(100);
        bronzeCup.setFitWidth(80);

        IconCreator silverCupImage = new IconCreator(PathUtil.SILVER_CUP_PATH);
        silverCup = silverCupImage.createImage();
        silverCup.setFitHeight(100);
        silverCup.setFitWidth(80);
    }
    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }
}
