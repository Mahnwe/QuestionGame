package view;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.handlers.AchievementManager;
import model.handlers.SoundManager;
import util.FileUtil;
import util.PathUtil;
import util.stringUtilTranslate.UtilStringStorage;
import util.stringUtilTranslate.UtilTranslateString;
import view.scene.LanguageScene;
import view.scene.MenuScene;

public class LaunchManager {

    public static void launchGame(Stage stage)
    {
        UtilTranslateString utilTranslateString = new UtilTranslateString();
        AchievementManager achievementManager = new AchievementManager();
        if(FileUtil.getGeneralSavesFile().getProperty("saveLanguageOption").equals("French"))
        {
            utilTranslateString.translateFrString();
            App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        }
        else if(FileUtil.getGeneralSavesFile().getProperty("saveLanguageOption").equals("English"))
        {
            utilTranslateString.translateEngString();
            App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        }
        else if(FileUtil.getGeneralSavesFile().getProperty("saveLanguageOption").equals("Blank"))
        {
            LanguageScene languageScene = new LanguageScene(new BorderPane(), stage, achievementManager);
            stage.setScene(languageScene);
            stage.setTitle("Launcher");
            stage.show();
        }
    }

}
