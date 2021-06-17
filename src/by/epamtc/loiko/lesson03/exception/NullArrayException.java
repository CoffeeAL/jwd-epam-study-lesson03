package by.epamtc.loiko.lesson03.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public class NullArrayException extends Exception {

    public NullArrayException(String message) {
        super(message);
    }

    public NullArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullArrayException(Throwable cause) {
        super(cause);
    }

    public NullArrayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}