package view;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.AchievementManager;
import model.UtilStringStorage;
import model.UtilTranslateString;

public class App extends Application
{
    @Override
    public void start(Stage stage)
    {
        UtilTranslateString utilTranslateString = new UtilTranslateString();
        LanguageScene languageScene = new LanguageScene(new BorderPane());
        stage.setScene(languageScene);
        stage.setTitle("Turbo Jeu des Questions");
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
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(500);
            stage.setMinWidth(900);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });

    }
}
