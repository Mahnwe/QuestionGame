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
    private ImageView goldCupImage;
    private ImageView bronzeCupImage;
    private ImageView silverCupImage;
    private ImageView secretCupImage;
    private VBox goldCupVbox;
    private VBox silverCupVbox;
    private VBox bronzeCupVbox;
    private VBox secretCupVbox;
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
        goldCupVbox = new VBox();

        Label nbrOfGoldCupLabel = new Label();
        Label goldCupNumber = new Label();

        goldCupVbox.getChildren().add(goldCupImage);
        setUpVbox(goldCupVbox, nbrOfGoldCupLabel, UtilStringStorage.goldCupTrophy, FileUtil.getGeneralSavesFile(), "goldCup", goldCupNumber);
        goldCupVbox.getChildren().add(goldCupNumber);
    }
    public void createSilverVbox()
    {
        silverCupVbox = new VBox();

        Label nbrOfSilverCupLabel = new Label();
        Label silverCupNumber = new Label();

        silverCupVbox.getChildren().add(silverCupImage);
        silverCupImage.setTranslateX(10);
        setUpVbox(silverCupVbox, nbrOfSilverCupLabel, UtilStringStorage.silverCupTrophy, FileUtil.getGeneralSavesFile(), "silverCup", silverCupNumber);
        silverCupVbox.getChildren().add(silverCupNumber);
    }
    public void createBronzeVbox()
    {
        bronzeCupVbox = new VBox();

        Label nbrOfBronzeCupLabel = new Label();
        Label bronzeCupNumber = new Label();

        bronzeCupVbox.getChildren().add(bronzeCupImage);
        setUpVbox(bronzeCupVbox, nbrOfBronzeCupLabel, UtilStringStorage.bronzeCupTrophy, FileUtil.getGeneralSavesFile(), "bronzeCup", bronzeCupNumber);
        bronzeCupVbox.getChildren().add(bronzeCupNumber);
    }

    public void createSecretVbox()
    {
        secretCupVbox = new VBox();

        Label nbrOfSecretCupLabel = new Label();
        Label secretCupNumber = new Label();

        secretCupVbox.getChildren().add(secretCupImage);
        setUpSecretVbox(secretCupVbox, nbrOfSecretCupLabel, UtilStringStorage.secretCupTrophy, FileUtil.getGeneralSavesFile(), "secretCup", secretCupNumber);
        secretCupVbox.getChildren().add(secretCupNumber);
    }

    public void setUpGridPane()
    {
        Label trophyLabel = new Label();
        stylizeTitleLabel(trophyLabel);
        gridPane.add(trophyLabel, 1, 0);

        gridPane.add(goldCupVbox, 0, 1);
        goldCupVbox.setTranslateX(25);

        gridPane.add(silverCupVbox, 1, 1);
        silverCupVbox.setTranslateX(-30);

        gridPane.add(bronzeCupVbox, 2, 1);
        bronzeCupVbox.setTranslateX(-25);

        gridPane.add(secretCupVbox, 3, 1);
        secretCupVbox.setTranslateX(-10);

        gridPane.setTranslateX(80);
    }

    public void stylizeTitleLabel(Label label)
    {
        label.setText(UtilStringStorage.trophyLabel);
        label.setFont(Font.font("Impact", FontWeight.BOLD, 40));
        label.setTranslateX(150);
    }

    public void setUpVbox(VBox vBox, Label label, String string, Properties properties, String propertyKey, Label cupNumber)
    {
        placeLabel(label, 0, 25);
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

    public void setUpSecretVbox(VBox vBox, Label label, String string, Properties properties, String propertyKey, Label cupNumber)
    {
        placeLabel(label, 0, 25);
        stylizeSecretLabel(label, string, properties, propertyKey, cupNumber);
        cupNumber.setTranslateX(80);
        cupNumber.setTranslateY(40);
        vBox.getChildren().add(label);
    }

    public void stylizeSecretLabel(Label label, String string, Properties properties, String propertyKey, Label cupNumber)
    {
        label.setText(string +" ");
        cupNumber.setText(properties.getProperty(propertyKey)+"/2");
        label.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 26));
        cupNumber.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 28));
    }

    public void createIcons()
    {
        goldCupImage = IconCreator.createCupIcon(PathUtil.GOLD_CUP_PATH);
        goldCupImage.setTranslateY(10);

        bronzeCupImage = IconCreator.createCupIcon(PathUtil.BRONZE_CUP_PATH);
        bronzeCupImage.setTranslateY(10);

        silverCupImage = IconCreator.createCupIcon(PathUtil.SILVER_CUP_PATH);
        silverCupImage.setTranslateY(10);

        int numberOfSecretCup = Integer.parseInt(FileUtil.getGeneralSavesFile().getProperty("secretCup"));
        if(numberOfSecretCup > 0)
        {
            secretCupImage = IconCreator.createCupIcon(PathUtil.SECRET_CUP);
        } else
        {
            secretCupImage = IconCreator.createCupIcon(PathUtil.PLACE_HOLDER_CUP);
        }
        secretCupImage.setFitWidth(180);
        secretCupImage.setTranslateY(10);
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
