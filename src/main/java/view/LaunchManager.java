package view;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.handlers.AchievementManager;
import model.handlers.SoundManager;
import util.FileUtil;
import util.PathUtil;
import util.stringutiltranslate.UtilStringStorage;
import util.stringutiltranslate.UtilTranslateString;
import view.scene.LanguageScene;
import view.scene.MenuScene;

public class LaunchManager {

    public static void launchGame(Stage stage)
    {
        FileUtil.createAndLoadFiles();
        UtilTranslateString utilTranslateString = new UtilTranslateString();
        AchievementManager achievementManager = new AchievementManager();

        checkSavedLanguage(utilTranslateString, stage, achievementManager);
    }

    public static void checkSavedLanguage(UtilTranslateString utilTranslateString, Stage stage, AchievementManager achievementManager)
    {
        if(FileUtil.getGeneralSavesFile().getProperty("saveLanguageOption").equals("French"))
        {
            launchGameInFr(utilTranslateString, stage, achievementManager);
        }
        else if(FileUtil.getGeneralSavesFile().getProperty("saveLanguageOption").equals("English"))
        {
            launchGameInEng(utilTranslateString, stage, achievementManager);
        }
        else if(FileUtil.getGeneralSavesFile().getProperty("saveLanguageOption").equals("Blank"))
        {
            launchGameWithNoLanguageSaved(stage, achievementManager);
        }
    }

    public static void launchGameInFr(UtilTranslateString utilTranslateString, Stage stage, AchievementManager achievementManager)
    {
        utilTranslateString.translateFrString();
        App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
        stage.setTitle(UtilStringStorage.gameTitle);
        stage.show();
    }

    public static void launchGameInEng(UtilTranslateString utilTranslateString, Stage stage, AchievementManager achievementManager)
    {
        utilTranslateString.translateEngString();
        App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
        stage.setTitle(UtilStringStorage.gameTitle);
        stage.show();
    }

    public static void launchGameWithNoLanguageSaved(Stage stage, AchievementManager achievementManager)
    {
        LanguageScene languageScene = new LanguageScene(new BorderPane(), stage, achievementManager);
        stage.setScene(languageScene);
        stage.setTitle("Launcher");
        stage.show();
    }

}
