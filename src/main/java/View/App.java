package View;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application
{
    @Override
    public void start(Stage stage)
    {
        ViewInitialize viewInitialize = new ViewInitialize(stage);
        stage.show();

    }
}
