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
    private GridPane gridPane;

    public TrophyScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.pane = pane;
        pane.setPrefHeight(750);
        pane.setPrefWidth(1200);
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

        createGridPane();

        Label trophyLabel = new Label();
        stylizeTitleLabel(trophyLabel);

        VBox goldCupImages = new VBox();
        Label nbrOfGoldCupLabel = new Label();
        Label goldCupNumber = new Label();
        goldCupImages.getChildren().add(goldCup);
        if(UtilStringStorage.goldCupTrophy.equals("Coupe d'or :")) {
            setUpVbox(goldCupImages, nbrOfGoldCupLabel, 5, 25, UtilStringStorage.goldCupTrophy, FileUtil.generalSavesFile, "goldCup", goldCupNumber);
        } else {
            setUpVbox(goldCupImages, nbrOfGoldCupLabel, 20, 25, UtilStringStorage.goldCupTrophy, FileUtil.generalSavesFile, "goldCup", goldCupNumber);
        }
        goldCupImages.getChildren().add(goldCupNumber);
        goldCupImages.setTranslateX(-20);

        VBox silverCupImages = new VBox();
        Label nbrOfSilverCupLabel = new Label();
        Label silverCupNumber = new Label();
        silverCupImages.getChildren().add(silverCup);
        if(UtilStringStorage.silverCupTrophy.equals("Coupe d'argent :")) {
            setUpVbox(silverCupImages, nbrOfSilverCupLabel, -25, 25, UtilStringStorage.silverCupTrophy, FileUtil.generalSavesFile, "silverCup", silverCupNumber);
        } else {
            setUpVbox(silverCupImages, nbrOfSilverCupLabel, 0, 25, UtilStringStorage.silverCupTrophy, FileUtil.generalSavesFile, "silverCup", silverCupNumber);
        }
        silverCupImages.getChildren().add(silverCupNumber);

        VBox bronzeCupImages = new VBox();
        Label nbrOfBronzeCupLabel = new Label();
        Label bronzeCupNumber = new Label();
        bronzeCupImages.getChildren().add(bronzeCup);
        if(UtilStringStorage.bronzeCupTrophy.equals("Coupe de bronze :")) {
            setUpVbox(bronzeCupImages, nbrOfBronzeCupLabel, -35, 25, UtilStringStorage.bronzeCupTrophy, FileUtil.generalSavesFile, "bronzeCup", bronzeCupNumber);
        } else {
            setUpVbox(bronzeCupImages, nbrOfBronzeCupLabel, -5, 25, UtilStringStorage.bronzeCupTrophy, FileUtil.generalSavesFile, "bronzeCup", bronzeCupNumber);
        }
        bronzeCupImages.getChildren().add(bronzeCupNumber);

        gridPane.add(goldCupImages, 0, 0);
        gridPane.add(silverCupImages, 1, 0);
        gridPane.add(bronzeCupImages, 2, 0);
        gridPane.setTranslateX(130);

        centralVbox.getChildren().add(trophyLabel);
        centralVbox.getChildren().add(gridPane);

        pane.setCenter(centralVbox);
        centralVbox.setTranslateX(100);
        centralVbox.setTranslateY(70);
    }

    public void createGridPane()
    {
        gridPane = new GridPane();
        gridPane.setHgap(90);
        gridPane.setVgap(50);
        gridPane.setTranslateY(130);
        gridPane.setTranslateX(155);
    }

    public void stylizeTitleLabel(Label label)
    {
        label.setText(UtilStringStorage.trophyLabel);
        label.setFont(Font.font("Impact", FontWeight.BOLD, 30));
        label.setTranslateX(355);
        label.setTranslateY(10);
    }

    public void setUpVbox(VBox vbox, Label label, int translateX, int translateY, String string, Properties properties, String propertyKey, Label cupNumber)
    {
        placeLabel(label, translateX, translateY);
        stylizeLabel(label, string, properties, propertyKey, cupNumber);
        cupNumber.setTranslateX(80);
        cupNumber.setTranslateY(40);
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

    public void stylizeLabel(Label label, String string, Properties properties, String propertyKey, Label cupNumber)
    {
        label.setText(string +" ");
        cupNumber.setText(properties.getProperty(propertyKey));
        label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 23));
        cupNumber.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 25));
    }

    public void createIcons()
    {
        goldCup = IconCreator.createCupIcon(PathUtil.GOLD_CUP_PATH);
        goldCup.setTranslateY(10);
        goldCup.setTranslateX(10);

        bronzeCup = IconCreator.createCupIcon(PathUtil.BRONZE_CUP_PATH);
        bronzeCup.setTranslateY(10);
        bronzeCup.setTranslateX(10);

        silverCup = IconCreator.createCupIcon(PathUtil.SILVER_CUP_PATH);
        silverCup.setTranslateY(10);
        silverCup.setTranslateX(10);
    }
    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }
}
