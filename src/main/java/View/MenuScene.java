package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.GameHandler;
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

        createWelcomeArea();
        createLeaderBoardButtonArea();
        createButtonArea();
        setButtonOnAction();
    }

    public void createWelcomeArea()
    {
        VBox welcomeArea = new VBox();
        Label welcomeInGame = new Label("Bienvenue dans le Turbo Jeu des Questions !");
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
        leaderBoardVBox.setMinWidth(100);

        Button leaderBoardButton = new Button("Classement");
        placeButtons(leaderBoardButton, 10, 30);

        Button trophyButton = new Button("Trophées");
        placeButtons(trophyButton, 10, 60);

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
        chooseMode.setTranslateX(100);

        tenModeButton = new Button("Dix questions");
        placeButtons(tenModeButton, 200, 10);

        fifteenModeButton = new Button("Quinze questions");
        placeButtons(fifteenModeButton, 200, 30);

        twentyModeButton = new Button("Vingt questions");
        placeButtons(twentyModeButton, 200, 50);


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
        stage.setScene(mainScene);
        stage.setMinHeight(450);
        stage.setMinWidth(850);
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
