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
        UtilStringStorage.question1 = engTradFile.getProperty("question1");
        UtilStringStorage.answerA1 = engTradFile.getProperty("answerA1");
        UtilStringStorage.answerB1 = engTradFile.getProperty("answerB1");
        UtilStringStorage.answerC1 = engTradFile.getProperty("answerC1");
        UtilStringStorage.answerD1 = engTradFile.getProperty("answerD1");
        UtilStringStorage.goodAnswer1 = engTradFile.getProperty("goodAnswer1");
        UtilStringStorage.explanation1 = engTradFile.getProperty("explanation1");
        UtilStringStorage.question2 = engTradFile.getProperty("question2");
        UtilStringStorage.answerA2 = engTradFile.getProperty("answerA2");
        UtilStringStorage.answerB2 = engTradFile.getProperty("answerB2");
        UtilStringStorage.answerC2 = engTradFile.getProperty("answerC2");
        UtilStringStorage.answerD2 = engTradFile.getProperty("answerD2");
        UtilStringStorage.goodAnswer2 = engTradFile.getProperty("goodAnswer2");
        UtilStringStorage.explanation2 = engTradFile.getProperty("explanation2");
        UtilStringStorage.question3 = engTradFile.getProperty("question3");
        UtilStringStorage.answerA3 = engTradFile.getProperty("answerA3");
        UtilStringStorage.answerB3 = engTradFile.getProperty("answerB3");
        UtilStringStorage.answerC3 = engTradFile.getProperty("answerC3");
        UtilStringStorage.answerD3 = engTradFile.getProperty("answerD3");
        UtilStringStorage.goodAnswer3 = engTradFile.getProperty("goodAnswer3");
        UtilStringStorage.explanation3 = engTradFile.getProperty("explanation3");
        UtilStringStorage.question4 = engTradFile.getProperty("question4");
        UtilStringStorage.answerA4 = engTradFile.getProperty("answerA4");
        UtilStringStorage.answerB4 = engTradFile.getProperty("answerB4");
        UtilStringStorage.answerC4 = engTradFile.getProperty("answerC4");
        UtilStringStorage.answerD4 = engTradFile.getProperty("answerD4");
        UtilStringStorage.goodAnswer4 = engTradFile.getProperty("goodAnswer4");
        UtilStringStorage.explanation4 = engTradFile.getProperty("explanation4");
        UtilStringStorage.question5 = engTradFile.getProperty("question5");
        UtilStringStorage.answerA5 = engTradFile.getProperty("answerA5");
        UtilStringStorage.answerB5 = engTradFile.getProperty("answerB5");
        UtilStringStorage.answerC5 = engTradFile.getProperty("answerC5");
        UtilStringStorage.answerD5 = engTradFile.getProperty("answerD5");
        UtilStringStorage.goodAnswer5 = engTradFile.getProperty("goodAnswer5");
        UtilStringStorage.explanation5 = engTradFile.getProperty("explanation5");
        UtilStringStorage.question6 = engTradFile.getProperty("question6");
        UtilStringStorage.answerA6 = engTradFile.getProperty("answerA6");
        UtilStringStorage.answerB6 = engTradFile.getProperty("answerB6");
        UtilStringStorage.answerC6 = engTradFile.getProperty("answerC6");
        UtilStringStorage.answerD6 = engTradFile.getProperty("answerD6");
        UtilStringStorage.goodAnswer6 = engTradFile.getProperty("goodAnswer6");
        UtilStringStorage.explanation6 = engTradFile.getProperty("explanation6");
        UtilStringStorage.question7 = engTradFile.getProperty("question7");
        UtilStringStorage.answerA7 = engTradFile.getProperty("answerA7");
        UtilStringStorage.answerB7 = engTradFile.getProperty("answerB7");
        UtilStringStorage.answerC7 = engTradFile.getProperty("answerC7");
        UtilStringStorage.answerD7 = engTradFile.getProperty("answerD7");
        UtilStringStorage.goodAnswer7 = engTradFile.getProperty("goodAnswer7");
        UtilStringStorage.explanation7 = engTradFile.getProperty("explanation7");
        UtilStringStorage.question8 = engTradFile.getProperty("question8");
        UtilStringStorage.answerA8 = engTradFile.getProperty("answerA8");
        UtilStringStorage.answerB8 = engTradFile.getProperty("answerB8");
        UtilStringStorage.answerC8 = engTradFile.getProperty("answerC8");
        UtilStringStorage.answerD8 = engTradFile.getProperty("answerD8");
        UtilStringStorage.goodAnswer8 = engTradFile.getProperty("goodAnswer8");
        UtilStringStorage.explanation8 = engTradFile.getProperty("explanation8");
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
        UtilStringStorage.question1 = frTradFile.getProperty("question1");
        UtilStringStorage.answerA1 = frTradFile.getProperty("answerA1");
        UtilStringStorage.answerB1 = frTradFile.getProperty("answerB1");
        UtilStringStorage.answerC1 = frTradFile.getProperty("answerC1");
        UtilStringStorage.answerD1 = frTradFile.getProperty("answerD1");
        UtilStringStorage.goodAnswer1 = frTradFile.getProperty("goodAnswer1");
        UtilStringStorage.explanation1 = frTradFile.getProperty("explanation1");
        UtilStringStorage.question2 = frTradFile.getProperty("question2");
        UtilStringStorage.answerA2 = frTradFile.getProperty("answerA2");
        UtilStringStorage.answerB2 = frTradFile.getProperty("answerB2");
        UtilStringStorage.answerC2 = frTradFile.getProperty("answerC2");
        UtilStringStorage.answerD2 = frTradFile.getProperty("answerD2");
        UtilStringStorage.goodAnswer2 = frTradFile.getProperty("goodAnswer2");
        UtilStringStorage.explanation2 = frTradFile.getProperty("explanation2");
        UtilStringStorage.question3 = frTradFile.getProperty("question3");
        UtilStringStorage.answerA3 = frTradFile.getProperty("answerA3");
        UtilStringStorage.answerB3 = frTradFile.getProperty("answerB3");
        UtilStringStorage.answerC3 = frTradFile.getProperty("answerC3");
        UtilStringStorage.answerD3 = frTradFile.getProperty("answerD3");
        UtilStringStorage.goodAnswer3 = frTradFile.getProperty("goodAnswer3");
        UtilStringStorage.explanation3 = frTradFile.getProperty("explanation3");
        UtilStringStorage.question4 = frTradFile.getProperty("question4");
        UtilStringStorage.answerA4 = frTradFile.getProperty("answerA4");
        UtilStringStorage.answerB4 = frTradFile.getProperty("answerB4");
        UtilStringStorage.answerC4 = frTradFile.getProperty("answerC4");
        UtilStringStorage.answerD4 = frTradFile.getProperty("answerD4");
        UtilStringStorage.goodAnswer4 = frTradFile.getProperty("goodAnswer4");
        UtilStringStorage.explanation4 = frTradFile.getProperty("explanation4");
        UtilStringStorage.question5 = frTradFile.getProperty("question5");
        UtilStringStorage.answerA5 = frTradFile.getProperty("answerA5");
        UtilStringStorage.answerB5 = frTradFile.getProperty("answerB5");
        UtilStringStorage.answerC5 = frTradFile.getProperty("answerC5");
        UtilStringStorage.answerD5 = frTradFile.getProperty("answerD5");
        UtilStringStorage.goodAnswer5 = frTradFile.getProperty("goodAnswer5");
        UtilStringStorage.explanation5 = frTradFile.getProperty("explanation5");
        UtilStringStorage.question6 = frTradFile.getProperty("question6");
        UtilStringStorage.answerA6 = frTradFile.getProperty("answerA6");
        UtilStringStorage.answerB6 = frTradFile.getProperty("answerB6");
        UtilStringStorage.answerC6 = frTradFile.getProperty("answerC6");
        UtilStringStorage.answerD6 = frTradFile.getProperty("answerD6");
        UtilStringStorage.goodAnswer6 = frTradFile.getProperty("goodAnswer6");
        UtilStringStorage.explanation6 = frTradFile.getProperty("explanation6");
        UtilStringStorage.question7 = frTradFile.getProperty("question7");
        UtilStringStorage.answerA7 = frTradFile.getProperty("answerA7");
        UtilStringStorage.answerB7 = frTradFile.getProperty("answerB7");
        UtilStringStorage.answerC7 = frTradFile.getProperty("answerC7");
        UtilStringStorage.answerD7 = frTradFile.getProperty("answerD7");
        UtilStringStorage.goodAnswer7 = frTradFile.getProperty("goodAnswer7");
        UtilStringStorage.explanation7 = frTradFile.getProperty("explanation7");
        UtilStringStorage.question8 = frTradFile.getProperty("question8");
        UtilStringStorage.answerA8 = frTradFile.getProperty("answerA8");
        UtilStringStorage.answerB8 = frTradFile.getProperty("answerB8");
        UtilStringStorage.answerC8 = frTradFile.getProperty("answerC8");
        UtilStringStorage.answerD8 = frTradFile.getProperty("answerD8");
        UtilStringStorage.goodAnswer8 = frTradFile.getProperty("goodAnswer8");
        UtilStringStorage.explanation8 = frTradFile.getProperty("explanation8");
    }
}
