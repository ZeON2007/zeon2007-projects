package by.pvt.herzhot.constants;

/**
 * @author Herzhot
 * @version 1.0
 *          08.05.2016
 */
public class SqlRequests {

    public static final String GET_NEWS_BY_LOGIN = "SELECT n.* FROM news n JOIN authors a ON n.autid = a.id WHERE a.email = ? ORDER BY n.date desc";
    public static final String GET_ALL_NEWS_IN_CATEGORY_BY_LOGIN = "SELECT n.* FROM news n JOIN authors a ON n.autid = a.id WHERE n.catid = ? AND a.email = ? ORDER BY n.date desc";
    public static final String GET_AUTHOR_BY_LOGIN = "SELECT * FROM authors WHERE email = ?";
    public static final String CHECK_ACCESS_LEVEL = "SELECT access_lvl FROM authors WHERE email = ?";
    public static final String GET_ALL_AUTHORS = "SELECT * FROM authors";
    public static final String GET_ALL_NEWS = "SELECT * FROM news ORDER BY date desc";
    public static final String GET_ALL_NEWS_IN_CATEGORY = "SELECT * FROM news WHERE catid = ? ORDER BY date desc";
    public static final String ADD_NEWS = "INSERT INTO news (catid, autid, date, name, description, maintext) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String ADD_AUTHOR = "INSERT INTO authors (first_name, last_name, email, password, access_lvl) VALUES (?, ?, ?, ?, ?)";
    public static final String ADD_CATEGORY_OF_NEWS = "INSERT INTO categories (category) VALUES (?)";
    public static final String DELETE_NEWS = "DELETE FROM news WHERE id = ?";
    public static final String DELETE_AUTHOR = "DELETE FROM authors WHERE id = ?";
    public static final String DELETE_CATEGORY_OF_NEWS = "DELETE FROM categories WHERE id = ?";
    public static final String GET_ALL_CATEGORIES = "SELECT * FROM categories ORDER BY category";
    public static final String GET_AUTHOR_BY_ID = "SELECT * FROM authors WHERE id = ?";
    public static final String GET_NEWS_BY_ID = "SELECT * FROM news WHERE id = ?";
    public static final String GET_CATEGORY_BY_ID = "SELECT * FROM categories WHERE id = ?";
    public static final String CHECK_AUTHORIZATION = "SELECT email, password FROM authors WHERE email = ? AND password = ?";

    public static final String GET_NEXT_ID_OF_NEWS_TABLE = "SHOW TABLE STATUS FROM news_portal LIKE 'news'";
    public static final String GET_NEXT_ID_OF_AUTHORS_TABLE = "SHOW TABLE STATUS FROM news_portal LIKE 'authors'";
    public static final String GET_NEXT_ID_OF_CATEGORIES_TABLE = "SHOW TABLE STATUS FROM news_portal LIKE 'categories'";

    private SqlRequests(){}
}
