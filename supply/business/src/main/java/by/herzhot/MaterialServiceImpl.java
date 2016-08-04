package by.herzhot;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Herzhot
 * @version 1.0
 *          03.08.2016
 */
@Stateless
public class MaterialServiceImpl implements IMaterialService {

    @Inject
    private IDao dao;

    @Override
    public String find(Long id) throws ServiceException {

        return (String) dao.find(id);


    }
}
