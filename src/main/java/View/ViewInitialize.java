package View;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.GameHandler;


public class ViewInitialize
{
    public ViewInitialize(Stage stage)
    {
        MainScene mainScene = new MainScene(new BorderPane(), stage);
        stage.setScene(mainScene);

    }

}
