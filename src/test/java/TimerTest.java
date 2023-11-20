import model.GameTimer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class TimerTest {

    private static final Logger logger = LogManager.getLogger(TimerTest.class);
    @Test
    void testTimer()
    {
        GameTimer.startTimer();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            logger.error("Timer error");
            fail();
        }

        GameTimer.stopTimer();
        GameTimer.setTimerDisplay();

        assertThat(GameTimer.getElapsedMinutes()).isZero();
        assertThat(GameTimer.getSecondsDisplay()).isEqualTo(2);
    }
}
