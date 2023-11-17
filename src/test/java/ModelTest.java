import org.junit.jupiter.api.Test;

 class ModelTest
{
    @Test
     void testModel()
    {
        AchievementTest achievementTest = new AchievementTest();
        achievementTest.testAchievement();

        PlayerTest playerTest = new PlayerTest();
        playerTest.testPlayer();

        QuestionTest questionTest = new QuestionTest();
        questionTest.testQuestion();
        questionTest.testSetUpQuestionInNormalMod();
        questionTest.testSetUpSurvivalMod();

        TranslateTest translateTest = new TranslateTest();
        translateTest.testTranslate();

        TimerTest timerTest = new TimerTest();
        timerTest.testTimer();
    }
}
