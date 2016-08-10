package by.herzhot.exceptions;

/**
 * @author Herzhot
 * @version 1.0
 *          30.05.2016
 */
public class DaoException extends Exception {

    public DaoException() {}
    public DaoException(String message) {
        super(message);
    }
    public DaoException(Throwable cause) {
        super(cause);
    }
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
