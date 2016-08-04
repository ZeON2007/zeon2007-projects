package by.herzhot;


import java.io.Serializable;

/**
 * @author Herzhot
 * @version 1.0
 *          03.08.2016
 */

public interface IDao<T> extends Serializable {

    T find(Long id) ;

}
