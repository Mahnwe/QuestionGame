package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.AchievementManager;
import model.IconCreator;
import model.PathUtil;

public class TrophyScene extends Scene
{
    private ImageView goldCup;
    private ImageView bronzeCup;
    private ImageView silverCup;
    private final Stage stage;
    private final AchievementManager achievementManager;

    public TrophyScene(BorderPane pane, TrophyHandler trophyHandler, Stage stage, AchievementManager achievementManager)
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

        TextArea nbrOfGoldCup = new TextArea();
        setUpCupTextArea(nbrOfGoldCup, String.valueOf(trophyHandler.ReadInGoldCupFile()));

        TextArea nbrOfSilverCup = new TextArea();
        setUpCupTextArea(nbrOfSilverCup, String.valueOf(trophyHandler.ReadInSilverCupFile()));

        TextArea nbrOfBronzeCup = new TextArea();
        setUpCupTextArea(nbrOfBronzeCup, String.valueOf(trophyHandler.ReadInBronzeCupFile()));

        nbrOfCups.getChildren().add(nbrOfGoldCup);
        nbrOfCups.getChildren().add(nbrOfSilverCup);
        nbrOfCups.getChildren().add(nbrOfBronzeCup);
        pane.setCenter(nbrOfCups);

        HBox buttonHbox = new HBox();
        buttonHbox.setPrefHeight(50);
        Button returnToMenu = new Button("Retour");
        buttonHbox.getChildren().add(returnToMenu);
        pane.setTop(buttonHbox);
        returnToMenu.setOnAction(event -> backToMainMenu());

    }

    public void setUpCupTextArea(TextArea textArea, String string)
    {
        textArea.setMaxHeight(120);
        textArea.setEditable(false);
        textArea.setText(string);
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
