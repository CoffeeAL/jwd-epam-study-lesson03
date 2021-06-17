package by.epamtc.loiko.lesson03.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public class IllegalIntervalException extends Exception {

    public IllegalIntervalException(String message) {
        super(message);
    }

    public IllegalIntervalException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalIntervalException(Throwable cause) {
        super(cause);
    }

    public IllegalIntervalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}