package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.GameHandler;
import org.example.Player;


public class MenuScene extends Scene
{
    private BorderPane pane;
    private Player player;

    private MainScene mainScene;

    private Stage stage;

    private Button fiveModeButton;
    private Button tenModeButton;

    private GameHandler gameHandler;
    public MenuScene(BorderPane pane, Stage stage)
    {
        super(pane);
        this.pane = pane;
        this.stage = stage;
        this.gameHandler = new GameHandler();
        createWelcomeArea();
        createButtonArea();
        setButtonOnAction();
    }

    public void createWelcomeArea()
    {
        VBox welcomeArea = new VBox();
        Label welcomeInGame = new Label("Welcome in the Turbo Question Game !");
        welcomeArea.getChildren().add(createStatArea(welcomeInGame));
        pane.setTop(welcomeArea);
    }

    public void createButtonArea()
    {
        VBox selectModeArea = new VBox();

        Label chooseMode = new Label("Click on the mod that you want to play !");

        fiveModeButton = new Button("Five questions");
        fiveModeButton.setTranslateX(10);
        fiveModeButton.setTranslateY(10);

        tenModeButton = new Button("Ten questions");
        tenModeButton.setTranslateX(10);
        tenModeButton.setTranslateY(30);

        selectModeArea.getChildren().add(createStatArea(chooseMode));
        selectModeArea.getChildren().add(fiveModeButton);
        selectModeArea.getChildren().add(tenModeButton);
        pane.setCenter(selectModeArea);
    }

    public void setButtonOnAction()
    {
        fiveModeButton.setOnAction(event -> {
            gameHandler.fiveQuestionList();
            Player player = new Player();
            MainScene mainScene = new MainScene(new BorderPane(), player, gameHandler);
            stage.setScene(mainScene);
        });

        tenModeButton.setOnAction(event -> {
            gameHandler.tenQuestionList();
            Player player = new Player();
            MainScene mainScene = new MainScene(new BorderPane(), player, gameHandler);
            stage.setScene(mainScene);
        });
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

    public GameHandler getGameHandler() {
        return gameHandler;
    }
}
