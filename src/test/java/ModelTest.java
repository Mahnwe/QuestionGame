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
        questionTest.createElements();
        questionTest.testQuestion();
        questionTest.testSetUpQuestionInNormalMod();
        questionTest.createElements();
        questionTest.testSetUpSurvivalMod();

        TranslateTest translateTest = new TranslateTest();
        translateTest.createTranslateElement();
        translateTest.testFrTranslate();
        translateTest.testEngTranslate();

        TimerTest timerTest = new TimerTest();
        timerTest.testTimer();
    }
}
