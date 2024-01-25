package view;

import javafx.geometry.Pos;
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
import model.*;
import util.*;


public class MenuScene extends Scene
{
    private final BorderPane pane;

    private final Stage menuStage;

    private Button launchGameButton;
    private final GameHandler gameHandler;
    private ComboBox<String> comboBox;
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
        pane.setPrefWidth(1200);
        pane.setPrefHeight(750);

        this.gameHandler = new GameHandler();
        this.achievementManager = achievementManager;
        FileUtil.actualizeTimePlayed();
        createWelcomeArea();
        createIconOptionButton();
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
        welcomeInGame.setFont(Font.font("Futura", FontWeight.BOLD, 32));
        welcomeInGame.setTranslateX(350);
        welcomeArea.getChildren().add(createStatArea(welcomeInGame));
        welcomeInGame.setTranslateY(20);
        pane.setTop(welcomeArea);
    }

    public void createLeaderBoardButtonArea()
    {
        BootstrapPane leaderBoardVBox = new BootstrapPane(1);
        leaderBoardVBox.setBorder(CustomOption.createCustomBorder(1.0, 1.0, Color.BLACK));
        leaderBoardVBox.setMinWidth(240);

        BootstrapPane sideButtonGridPane = createLeftButtons();

        setLeftButtonOnAction();

        leaderBoardVBox.add(sideButtonGridPane, 0, 0);
        pane.setLeft(leaderBoardVBox);
    }

    public BootstrapPane createLeftButtons()
    {
        BootstrapPane gridPaneMenuButton = new BootstrapPane(1);
        gridPaneMenuButton.addColumn(1);
        gridPaneMenuButton.addRow(6);
        gridPaneMenuButton.setVgap(70);
        gridPaneMenuButton.setAlignment(Pos.CENTER);
        gridPaneMenuButton.setTranslateY(80);
        gridPaneMenuButton.setTranslateX(40);

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

        return gridPaneMenuButton;
    }

    public void createIconOptionButton()
    {
        optionButton = new MenuSideButton("", UtilStringStorage.optionTooltip, 15);
        optionButton.setTranslateX(25);
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
        chooseMode.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 30));
        chooseMode.setTextFill(Color.BLACK);
        chooseMode.setTranslateX(245);
        chooseMode.setTranslateY(65);
        if(chooseMode.getText().equals("Choose your game mod"))
        {
            chooseMode.setTranslateX(295);
        }

        comboBox = new ComboBox<>();
        CustomOption.customComboBox(comboBox);

        launchGameButton = new Button(UtilStringStorage.launchGameButton);
        CustomOption.customLaunchButton(launchGameButton);

        ImageView gifImageView = GifCreator.createVibeGif(60, 70);
        ImageView gifImageView2 = GifCreator.createVibeGif(640, -80);

        HBox bottomHbox = new HBox();
        DeveloperVbox developerVbox = new DeveloperVbox();
        developerVbox.setTranslateX(305);
        bottomHbox.setTranslateY(63);
        bottomHbox.getChildren().add(optionButton);
        bottomHbox.getChildren().add(creditButton);
        bottomHbox.getChildren().add(developerVbox);

        selectModeArea.getChildren().add(chooseMode);
        selectModeArea.getChildren().add(comboBox);
        selectModeArea.getChildren().add(launchGameButton);
        selectModeArea.getChildren().add(gifImageView);
        selectModeArea.getChildren().add(gifImageView2);
        selectModeArea.getChildren().add(bottomHbox);
        pane.setCenter(selectModeArea);
        selectModeArea.setTranslateX(50);
        selectModeArea.setTranslateY(50);
    }

    public void setButtonOnAction()
    {
        launchGameButton.setOnAction(event ->
        {
            if(comboBox.getSelectionModel().getSelectedItem().equals(comboBox.getItems().get(0))) {
                gameHandler.setupQuestionList(10);
                instantiateMainScene();
            }

            if(comboBox.getSelectionModel().getSelectedItem().equals(comboBox.getItems().get(1))) {
                gameHandler.setupQuestionList(15);
                instantiateMainScene();
            }

            if(comboBox.getSelectionModel().getSelectedItem().equals(comboBox.getItems().get(2))) {
            gameHandler.setupQuestionList(20);
            instantiateMainScene();
            }

            if(comboBox.getSelectionModel().getSelectedItem().equals(comboBox.getItems().get(3))) {
                gameHandler.setUpSurvivalMode();
                instantiateMainScene();
            }

        });
    }

    public void instantiateMainScene()
    {
        Player player = new Player();
        MainScene mainScene = new MainScene(player, gameHandler, menuStage, achievementManager);
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
