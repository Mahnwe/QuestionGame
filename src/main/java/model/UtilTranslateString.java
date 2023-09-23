package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class UtilTranslateString {

    Properties engTradFile = new Properties();
    Properties frTradFile = new Properties();

    public UtilTranslateString()
    {
        loadEngTradFile();
        loadFrTradFile();
    }

    public void loadEngTradFile()
    {
        try {
            engTradFile.load(Files.newInputStream(Path.of(PathUtil.ENG_TRAD_PROPERTIES_FILE)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadFrTradFile()
    {
        try {
            frTradFile.load(Files.newInputStream(Path.of(PathUtil.FR_TRAD_PROPERTIES_FILE)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void translateEngString()
    {
        UtilStringStorage.gameTitle = engTradFile.getProperty("engGameTitle");
        UtilStringStorage.returnButton = engTradFile.getProperty("returnButton");
        UtilStringStorage.validateButton = engTradFile.getProperty("Validate");
        UtilStringStorage.yesButton = engTradFile.getProperty("Yes");
        UtilStringStorage.noButton = engTradFile.getProperty("No");
        UtilStringStorage.goldCupAchievementDescription = engTradFile.getProperty("goldCupAchievementDescription");
        UtilStringStorage.silverCupAchievementDescription = engTradFile.getProperty("silverCupAchievementDescription");
        UtilStringStorage.bronzeCupAchievementDescription = engTradFile.getProperty("bronzeCupAchievementDescription");
        UtilStringStorage.perfectScore10Achievement = engTradFile.getProperty("perfectScore10Achievement");
        UtilStringStorage.perfectScore15Achievement = engTradFile.getProperty("perfectScore15Achievement");
        UtilStringStorage.perfectScore20Achievement = engTradFile.getProperty("perfectScore20Achievement");
        UtilStringStorage.successUnlock = engTradFile.getProperty("successUnlock");
        UtilStringStorage.successLock = engTradFile.getProperty("successLock");
    }

    public void translateFrString()
    {
        UtilStringStorage.gameTitle = frTradFile.getProperty("frGameTitle");
        UtilStringStorage.returnButton = frTradFile.getProperty("returnButton");
        UtilStringStorage.validateButton = frTradFile.getProperty("Valider");
        UtilStringStorage.yesButton = frTradFile.getProperty("Oui");
        UtilStringStorage.noButton = frTradFile.getProperty("Non");
        UtilStringStorage.goldCupAchievementDescription = frTradFile.getProperty("goldCupAchievementDescription");
        UtilStringStorage.silverCupAchievementDescription = frTradFile.getProperty("silverCupAchievementDescription");
        UtilStringStorage.bronzeCupAchievementDescription = frTradFile.getProperty("bronzeCupAchievementDescription");
        UtilStringStorage.perfectScore10Achievement = frTradFile.getProperty("perfectScore10Achievement");
        UtilStringStorage.perfectScore15Achievement = frTradFile.getProperty("perfectScore15Achievement");
        UtilStringStorage.perfectScore20Achievement = frTradFile.getProperty("perfectScore20Achievement");
        UtilStringStorage.successUnlock = frTradFile.getProperty("successUnlock");
        UtilStringStorage.successLock = frTradFile.getProperty("successLock");
    }
}
