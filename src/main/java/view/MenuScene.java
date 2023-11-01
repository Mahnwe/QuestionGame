package view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import model.GameHandler;
import model.Player;
import model.SoundManager;
import util.BackgroundCreator;
import util.FileUtil;
import util.PathUtil;
import util.UtilStringStorage;

import java.io.File;


public class MenuScene extends Scene
{
    private final BorderPane pane;

    private final Stage menuStage;

    private Button launchGameButton;
    private final GameHandler gameHandler;
    private final File saveFile;
    private ComboBox<String> comboBox;
    private final Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    private final AchievementManager achievementManager;

    public static final String POLICE_LABEL = "Verdana";

    private Button leaderBoardButton;
    private Button trophyButton;
    private Button achievementButton;
    private Button optionButton;
    private Button creditButton;
    public static MediaPlayer relaunchGame;

    public MenuScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.pane = pane;
        this.menuStage = stage;
        pane.setPrefWidth(900);
        pane.setPrefHeight(500);

        this.gameHandler = new GameHandler();
        saveFile = FileUtil.saveFile;

        this.achievementManager = achievementManager;

        createWelcomeArea();
        createLeaderBoardButtonArea();
        createButtonArea();

        setButtonOnAction();

        createBackground();

    }

    public void createBackground()
    {
        BackgroundImage backgroundImage = BackgroundCreator.createMenuBackground();
        pane.setBackground(new Background(backgroundImage));
    }

    public void createWelcomeArea()
    {
        VBox welcomeArea = new VBox();
        Label welcomeInGame = new Label(UtilStringStorage.welcomeLabel);
        welcomeInGame.setTextFill(Color.BLACK);
        welcomeInGame.setFont(Font.font("Impact", FontWeight.BOLD, 20));
        welcomeInGame.setTranslateX(250);
        welcomeArea.getChildren().add(createStatArea(welcomeInGame));
        welcomeInGame.setTranslateY(10);
        pane.setTop(welcomeArea);
    }

    public void placeButtons(Button button, int translateX, int translateY)
    {
        button.setTranslateX(translateX);
        button.setTranslateY(translateY);
    }

    public void createButton(Button button, Tooltip tooltip, int x, int y)
    {
        button.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 14));
        placeButtons(button, x, y);
        button.setTooltip(tooltip);
    }

    public void createLeaderBoardButtonArea()
    {
        VBox leaderBoardVBox = new VBox();
        leaderBoardVBox.setBorder(border);
        leaderBoardVBox.setPrefWidth(150);

        createLeftButtons();

        setLeftButtonOnAction();

        leaderBoardVBox.getChildren().add(leaderBoardButton);
        leaderBoardVBox.getChildren().add(trophyButton);
        leaderBoardVBox.getChildren().add(achievementButton);
        leaderBoardVBox.getChildren().add(optionButton);
        leaderBoardVBox.getChildren().add(creditButton);
        pane.setLeft(leaderBoardVBox);
    }

    public void createLeftButtons()
    {
        leaderBoardButton = new Button(UtilStringStorage.leaderBoardButton);
        Tooltip leaderBoardTooltip = new Tooltip(UtilStringStorage.leaderBoardTooltip);
        createButton(leaderBoardButton, leaderBoardTooltip, 5, 25);

        trophyButton = new Button(UtilStringStorage.trophyButton);
        Tooltip trophyTooltip = new Tooltip(UtilStringStorage.trophyTooltip);
        createButton(trophyButton, trophyTooltip, 10, 85);

        achievementButton = new Button(UtilStringStorage.achievementButton);
        Tooltip achievementTooltip = new Tooltip(UtilStringStorage.achievementTooltip);
        createButton(achievementButton, achievementTooltip, 10, 145);

        optionButton = new Button(UtilStringStorage.optionButton);
        Tooltip optionTooltip = new Tooltip(UtilStringStorage.optionTooltip);
        createButton(optionButton, optionTooltip, 10, 205);

        creditButton = new Button(UtilStringStorage.creditButton);
        Tooltip creditTooltip = new Tooltip(UtilStringStorage.creditTooltip);
        createButton(creditButton, creditTooltip, 10, 265);
    }

    public void setLeftButtonOnAction()
    {
        leaderBoardButton.setOnAction(event -> {
            LeaderBoardScene leaderBoardScene = new LeaderBoardScene(new ScrollPane(), saveFile, menuStage, achievementManager);
            menuStage.setScene(leaderBoardScene);
        });

        trophyButton.setOnAction(event -> {
            TrophyScene trophyScene = new TrophyScene(new BorderPane(), menuStage, achievementManager, FileUtil.cupFile);
            menuStage.setScene(trophyScene);
        });

        achievementButton.setOnAction(event -> {
            AchievementScene achievementScene = new AchievementScene(new BorderPane(), achievementManager, menuStage, FileUtil.cupFile, FileUtil.perfectScoreFile);
            menuStage.setScene(achievementScene);
        });

        optionButton.setOnAction(event -> {
            OptionScene optionScene = new OptionScene(new BorderPane(), menuStage, achievementManager);
            menuStage.setScene(optionScene);
        });

        creditButton.setOnAction(event -> {
            CreditScene creditScene = new CreditScene(new BorderPane(), menuStage, achievementManager);
            menuStage.setScene(creditScene);
        });
    }

    public void createButtonArea()
    {
        VBox selectModeArea = new VBox();

        Label chooseMode = new Label(UtilStringStorage.chooseMode);
        chooseMode.setFont(Font.font("Impact", FontWeight.BOLD, 20));
        chooseMode.setTextFill(Color.BLACK);
        chooseMode.setTranslateX(225);
        chooseMode.setTranslateY(100);

        Label tenModeButton = new Label(UtilStringStorage.mode10Button);
        tenModeButton.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 16));
        tenModeButton.setTextFill(Color.BLACK);

        Label fifteenModeButton = new Label(UtilStringStorage.mode15Button);
        fifteenModeButton.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 16));
        fifteenModeButton.setTextFill(Color.BLACK);

        Label twentyModeButton = new Label(UtilStringStorage.mode20Button);
        twentyModeButton.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 16));
        twentyModeButton.setTextFill(Color.BLACK);


        comboBox = new ComboBox<>();
        comboBox.setStyle("-fx-font: 20px \"Verdana\"");
        comboBox.setMinHeight(30);
        comboBox.setMinWidth(90);
        comboBox.setTranslateX(230);
        comboBox.setTranslateY(140);
        comboBox.getItems().add(tenModeButton.getText());
        comboBox.getItems().add(fifteenModeButton.getText());
        comboBox.getItems().add(twentyModeButton.getText());
        comboBox.getSelectionModel().selectFirst();

        launchGameButton = new Button(UtilStringStorage.launchGameButton);
        launchGameButton.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 20));
        launchGameButton.setTranslateX(275);
        launchGameButton.setTranslateY(155);

        selectModeArea.getChildren().add(chooseMode);
        selectModeArea.getChildren().add(comboBox);
        selectModeArea.getChildren().add(launchGameButton);
        pane.setCenter(selectModeArea);
    }

    public void setButtonOnAction()
    {
        launchGameButton.setOnAction(event -> {
            if(comboBox.getSelectionModel().getSelectedItem().equals(comboBox.getItems().get(0)))
            {
                gameHandler.setupQuestionList(10);
                instantiateMainScene();
            }

            if(comboBox.getSelectionModel().getSelectedItem().equals(comboBox.getItems().get(1)))
            {
                gameHandler.setupQuestionList(15);
                instantiateMainScene();
            }

            if(comboBox.getSelectionModel().getSelectedItem().equals(comboBox.getItems().get(2)))
            {
            gameHandler.setupQuestionList(20);
            instantiateMainScene();
            }
        });
    }

    public void instantiateMainScene()
    {
        Player player = new Player();
        MainScene mainScene = new MainScene(player, gameHandler, menuStage, saveFile, achievementManager, FileUtil.cupFile, FileUtil.perfectScoreFile);
        SoundManager.stopMusic(App.menuMusicToStop);
        if(ResultScene.returnToMenuMusic != null) {
            SoundManager.stopMusic(ResultScene.returnToMenuMusic);
            relaunchGame = SoundManager.playMusicRepeat(PathUtil.IN_GAME_MUSIC);
        }
        menuStage.setScene(mainScene);

    }

    public HBox createStatArea(Label label) {
        label.setTranslateY(3);

        HBox area = new HBox();
        area.setPrefHeight(50);
        area.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Label emptySpace = new Label();
        emptySpace.setPrefWidth(20);
        area.getChildren().add(emptySpace);
        area.getChildren().add(label);

        return area;
    }

}
