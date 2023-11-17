import model.GameHandler;
import model.QuestionStorage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

 class QuestionTest
{
    @Test
    void testQuestion()
    {
        QuestionStorage questionStorage = new QuestionStorage();

        assertFalse(questionStorage.getQuestionList().isEmpty());
        assertEquals(questionStorage.getQuestionList().size(), questionStorage.getQuestionList().size());
    }

    @Test
    void testSetUpQuestion()
    {
        QuestionStorage questionStorage = new QuestionStorage();
        GameHandler gameHandler = new GameHandler();

        assertFalse(questionStorage.getQuestionList().isEmpty());

        gameHandler.setupQuestionList(15);

        assertThat(gameHandler.getQuestionList()).hasSize(15);
    }
}
