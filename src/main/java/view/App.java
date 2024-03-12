package view;

import javafx.application.Application;
import javafx.scene.control.Hyperlink;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.TimePlayedTimer;
import util.stringutiltranslate.UtilStringStorage;

public class App extends Application
{
    public static MediaPlayer menuMusicToStop;
    public static Hyperlink hyperLinkIcon;
    public static Hyperlink hyperLinkIcon2;
    public static Hyperlink hyperLinkBackground;

    public void createHyperLinks()
    {
        hyperLinkIcon = new Hyperlink(UtilStringStorage.iconLink);
        hyperLinkIcon2 = new Hyperlink(UtilStringStorage.iconLink2);
        hyperLinkBackground = new Hyperlink(UtilStringStorage.backgroundLink);
        hyperLinkIcon.setOnAction(linkEvent -> getHostServices().showDocument(hyperLinkIcon.getText()));
        hyperLinkIcon2.setOnAction(linkEvent -> getHostServices().showDocument(hyperLinkIcon2.getText()));
        hyperLinkBackground.setOnAction(linkEvent -> getHostServices().showDocument(hyperLinkBackground.getText()));
    }

    @Override
    public void start(Stage primaryStage)
    {
        createHyperLinks();
        TimePlayedTimer.startTimer();
        primaryStage.setWidth(1920);
        primaryStage.setHeight(1080);
        primaryStage.setResizable(false);
        LaunchManager.launchGame(primaryStage);
    }

    @Override
    public void stop()
    {
        // executed when the application shuts down
        TimePlayedTimer.calculateTimer();
    }

}
