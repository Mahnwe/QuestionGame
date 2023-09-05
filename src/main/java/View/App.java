package View;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application
{
    @Override
    public void start(Stage stage)
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage);
        stage.setMinHeight(500);
        stage.setMinWidth(900);
        stage.setScene(menuScene);
        stage.setTitle("Turbo Jeu des Questions");
        stage.show();

    }
}
