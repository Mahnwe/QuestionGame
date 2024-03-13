package view.scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Player;
import model.handlers.AchievementManager;
import model.handlers.GameHandler;
import model.handlers.PlayerHandler;
import model.handlers.SoundManager;
import view.customobject.*;
import util.PathUtil;
import util.creators.BackgroundCreator;
import util.creators.GifCreator;
import util.creators.IconCreator;
import util.stringutiltranslate.UtilStringStorage;
import view.App;
import view.bootstrap.BootstrapPane;
import view.customvbox.DeveloperVbox;


public class MenuScene extends Scene
{
    private final BorderPane pane;
    private final Stage menuStage;
    private final GameHandler gameHandler;
    private final AchievementManager achievementManager;

    public static final String POLICE_LABEL = "Verdana";
    private MenuSideButton leaderBoardButton;
    private MenuSideButton trophyButton;
    private MenuSideButton achievementButton;
    private MenuSideButton questionCreatorButton;
    private MenuSideButton optionButton;
    private MenuSideButton creditButton;
    private MenuSideButton statsButton;
    public static MediaPlayer relaunchGame;

    public MenuScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.pane = pane;
        this.menuStage = stage;
        stage.setMaximized(true);

        this.gameHandler = new GameHandler();
        this.achievementManager = achievementManager;

        createWelcomeArea();
        createIconOptionButton();
        createLeaderBoardButtonArea();
        createButtonArea();

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
        welcomeInGame.setFont(Font.font("Futura", FontWeight.BOLD, 40));
        welcomeInGame.setTranslateX(500);
        welcomeArea.getChildren().add(createStatArea(welcomeInGame));
        welcomeInGame.setTranslateY(15);
        pane.setTop(welcomeArea);
    }

    public void createLeaderBoardButtonArea()
    {
        BootstrapPane leaderBoardVBox = new BootstrapPane(1);
        leaderBoardVBox.setBorder(CustomOption.createCustomBorder(1.0, 1.0, Color.BLACK));
        leaderBoardVBox.setMinWidth(320);

        BootstrapPane sideButtonGridPane = createLeftButtons();

        setLeftButtonOnAction();

        leaderBoardVBox.add(sideButtonGridPane, 0, 0);
        pane.setLeft(leaderBoardVBox);
    }

    public void setUpBootStrapPane(BootstrapPane bootStrapPane)
    {
        bootStrapPane.addColumn(1);
        bootStrapPane.addRow(6);
        bootStrapPane.setVgap(90);
        bootStrapPane.setAlignment(Pos.CENTER);
        bootStrapPane.setTranslateY(80);
        bootStrapPane.setTranslateX(60);
    }

    public BootstrapPane createLeftButtons()
    {
        BootstrapPane gridPaneMenuButton = new BootstrapPane(1);
        setUpBootStrapPane(gridPaneMenuButton);

        leaderBoardButton = new MenuSideButton(UtilStringStorage.leaderBoardButton, UtilStringStorage.leaderBoardTooltip, 5);
        if(leaderBoardButton.getText().equals("Records"))
        {
            leaderBoardButton.setTranslateX(15);
        }
        gridPaneMenuButton.add(leaderBoardButton, 0, 0);

        trophyButton = new MenuSideButton(UtilStringStorage.trophyButton, UtilStringStorage.trophyTooltip, 12);
        gridPaneMenuButton.add(trophyButton, 0, 1);

        achievementButton = new MenuSideButton(UtilStringStorage.achievementButton, UtilStringStorage.achievementTooltip, 15);
        if(achievementButton.getText().equals("Achievements"))
        {
            achievementButton.setTranslateX(-5);
        }
        gridPaneMenuButton.add(achievementButton, 0, 2);

        statsButton = new MenuSideButton(UtilStringStorage.statisticLabel, UtilStringStorage.statisticTooltip, 5);
        gridPaneMenuButton.add(statsButton, 0, 3);

        questionCreatorButton = new MenuSideButton(UtilStringStorage.questionCreatorButton, UtilStringStorage.questionCreatorTooltip, 15);
        gridPaneMenuButton.add(questionCreatorButton, 0, 4);

        HBox iconOptionHbox = new HBox();
        iconOptionHbox.getChildren().add(optionButton);
        iconOptionHbox.getChildren().add(creditButton);
        gridPaneMenuButton.add(iconOptionHbox, 0, 5);

        ExitGameButton exitGameButton = new ExitGameButton(UtilStringStorage.quitGameButtonLabel, UtilStringStorage.quitGameButtonTooltip, 15);
        gridPaneMenuButton.add(exitGameButton, 0, 6);

        return gridPaneMenuButton;
    }

    public void createIconOptionButton()
    {
        optionButton = new MenuSideButton("", UtilStringStorage.optionTooltip, 15);
        optionButton.setTranslateX(-15);
        IconCreator optionIcon = new IconCreator(PathUtil.OPTION_ICON);
        ImageView optionImage = optionIcon.createImage();
        optionImage.setFitHeight(40);
        optionImage.setFitWidth(40);
        optionButton.setGraphic(optionImage);

        creditButton = new MenuSideButton("", UtilStringStorage.creditTooltip, 15);
        IconCreator creditsIcon = new IconCreator(PathUtil.CREDITS_ICON);
        ImageView creditsImage = creditsIcon.createImage();
        creditsImage.setFitHeight(40);
        creditsImage.setFitWidth(40);
        creditButton.setGraphic(creditsImage);
        creditButton.setTranslateX(55);
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

        questionCreatorButton.setOnAction(event -> {
            QuestionCreatorScene questionCreatorScene = new QuestionCreatorScene(new BorderPane(), menuStage, achievementManager);
            menuStage.setScene(questionCreatorScene);
        });

        optionButton.setOnAction(event -> {
            OptionScene optionScene = new OptionScene(new BorderPane(), menuStage, achievementManager);
            menuStage.setScene(optionScene);
        });

        creditButton.setOnAction(event -> {
            CreditScene creditScene = new CreditScene(new BorderPane(), menuStage, achievementManager);
            menuStage.setScene(creditScene);
        });

        statsButton.setOnAction(event -> {
            StatsScene statsScene = new StatsScene(new BorderPane(), menuStage, achievementManager);
            menuStage.setScene(statsScene);
    });
    }

    public void createButtonArea()
    {
        VBox selectModeArea = new VBox();

        Label chooseMode = new Label(UtilStringStorage.chooseMode);
        setUpChooseLabel(chooseMode);

        CustomComboBox comboBox = new CustomComboBox();

        Label labelBeforeLaunchButton = new Label(UtilStringStorage.labelBeforeLaunchingGame);
        labelBeforeLaunchButton.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 36));
        labelBeforeLaunchButton.setTextFill(Color.BLACK);
        labelBeforeLaunchButton.setTranslateX(370);
        labelBeforeLaunchButton.setTranslateY(200);

        Button launchGameButton = new LaunchGameButton(comboBox, gameHandler, this);

        ImageView gifImageView = GifCreator.createVibeGif(40, 70);
        ImageView gifImageView2 = GifCreator.createVibeGif(660, -100);

        DeveloperVbox developerVbox = new DeveloperVbox();
        developerVbox.setTranslateX(370);
        developerVbox.setTranslateY(120);

        selectModeArea.getChildren().add(chooseMode);
        selectModeArea.getChildren().add(comboBox);
        selectModeArea.getChildren().add(labelBeforeLaunchButton);
        selectModeArea.getChildren().add(launchGameButton);
        selectModeArea.getChildren().add(gifImageView);
        selectModeArea.getChildren().add(gifImageView2);
        selectModeArea.getChildren().add(developerVbox);

        pane.setCenter(selectModeArea);
        selectModeArea.setTranslateX(300);
        selectModeArea.setTranslateY(150);
    }

    public void setUpChooseLabel(Label label)
    {
        label.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 35));
        label.setTextFill(Color.BLACK);
        label.setTranslateX(240);
        label.setTranslateY(65);
        if(label.getText().equals("Choose your game mod"))
        {
            label.setTranslateX(285);
        }
    }

    public void instantiateMainScene()
    {
        Player player = new Player();
        PlayerHandler playerHandler = new PlayerHandler(player);
        MainScene mainScene = new MainScene(playerHandler, gameHandler, menuStage, achievementManager);
        MainScene.inGameMusicToStop = SoundManager.playMusicRepeat(PathUtil.IN_GAME_MUSIC);
        SoundManager.stopMusic(App.menuMusicToStop);
        menuStage.setScene(mainScene);
    }

    public HBox createStatArea(Label label) {
        label.setTranslateY(3);

        HBox area = new HBox();
        area.setPrefHeight(70);
        area.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Label emptySpace = new Label();
        emptySpace.setPrefWidth(20);
        area.getChildren().add(emptySpace);
        area.getChildren().add(label);

        return area;
    }

}
