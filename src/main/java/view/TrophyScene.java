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
        pane.setPrefWidth(1000);
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
        gridPane.setTranslateX(155);

        Label trophyLabel = new Label();
        trophyLabel.setText(UtilStringStorage.trophyLabel);
        trophyLabel.setFont(Font.font("Impact", FontWeight.BOLD, 25));
        trophyLabel.setTranslateX(330);
        trophyLabel.setTranslateY(20);

        VBox goldCupImages = new VBox();
        Label nbrOfGoldCupLabel = new Label();
        setUpVbox(goldCup, goldCupImages, nbrOfGoldCupLabel, -10, 5, UtilStringStorage.goldCupTrophy, cupFile, "goldCup");

        VBox silverCupImages = new VBox();
        Label nbrOfSilverCupLabel = new Label();
        setUpVbox(silverCup, silverCupImages, nbrOfSilverCupLabel, -20, 5, UtilStringStorage.silverCupTrophy, cupFile, "silverCup");

        VBox bronzeCupImages = new VBox();
        Label nbrOfBronzeCupLabel = new Label();
        setUpVbox(bronzeCup, bronzeCupImages, nbrOfBronzeCupLabel, -20, 5, UtilStringStorage.bronzeCupTrophy, cupFile, "bronzeCup");

        gridPane.add(goldCupImages, 0, 0);
        gridPane.add(silverCupImages, 1, 0);
        gridPane.add(bronzeCupImages, 2, 0);
        centralVbox.getChildren().add(trophyLabel);
        centralVbox.getChildren().add(gridPane);

        pane.setCenter(centralVbox);
    }

    public void setUpVbox(ImageView imageView, VBox vbox, Label label, int translateX, int translateY, String string, Properties properties, String propertyKey)
    {
        placeLabel(label, translateX, translateY);
        stylizeLabel(label, string, properties, propertyKey);
        vbox.getChildren().add(imageView);
        vbox.getChildren().add(label);
    }

    public void createReturnButton()
    {

        HBox buttonHbox = new HBox();
        ReturnButton returnButton = new ReturnButton();
        buttonHbox.getChildren().add(returnButton);
        pane.setTop(buttonHbox);
        returnButton.setOnAction(event -> backToMainMenu());
    }

    public void placeLabel(Label label, int translateX, int translateY)
    {
        label.setTranslateX(translateX);
        label.setTranslateY(translateY);
    }

    public void stylizeLabel(Label label, String string, Properties properties, String propertyKey)
    {
        label.setText(string +" "+ properties.getProperty(propertyKey));
        label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 17));
    }

    public void createIcons()
    {
        IconCreator goldCupImage = new IconCreator(PathUtil.GOLD_CUP_PATH);
        goldCup = goldCupImage.createImage();
        stylizeIcon(goldCup);

        IconCreator bronzeCupImage = new IconCreator(PathUtil.BRONZE_CUP_PATH);
        bronzeCup = bronzeCupImage.createImage();
        stylizeIcon(bronzeCup);

        IconCreator silverCupImage = new IconCreator(PathUtil.SILVER_CUP_PATH);
        silverCup = silverCupImage.createImage();
        stylizeIcon(silverCup);

    }

    public void stylizeIcon(ImageView imageView)
    {
        imageView.setFitHeight(120);
        imageView.setFitWidth(100);
    }
    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }
}
