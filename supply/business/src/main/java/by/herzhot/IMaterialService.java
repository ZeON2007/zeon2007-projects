package by.herzhot;

import by.herzhot.exceptions.ServiceException;

import javax.ejb.Local;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          09.08.2016
 */
@Local
public interface IMaterialService extends IService<Material> {

    List<Material> findByCriterion(String criterion) throws ServiceException;

}
