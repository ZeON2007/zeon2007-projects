package by.pvt.herzhot.commands.author;

import by.pvt.herzhot.commands.AbstractCommand;
import by.pvt.herzhot.constants.*;
import by.pvt.herzhot.impl.AuthorServiceImpl;
import by.pvt.herzhot.impl.NewsCategoryServiceImpl;
import by.pvt.herzhot.impl.NewsServiceImpl;
import by.pvt.herzhot.managers.impl.ConfigManagerImpl;
import by.pvt.herzhot.managers.impl.MessageManagerImpl;
import by.pvt.herzhot.pojos.impl.Author;
import by.pvt.herzhot.pojos.impl.NewsCategory;
import by.pvt.herzhot.pojos.impl.News;
import by.pvt.herzhot.utils.CommandsLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          09.05.2016
 */
public class LoginAuthorCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        UserType userType;
        HttpSession session = request.getSession();
        String login = request.getParameter(Parameters.EMAIL);
        String password = request.getParameter(Parameters.PASSWORD);
        try {
            if (AuthorServiceImpl.INSTANCE.isAuthorized(login, password)) {
                Author author = AuthorServiceImpl.INSTANCE.getAuthorByLogin(login);
                if (AccessLevels.AUTHOR == author.getAccessLevel()) {
                    userType = UserType.AUTHOR;
                } else {
                    userType = UserType.USER;
                }
                session.setAttribute(Parameters.USERTYPE, userType);
                session.setAttribute(Parameters.AUTHOR, author);

                if (UserType.USER.equals(userType)) {
                    page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.INDEX_PAGE_PATH);
                } else {
                    List<News> listNews = NewsServiceImpl.INSTANCE.getNewsByLogin(login);
                    request.setAttribute(Parameters.NEWS_LIST, listNews);
                    List<NewsCategory> listCategory = NewsCategoryServiceImpl.INSTANCE.getAll();
                    request.setAttribute(Parameters.CATEGORY_LIST, listCategory);
                    page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.INDEX_PAGE_PATH);
                }
            } else {
                request.setAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD,
                        MessageManagerImpl.INSTANCE.getProperty(MessageConstants.WRONG_LOGIN_OR_PASSWORD));
                page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
            }
        }
        catch (SQLException e) {
            request.setAttribute(Parameters.ERROR_DATABASE,
                    MessageManagerImpl.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
            page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            CommandsLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
        return page;
    }
}
