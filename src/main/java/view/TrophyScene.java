package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
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

        IconCreator returnArrow = new IconCreator(PathUtil.BACK_ARROW);
        Image backArrow = returnArrow.createImage().getImage();

        HBox buttonHbox = new HBox();
        Button returnToMenu = new Button();
        Tooltip returnTooltip = new Tooltip(UtilStringStorage.returnButton);
        returnToMenu.setTooltip(returnTooltip);
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        returnToMenu.setBackground(new Background(new BackgroundImage(backArrow, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        returnToMenu.setPrefHeight(50);
        returnToMenu.setPrefWidth(50);
        buttonHbox.getChildren().add(returnToMenu);
        pane.setTop(buttonHbox);
        returnToMenu.setOnAction(event -> backToMainMenu());

        BackgroundCreator menuBackground = new BackgroundCreator(PathUtil.MENU_BACKGROUND);
        Image menuSceneBackground = menuBackground.createBackground();
        BackgroundImage backgroundImage = new BackgroundImage(menuSceneBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize);
        pane.setBackground(new Background(backgroundImage));

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
