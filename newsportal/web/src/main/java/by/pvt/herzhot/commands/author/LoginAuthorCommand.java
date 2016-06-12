package by.pvt.herzhot.commands.author;

import by.pvt.herzhot.commands.AbstractCommand;
import by.pvt.herzhot.constants.*;
import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.impl.AuthorServiceImpl;
import by.pvt.herzhot.impl.NewsCategoryServiceImpl;
import by.pvt.herzhot.impl.NewsServiceImpl;
import by.pvt.herzhot.managers.impl.ConfigManagerImpl;
import by.pvt.herzhot.managers.impl.MessageManagerImpl;
import by.pvt.herzhot.pojos.impl.Author;
import by.pvt.herzhot.pojos.impl.NewsCategory;
import by.pvt.herzhot.pojos.impl.News;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          09.05.2016
 */
public class LoginAuthorCommand extends AbstractCommand {

    private AuthorServiceImpl authorService = AuthorServiceImpl.INSTANCE;
    private NewsServiceImpl newsService = NewsServiceImpl.INSTANCE;
    private NewsCategoryServiceImpl newsCategoryService = NewsCategoryServiceImpl.INSTANCE;
    private MessageManagerImpl messageManager = MessageManagerImpl.INSTANCE;
    private ConfigManagerImpl configManager = ConfigManagerImpl.INSTANCE;

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        UserType userType;
        HttpSession session = request.getSession();
        String login = request.getParameter(Parameters.EMAIL);
        String password = request.getParameter(Parameters.PASSWORD);
        try {
            if (authorService.checkAuthentication(login, password)) {
                Author author = authorService.find(login);
                if (AccessLevels.AUTHOR == author.getAccessLevel()) {
                    userType = UserType.AUTHOR;
                } else {
                    userType = UserType.USER;
                }
                session.setAttribute(Parameters.USERTYPE, userType);
                session.setAttribute(Parameters.AUTHOR, author);

                if (UserType.USER.equals(userType)) {
                    page = configManager.getProperty(ConfigConstants.INDEX_PAGE_PATH);
                } else {
                    List<News> listNews = newsService.getNewsByLogin(login);
                    request.setAttribute(Parameters.NEWS_LIST, listNews);
                    List<NewsCategory> listCategory = newsCategoryService.findAll();
                    request.setAttribute(Parameters.CATEGORY_LIST, listCategory);
                    page = configManager.getProperty(ConfigConstants.INDEX_PAGE_PATH);
                }
            } else {
                request.setAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD,
                        messageManager.getProperty(MessageConstants.WRONG_LOGIN_OR_PASSWORD));
                page = configManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
            }
        }
        catch (ServiceException e) {
            request.setAttribute(Parameters.ERROR_DATABASE,
                    messageManager.getProperty(MessageConstants.ERROR_DATABASE));
            page = configManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
        }
        return page;
    }
}
