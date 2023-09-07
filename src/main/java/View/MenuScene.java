package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.BackgroundCreator;
import model.GameHandler;
import model.PathUtil;
import model.Player;

import java.io.File;


public class MenuScene extends Scene
{
    private final BorderPane pane;

    private final Stage stage;

    private Button twentyModeButton;
    private Button tenModeButton;
    private Button fifteenModeButton;
    private final GameHandler gameHandler;
    private final File saveFile;
    private final Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

    private final TrophyHandler trophyHandler;
    public MenuScene(BorderPane pane, Stage stage)
    {
        super(pane);
        this.pane = pane;
        this.stage = stage;
        this.gameHandler = new GameHandler();
        saveFile = new File("./src/main/resources/SaveFile/saveScoresFile");
        trophyHandler = new TrophyHandler();

        BackgroundCreator menuBackground = new BackgroundCreator(PathUtil.MENU_BACKGROUND);
        Image menuSceneBackground = menuBackground.createBackground();
        BackgroundFill backgroundFill = new BackgroundFill(new ImagePattern(menuSceneBackground), CornerRadii.EMPTY, Insets.EMPTY);
        pane.setBackground(new Background(backgroundFill));

        createWelcomeArea();
        createLeaderBoardButtonArea();
        createButtonArea();
        createAdviceForPlayer();

        setButtonOnAction();
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
        leaderBoardVBox.setMinWidth(105);

        Button leaderBoardButton = new Button("Classement");
        leaderBoardButton.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 13));
        placeButtons(leaderBoardButton, 5, 70);

        Button trophyButton = new Button("Trophées");
        trophyButton.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 13));
        placeButtons(trophyButton, 10, 150);

        leaderBoardButton.setOnAction(event -> {
            LeaderBoardScene leaderBoardScene = new LeaderBoardScene(new BorderPane(), saveFile);
            leaderBoardScene.displayLeaderBoard();
        });

        trophyButton.setOnAction(event -> {
            TrophyScene trophyScene = new TrophyScene(new BorderPane(), trophyHandler);
            trophyScene.displayTrophyScene();
        });

        leaderBoardVBox.getChildren().add(leaderBoardButton);
        leaderBoardVBox.getChildren().add(trophyButton);
        pane.setLeft(leaderBoardVBox);
    }

    public void createButtonArea()
    {
        VBox selectModeArea = new VBox();

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
        MainScene mainScene = new MainScene(new BorderPane(), player, gameHandler, stage, saveFile, trophyHandler);
        stage.setMinHeight(450);
        stage.setMinWidth(850);
        stage.setScene(mainScene);

    }

    public void createAdviceForPlayer()
    {
        VBox adviceVbox = new VBox();
        adviceVbox.setMinHeight(60);
        adviceVbox.setMinWidth(250);
        adviceVbox.setBorder(border);

        Label adviceLabel = new Label("Cliquez sur 'Classement' pour retrouver les scores de vos parties précédentes");
        adviceLabel.setTranslateX(105);
        adviceLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 15));
        adviceLabel.setTextFill(Color.BLACK);

        Label adviceLabel2 = new Label("Cliquez sur 'Trophées' pour voir tout les trophées débloqués");
        adviceLabel2.setTranslateX(105);
        adviceLabel2.setTranslateY(15);
        adviceLabel2.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 15));
        adviceLabel2.setTextFill(Color.BLACK);

        adviceVbox.getChildren().add(adviceLabel);
        adviceVbox.getChildren().add(adviceLabel2);
        pane.setBottom(adviceVbox);
    }

    public HBox createStatArea(Label label) {
        label.setTranslateY(3);

        HBox area = new HBox();
        area.setMinHeight(30);
        area.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Label emptySpace = new Label();
        emptySpace.setMinWidth(20);
        area.getChildren().add(emptySpace);
        area.getChildren().add(label);

        return area;
    }

}
