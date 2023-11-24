package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilTranslateString {

    public static Properties engTradFile = new Properties();
    public static Properties frTradFile = new Properties();
    private static final Logger logger = LogManager.getLogger(UtilTranslateString.class);
    private final UtilTranslateQuestion utilTranslateQuestion = new UtilTranslateQuestion();

    public UtilTranslateString()
    {
        loadEngTradFile();
        loadFrTradFile();
    }

    public void loadEngTradFile()
    {
        try (FileInputStream fileInputStream = new FileInputStream(PathUtil.ENG_TRAD_PROPERTIES_FILE)) {
            engTradFile.load(fileInputStream);
        } catch (IOException e) {
            logger.error("English trad file can't be load");
        }
    }

    public void loadFrTradFile()
    {
        try (FileInputStream fileInputStream = new FileInputStream(PathUtil.FR_TRAD_PROPERTIES_FILE)){
            frTradFile.load(fileInputStream);
        } catch (IOException e) {
            logger.error("French trad file can't be load");
        }
    }

    public void translateEngString()
    {
        // TITLE
        UtilStringStorage.gameTitle = engTradFile.getProperty("engGameTitle");

        // UTIL
        UtilStringStorage.englishLanguageTooltip = engTradFile.getProperty("englishLanguageTooltip");
        UtilStringStorage.frenchLanguageTooltip = engTradFile.getProperty("frenchLanguageTooltip");
        UtilStringStorage.returnButton = engTradFile.getProperty("returnButton");
        UtilStringStorage.validateButton = engTradFile.getProperty("validateButton");
        UtilStringStorage.yesButton = engTradFile.getProperty("yesButton");
        UtilStringStorage.noButton = engTradFile.getProperty("noButton");

        // ACHIEVEMENTS
        UtilStringStorage.achievementLabel = engTradFile.getProperty("achievementLabel");
        UtilStringStorage.goldCupAchievementDescription = engTradFile.getProperty("goldCupAchievementDescription");
        UtilStringStorage.silverCupAchievementDescription = engTradFile.getProperty("silverCupAchievementDescription");
        UtilStringStorage.bronzeCupAchievementDescription = engTradFile.getProperty("bronzeCupAchievementDescription");
        UtilStringStorage.perfectScore10Achievement = engTradFile.getProperty("perfectScore10Achievement");
        UtilStringStorage.perfectScore15Achievement = engTradFile.getProperty("perfectScore15Achievement");
        UtilStringStorage.perfectScore20Achievement = engTradFile.getProperty("perfectScore20Achievement");
        UtilStringStorage.survivalAchievement20Description = engTradFile.getProperty("survival20Achievement");
        UtilStringStorage.survivalAchievement30Description = engTradFile.getProperty("survival30Achievement");
        UtilStringStorage.survivalAchievement40Description = engTradFile.getProperty("survival40Achievement");
        UtilStringStorage.secretAchievement = engTradFile.getProperty("secretAchievement");
        UtilStringStorage.secretLabel = engTradFile.getProperty("secretLabel");
        UtilStringStorage.successUnlock = engTradFile.getProperty("successUnlock");
        UtilStringStorage.successLock = engTradFile.getProperty("successLock");

        // LEADERBOARD
        UtilStringStorage.leaderBoardLabel = engTradFile.getProperty("leaderBoardLabel");
        UtilStringStorage.eraseTooltipLabel = engTradFile.getProperty("eraseTooltipLabel");
        UtilStringStorage.askToResetScore = engTradFile.getProperty("askToResetScore");
        UtilStringStorage.resetScoreInfo = engTradFile.getProperty("resetScoreInfo");
        UtilStringStorage.bestScoreIn10Label = engTradFile.getProperty("bestScoreIn10QuestionsLabel");
        UtilStringStorage.bestScoreIn15Label = engTradFile.getProperty("bestScoreIn15QuestionsLabel");
        UtilStringStorage.bestScoreIn20Label = engTradFile.getProperty("bestScoreIn20QuestionsLabel");
        UtilStringStorage.bestScoreSurvivalLabel = engTradFile.getProperty("bestScoreInSurvivalMode");

        // MENU SCENE
        UtilStringStorage.welcomeLabel = engTradFile.getProperty("welcomeLabel");
        UtilStringStorage.leaderBoardButton = engTradFile.getProperty("leaderBoardButton");
        UtilStringStorage.leaderBoardTooltip = engTradFile.getProperty("leaderBoardTooltip");
        UtilStringStorage.trophyButton = engTradFile.getProperty("trophyButton");
        UtilStringStorage.trophyTooltip = engTradFile.getProperty("trophyTooltip");
        UtilStringStorage.achievementButton = engTradFile.getProperty("achievementButton");
        UtilStringStorage.achievementTooltip = engTradFile.getProperty("achievementTooltip");
        UtilStringStorage.optionButton = engTradFile.getProperty("optionButton");
        UtilStringStorage.optionTooltip = engTradFile.getProperty("optionTooltip");
        UtilStringStorage.creditButton = engTradFile.getProperty("creditButton");
        UtilStringStorage.creditTooltip = engTradFile.getProperty("creditTooltip");
        UtilStringStorage.chooseMode = engTradFile.getProperty("chooseMode");
        UtilStringStorage.mode10Button = engTradFile.getProperty("mode10Button");
        UtilStringStorage.mode15Button = engTradFile.getProperty("mode15Button");
        UtilStringStorage.mode20Button = engTradFile.getProperty("mode20Button");
        UtilStringStorage.modeSurvivalButton = engTradFile.getProperty("modeSurvivalButton");
        UtilStringStorage.launchGameButton = engTradFile.getProperty("launchGameButton");

        // MAIN SCENE
        UtilStringStorage.scoreLabel = engTradFile.getProperty("scoreLabel");
        UtilStringStorage.questionNumber = engTradFile.getProperty("questionNumber");
        UtilStringStorage.congratsLabel = engTradFile.getProperty("congratsLabel");
        UtilStringStorage.answerAllQuestions = engTradFile.getProperty("answerAllQuestions");
        UtilStringStorage.playerResult = engTradFile.getProperty("playerResult");
        UtilStringStorage.scoreOn = engTradFile.getProperty("scoreOn");
        UtilStringStorage.survivalLabel = engTradFile.getProperty("survivalLabel");
        UtilStringStorage.classicModeLabelInfile = engTradFile.getProperty("classicModeLabelInfile");
        UtilStringStorage.survivalLabelInfile = engTradFile.getProperty("survivalLabelInfile");
        UtilStringStorage.playerNameInfile = engTradFile.getProperty("playerNameInfile");
        UtilStringStorage.scoreLabelInfile = engTradFile.getProperty("scoreLabelInfile");
        UtilStringStorage.timerLabelInfile = engTradFile.getProperty("timerLabelInfile");
        UtilStringStorage.gameIn = engTradFile.getProperty("gameIn");
        UtilStringStorage.gameMinutes = engTradFile.getProperty("gameMinutes");
        UtilStringStorage.gameSecondes = engTradFile.getProperty("gameSecondes");

        // PLAYER INFO
        UtilStringStorage.askPlayerName = engTradFile.getProperty("askPlayerName");
        UtilStringStorage.playerNameIngame = engTradFile.getProperty("playerNameIngame");
        UtilStringStorage.scoreLabelIngame = engTradFile.getProperty("scoreLabelIngame");
        UtilStringStorage.playerLivesIngame = engTradFile.getProperty("playerLivesLabel");

        // QUESTION INTERFACE
        UtilStringStorage.nextQuestionButton = engTradFile.getProperty("nextQuestionButton");
        UtilStringStorage.goodAnswerLabel = engTradFile.getProperty("goodAnswerLabel");
        UtilStringStorage.badAnswerLabel = engTradFile.getProperty("badAnswerLabel");
        UtilStringStorage.validateAnswerButton = engTradFile.getProperty("validateAnswerButton");

        // RESULT SCENE
        UtilStringStorage.returnToMenuButton = engTradFile.getProperty("returnToMenuButton");
        UtilStringStorage.timeLabel = engTradFile.getProperty("timeLabel");
        UtilStringStorage.minLabel = engTradFile.getProperty("minLabel");
        UtilStringStorage.secondesLabel = engTradFile.getProperty("secondesLabel");
        UtilStringStorage.noSurviveLabel = engTradFile.getProperty("noSurviveLabel");
        UtilStringStorage.surviveEnoughGoldLabel = engTradFile.getProperty("surviveEnoughGoldLabel");
        UtilStringStorage.surviveEnoughSilverLabel = engTradFile.getProperty("surviveEnoughSilverLabel");
        UtilStringStorage.surviveEnoughBronzeLabel = engTradFile.getProperty("surviveEnoughBronzeLabel");
        UtilStringStorage.noCupLabel = engTradFile.getProperty("noCupLabel");
        UtilStringStorage.goldCupLabel = engTradFile.getProperty("goldCupLabel");
        UtilStringStorage.silverCupLabel = engTradFile.getProperty("silverCupLabel");
        UtilStringStorage.bronzeCupLabel = engTradFile.getProperty("bronzeCupLabel");
        UtilStringStorage.notificationTitle = engTradFile.getProperty("notificationTitle");
        UtilStringStorage.notificationText = engTradFile.getProperty("notificationText");

        // TROPHY
        UtilStringStorage.trophyLabel = engTradFile.getProperty("trophyLabel");
        UtilStringStorage.goldCupTrophy = engTradFile.getProperty("goldCupTrophy");
        UtilStringStorage.silverCupTrophy = engTradFile.getProperty("silverCupTrophy");
        UtilStringStorage.bronzeCupTrophy = engTradFile.getProperty("bronzeCupTrophy");

        // OPTION SCENE
        UtilStringStorage.volumeLabel = engTradFile.getProperty("volumeLabel");
        UtilStringStorage.languageLabel = engTradFile.getProperty("languageLabel");
        UtilStringStorage.languageTooltip = engTradFile.getProperty("languageTooltip");
        UtilStringStorage.resetLabel = engTradFile.getProperty("resetLabel");
        UtilStringStorage.resetTooltip = engTradFile.getProperty("resetTooltip");
        UtilStringStorage.confirmAlertWindow = engTradFile.getProperty("confirmAlertWindow");
        UtilStringStorage.askConfirmReset = engTradFile.getProperty("askToReset");
        UtilStringStorage.resetInfo = engTradFile.getProperty("resetInfo");

        // CREDIT SCENE
        UtilStringStorage.generalThank = engTradFile.getProperty("generalThank");
        UtilStringStorage.kebabThank = engTradFile.getProperty("kebabThank");
        UtilStringStorage.pandaThank = engTradFile.getProperty("pandaThank");
        UtilStringStorage.satanThank = engTradFile.getProperty("satanThank");
        UtilStringStorage.givrThank = engTradFile.getProperty("givrThank");
        UtilStringStorage.yukiThank = engTradFile.getProperty("yukiThank");
        UtilStringStorage.darkwestThank = engTradFile.getProperty("darkwestThank");
        UtilStringStorage.darkantThank = engTradFile.getProperty("darkantThank");
        UtilStringStorage.loveLabel = engTradFile.getProperty("loveLabel");
        UtilStringStorage.linkLabel = engTradFile.getProperty("linkLabel");

        //QUESTIONS
        utilTranslateQuestion.translateEngQuestions();


    }

    public void translateFrString()
    {
        // TITLE
        UtilStringStorage.gameTitle = frTradFile.getProperty("frGameTitle");

        // UTIL
        UtilStringStorage.englishLanguageTooltip = frTradFile.getProperty("englishLanguageTooltip");
        UtilStringStorage.frenchLanguageTooltip = frTradFile.getProperty("frenchLanguageTooltip");
        UtilStringStorage.returnButton = frTradFile.getProperty("returnButton");
        UtilStringStorage.validateButton = frTradFile.getProperty("validateButton");
        UtilStringStorage.yesButton = frTradFile.getProperty("yesButton");
        UtilStringStorage.noButton = frTradFile.getProperty("noButton");

        // ACHIEVEMENTS
        UtilStringStorage.achievementLabel = frTradFile.getProperty("achievementLabel");
        UtilStringStorage.goldCupAchievementDescription = frTradFile.getProperty("goldCupAchievementDescription");
        UtilStringStorage.silverCupAchievementDescription = frTradFile.getProperty("silverCupAchievementDescription");
        UtilStringStorage.bronzeCupAchievementDescription = frTradFile.getProperty("bronzeCupAchievementDescription");
        UtilStringStorage.perfectScore10Achievement = frTradFile.getProperty("perfectScore10Achievement");
        UtilStringStorage.perfectScore15Achievement = frTradFile.getProperty("perfectScore15Achievement");
        UtilStringStorage.perfectScore20Achievement = frTradFile.getProperty("perfectScore20Achievement");
        UtilStringStorage.survivalAchievement20Description = frTradFile.getProperty("survival20Achievement");
        UtilStringStorage.survivalAchievement30Description = frTradFile.getProperty("survival30Achievement");
        UtilStringStorage.survivalAchievement40Description = frTradFile.getProperty("survival40Achievement");
        UtilStringStorage.secretAchievement = frTradFile.getProperty("secretAchievement");
        UtilStringStorage.secretLabel = frTradFile.getProperty("secretLabel");
        UtilStringStorage.successUnlock = frTradFile.getProperty("successUnlock");
        UtilStringStorage.successLock = frTradFile.getProperty("successLock");

        //LEADERBOARD SCENE
        UtilStringStorage.leaderBoardLabel = frTradFile.getProperty("leaderBoardLabel");
        UtilStringStorage.eraseTooltipLabel = frTradFile.getProperty("eraseTooltipLabel");
        UtilStringStorage.askToResetScore = frTradFile.getProperty("askToResetScore");
        UtilStringStorage.resetScoreInfo = frTradFile.getProperty("resetScoreInfo");
        UtilStringStorage.bestScoreIn10Label = frTradFile.getProperty("bestScoreIn10QuestionsLabel");
        UtilStringStorage.bestScoreIn15Label = frTradFile.getProperty("bestScoreIn15QuestionsLabel");
        UtilStringStorage.bestScoreIn20Label = frTradFile.getProperty("bestScoreIn20QuestionsLabel");
        UtilStringStorage.bestScoreSurvivalLabel = frTradFile.getProperty("bestScoreInSurvivalMode");

        // MENU SCENE
        UtilStringStorage.welcomeLabel = frTradFile.getProperty("welcomeLabel");
        UtilStringStorage.leaderBoardButton = frTradFile.getProperty("leaderBoardButton");
        UtilStringStorage.leaderBoardTooltip = frTradFile.getProperty("leaderBoardTooltip");
        UtilStringStorage.trophyButton = frTradFile.getProperty("trophyButton");
        UtilStringStorage.trophyTooltip = frTradFile.getProperty("trophyTooltip");
        UtilStringStorage.achievementButton = frTradFile.getProperty("achievementButton");
        UtilStringStorage.achievementTooltip = frTradFile.getProperty("achievementTooltip");
        UtilStringStorage.optionButton = frTradFile.getProperty("optionButton");
        UtilStringStorage.optionTooltip = frTradFile.getProperty("optionTooltip");
        UtilStringStorage.creditButton = frTradFile.getProperty("creditButton");
        UtilStringStorage.creditTooltip = frTradFile.getProperty("creditTooltip");
        UtilStringStorage.chooseMode = frTradFile.getProperty("chooseMode");
        UtilStringStorage.mode10Button = frTradFile.getProperty("mode10Button");
        UtilStringStorage.mode15Button = frTradFile.getProperty("mode15Button");
        UtilStringStorage.mode20Button = frTradFile.getProperty("mode20Button");
        UtilStringStorage.modeSurvivalButton = frTradFile.getProperty("modeSurvivalButton");
        UtilStringStorage.launchGameButton = frTradFile.getProperty("launchGameButton");

        // MAIN SCENE
        UtilStringStorage.scoreLabel = frTradFile.getProperty("scoreLabel");
        UtilStringStorage.questionNumber = frTradFile.getProperty("questionNumber");
        UtilStringStorage.congratsLabel = frTradFile.getProperty("congratsLabel");
        UtilStringStorage.answerAllQuestions = frTradFile.getProperty("answerAllQuestions");
        UtilStringStorage.playerResult = frTradFile.getProperty("playerResult");
        UtilStringStorage.scoreOn = frTradFile.getProperty("scoreOn");
        UtilStringStorage.survivalLabel = frTradFile.getProperty("survivalLabel");
        UtilStringStorage.classicModeLabelInfile = frTradFile.getProperty("classicModeLabelInfile");
        UtilStringStorage.survivalLabelInfile = frTradFile.getProperty("survivalLabelInfile");
        UtilStringStorage.playerNameInfile = frTradFile.getProperty("playerNameInfile");
        UtilStringStorage.scoreLabelInfile = frTradFile.getProperty("scoreLabelInfile");
        UtilStringStorage.timerLabelInfile = frTradFile.getProperty("timerLabelInfile");
        UtilStringStorage.gameIn = frTradFile.getProperty("gameIn");
        UtilStringStorage.gameMinutes = frTradFile.getProperty("gameMinutes");
        UtilStringStorage.gameSecondes = frTradFile.getProperty("gameSecondes");

        // PLAYER INFO
        UtilStringStorage.askPlayerName = frTradFile.getProperty("askPlayerName");
        UtilStringStorage.playerNameIngame = frTradFile.getProperty("playerNameIngame");
        UtilStringStorage.scoreLabelIngame = frTradFile.getProperty("scoreLabelIngame");
        UtilStringStorage.playerLivesIngame = frTradFile.getProperty("playerLivesLabel");

        // QUESTION INTERFACE
        UtilStringStorage.nextQuestionButton = frTradFile.getProperty("nextQuestionButton");
        UtilStringStorage.goodAnswerLabel = frTradFile.getProperty("goodAnswerLabel");
        UtilStringStorage.badAnswerLabel = frTradFile.getProperty("badAnswerLabel");
        UtilStringStorage.validateAnswerButton = frTradFile.getProperty("validateAnswerButton");

        // RESULT SCENE
        UtilStringStorage.returnToMenuButton = frTradFile.getProperty("returnToMenuButton");
        UtilStringStorage.timeLabel = frTradFile.getProperty("timeLabel");
        UtilStringStorage.minLabel = frTradFile.getProperty("minLabel");
        UtilStringStorage.secondesLabel = frTradFile.getProperty("secondesLabel");
        UtilStringStorage.noSurviveLabel = frTradFile.getProperty("noSurviveLabel");
        UtilStringStorage.surviveEnoughGoldLabel = frTradFile.getProperty("surviveEnoughGoldLabel");
        UtilStringStorage.surviveEnoughSilverLabel = frTradFile.getProperty("surviveEnoughSilverLabel");
        UtilStringStorage.surviveEnoughBronzeLabel = frTradFile.getProperty("surviveEnoughBronzeLabel");
        UtilStringStorage.noCupLabel = frTradFile.getProperty("noCupLabel");
        UtilStringStorage.goldCupLabel = frTradFile.getProperty("goldCupLabel");
        UtilStringStorage.silverCupLabel = frTradFile.getProperty("silverCupLabel");
        UtilStringStorage.bronzeCupLabel = frTradFile.getProperty("bronzeCupLabel");
        UtilStringStorage.notificationTitle = frTradFile.getProperty("notificationTitle");
        UtilStringStorage.notificationText = frTradFile.getProperty("notificationText");

        // TROPHY SCENE
        UtilStringStorage.trophyLabel = frTradFile.getProperty("trophyLabel");
        UtilStringStorage.goldCupTrophy = frTradFile.getProperty("goldCupTrophy");
        UtilStringStorage.silverCupTrophy = frTradFile.getProperty("silverCupTrophy");
        UtilStringStorage.bronzeCupTrophy = frTradFile.getProperty("bronzeCupTrophy");

        // OPTION SCENE
        UtilStringStorage.volumeLabel = frTradFile.getProperty("volumeLabel");
        UtilStringStorage.languageLabel = frTradFile.getProperty("languageLabel");
        UtilStringStorage.languageTooltip = frTradFile.getProperty("languageTooltip");
        UtilStringStorage.resetLabel = frTradFile.getProperty("resetLabel");
        UtilStringStorage.resetTooltip = frTradFile.getProperty("resetTooltip");
        UtilStringStorage.confirmAlertWindow = frTradFile.getProperty("confirmAlertWindow");
        UtilStringStorage.askConfirmReset = frTradFile.getProperty("askToReset");
        UtilStringStorage.resetInfo = frTradFile.getProperty("resetInfo");

        // CREDIT SCENE
        UtilStringStorage.generalThank = frTradFile.getProperty("generalThank");
        UtilStringStorage.kebabThank = frTradFile.getProperty("kebabThank");
        UtilStringStorage.pandaThank = frTradFile.getProperty("pandaThank");
        UtilStringStorage.satanThank = frTradFile.getProperty("satanThank");
        UtilStringStorage.givrThank = frTradFile.getProperty("givrThank");
        UtilStringStorage.yukiThank = frTradFile.getProperty("yukiThank");
        UtilStringStorage.darkwestThank = frTradFile.getProperty("darkwestThank");
        UtilStringStorage.darkantThank = frTradFile.getProperty("darkantThank");
        UtilStringStorage.loveLabel = frTradFile.getProperty("loveLabel");
        UtilStringStorage.linkLabel = frTradFile.getProperty("linkLabel");

        //QUESTIONS
        utilTranslateQuestion.translateFrQuestions();

    }
}
