package util.stringUtilTranslate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.PathUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilTranslateString {

    private static final Properties engTradFile = new Properties();
    private static final Properties frTradFile = new Properties();
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

        // QUESTIONS CATEGORIES
        UtilStringStorage.geography = engTradFile.getProperty("geography");
        UtilStringStorage.historia = engTradFile.getProperty("historia");
        UtilStringStorage.linguistic = engTradFile.getProperty("linguistic");
        UtilStringStorage.animals = engTradFile.getProperty("animals");
        UtilStringStorage.insolite = engTradFile.getProperty("insolite");
        UtilStringStorage.paleontology = engTradFile.getProperty("paleontology");
        UtilStringStorage.videoGames = engTradFile.getProperty("videoGames");
        UtilStringStorage.cinema = engTradFile.getProperty("cinema");
        UtilStringStorage.space = engTradFile.getProperty("space");
        UtilStringStorage.plants = engTradFile.getProperty("plants");
        UtilStringStorage.music = engTradFile.getProperty("music");
        UtilStringStorage.literature = engTradFile.getProperty("literature");
        UtilStringStorage.humanBody = engTradFile.getProperty("humanBody");
        UtilStringStorage.records = engTradFile.getProperty("record");
        UtilStringStorage.culture = engTradFile.getProperty("culture");
        UtilStringStorage.law =engTradFile.getProperty("law");
        UtilStringStorage.mythology = engTradFile.getProperty("mythology");
        UtilStringStorage.society = engTradFile.getProperty("society");
        UtilStringStorage.internet = engTradFile.getProperty("internet");
        UtilStringStorage.flags = engTradFile.getProperty("flags");
        UtilStringStorage.sports = engTradFile.getProperty("sports");
        UtilStringStorage.painting = engTradFile.getProperty("painting");
        UtilStringStorage.minerals = engTradFile.getProperty("minerals");
        UtilStringStorage.nature = engTradFile.getProperty("nature");
        UtilStringStorage.invention = engTradFile.getProperty("invention");
        UtilStringStorage.science = engTradFile.getProperty("science");
        UtilStringStorage.monument = engTradFile.getProperty("monument");
        UtilStringStorage.economy = engTradFile.getProperty("economy");

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
        UtilStringStorage.numberOfGamesPlayed5Description = engTradFile.getProperty("numberOfGamesPlayed5");
        UtilStringStorage.numberOfGamesPlayed10Description = engTradFile.getProperty("numberOfGamesPlayed10");
        UtilStringStorage.numberOfGamesPlayed20Description = engTradFile.getProperty("numberOfGamesPlayed20");
        UtilStringStorage.numberOfGoodAnswer50Description = engTradFile.getProperty("numberOfGoodAnswer50");
        UtilStringStorage.numberOfGoodAnswer100Description = engTradFile.getProperty("numberOfGoodAnswer100");
        UtilStringStorage.numberOfGoodAnswer150Description = engTradFile.getProperty("numberOfGoodAnswer150");
        UtilStringStorage.secretAchievement = engTradFile.getProperty("secretAchievement");
        UtilStringStorage.secretLabel = engTradFile.getProperty("secretLabel");
        UtilStringStorage.successUnlock = engTradFile.getProperty("successUnlock");
        UtilStringStorage.successLock = engTradFile.getProperty("successLock");

        // LEADERBOARD
        UtilStringStorage.leaderBoardLabel = engTradFile.getProperty("leaderBoardLabel");
        UtilStringStorage.eraseTooltipLabel = engTradFile.getProperty("eraseTooltipLabel");
        UtilStringStorage.askToResetScore = engTradFile.getProperty("askToResetScore");
        UtilStringStorage.statisticLabel = engTradFile.getProperty("statisticLabel");
        UtilStringStorage.statisticTooltip = engTradFile.getProperty("statisticTooltip");
        UtilStringStorage.individualDeleteTooltip = engTradFile.getProperty("individualDeleteTooltip");
        UtilStringStorage.confirmIndividualDeleteGame = engTradFile.getProperty("confirmIndividualDeleteGame");

        // STATS SCENE
        UtilStringStorage.bestScoreIn10Label = engTradFile.getProperty("bestScoreIn10QuestionsLabel");
        UtilStringStorage.bestScoreIn15Label = engTradFile.getProperty("bestScoreIn15QuestionsLabel");
        UtilStringStorage.bestScoreIn20Label = engTradFile.getProperty("bestScoreIn20QuestionsLabel");
        UtilStringStorage.bestScoreSurvivalLabel = engTradFile.getProperty("bestScoreInSurvivalMode");
        UtilStringStorage.timePlayedLabel = engTradFile.getProperty("timePlayedLabel");
        UtilStringStorage.numberOfGamesLabel = engTradFile.getProperty("numberOfGamesLabel");
        UtilStringStorage.questionAnsweredLabel = engTradFile.getProperty("questionAnsweredLabel");
        UtilStringStorage.goodAnswerNumberLabel = engTradFile.getProperty("goodAnswerNumberLabel");
        UtilStringStorage.badAnswerNumberLabel = engTradFile.getProperty("badAnswerNumberLabel");
        UtilStringStorage.successPercentageLabel = engTradFile.getProperty("successPercentageLabel");
        UtilStringStorage.normalGameModeLabel = engTradFile.getProperty("normalGameModLabel");
        UtilStringStorage.survivalGameModeLabel = engTradFile.getProperty("survivalGameModLabel");

        // MENU SCENE
        UtilStringStorage.welcomeLabel = engTradFile.getProperty("welcomeLabel");
        UtilStringStorage.leaderBoardButton = engTradFile.getProperty("leaderBoardButton");
        UtilStringStorage.leaderBoardTooltip = engTradFile.getProperty("leaderBoardTooltip");
        UtilStringStorage.trophyButton = engTradFile.getProperty("trophyButton");
        UtilStringStorage.trophyTooltip = engTradFile.getProperty("trophyTooltip");
        UtilStringStorage.achievementButton = engTradFile.getProperty("achievementButton");
        UtilStringStorage.achievementTooltip = engTradFile.getProperty("achievementTooltip");
        UtilStringStorage.questionCreatorButton = engTradFile.getProperty("questionCreatorButton");
        UtilStringStorage.questionCreatorTooltip = engTradFile.getProperty("questionCreatorTooltip");
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
        UtilStringStorage.survivalGameOver = engTradFile.getProperty("survivalGameOver");
        UtilStringStorage.playerResult = engTradFile.getProperty("playerResult");
        UtilStringStorage.scoreOn = engTradFile.getProperty("scoreOn");
        UtilStringStorage.survivalLabel = engTradFile.getProperty("survivalLabel");
        UtilStringStorage.gameModLabel = engTradFile.getProperty("gameModLabel");
        UtilStringStorage.classicModeLabelInfile = engTradFile.getProperty("classicModeLabelInfile");
        UtilStringStorage.survivalLabelInfile = engTradFile.getProperty("survivalLabelInfile");
        UtilStringStorage.playerNameInfile = engTradFile.getProperty("playerNameInfile");
        UtilStringStorage.scoreLabelInfile = engTradFile.getProperty("scoreLabelInfile");
        UtilStringStorage.timerLabelInfile = engTradFile.getProperty("timerLabelInfile");
        UtilStringStorage.gameIn = engTradFile.getProperty("gameIn");
        UtilStringStorage.gameMinutes = engTradFile.getProperty("gameMinutes");
        UtilStringStorage.gameSecondes = engTradFile.getProperty("gameSecondes");
        UtilStringStorage.returnMenuConfirmAlert = engTradFile.getProperty("returnMenuConfirmAlert");

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
        UtilStringStorage.secretCupTrophy = engTradFile.getProperty("secretCupTrophy");

        //QUESTION CREATOR
        UtilStringStorage.creatorSceneTitleLabel = engTradFile.getProperty("creatorSceneTitleLabel");
        UtilStringStorage.sceneExplanationLabel = engTradFile.getProperty("sceneExplanationLabel");
        UtilStringStorage.createCategoryLabel = engTradFile.getProperty("createCategoryLabel");
        UtilStringStorage.createQuestionToAskLabel = engTradFile.getProperty("createQuestionToAskLabel");
        UtilStringStorage.createAnswerALabel = engTradFile.getProperty("createAnswerALabel");
        UtilStringStorage.createAnswerBLabel = engTradFile.getProperty("createAnswerBLabel");
        UtilStringStorage.createAnswerCLabel = engTradFile.getProperty("createAnswerCLabel");
        UtilStringStorage.createAnswerDLabel = engTradFile.getProperty("createAnswerDLabel");
        UtilStringStorage.createGoodAnswerLabel = engTradFile.getProperty("createGoodAnswerLabel");
        UtilStringStorage.createExplanationLabel = engTradFile.getProperty("createExplanationLabel");
        UtilStringStorage.validateCreationButton = engTradFile.getProperty("validateCreationButton");
        UtilStringStorage.questionIsForged = engTradFile.getProperty("questionIsForged");
        UtilStringStorage.questionIsNotForged = engTradFile.getProperty("questionIsNotForged");
        UtilStringStorage.personalizeListButtonTooltip = engTradFile.getProperty("personalizeListButtonTooltip");
        UtilStringStorage.personalizeQuestionListLabel = engTradFile.getProperty("personalizeQuestionListLabel");
        UtilStringStorage.confirmAlertDeleteAllQuestions = engTradFile.getProperty("confirmAlertHeaderText");
        UtilStringStorage.deleteAllLabel = engTradFile.getProperty("deleteAllLabel");
        UtilStringStorage.deleteAllTooltip = engTradFile.getProperty("deleteAllTooltip");
        UtilStringStorage.questionAreDeleted = engTradFile.getProperty("questionAreDeletedLabel");
        UtilStringStorage.nothingToDelete = engTradFile.getProperty("nothingToDelete");
        UtilStringStorage.questionListTitle = engTradFile.getProperty("questionListTitle");
        UtilStringStorage.noPersonalizeQuestionInList = engTradFile.getProperty("noPersonalizeQuestionInList");
        UtilStringStorage.individualQuestionTooltip = engTradFile.getProperty("individualQuestionTooltip");
        UtilStringStorage.individualConfirmDelete = engTradFile.getProperty("individualConfirmDelete");

        // OPTION SCENE
        UtilStringStorage.volumeLabel = engTradFile.getProperty("volumeLabel");
        UtilStringStorage.languageLabel = engTradFile.getProperty("languageLabel");
        UtilStringStorage.languageTooltip = engTradFile.getProperty("languageTooltip");
        UtilStringStorage.resetLabel = engTradFile.getProperty("resetLabel");
        UtilStringStorage.resetTooltip = engTradFile.getProperty("resetTooltip");
        UtilStringStorage.confirmAlertWindow = engTradFile.getProperty("confirmAlertWindow");
        UtilStringStorage.askConfirmReset = engTradFile.getProperty("askToReset");
        UtilStringStorage.exportLabel = engTradFile.getProperty("exportLabel");
        UtilStringStorage.exportButtonLabel = engTradFile.getProperty("exportButtonLabel");
        UtilStringStorage.confirmCopyFileLabel = engTradFile.getProperty("confirmCopyFileLabel");
        UtilStringStorage.exportInfoButton = engTradFile.getProperty("exportButtonInfo");
        UtilStringStorage.importLabel = engTradFile.getProperty("importLabel");
        UtilStringStorage.importButtonLabel = engTradFile.getProperty("importButtonLabel");
        UtilStringStorage.confirmImportLabel = engTradFile.getProperty("confirmImportLabel");
        UtilStringStorage.importInfoButton = engTradFile.getProperty("importButtonInfo");
        UtilStringStorage.importDirectoryLabel = engTradFile.getProperty("importDirectoryLabel");
        UtilStringStorage.importDirectoryButtonLabel = engTradFile.getProperty("importDirectoryButtonLabel");
        UtilStringStorage.importDirectoryInfoButton = engTradFile.getProperty("importDirectoryInfoButton");

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

        // QUESTIONS CATEGORIES
        UtilStringStorage.geography = frTradFile.getProperty("geography");
        UtilStringStorage.historia = frTradFile.getProperty("historia");
        UtilStringStorage.linguistic = frTradFile.getProperty("linguistic");
        UtilStringStorage.animals = frTradFile.getProperty("animals");
        UtilStringStorage.insolite = frTradFile.getProperty("insolite");
        UtilStringStorage.paleontology = frTradFile.getProperty("paleontology");
        UtilStringStorage.videoGames = frTradFile.getProperty("videoGames");
        UtilStringStorage.cinema = frTradFile.getProperty("cinema");
        UtilStringStorage.space = frTradFile.getProperty("space");
        UtilStringStorage.plants = frTradFile.getProperty("plants");
        UtilStringStorage.music = frTradFile.getProperty("music");
        UtilStringStorage.literature = frTradFile.getProperty("literature");
        UtilStringStorage.humanBody = frTradFile.getProperty("humanBody");
        UtilStringStorage.records = frTradFile.getProperty("record");
        UtilStringStorage.culture = frTradFile.getProperty("culture");
        UtilStringStorage.law =frTradFile.getProperty("law");
        UtilStringStorage.mythology = frTradFile.getProperty("mythology");
        UtilStringStorage.society = frTradFile.getProperty("society");
        UtilStringStorage.internet = frTradFile.getProperty("internet");
        UtilStringStorage.flags = frTradFile.getProperty("flags");
        UtilStringStorage.sports = frTradFile.getProperty("sports");
        UtilStringStorage.painting = frTradFile.getProperty("painting");
        UtilStringStorage.minerals = frTradFile.getProperty("minerals");
        UtilStringStorage.nature = frTradFile.getProperty("nature");
        UtilStringStorage.invention = frTradFile.getProperty("invention");
        UtilStringStorage.science = frTradFile.getProperty("science");
        UtilStringStorage.monument = frTradFile.getProperty("monument");
        UtilStringStorage.economy = frTradFile.getProperty("economy");

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
        UtilStringStorage.numberOfGamesPlayed5Description = frTradFile.getProperty("numberOfGamesPlayed5");
        UtilStringStorage.numberOfGamesPlayed10Description = frTradFile.getProperty("numberOfGamesPlayed10");
        UtilStringStorage.numberOfGamesPlayed20Description = frTradFile.getProperty("numberOfGamesPlayed20");
        UtilStringStorage.numberOfGoodAnswer50Description = frTradFile.getProperty("numberOfGoodAnswer50");
        UtilStringStorage.numberOfGoodAnswer100Description = frTradFile.getProperty("numberOfGoodAnswer100");
        UtilStringStorage.numberOfGoodAnswer150Description = frTradFile.getProperty("numberOfGoodAnswer150");
        UtilStringStorage.secretAchievement = frTradFile.getProperty("secretAchievement");
        UtilStringStorage.secretLabel = frTradFile.getProperty("secretLabel");
        UtilStringStorage.successUnlock = frTradFile.getProperty("successUnlock");
        UtilStringStorage.successLock = frTradFile.getProperty("successLock");

        //LEADERBOARD SCENE
        UtilStringStorage.leaderBoardLabel = frTradFile.getProperty("leaderBoardLabel");
        UtilStringStorage.eraseTooltipLabel = frTradFile.getProperty("eraseTooltipLabel");
        UtilStringStorage.askToResetScore = frTradFile.getProperty("askToResetScore");
        UtilStringStorage.statisticLabel = frTradFile.getProperty("statisticLabel");
        UtilStringStorage.statisticTooltip = frTradFile.getProperty("statisticTooltip");
        UtilStringStorage.individualDeleteTooltip = frTradFile.getProperty("individualDeleteTooltip");
        UtilStringStorage.confirmIndividualDeleteGame = frTradFile.getProperty("confirmIndividualDeleteGame");

        // STATS SCENE
        UtilStringStorage.bestScoreIn10Label = frTradFile.getProperty("bestScoreIn10QuestionsLabel");
        UtilStringStorage.bestScoreIn15Label = frTradFile.getProperty("bestScoreIn15QuestionsLabel");
        UtilStringStorage.bestScoreIn20Label = frTradFile.getProperty("bestScoreIn20QuestionsLabel");
        UtilStringStorage.bestScoreSurvivalLabel = frTradFile.getProperty("bestScoreInSurvivalMode");
        UtilStringStorage.timePlayedLabel = frTradFile.getProperty("timePlayedLabel");
        UtilStringStorage.numberOfGamesLabel = frTradFile.getProperty("numberOfGamesLabel");
        UtilStringStorage.questionAnsweredLabel = frTradFile.getProperty("questionAnsweredLabel");
        UtilStringStorage.goodAnswerNumberLabel = frTradFile.getProperty("goodAnswerNumberLabel");
        UtilStringStorage.badAnswerNumberLabel = frTradFile.getProperty("badAnswerNumberLabel");
        UtilStringStorage.successPercentageLabel = frTradFile.getProperty("successPercentageLabel");
        UtilStringStorage.normalGameModeLabel = frTradFile.getProperty("normalGameModLabel");
        UtilStringStorage.survivalGameModeLabel = frTradFile.getProperty("survivalGameModLabel");

        // MENU SCENE
        UtilStringStorage.welcomeLabel = frTradFile.getProperty("welcomeLabel");
        UtilStringStorage.leaderBoardButton = frTradFile.getProperty("leaderBoardButton");
        UtilStringStorage.leaderBoardTooltip = frTradFile.getProperty("leaderBoardTooltip");
        UtilStringStorage.trophyButton = frTradFile.getProperty("trophyButton");
        UtilStringStorage.trophyTooltip = frTradFile.getProperty("trophyTooltip");
        UtilStringStorage.achievementButton = frTradFile.getProperty("achievementButton");
        UtilStringStorage.achievementTooltip = frTradFile.getProperty("achievementTooltip");
        UtilStringStorage.questionCreatorButton = frTradFile.getProperty("questionCreatorButton");
        UtilStringStorage.questionCreatorTooltip = frTradFile.getProperty("questionCreatorTooltip");
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
        UtilStringStorage.survivalGameOver = frTradFile.getProperty("survivalGameOver");
        UtilStringStorage.playerResult = frTradFile.getProperty("playerResult");
        UtilStringStorage.scoreOn = frTradFile.getProperty("scoreOn");
        UtilStringStorage.survivalLabel = frTradFile.getProperty("survivalLabel");
        UtilStringStorage.gameModLabel = frTradFile.getProperty("gameModLabel");
        UtilStringStorage.classicModeLabelInfile = frTradFile.getProperty("classicModeLabelInfile");
        UtilStringStorage.survivalLabelInfile = frTradFile.getProperty("survivalLabelInfile");
        UtilStringStorage.playerNameInfile = frTradFile.getProperty("playerNameInfile");
        UtilStringStorage.scoreLabelInfile = frTradFile.getProperty("scoreLabelInfile");
        UtilStringStorage.timerLabelInfile = frTradFile.getProperty("timerLabelInfile");
        UtilStringStorage.gameIn = frTradFile.getProperty("gameIn");
        UtilStringStorage.gameMinutes = frTradFile.getProperty("gameMinutes");
        UtilStringStorage.gameSecondes = frTradFile.getProperty("gameSecondes");
        UtilStringStorage.returnMenuConfirmAlert = frTradFile.getProperty("returnMenuConfirmAlert");

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
        UtilStringStorage.secretCupTrophy = frTradFile.getProperty("secretCupTrophy");

        //QUESTION CREATOR
        UtilStringStorage.creatorSceneTitleLabel = frTradFile.getProperty("creatorSceneTitleLabel");
        UtilStringStorage.sceneExplanationLabel = frTradFile.getProperty("sceneExplanationLabel");
        UtilStringStorage.createCategoryLabel = frTradFile.getProperty("createCategoryLabel");
        UtilStringStorage.createQuestionToAskLabel = frTradFile.getProperty("createQuestionToAskLabel");
        UtilStringStorage.createAnswerALabel = frTradFile.getProperty("createAnswerALabel");
        UtilStringStorage.createAnswerBLabel = frTradFile.getProperty("createAnswerBLabel");
        UtilStringStorage.createAnswerCLabel = frTradFile.getProperty("createAnswerCLabel");
        UtilStringStorage.createAnswerDLabel = frTradFile.getProperty("createAnswerDLabel");
        UtilStringStorage.createGoodAnswerLabel = frTradFile.getProperty("createGoodAnswerLabel");
        UtilStringStorage.createExplanationLabel = frTradFile.getProperty("createExplanationLabel");
        UtilStringStorage.validateCreationButton = frTradFile.getProperty("validateCreationButton");
        UtilStringStorage.questionIsForged = frTradFile.getProperty("questionIsForged");
        UtilStringStorage.questionIsNotForged = frTradFile.getProperty("questionIsNotForged");
        UtilStringStorage.personalizeListButtonTooltip = frTradFile.getProperty("personalizeListButtonTooltip");
        UtilStringStorage.personalizeQuestionListLabel = frTradFile.getProperty("personalizeQuestionListLabel");
        UtilStringStorage.confirmAlertDeleteAllQuestions = frTradFile.getProperty("confirmAlertHeaderText");
        UtilStringStorage.deleteAllLabel = frTradFile.getProperty("deleteAllLabel");
        UtilStringStorage.deleteAllTooltip = frTradFile.getProperty("deleteAllTooltip");
        UtilStringStorage.questionAreDeleted = frTradFile.getProperty("questionAreDeletedLabel");
        UtilStringStorage.nothingToDelete = frTradFile.getProperty("nothingToDelete");
        UtilStringStorage.questionListTitle = frTradFile.getProperty("questionListTitle");
        UtilStringStorage.noPersonalizeQuestionInList = frTradFile.getProperty("noPersonalizeQuestionInList");
        UtilStringStorage.individualQuestionTooltip = frTradFile.getProperty("individualQuestionTooltip");
        UtilStringStorage.individualConfirmDelete = frTradFile.getProperty("individualConfirmDelete");

        // OPTION SCENE
        UtilStringStorage.volumeLabel = frTradFile.getProperty("volumeLabel");
        UtilStringStorage.languageLabel = frTradFile.getProperty("languageLabel");
        UtilStringStorage.languageTooltip = frTradFile.getProperty("languageTooltip");
        UtilStringStorage.resetLabel = frTradFile.getProperty("resetLabel");
        UtilStringStorage.resetTooltip = frTradFile.getProperty("resetTooltip");
        UtilStringStorage.confirmAlertWindow = frTradFile.getProperty("confirmAlertWindow");
        UtilStringStorage.askConfirmReset = frTradFile.getProperty("askToReset");
        UtilStringStorage.exportLabel = frTradFile.getProperty("exportLabel");
        UtilStringStorage.exportButtonLabel = frTradFile.getProperty("exportButtonLabel");
        UtilStringStorage.confirmCopyFileLabel = frTradFile.getProperty("confirmCopyFileLabel");
        UtilStringStorage.exportInfoButton = frTradFile.getProperty("exportButtonInfo");
        UtilStringStorage.importLabel = frTradFile.getProperty("importLabel");
        UtilStringStorage.importButtonLabel = frTradFile.getProperty("importButtonLabel");
        UtilStringStorage.confirmImportLabel = frTradFile.getProperty("confirmImportLabel");
        UtilStringStorage.importInfoButton = frTradFile.getProperty("importButtonInfo");
        UtilStringStorage.importDirectoryLabel = frTradFile.getProperty("importDirectoryLabel");
        UtilStringStorage.importDirectoryButtonLabel = frTradFile.getProperty("importDirectoryButtonLabel");
        UtilStringStorage.importDirectoryInfoButton = frTradFile.getProperty("importDirectoryInfoButton");

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

    public static Properties getEngTradFile() {
        return engTradFile;
    }

    public static Properties getFrTradFile() {
        return frTradFile;
    }
}
