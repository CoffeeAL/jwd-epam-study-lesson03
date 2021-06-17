package by.epamtc.loiko.lesson03.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public class IllegalArrayValueCapacityException extends Exception {

    public IllegalArrayValueCapacityException(String message) {
        super(message);
    }

    public IllegalArrayValueCapacityException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalArrayValueCapacityException(Throwable cause) {
        super(cause);
    }

    public IllegalArrayValueCapacityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}