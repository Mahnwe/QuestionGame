import model.handlers.GameHandler;
import model.QuestionStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.FileUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

 class QuestionTest
{
    private QuestionStorage questionStorage;
    private GameHandler gameHandler;
    private int questionBankSize;
    @BeforeEach
    void createElements()
    {
        FileUtil.createAndLoadFiles();
       questionStorage = new QuestionStorage();
       gameHandler = new GameHandler();
       questionBankSize = questionStorage.getQuestionList().size();
    }
    @Test
    void testQuestionListSize()
    {
        assertFalse(questionStorage.getQuestionList().isEmpty());

        assertEquals(questionBankSize, questionStorage.getQuestionList().size());
    }

    @Test
    void testSetUpQuestionInNormalMod()
    {
        gameHandler.setupQuestionList(15);

        assertThat(gameHandler.getQuestionList()).hasSize(15);
    }

    @Test
    void testSetUpSurvivalMod()
    {
        gameHandler.setUpSurvivalMode();

        assertThat(gameHandler.getQuestionList()).hasSize(questionBankSize);
    }
}
