package by.pvt.herzhot.commands.impl.author;

import by.pvt.herzhot.commands.AbstractCommand;
import by.pvt.herzhot.constants.*;
import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.impl.AuthorServiceImpl;
import by.pvt.herzhot.impl.NewsCategoryServiceImpl;
import by.pvt.herzhot.impl.NewsServiceImpl;
import by.pvt.herzhot.managers.ConfigManagerImpl;
import by.pvt.herzhot.managers.MessageManagerImpl;
import by.pvt.herzhot.pojos.impl.Author;
import by.pvt.herzhot.pojos.impl.NewsCategory;
import by.pvt.herzhot.pojos.impl.News;
import by.pvt.herzhot.util.Paginator;

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
    private Paginator paginator = Paginator.INSTANCE;

    @Override
    public String execute(HttpServletRequest request) {

        String page;
        HttpSession session = request.getSession();
        String login = request.getParameter(Parameters.EMAIL);
        String password = request.getParameter(Parameters.PASSWORD);
        Author currentAuthor = (Author) session.getAttribute(Parameters.AUTHOR);

        try {
            if (authorService.checkAuthentication(login, password)) {
                Author author = authorService.find(login);
                session.setAttribute(Parameters.USERTYPE, UserType.AUTHOR);
                session.setAttribute(Parameters.AUTHOR, author);

                session.setAttribute(Parameters.TOTAL_PAGES_QUANTITY,
                        newsService.countNewsByLogin(login));
                List<News> listNews = newsService.getNewsByLogin(login, paginator.update(request));
                request.setAttribute(Parameters.NEWS_LIST, listNews);
                List<NewsCategory> listCategory = newsCategoryService.findAll();
                request.setAttribute(Parameters.CATEGORY_LIST, listCategory);
                page = configManager.getProperty(ConfigConstants.INDEX_PAGE_PATH);

            } else {
                request.setAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD,
                        messageManager.getProperty(MessageConstants.WRONG_LOGIN_OR_PASSWORD, request));
                page = configManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
            }

            if (currentAuthor != null) {
                login = currentAuthor.getEmail();
                session.setAttribute(Parameters.TOTAL_PAGES_QUANTITY,
                        newsService.countNewsByLogin(login));
                List<News> listNews = newsService.getNewsByLogin(login, paginator.update(request));
                request.setAttribute(Parameters.NEWS_LIST, listNews);
                List<NewsCategory> listCategory = newsCategoryService.findAll();
                request.setAttribute(Parameters.CATEGORY_LIST, listCategory);
                page = configManager.getProperty(ConfigConstants.INDEX_PAGE_PATH);
            }
        }
        catch (ServiceException e) {
            request.setAttribute(Parameters.ERROR_DATABASE,
                    messageManager.getProperty(MessageConstants.ERROR_DATABASE, request));
            page = configManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
        }
        return page;
    }
}
