package by.epamtc.loiko.lesson03.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public class NullTypeSortingException extends Exception {

    public NullTypeSortingException(String message) {
        super(message);
    }

    public NullTypeSortingException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullTypeSortingException(Throwable cause) {
        super(cause);
    }

    public NullTypeSortingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}