package by.herzhot;


/**
 * @author Herzhot
 * @version 1.0
 *          03.08.2016
 */

public class DaoImpl implements IDao {


    @Override
    public String find(Long id)  {
        return id.toString()+"azaza";
    }
}
