package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
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

    private final TrophyHandler trophyHandler;
    private final AchievementManager achievementManager;
    private final File goldCupFile;
    private final File silverCupFile;
    private final File bronzeCupFile;
    private final File perfectScoreFile10;
    private final File perfectScoreFile15;
    private final File perfectScoreFile20;
    public static final String POLICE_LABEL = "Verdana";

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

        trophyHandler = new TrophyHandler();
        this.achievementManager = achievementManager;

        createWelcomeArea();
        createLeaderBoardButtonArea();
        createButtonArea();

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
        Label welcomeInGame = new Label(UtilStringStorage.WELCOME_LABEL);
        welcomeInGame.setTextFill(Color.BLACK);
        welcomeInGame.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
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

        Button leaderBoardButton = new Button(UtilStringStorage.LEADERBOARD_BUTTON);
        Tooltip leaderBoardTooltip = new Tooltip(UtilStringStorage.LEADERBOARD_TOOLTIP);
        leaderBoardButton.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 13));
        placeButtons(leaderBoardButton, 5, 70);
        leaderBoardButton.setTooltip(leaderBoardTooltip);

        Button trophyButton = new Button(UtilStringStorage.TROPHY_BUTTON);
        Tooltip trophyTooltip = new Tooltip(UtilStringStorage.TROPHY_TOOLTIP);
        trophyButton.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 13));
        placeButtons(trophyButton, 10, 150);
        trophyButton.setTooltip(trophyTooltip);

        Button achievementButton = new Button(UtilStringStorage.ACHIEVEMENT_BUTTON);
        Tooltip achievementTooltip = new Tooltip(UtilStringStorage.ACHIEVEMENT_TOOLTIP);
        achievementButton.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 13));
        placeButtons(achievementButton, 10, 230);
        achievementButton.setTooltip(achievementTooltip);

        leaderBoardButton.setOnAction(event -> {
            LeaderBoardScene leaderBoardScene = new LeaderBoardScene(new BorderPane(), saveFile, menuStage, achievementManager);
            menuStage.setScene(leaderBoardScene);
        });

        trophyButton.setOnAction(event -> {
            TrophyScene trophyScene = new TrophyScene(new BorderPane(), trophyHandler, menuStage, achievementManager, goldCupFile, silverCupFile, bronzeCupFile);
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
        VBox selectModeArea = new VBox();

        Label chooseMode = new Label(UtilStringStorage.CHOOSE_MODE);
        chooseMode.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        chooseMode.setTextFill(Color.BLACK);
        chooseMode.setTranslateX(200);

        tenModeButton = new Button(UtilStringStorage.MODE_10_BUTTON);
        tenModeButton.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        placeButtons(tenModeButton, 250, 50);

        fifteenModeButton = new Button(UtilStringStorage.MODE_15_BUTTON);
        fifteenModeButton.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        placeButtons(fifteenModeButton, 250, 100);

        twentyModeButton = new Button(UtilStringStorage.MODE_20_BUTTON);
        twentyModeButton.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
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
        MainScene mainScene = new MainScene(new BorderPane(), player, gameHandler, menuStage, saveFile, trophyHandler, achievementManager, perfectScoreFile10, perfectScoreFile15, perfectScoreFile20, goldCupFile, silverCupFile, bronzeCupFile);
        menuStage.setScene(mainScene);

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
