package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.*;

import java.io.File;


public class MenuScene extends Scene
{
    private final BorderPane pane;

    private final Stage menuStage;

    private Button twentyModeButton;
    private Button tenModeButton;
    private Button fifteenModeButton;
    private final GameHandler gameHandler;
    private final File saveFile;
    private final Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

    private final Background buttonBackground = new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY));

    private final TrophyHandler trophyHandler;

    private VBox selectModeArea;
    private final AchievementManager achievementManager;
    private final File goldCupFile;
    private final File silverCupFile;
    private final File bronzeCupFile;
    private final File perfectScoreFile10;
    private final File perfectScoreFile15;
    private final File perfectScoreFile20;

    public MenuScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.pane = pane;
        this.menuStage = stage;
        pane.setPrefWidth(900);
        pane.setPrefHeight(500);

        this.gameHandler = new GameHandler();
        saveFile = new File("./src/main/resources/SaveFile/saveScoresFile");

        goldCupFile = new File("./src/main/resources/SaveFile/GoldCupFile");
        silverCupFile = new File("./src/main/resources/SaveFile/SilverCupFile");
        bronzeCupFile = new File("./src/main/resources/SaveFile/BronzeCupFile");
        perfectScoreFile10 = new File("./src/main/resources/SaveFile/PerfectScoreFile10");
        perfectScoreFile15 = new File("./src/main/resources/SaveFile/PerfectScoreFile15");
        perfectScoreFile20 = new File("./src/main/resources/SaveFile/PerfectScoreFile20");

        trophyHandler = new TrophyHandler(goldCupFile, silverCupFile, bronzeCupFile);
        this.achievementManager = achievementManager;

        createWelcomeArea();
        createLeaderBoardButtonArea();
        createButtonArea();
        createAdviceForPlayer();

        setButtonOnAction();

        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        BackgroundCreator menuBackground = new BackgroundCreator(PathUtil.MENU_BACKGROUND);
        Image menuSceneBackground = menuBackground.createBackground();
        BackgroundImage backgroundImage = new BackgroundImage(menuSceneBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize);
        pane.setBackground(new Background(backgroundImage));
    }

    public void createWelcomeArea()
    {
        VBox welcomeArea = new VBox();
        Label welcomeInGame = new Label("Bienvenue dans le Turbo Jeu des Questions !");
        welcomeInGame.setTextFill(Color.BLACK);
        welcomeInGame.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 15));
        welcomeArea.getChildren().add(createStatArea(welcomeInGame));
        pane.setTop(welcomeArea);
    }

    public void placeButtons(Button button, int translateX, int translateY)
    {
        button.setTranslateX(translateX);
        button.setTranslateY(translateY);
    }

    public void createLeaderBoardButtonArea()
    {
        VBox leaderBoardVBox = new VBox();
        leaderBoardVBox.setBorder(border);
        leaderBoardVBox.setPrefWidth(105);

        Button leaderBoardButton = new Button("Classement");
        leaderBoardButton.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 13));
        leaderBoardButton.setBackground(buttonBackground);
        placeButtons(leaderBoardButton, 5, 70);

        Button trophyButton = new Button("Trophées");
        trophyButton.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 13));
        trophyButton.setBackground(buttonBackground);
        placeButtons(trophyButton, 10, 150);

        Button achievementButton = new Button("Succés");
        achievementButton.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 13));
        achievementButton.setBackground(buttonBackground);
        placeButtons(achievementButton, 10, 230);

        leaderBoardButton.setOnAction(event -> {
            LeaderBoardScene leaderBoardScene = new LeaderBoardScene(new BorderPane(), saveFile, menuStage, achievementManager);
            menuStage.setScene(leaderBoardScene);
        });

        trophyButton.setOnAction(event -> {
            TrophyScene trophyScene = new TrophyScene(new BorderPane(), trophyHandler, menuStage, achievementManager);
            menuStage.setScene(trophyScene);
        });

        achievementButton.setOnAction(event -> {
            AchievementScene achievementScene = new AchievementScene(new BorderPane(), achievementManager, menuStage, goldCupFile, silverCupFile, bronzeCupFile, perfectScoreFile10, perfectScoreFile15, perfectScoreFile20);
            menuStage.setScene(achievementScene);
        });

        leaderBoardVBox.getChildren().add(leaderBoardButton);
        leaderBoardVBox.getChildren().add(trophyButton);
        leaderBoardVBox.getChildren().add(achievementButton);
        pane.setLeft(leaderBoardVBox);
    }

    public void createButtonArea()
    {
        selectModeArea = new VBox();

        Label chooseMode = new Label("Cliquez sur le nombre de questions auquel vous voulez répondre");
        chooseMode.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 15));
        chooseMode.setTextFill(Color.BLACK);
        chooseMode.setTranslateX(70);

        tenModeButton = new Button("Dix questions");
        tenModeButton.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 15));
        placeButtons(tenModeButton, 250, 50);

        fifteenModeButton = new Button("Quinze questions");
        fifteenModeButton.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 15));
        placeButtons(fifteenModeButton, 250, 100);

        twentyModeButton = new Button("Vingt questions");
        twentyModeButton.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 15));
        placeButtons(twentyModeButton, 250, 150);


        selectModeArea.getChildren().add(createStatArea(chooseMode));
        selectModeArea.getChildren().add(tenModeButton);
        selectModeArea.getChildren().add(fifteenModeButton);
        selectModeArea.getChildren().add(twentyModeButton);
        pane.setCenter(selectModeArea);
    }

    public void setButtonOnAction()
    {
        tenModeButton.setOnAction(event -> {
            gameHandler.setupQuestionList(10);
            instantiateMainScene();
        });

        fifteenModeButton.setOnAction(event -> {
            gameHandler.setupQuestionList(15);
            instantiateMainScene();
        });

        twentyModeButton.setOnAction(event -> {
            gameHandler.setupQuestionList(20);
            instantiateMainScene();
        });
    }

    public void instantiateMainScene()
    {
        Player player = new Player();
        MainScene mainScene = new MainScene(new BorderPane(), player, gameHandler, menuStage, saveFile, trophyHandler, achievementManager, perfectScoreFile10, perfectScoreFile15, perfectScoreFile20);
        menuStage.setMinHeight(450);
        menuStage.setMinWidth(850);
        menuStage.setScene(mainScene);

    }

    public void createAdviceForPlayer()
    {
        VBox adviceVbox = new VBox();
        adviceVbox.setTranslateY(250);
        adviceVbox.setPrefHeight(100);
        Label adviceLabel = new Label("Cliquez sur 'Classement' pour retrouver les scores de vos parties précédentes");
        adviceLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 15));
        adviceLabel.setTextFill(Color.BLACK);

        Label adviceLabel2 = new Label("Cliquez sur 'Trophées' pour voir tout les trophées débloqués");
        adviceLabel2.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 15));
        adviceLabel2.setTextFill(Color.BLACK);
        adviceLabel2.setTranslateY(20);

        Label adviceLabel3 = new Label("Cliquez sur 'Succés' pour voir tout les succés");
        adviceLabel3.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 15));
        adviceLabel3.setTextFill(Color.BLACK);
        adviceLabel3.setTranslateY(40);

        adviceVbox.getChildren().add(adviceLabel);
        adviceVbox.getChildren().add(adviceLabel2);
        adviceVbox.getChildren().add(adviceLabel3);
        adviceVbox.setBorder(border);
        selectModeArea.getChildren().add(adviceVbox);
    }

    public HBox createStatArea(Label label) {
        label.setTranslateY(3);

        HBox area = new HBox();
        area.setPrefHeight(30);
        area.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Label emptySpace = new Label();
        emptySpace.setPrefWidth(20);
        area.getChildren().add(emptySpace);
        area.getChildren().add(label);

        return area;
    }

}
