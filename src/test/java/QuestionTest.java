import model.GameHandler;
import model.QuestionStorage;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest
{
    @Test
    public void testQuestion()
    {
        QuestionStorage questionStorage = new QuestionStorage();
        assertFalse(questionStorage.getQuestionList().isEmpty());
        assertEquals(questionStorage.getQuestionList().size(), questionStorage.getQuestionList().size());
    }

    @Test
    public void testSetUpQuestion()
    {
        QuestionStorage questionStorage = new QuestionStorage();
        assertFalse(questionStorage.getQuestionList().isEmpty());
        GameHandler gameHandler = new GameHandler();
        gameHandler.setupQuestionList(15);
        assertEquals(15, gameHandler.getQuestionList().size());
    }
}
