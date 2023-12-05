package view;

import javafx.application.Application;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.AchievementManager;
import util.FileUtil;
import util.PathUtil;
import util.UtilStringStorage;

public class App extends Application
{
    public static MediaPlayer menuMusicToStop;
    public static Hyperlink hyperLinkIcon;
    public static Hyperlink hyperLinkIcon2;
    public static Hyperlink hyperLinkBackground;
    public static void main (String[]args) {
        launch(args);
    }
    @Override
    public void start(Stage stage)
    {
        hyperLinkIcon = new Hyperlink(UtilStringStorage.iconLink);
        hyperLinkIcon2 = new Hyperlink(UtilStringStorage.iconLink2);
        hyperLinkBackground = new Hyperlink(UtilStringStorage.backgroundLink);
        hyperLinkIcon.setOnAction(linkEvent -> getHostServices().showDocument(hyperLinkIcon.getText()));
        hyperLinkIcon2.setOnAction(linkEvent -> getHostServices().showDocument(hyperLinkIcon2.getText()));
        hyperLinkBackground.setOnAction(linkEvent -> getHostServices().showDocument(hyperLinkBackground.getText()));

        FileUtil.createSaveFile();
        FileUtil.loadFile(FileUtil.generalSavesFile, PathUtil.GENERAL_SAVES_FILE);
        FileUtil.loadFile(FileUtil.personalizeQuestionsFile, PathUtil.PERSONALIZE_QUESTIONS_FILE);

        AchievementManager achievementManager = new AchievementManager();
        LanguageScene languageScene = new LanguageScene(new BorderPane(), stage, achievementManager);
        stage.setScene(languageScene);
        stage.setTitle("Launcher");
        stage.show();

    }
}
