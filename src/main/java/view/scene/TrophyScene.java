package view.scene;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.handlers.AchievementManager;
import util.*;
import util.creators.BackgroundCreator;
import util.creators.IconCreator;
import util.stringutiltranslate.UtilStringStorage;
import view.bootstrap.BootstrapPane;
import view.customobject.ReturnButton;

import java.util.Properties;

public class TrophyScene extends Scene
{
    private ImageView goldCup;
    private ImageView bronzeCup;
    private ImageView silverCup;
    private ImageView secretCup;
    private VBox goldCupImage;
    private VBox silverCupImage;
    private VBox bronzeCupImage;
    private VBox secretCupImage;
    private final Stage stage;
    private final AchievementManager achievementManager;
    private final BorderPane pane;
    private BootstrapPane gridPane;
    public static boolean allAchievementAreUnlocked;

    public TrophyScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.pane = pane;
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

        gridPane = new BootstrapPane(4);
        gridPane.setHgap(10);
        gridPane.setVgap(200);

        createGoldVbox();
        createSilverVbox();
        createBronzeVbox();
        createSecretVbox();

        setUpGridPane();
        centralVbox.getChildren().add(gridPane);
        pane.setCenter(centralVbox);
        centralVbox.setTranslateY(120);
    }

    public void createGoldVbox()
    {
        goldCupImage = new VBox();

        Label nbrOfGoldCupLabel = new Label();
        Label goldCupNumber = new Label();

        goldCupImage.getChildren().add(goldCup);
        setUpVbox(goldCupImage, nbrOfGoldCupLabel, 0, 25, UtilStringStorage.goldCupTrophy, FileUtil.getGeneralSavesFile(), "goldCup", goldCupNumber);
        goldCupImage.getChildren().add(goldCupNumber);
    }
    public void createSilverVbox()
    {
        silverCupImage = new VBox();

        Label nbrOfSilverCupLabel = new Label();
        Label silverCupNumber = new Label();

        silverCupImage.getChildren().add(silverCup);
        silverCup.setTranslateX(10);
        setUpVbox(silverCupImage, nbrOfSilverCupLabel, 0, 25, UtilStringStorage.silverCupTrophy, FileUtil.getGeneralSavesFile(), "silverCup", silverCupNumber);
        silverCupImage.getChildren().add(silverCupNumber);
    }
    public void createBronzeVbox()
    {
        bronzeCupImage = new VBox();

        Label nbrOfBronzeCupLabel = new Label();
        Label bronzeCupNumber = new Label();

        bronzeCupImage.getChildren().add(bronzeCup);
        setUpVbox(bronzeCupImage, nbrOfBronzeCupLabel, 0, 25, UtilStringStorage.bronzeCupTrophy, FileUtil.getGeneralSavesFile(), "bronzeCup", bronzeCupNumber);
        bronzeCupImage.getChildren().add(bronzeCupNumber);
    }

    public void createSecretVbox()
    {
        secretCupImage = new VBox();

        Label nbrOfSecretCupLabel = new Label();
        Label secretCupNumber = new Label();

        secretCupImage.getChildren().add(secretCup);
        setUpVbox(secretCupImage, nbrOfSecretCupLabel, 0, 25, UtilStringStorage.secretCupTrophy, FileUtil.getGeneralSavesFile(), "secretCup", secretCupNumber);
        secretCupImage.getChildren().add(secretCupNumber);
    }

    public void setUpGridPane()
    {
        Label trophyLabel = new Label();
        stylizeTitleLabel(trophyLabel);
        gridPane.add(trophyLabel, 1, 0);

        gridPane.add(goldCupImage, 0, 1);
        goldCupImage.setTranslateX(25);

        gridPane.add(silverCupImage, 1, 1);
        silverCupImage.setTranslateX(-30);

        gridPane.add(bronzeCupImage, 2, 1);
        bronzeCupImage.setTranslateX(-25);

        gridPane.add(secretCupImage, 3, 1);
        secretCupImage.setTranslateX(-10);

        gridPane.setTranslateX(80);
    }

    public void stylizeTitleLabel(Label label)
    {
        label.setText(UtilStringStorage.trophyLabel);
        label.setFont(Font.font("Impact", FontWeight.BOLD, 40));
        label.setTranslateX(150);
    }

    public void setUpVbox(VBox vBox, Label label, int translateX, int translateY, String string, Properties properties, String propertyKey, Label cupNumber)
    {
        placeLabel(label, translateX, translateY);
        stylizeLabel(label, string, properties, propertyKey, cupNumber);
        cupNumber.setTranslateX(80);
        cupNumber.setTranslateY(40);
        vBox.getChildren().add(label);
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
        label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 26));
        cupNumber.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 28));
    }

    public void createIcons()
    {
        goldCup = IconCreator.createCupIcon(PathUtil.GOLD_CUP_PATH);
        goldCup.setTranslateY(10);

        bronzeCup = IconCreator.createCupIcon(PathUtil.BRONZE_CUP_PATH);
        bronzeCup.setTranslateY(10);

        silverCup = IconCreator.createCupIcon(PathUtil.SILVER_CUP_PATH);
        silverCup.setTranslateY(10);

        if(!allAchievementAreUnlocked)
        {
            secretCup = IconCreator.createCupIcon(PathUtil.PLACE_HOLDER_CUP);
        } else
        {
            secretCup = IconCreator.createCupIcon(PathUtil.SECRET_CUP);
        }
        secretCup.setFitWidth(180);
        secretCup.setTranslateY(10);
    }
    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }

    public static void setAllAchievementAreUnlocked(boolean allAchievementAreUnlocked)
    {
        TrophyScene.allAchievementAreUnlocked = allAchievementAreUnlocked;
    }
}
