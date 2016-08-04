package by.herzhot;

import javax.ejb.Local;

/**
 * @author Herzhot
 * @version 1.0
 *          03.08.2016
 */
@Local
public interface IMaterialService<T> {

    T find(Long id) throws ServiceException;
}
