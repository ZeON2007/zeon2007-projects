package by.herzhot.exceptions;

/**
 * @author Herzhot
 * @version 1.0
 *          30.05.2016
 */
public class ServiceException extends Exception {

    public ServiceException() {}
    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(Throwable cause) {
        super(cause);
    }
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
