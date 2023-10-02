package view;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.*;

public class App extends Application
{
    public static MediaPlayer menuMusicToStop;
    @Override
    public void start(Stage stage)
    {
        UtilTranslateString utilTranslateString = new UtilTranslateString();
        LanguageScene languageScene = new LanguageScene(new BorderPane());
        stage.setScene(languageScene);
        stage.setTitle("Launcher");
        stage.show();
        languageScene.getEngButton().setOnAction(event -> {
            utilTranslateString.loadEngTradFile();
            utilTranslateString.translateEngString();
            AchievementManager achievementManager = new AchievementManager();
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(500);
            stage.setMinWidth(900);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });

        languageScene.getFrButton().setOnAction(event -> {
            utilTranslateString.loadFrTradFile();
            utilTranslateString.translateFrString();
            AchievementManager achievementManager = new AchievementManager();
            menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(500);
            stage.setMinWidth(900);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });

    }
}
