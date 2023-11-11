import org.junit.Test;

public class ModelTest
{
    @Test
    public void testModel()
    {
        AchievementTest achievementTest = new AchievementTest();
        achievementTest.testAchievement();

        PlayerTest playerTest = new PlayerTest();
        playerTest.testPlayer();

        QuestionTest questionTest = new QuestionTest();
        questionTest.testQuestion();
        questionTest.testSetUpQuestion();

        TranslateTest translateTest = new TranslateTest();
        translateTest.testTranslate();

        TimerTest timerTest = new TimerTest();
        timerTest.testTimer();
    }
}
