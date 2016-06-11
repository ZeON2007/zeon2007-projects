package by.pvt.herzhot.impl;

import by.pvt.herzhot.IService;
import by.pvt.herzhot.dao.IDao;
import by.pvt.herzhot.dao.impl.DaoImpl;
import by.pvt.herzhot.pojos.impl.Author;

/**
 * @author Herzhot
 * @version 1.0
 *          23.05.2016
 */
public enum AuthorServiceImpl implements IService {

    INSTANCE;

    private IDao dao;
    private Author author;

    AuthorServiceImpl() {
        dao = DaoImpl.getInstance();
        author = new Author();
    }

}
