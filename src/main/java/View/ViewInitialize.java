package View;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.Player;


public class ViewInitialize
{
    public ViewInitialize(Stage stage)
    {
        Player player = new Player();
        MainScene mainScene = new MainScene(new BorderPane(), player);
        stage.setScene(mainScene);
    }

}
