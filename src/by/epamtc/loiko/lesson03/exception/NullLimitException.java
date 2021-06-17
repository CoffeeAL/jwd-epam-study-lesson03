package by.epamtc.loiko.lesson03.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public class NullLimitException extends Exception {

    public NullLimitException(String message) {
        super(message);
    }

    public NullLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullLimitException(Throwable cause) {
        super(cause);
    }

    public NullLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}