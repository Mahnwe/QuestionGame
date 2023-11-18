package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
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
import util.*;


public class MenuScene extends Scene
{
    private final BorderPane pane;

    private final Stage menuStage;

    private Button launchGameButton;
    private final GameHandler gameHandler;
    private ComboBox<String> comboBox;
    private final Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    private final AchievementManager achievementManager;

    public static final String POLICE_LABEL = "Verdana";
    private Label tenModeButton;
    private Label fifteenModeButton;
    private Label twentyModeButton;
    private Label survivalModeButton;
    private MenuSideButton leaderBoardButton;
    private MenuSideButton trophyButton;
    private MenuSideButton achievementButton;
    private MenuSideButton optionButton;
    private MenuSideButton creditButton;
    public static MediaPlayer relaunchGame;

    public MenuScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.pane = pane;
        this.menuStage = stage;
        pane.setPrefWidth(1000);
        pane.setPrefHeight(550);

        this.gameHandler = new GameHandler();

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
        welcomeInGame.setFont(Font.font("Impact", FontWeight.BOLD, 22));
        welcomeInGame.setTranslateX(300);
        welcomeArea.getChildren().add(createStatArea(welcomeInGame));
        welcomeInGame.setTranslateY(10);
        pane.setTop(welcomeArea);
    }

    public void createLeaderBoardButtonArea()
    {
        VBox leaderBoardVBox = new VBox();
        leaderBoardVBox.setBorder(border);
        leaderBoardVBox.setPrefWidth(170);

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
        leaderBoardButton = new MenuSideButton(UtilStringStorage.leaderBoardButton, UtilStringStorage.leaderBoardTooltip, 25, 30);
        if(leaderBoardButton.getText().equals("Leaderboard"))
        {
            leaderBoardButton.setTranslateX(21);
        }

        trophyButton = new MenuSideButton(UtilStringStorage.trophyButton, UtilStringStorage.trophyTooltip, 35, 90);

        achievementButton = new MenuSideButton(UtilStringStorage.achievementButton, UtilStringStorage.achievementTooltip, 42, 150);
        if(achievementButton.getText().equals("Achievements"))
        {
            achievementButton.setTranslateX(16);
        }

        optionButton = new MenuSideButton(UtilStringStorage.optionButton, UtilStringStorage.optionTooltip, 39, 210);

        creditButton = new MenuSideButton(UtilStringStorage.creditButton, UtilStringStorage.creditTooltip, 42, 270);
    }

    public void setLeftButtonOnAction()
    {
        leaderBoardButton.setOnAction(event -> {
            LeaderBoardScene leaderBoardScene = new LeaderBoardScene(new ScrollPane(), menuStage, achievementManager);
            menuStage.setScene(leaderBoardScene);
        });

        trophyButton.setOnAction(event -> {
            TrophyScene trophyScene = new TrophyScene(new BorderPane(), menuStage, achievementManager);
            menuStage.setScene(trophyScene);
        });

        achievementButton.setOnAction(event -> {
            AchievementScene achievementScene = new AchievementScene(new ScrollPane(), achievementManager, menuStage);
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

    public void createLabel()
    {
        tenModeButton = new Label(UtilStringStorage.mode10Button);
        tenModeButton.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 16));
        tenModeButton.setTextFill(Color.BLACK);

        fifteenModeButton = new Label(UtilStringStorage.mode15Button);
        fifteenModeButton.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 16));
        fifteenModeButton.setTextFill(Color.BLACK);

        twentyModeButton = new Label(UtilStringStorage.mode20Button);
        twentyModeButton.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 16));
        twentyModeButton.setTextFill(Color.BLACK);

        survivalModeButton = new Label(UtilStringStorage.modeSurvivalButton);
        survivalModeButton.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 16));
        survivalModeButton.setTextFill(Color.BLACK);
    }

    public void createButtonArea()
    {
        VBox selectModeArea = new VBox();

        Label chooseMode = new Label(UtilStringStorage.chooseMode);
        chooseMode.setFont(Font.font("Impact", FontWeight.BOLD, 22));
        chooseMode.setTextFill(Color.BLACK);
        chooseMode.setTranslateX(270);
        chooseMode.setTranslateY(135);
        if(chooseMode.getText().equals("Choose your game mod"))
        {
            chooseMode.setTranslateX(295);
        }

        createLabel();

        comboBox = new ComboBox<>();
        CustomOption.customComboBox(comboBox);
        comboBox.getItems().add(tenModeButton.getText());
        comboBox.getItems().add(fifteenModeButton.getText());
        comboBox.getItems().add(twentyModeButton.getText());
        comboBox.getItems().add(survivalModeButton.getText());
        comboBox.getSelectionModel().selectFirst();

        launchGameButton = new Button(UtilStringStorage.launchGameButton);
        CustomOption.customLaunchButton(launchGameButton);

        ImageView gifImageView = GifCreator.createVibeGif(80, 80);
        ImageView gifImageView2 = GifCreator.createVibeGif(640, -20);

        DeveloperVbox developerVbox = new DeveloperVbox();
        developerVbox.setTranslateX(348);
        developerVbox.setTranslateY(96);

        selectModeArea.getChildren().add(chooseMode);
        selectModeArea.getChildren().add(comboBox);
        selectModeArea.getChildren().add(launchGameButton);
        selectModeArea.getChildren().add(gifImageView);
        selectModeArea.getChildren().add(gifImageView2);
        selectModeArea.getChildren().add(developerVbox);
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
            if(comboBox.getSelectionModel().getSelectedItem().equals(comboBox.getItems().get(3)))
            {
                gameHandler.setUpSurvivalMode();
                instantiateMainScene();
            }
        });
    }

    public void instantiateMainScene()
    {
        Player player = new Player();
        MainScene mainScene = new MainScene(player, gameHandler, menuStage, achievementManager);
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
