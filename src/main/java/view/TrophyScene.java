package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import util.*;

import java.util.Properties;

public class TrophyScene extends Scene
{
    private ImageView goldCup;
    private ImageView bronzeCup;
    private ImageView silverCup;
    private final Stage stage;
    private final AchievementManager achievementManager;
    private final BorderPane pane;

    private final Properties cupFile;

    public TrophyScene(BorderPane pane, Stage stage, AchievementManager achievementManager, Properties cupFile)
    {
        super(pane);
        this.pane = pane;
        this.cupFile = cupFile;
        pane.setPrefHeight(500);
        pane.setPrefWidth(900);
        this.stage = stage;
        this.achievementManager = achievementManager;

        createIcons();
        createCupboardTrophy();
        createReturnButton();

        createBackground();

    }

    public void createBackground()
    {
        BackgroundImage backgroundImage = BackgroundCreator.createMenuBackground();
        pane.setBackground(new Background(backgroundImage));
    }

    public void createCupboardTrophy()
    {
        VBox centralVbox = new VBox();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(90);
        gridPane.setVgap(50);
        gridPane.setTranslateY(110);
        gridPane.setTranslateX(135);

        Label trophyLabel = new Label();
        trophyLabel.setText(UtilStringStorage.trophyLabel);
        trophyLabel.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, 25));
        trophyLabel.setTranslateX(310);
        trophyLabel.setTranslateY(20);

        VBox goldCupImages = new VBox();
        Label nbrOfGoldCupLabel = new Label();
        nbrOfGoldCupLabel.setTranslateX(-12);
        stylizeLabel(nbrOfGoldCupLabel, UtilStringStorage.goldCupTrophy, cupFile, "goldCup");
        goldCupImages.getChildren().add(goldCup);
        goldCupImages.getChildren().add(nbrOfGoldCupLabel);

        VBox silverCupImages = new VBox();
        Label nbrOfSilverCupLabel = new Label();
        nbrOfSilverCupLabel.setTranslateX(-20);
        stylizeLabel(nbrOfSilverCupLabel, UtilStringStorage.silverCupTrophy, cupFile, "silverCup");
        silverCupImages.getChildren().add(silverCup);
        silverCupImages.getChildren().add(nbrOfSilverCupLabel);

        VBox bronzeCupImages = new VBox();
        Label nbrOfBronzeCupLabel = new Label();
        nbrOfBronzeCupLabel.setTranslateX(-20);
        stylizeLabel(nbrOfBronzeCupLabel, UtilStringStorage.bronzeCupTrophy, cupFile, "bronzeCup");
        bronzeCupImages.getChildren().add(bronzeCup);
        bronzeCupImages.getChildren().add(nbrOfBronzeCupLabel);

        gridPane.add(goldCupImages, 0, 0);
        gridPane.add(silverCupImages, 1, 0);
        gridPane.add(bronzeCupImages, 2, 0);
        centralVbox.getChildren().add(trophyLabel);
        centralVbox.getChildren().add(gridPane);

        pane.setCenter(centralVbox);
    }

    public void createReturnButton()
    {

        HBox buttonHbox = new HBox();
        ReturnButton returnButton = new ReturnButton();
        buttonHbox.getChildren().add(returnButton);
        pane.setTop(buttonHbox);
        returnButton.setOnAction(event -> backToMainMenu());
    }

    public void stylizeLabel(Label label, String string, Properties properties, String propertyKey)
    {
        label.setText(string +" "+ properties.getProperty(propertyKey));
        label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 17));
    }

    public void createIcons()
    {
        IconCreator goldCupImage = new IconCreator(PathUtil.GOLD_CUP_PATH);
        goldCup = goldCupImage.createImage();
        goldCup.setFitHeight(120);
        goldCup.setFitWidth(100);

        IconCreator bronzeCupImage = new IconCreator(PathUtil.BRONZE_CUP_PATH);
        bronzeCup = bronzeCupImage.createImage();
        bronzeCup.setFitHeight(120);
        bronzeCup.setFitWidth(100);

        IconCreator silverCupImage = new IconCreator(PathUtil.SILVER_CUP_PATH);
        silverCup = silverCupImage.createImage();
        silverCup.setFitHeight(120);
        silverCup.setFitWidth(100);
    }
    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }
}
