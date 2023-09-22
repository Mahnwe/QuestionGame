package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import model.IconCreator;
import model.PathUtil;
import model.UtilStringStorage;

import java.io.File;

public class TrophyScene extends Scene
{
    private ImageView goldCup;
    private ImageView bronzeCup;
    private ImageView silverCup;
    private final Stage stage;
    private final AchievementManager achievementManager;

    public TrophyScene(BorderPane pane, TrophyHandler trophyHandler, Stage stage, AchievementManager achievementManager, File goldCupFile, File silverCupFile, File bronzeCupFile)
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
        nbrOfGoldCupLabel.setText(String.valueOf(trophyHandler.readInCupFile(goldCupFile)));
        nbrOfGoldCupLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        placeLabel(nbrOfGoldCupLabel, 10, 50);

        Label nbrOfSilverCupLabel = new Label();
        nbrOfSilverCupLabel.setText(String.valueOf(trophyHandler.readInCupFile(silverCupFile)));
        nbrOfSilverCupLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        placeLabel(nbrOfSilverCupLabel, 10, 150);

        Label nbrOfBronzeCupLabel = new Label();
        nbrOfBronzeCupLabel.setText(String.valueOf(trophyHandler.readInCupFile(bronzeCupFile)));
        nbrOfBronzeCupLabel.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
        placeLabel(nbrOfBronzeCupLabel, 10, 250);

        nbrOfCups.getChildren().add(nbrOfGoldCupLabel);
        nbrOfCups.getChildren().add(nbrOfSilverCupLabel);
        nbrOfCups.getChildren().add(nbrOfBronzeCupLabel);
        pane.setCenter(nbrOfCups);

        HBox buttonHbox = new HBox();
        buttonHbox.setPrefHeight(50);
        Button returnToMenu = new Button(UtilStringStorage.RETURN_BUTTON);
        buttonHbox.getChildren().add(returnToMenu);
        pane.setTop(buttonHbox);
        returnToMenu.setOnAction(event -> backToMainMenu());

    }

    public void placeLabel(Label label, int x, int y)
    {
        label.setTranslateX(x);
        label.setTranslateY(y);
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
