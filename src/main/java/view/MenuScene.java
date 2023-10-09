package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


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
    private final AchievementManager achievementManager;
    private final Properties perfectScoreFile = new Properties();
    private final Properties cupFile = new Properties();
    public static final String POLICE_LABEL = "Verdana";

    public MenuScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.pane = pane;
        this.menuStage = stage;
        pane.setPrefWidth(900);
        pane.setPrefHeight(500);

        loadPerfectScoreFile();
        loadCupFile();

        this.gameHandler = new GameHandler();
        saveFile = new File("./src/main/resources/SaveFile/saveScoresFile");

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
        Label welcomeInGame = new Label(UtilStringStorage.welcomeLabel);
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
        leaderBoardVBox.setPrefWidth(150);

        Button leaderBoardButton = new Button(UtilStringStorage.leaderBoardButton);
        Tooltip leaderBoardTooltip = new Tooltip(UtilStringStorage.leaderBoardTooltip);
        leaderBoardButton.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 13));
        placeButtons(leaderBoardButton, 5, 70);
        leaderBoardButton.setTooltip(leaderBoardTooltip);

        Button trophyButton = new Button(UtilStringStorage.trophyButton);
        Tooltip trophyTooltip = new Tooltip(UtilStringStorage.trophyTooltip);
        trophyButton.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 13));
        placeButtons(trophyButton, 10, 150);
        trophyButton.setTooltip(trophyTooltip);

        Button achievementButton = new Button(UtilStringStorage.achievementButton);
        Tooltip achievementTooltip = new Tooltip(UtilStringStorage.achievementTooltip);
        achievementButton.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 13));
        placeButtons(achievementButton, 10, 230);
        achievementButton.setTooltip(achievementTooltip);

        Button optionButton = new Button(UtilStringStorage.optionButton);
        Tooltip optionTooltip = new Tooltip(UtilStringStorage.optionTooltip);
        optionButton.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 13));
        placeButtons(optionButton, 10, 300);
        optionButton.setTooltip(optionTooltip);

        leaderBoardButton.setOnAction(event -> {
            LeaderBoardScene leaderBoardScene = new LeaderBoardScene(new ScrollPane(), saveFile, menuStage, achievementManager);
            menuStage.setScene(leaderBoardScene);
        });

        trophyButton.setOnAction(event -> {
            TrophyScene trophyScene = new TrophyScene(new BorderPane(), menuStage, achievementManager, cupFile);
            menuStage.setScene(trophyScene);
        });

        achievementButton.setOnAction(event -> {
            AchievementScene achievementScene = new AchievementScene(new BorderPane(), achievementManager, menuStage, cupFile, perfectScoreFile);
            menuStage.setScene(achievementScene);
        });

        optionButton.setOnAction(event -> {
            OptionScene optionScene = new OptionScene(new BorderPane(), menuStage, achievementManager, saveFile, cupFile, perfectScoreFile);
            menuStage.setScene(optionScene);
        });


        leaderBoardVBox.getChildren().add(leaderBoardButton);
        leaderBoardVBox.getChildren().add(trophyButton);
        leaderBoardVBox.getChildren().add(achievementButton);
        leaderBoardVBox.getChildren().add(optionButton);
        pane.setLeft(leaderBoardVBox);
    }

    public void createButtonArea()
    {
        VBox selectModeArea = new VBox();

        Label chooseMode = new Label(UtilStringStorage.chooseMode);
        chooseMode.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        chooseMode.setTextFill(Color.BLACK);
        chooseMode.setTranslateX(200);

        tenModeButton = new Button(UtilStringStorage.mode10Button);
        tenModeButton.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        placeButtons(tenModeButton, 250, 50);

        fifteenModeButton = new Button(UtilStringStorage.mode15Button);
        fifteenModeButton.setFont(Font.font(POLICE_LABEL, FontWeight.EXTRA_LIGHT, 15));
        placeButtons(fifteenModeButton, 250, 100);

        twentyModeButton = new Button(UtilStringStorage.mode20Button);
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
        MainScene mainScene = new MainScene(new BorderPane(), player, gameHandler, menuStage, saveFile, achievementManager, cupFile, perfectScoreFile);
        SoundManager.stopMusic(App.menuMusicToStop);
        if(ResultScene.returnToMenuMusic != null) {
            SoundManager.stopMusic(ResultScene.returnToMenuMusic);
        }
        menuStage.setScene(mainScene);

    }
    public void loadPerfectScoreFile()
    {
        try {
            perfectScoreFile.load(new FileInputStream(PathUtil.PERFECT_SCORE_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadCupFile()
    {
        try {
            cupFile.load(new FileInputStream(PathUtil.CUP_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
