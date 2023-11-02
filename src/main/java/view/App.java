package view;

import javafx.application.Application;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.AchievementManager;
import model.SoundManager;
import util.FileUtil;
import util.PathUtil;
import util.UtilStringStorage;
import util.UtilTranslateString;

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

        UtilTranslateString utilTranslateString = new UtilTranslateString();
        FileUtil.createSaveFile();
        FileUtil.loadFile(FileUtil.perfectScoreFile, PathUtil.PERFECT_SCORE_FILE);
        FileUtil.loadFile(FileUtil.cupFile, PathUtil.CUP_FILE);
        LanguageScene languageScene = new LanguageScene(new BorderPane());
        stage.setScene(languageScene);
        stage.setTitle("Launcher");
        stage.show();

        languageScene.getEngButton().setOnAction(event -> {
            utilTranslateString.translateEngString();
            AchievementManager achievementManager = new AchievementManager();
            menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(500);
            stage.setMinWidth(1000);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });

        languageScene.getFrButton().setOnAction(event -> {
            utilTranslateString.translateFrString();
            AchievementManager achievementManager = new AchievementManager();
            menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(500);
            stage.setMinWidth(1000);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });

    }
}
