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
    public static Hyperlink hyperLinkBackground;
    @Override
    public void start(Stage stage)
    {
        hyperLinkIcon = new Hyperlink(UtilStringStorage.iconLink);
        hyperLinkBackground = new Hyperlink(UtilStringStorage.backgroundLink);
        hyperLinkIcon.setOnAction(linkEvent -> getHostServices().showDocument(hyperLinkIcon.getText()));
        hyperLinkBackground.setOnAction(linkEvent -> getHostServices().showDocument(hyperLinkBackground.getText()));

        FileUtil.createSaveFile();
        FileUtil.loadFile(FileUtil.perfectScoreFile, PathUtil.PERFECT_SCORE_FILE);
        FileUtil.loadFile(FileUtil.cupFile, PathUtil.CUP_FILE);
        FileUtil.loadFile(FileUtil.survivalFile, PathUtil.SURVIVAL_FILE);

        AchievementManager achievementManager = new AchievementManager();
        LanguageScene languageScene = new LanguageScene(new BorderPane(), stage, achievementManager);
        stage.setScene(languageScene);
        stage.setTitle("Launcher");
        stage.show();

    }
}
