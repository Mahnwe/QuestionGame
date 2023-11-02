package util;

public class QuestionException extends Exception {

    public QuestionException(String message)
    {
        super(message);
    }

    @Override
    public String getMessage()
    {
        return super.getMessage();
    }

    public QuestionException(Throwable cause) {
        super(String.valueOf(cause));
    }

    public QuestionException(String message, Throwable cause) {
        super(message, cause);
    }
}
