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
        UtilStringStorage.validateButton = engTradFile.getProperty("validateButton");
        UtilStringStorage.yesButton = engTradFile.getProperty("yesButton");
        UtilStringStorage.noButton = engTradFile.getProperty("noButton");
        UtilStringStorage.goldCupAchievementDescription = engTradFile.getProperty("goldCupAchievementDescription");
        UtilStringStorage.silverCupAchievementDescription = engTradFile.getProperty("silverCupAchievementDescription");
        UtilStringStorage.bronzeCupAchievementDescription = engTradFile.getProperty("bronzeCupAchievementDescription");
        UtilStringStorage.perfectScore10Achievement = engTradFile.getProperty("perfectScore10Achievement");
        UtilStringStorage.perfectScore15Achievement = engTradFile.getProperty("perfectScore15Achievement");
        UtilStringStorage.perfectScore20Achievement = engTradFile.getProperty("perfectScore20Achievement");
        UtilStringStorage.successUnlock = engTradFile.getProperty("successUnlock");
        UtilStringStorage.successLock = engTradFile.getProperty("successLock");
        UtilStringStorage.leaderBoardLabel = engTradFile.getProperty("leaderBoardLabel");
        UtilStringStorage.welcomeLabel = engTradFile.getProperty("welcomeLabel");
        UtilStringStorage.leaderBoardButton = engTradFile.getProperty("leaderBoardButton");
        UtilStringStorage.leaderBoardTooltip = engTradFile.getProperty("leaderBoardTooltip");
        UtilStringStorage.trophyButton = engTradFile.getProperty("trophyButton");
        UtilStringStorage.trophyTooltip = engTradFile.getProperty("trophyTooltip");
        UtilStringStorage.achievementButton = engTradFile.getProperty("achievementButton");
        UtilStringStorage.achievementTooltip = engTradFile.getProperty("achievementTooltip");
        UtilStringStorage.chooseMode = engTradFile.getProperty("chooseMode");
        UtilStringStorage.mode10Button = engTradFile.getProperty("mode10Button");
        UtilStringStorage.mode15Button = engTradFile.getProperty("mode15Button");
        UtilStringStorage.mode20Button = engTradFile.getProperty("mode20Button");
        UtilStringStorage.scoreLabel = engTradFile.getProperty("scoreLabel");
        UtilStringStorage.questionNumber = engTradFile.getProperty("questionNumber");
        UtilStringStorage.congratsLabel = engTradFile.getProperty("congratsLabel");
        UtilStringStorage.answerAllQuestions = engTradFile.getProperty("answerAllQuestions");
        UtilStringStorage.playerResult = engTradFile.getProperty("playerResult");
        UtilStringStorage.scoreOn = engTradFile.getProperty("scoreOn");
        UtilStringStorage.playerNameInfile = engTradFile.getProperty("playerNameInfile");
        UtilStringStorage.scoreLabelInfile = engTradFile.getProperty("scoreLabelInfile");
        UtilStringStorage.gameIn = engTradFile.getProperty("gameIn");
        UtilStringStorage.gameMinutes = engTradFile.getProperty("gameMinutes");
        UtilStringStorage.gameSecondes = engTradFile.getProperty("gameSecondes");
        UtilStringStorage.askPlayerName = engTradFile.getProperty("askPlayerName");
        UtilStringStorage.playerNameIngame = engTradFile.getProperty("playerNameIngame");
        UtilStringStorage.scoreLabelIngame = engTradFile.getProperty("scoreLabelIngame");
        UtilStringStorage.confirmAlertWindow = engTradFile.getProperty("confirmAlertWindow");
        UtilStringStorage.askToConfirm = engTradFile.getProperty("askToConfirm");
        UtilStringStorage.nextQuestionButton = engTradFile.getProperty("nextQuestionButton");
        UtilStringStorage.goodAnswerLabel = engTradFile.getProperty("goodAnswerLabel");
        UtilStringStorage.badAnswerLabel = engTradFile.getProperty("badAnswerLabel");
        UtilStringStorage.returnToMenuButton = engTradFile.getProperty("returnToMenuButton");
        UtilStringStorage.timeLabel = engTradFile.getProperty("timeLabel");
        UtilStringStorage.minLabel = engTradFile.getProperty("minLabel");
        UtilStringStorage.secondesLabel = engTradFile.getProperty("secondesLabel");
        UtilStringStorage.noCupLabel = engTradFile.getProperty("noCupLabel");
        UtilStringStorage.goldCupLabel = engTradFile.getProperty("goldCupLabel");
        UtilStringStorage.silverCupLabel = engTradFile.getProperty("silverCupLabel");
        UtilStringStorage.bronzeCupLabel = engTradFile.getProperty("bronzeCupLabel");
        UtilStringStorage.goldCupTrophy = engTradFile.getProperty("goldCupTrophy");
        UtilStringStorage.silverCupTrophy = engTradFile.getProperty("silverCupTrophy");
        UtilStringStorage.bronzeCupTrophy = engTradFile.getProperty("bronzeCupTrophy");
    }

    public void translateFrString()
    {
        UtilStringStorage.gameTitle = frTradFile.getProperty("frGameTitle");
        UtilStringStorage.returnButton = frTradFile.getProperty("returnButton");
        UtilStringStorage.validateButton = frTradFile.getProperty("validateButton");
        UtilStringStorage.yesButton = frTradFile.getProperty("yesButton");
        UtilStringStorage.noButton = frTradFile.getProperty("noButton");
        UtilStringStorage.goldCupAchievementDescription = frTradFile.getProperty("goldCupAchievementDescription");
        UtilStringStorage.silverCupAchievementDescription = frTradFile.getProperty("silverCupAchievementDescription");
        UtilStringStorage.bronzeCupAchievementDescription = frTradFile.getProperty("bronzeCupAchievementDescription");
        UtilStringStorage.perfectScore10Achievement = frTradFile.getProperty("perfectScore10Achievement");
        UtilStringStorage.perfectScore15Achievement = frTradFile.getProperty("perfectScore15Achievement");
        UtilStringStorage.perfectScore20Achievement = frTradFile.getProperty("perfectScore20Achievement");
        UtilStringStorage.successUnlock = frTradFile.getProperty("successUnlock");
        UtilStringStorage.successLock = frTradFile.getProperty("successLock");
        UtilStringStorage.leaderBoardLabel = frTradFile.getProperty("leaderBoardLabel");
        UtilStringStorage.welcomeLabel = frTradFile.getProperty("welcomeLabel");
        UtilStringStorage.leaderBoardButton = frTradFile.getProperty("leaderBoardButton");
        UtilStringStorage.leaderBoardTooltip = frTradFile.getProperty("leaderBoardTooltip");
        UtilStringStorage.trophyButton = frTradFile.getProperty("trophyButton");
        UtilStringStorage.trophyTooltip = frTradFile.getProperty("trophyTooltip");
        UtilStringStorage.achievementButton = frTradFile.getProperty("achievementButton");
        UtilStringStorage.achievementTooltip = frTradFile.getProperty("achievementTooltip");
        UtilStringStorage.chooseMode = frTradFile.getProperty("chooseMode");
        UtilStringStorage.mode10Button = frTradFile.getProperty("mode10Button");
        UtilStringStorage.mode15Button = frTradFile.getProperty("mode15Button");
        UtilStringStorage.mode20Button = frTradFile.getProperty("mode20Button");
        UtilStringStorage.scoreLabel = frTradFile.getProperty("scoreLabel");
        UtilStringStorage.questionNumber = frTradFile.getProperty("questionNumber");
        UtilStringStorage.congratsLabel = frTradFile.getProperty("congratsLabel");
        UtilStringStorage.answerAllQuestions = frTradFile.getProperty("answerAllQuestions");
        UtilStringStorage.playerResult = frTradFile.getProperty("playerResult");
        UtilStringStorage.scoreOn = frTradFile.getProperty("scoreOn");
        UtilStringStorage.playerNameInfile = frTradFile.getProperty("playerNameInfile");
        UtilStringStorage.scoreLabelInfile = frTradFile.getProperty("scoreLabelInfile");
        UtilStringStorage.gameIn = frTradFile.getProperty("gameIn");
        UtilStringStorage.gameMinutes = frTradFile.getProperty("gameMinutes");
        UtilStringStorage.gameSecondes = frTradFile.getProperty("gameSecondes");
        UtilStringStorage.askPlayerName = frTradFile.getProperty("askPlayerName");
        UtilStringStorage.playerNameIngame = frTradFile.getProperty("playerNameIngame");
        UtilStringStorage.scoreLabelIngame = frTradFile.getProperty("scoreLabelIngame");
        UtilStringStorage.confirmAlertWindow = frTradFile.getProperty("confirmAlertWindow");
        UtilStringStorage.askToConfirm = frTradFile.getProperty("askToConfirm");
        UtilStringStorage.nextQuestionButton = frTradFile.getProperty("nextQuestionButton");
        UtilStringStorage.goodAnswerLabel = frTradFile.getProperty("goodAnswerLabel");
        UtilStringStorage.badAnswerLabel = frTradFile.getProperty("badAnswerLabel");
        UtilStringStorage.returnToMenuButton = frTradFile.getProperty("returnToMenuButton");
        UtilStringStorage.timeLabel = frTradFile.getProperty("timeLabel");
        UtilStringStorage.minLabel = frTradFile.getProperty("minLabel");
        UtilStringStorage.secondesLabel = frTradFile.getProperty("secondesLabel");
        UtilStringStorage.noCupLabel = frTradFile.getProperty("noCupLabel");
        UtilStringStorage.goldCupLabel = frTradFile.getProperty("goldCupLabel");
        UtilStringStorage.silverCupLabel = frTradFile.getProperty("silverCupLabel");
        UtilStringStorage.bronzeCupLabel = frTradFile.getProperty("bronzeCupLabel");
        UtilStringStorage.goldCupTrophy = frTradFile.getProperty("goldCupTrophy");
        UtilStringStorage.silverCupTrophy = frTradFile.getProperty("silverCupTrophy");
        UtilStringStorage.bronzeCupTrophy = frTradFile.getProperty("bronzeCupTrophy");
    }
}
