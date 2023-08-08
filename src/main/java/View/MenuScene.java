package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.GameHandler;
import org.example.Player;

import java.io.File;


public class MenuScene extends Scene
{
    private final BorderPane pane;

    private final Stage stage;

    private Button fiveModeButton;
    private Button tenModeButton;
    private Button fifteenModeButton;
    private final GameHandler gameHandler;
    private final File saveFile;
    private final Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    public MenuScene(BorderPane pane, Stage stage)
    {
        super(pane);
        this.pane = pane;
        this.stage = stage;
        this.gameHandler = new GameHandler();
        saveFile = new File("./src/main/resources/SaveFile/saveScoresFile");
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
        Button leaderBoardButton = new Button("LeaderBoard");
        placeButtons(leaderBoardButton, 0, 30);
        leaderBoardButton.setOnAction(event -> {
            LeaderBoardScene leaderBoardScene = new LeaderBoardScene(new BorderPane(), saveFile);
            leaderBoardScene.displayLeaderBoard();
        });
        leaderBoardVBox.getChildren().add(leaderBoardButton);
        pane.setLeft(leaderBoardVBox);
    }

    public void createButtonArea()
    {
        VBox selectModeArea = new VBox();

        Label chooseMode = new Label("Cliquez sur le nombre de questions auquel vous voulez répondre");

        fiveModeButton = new Button("Cinq questions");
        placeButtons(fiveModeButton, 10, 10);

        tenModeButton = new Button("Dix questions");
        placeButtons(tenModeButton, 10, 30);

        fifteenModeButton = new Button("Quinze questions");
        placeButtons(fifteenModeButton, 10, 50);


        selectModeArea.getChildren().add(createStatArea(chooseMode));
        selectModeArea.getChildren().add(fiveModeButton);
        selectModeArea.getChildren().add(tenModeButton);
        selectModeArea.getChildren().add(fifteenModeButton);
        pane.setCenter(selectModeArea);
    }

    public void setButtonOnAction()
    {
        fiveModeButton.setOnAction(event -> {
            gameHandler.fiveQuestionList();
            instantiateMainScene();
        });

        tenModeButton.setOnAction(event -> {
            gameHandler.tenQuestionList();
            instantiateMainScene();
        });

        fifteenModeButton.setOnAction(event -> {
            gameHandler.fifteenQuestionList();
            instantiateMainScene();
        });
    }

    public void instantiateMainScene()
    {
        Player player = new Player();
        MainScene mainScene = new MainScene(new BorderPane(), player, gameHandler, stage, saveFile);
        stage.setScene(mainScene);
        stage.setMinHeight(400);
        stage.setMinWidth(750);
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
