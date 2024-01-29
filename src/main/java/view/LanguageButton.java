package view;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.AchievementManager;
import model.SoundManager;
import util.*;

public class LanguageButton extends Button {

    public LanguageButton (String imagePath, String tooltipLanguage)
    {
        IconCreator englishIcon = new IconCreator(imagePath);
        Image englishFlag = englishIcon.createImage().getImage();

        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        this.setBackground(new Background(new BackgroundImage(englishFlag, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));

        this.setMinWidth(130);
        this.setMinHeight(80);
        this.setTranslateX(40);
        this.setTranslateY(30);

        Tooltip buttonTooltip = new Tooltip(tooltipLanguage);
        this.setTooltip(buttonTooltip);

        this.setOnMouseEntered(event -> {
            this.setEffect(CustomOption.glow);
            this.setBorder(CustomOption.createCustomBorder(1.0, 2.0, Color.GHOSTWHITE));
        });

        this.setOnMouseExited(event -> {
            this.setEffect(null);
            this.setBorder(null);
        });
    }

    public void setUpEnglishLanguageButton(Button button, UtilTranslateString utilTranslateString, Stage stage, AchievementManager achievementManager, boolean isMusicPlaying)
    {
        button.setOnAction(event -> {
            utilTranslateString.translateEngString();
            if(isMusicPlaying) { SoundManager.checkIfMusicIsPlayed(App.menuMusicToStop); }

            FileUtil.getGeneralSavesFile().setProperty("saveLanguageOption", "English");
            FileUtil.storeGeneralSavesFile();
            App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(750);
            stage.setMinWidth(1200);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });
    }
    public void setUpFrenchLanguageButton(Button button, UtilTranslateString utilTranslateString, Stage stage, AchievementManager achievementManager, boolean isMusicPlaying)
    {
        button.setOnAction(event -> {
            utilTranslateString.translateFrString();
            if(isMusicPlaying)
            {
                SoundManager.checkIfMusicIsPlayed(App.menuMusicToStop);
            }
            FileUtil.getGeneralSavesFile().setProperty("saveLanguageOption", "French");
            FileUtil.storeGeneralSavesFile();
            App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setMinHeight(750);
            stage.setMinWidth(1200);
            stage.setScene(menuScene);
            stage.setTitle(UtilStringStorage.gameTitle);
            stage.show();
        });
    }
}
