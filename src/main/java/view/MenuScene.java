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
    private final Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    private final AchievementManager achievementManager;

    public static final String POLICE_LABEL = "Verdana";
    private MenuSideButton leaderBoardButton;
    private MenuSideButton trophyButton;
    private MenuSideButton achievementButton;
    private MenuSideButton questionCreatorButton;
    private MenuSideButton optionButton;
    private MenuSideButton creditButton;
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
        welcomeInGame.setFont(Font.font("Futura", FontWeight.BOLD, 30));
        welcomeInGame.setTranslateX(350);
        welcomeArea.getChildren().add(createStatArea(welcomeInGame));
        welcomeInGame.setTranslateY(20);
        pane.setTop(welcomeArea);
    }

    public void createLeaderBoardButtonArea()
    {
        BootstrapPane leaderBoardVBox = new BootstrapPane(1);
        leaderBoardVBox.setBorder(border);
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
        gridPaneMenuButton.setTranslateY(40);
        gridPaneMenuButton.setTranslateX(40);

        leaderBoardButton = new MenuSideButton(UtilStringStorage.leaderBoardButton, UtilStringStorage.leaderBoardTooltip, -5);
        gridPaneMenuButton.add(leaderBoardButton, 0, 0);

        trophyButton = new MenuSideButton(UtilStringStorage.trophyButton, UtilStringStorage.trophyTooltip, 10);
        gridPaneMenuButton.add(trophyButton, 0, 1);

        achievementButton = new MenuSideButton(UtilStringStorage.achievementButton, UtilStringStorage.achievementTooltip, 0);
        gridPaneMenuButton.add(achievementButton, 0, 2);

        questionCreatorButton = new MenuSideButton(UtilStringStorage.questionCreatorButton, UtilStringStorage.questionCreatorTooltip, -15);
        gridPaneMenuButton.add(questionCreatorButton, 0, 3);

        optionButton = new MenuSideButton(UtilStringStorage.optionButton, UtilStringStorage.optionTooltip, 10);
        gridPaneMenuButton.add(optionButton, 0, 4);

        creditButton = new MenuSideButton(UtilStringStorage.creditButton, UtilStringStorage.creditTooltip, 10);
        gridPaneMenuButton.add(creditButton, 0, 5);

        return gridPaneMenuButton;
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
    }

    public void createButtonArea()
    {
        VBox selectModeArea = new VBox();

        Label chooseMode = new Label(UtilStringStorage.chooseMode);
        chooseMode.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 28));
        chooseMode.setTextFill(Color.BLACK);
        chooseMode.setTranslateX(245);
        chooseMode.setTranslateY(75);
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

        DeveloperVbox developerVbox = new DeveloperVbox();
        developerVbox.setTranslateX(353);
        developerVbox.setTranslateY(77);

        selectModeArea.getChildren().add(chooseMode);
        selectModeArea.getChildren().add(comboBox);
        selectModeArea.getChildren().add(launchGameButton);
        selectModeArea.getChildren().add(gifImageView);
        selectModeArea.getChildren().add(gifImageView2);
        selectModeArea.getChildren().add(developerVbox);
        pane.setCenter(selectModeArea);
        selectModeArea.setTranslateX(50);
        selectModeArea.setTranslateY(50);
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
        area.setPrefHeight(70);
        area.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Label emptySpace = new Label();
        emptySpace.setPrefWidth(20);
        area.getChildren().add(emptySpace);
        area.getChildren().add(label);

        return area;
    }

}
