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
        stage.setMinHeight(400);
        stage.setMinWidth(600);
        stage.setScene(menuScene);
        stage.setTitle("Turbo Jeu des Question");
        stage.show();

    }
}
