import junit.framework.TestCase;
import model.GameTimer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class TimerTest {

    private static final Logger logger = LogManager.getLogger(TimerTest.class);
    @Test
    public void testTimer()
    {
        GameTimer.startTimer();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            logger.error("Timer error");
            TestCase.fail();
        }
        GameTimer.stopTimer();
        GameTimer.setTimerDisplay();
        assertEquals(0, GameTimer.getElapsedMinutes());
        assertEquals(5, GameTimer.getSecondsDisplay());
    }
}
