package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuestionException extends Exception {

    private static final Logger logger = LogManager.getLogger(QuestionException.class);

    public QuestionException(String message)
    {
        super(message);
        logger.error(message);
    }

}
