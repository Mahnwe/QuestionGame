package View;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.GameHandler;
import org.example.Initialize;


public class ViewInitialize
{
    private MainScene mainScene;
    private GameHandler gameHandler;
    public ViewInitialize(Stage stage)
    {
        MainScene mainScene = new MainScene(new BorderPane(), stage);
        stage.setScene(mainScene);

    }

}
