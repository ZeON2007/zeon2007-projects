package by.pvt.herzhot.commands.impl.news;

import by.pvt.herzhot.commands.AbstractCommand;
import by.pvt.herzhot.constants.ConfigConstants;
import by.pvt.herzhot.constants.MessageConstants;
import by.pvt.herzhot.constants.Parameters;
import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.impl.NewsCategoryServiceImpl;
import by.pvt.herzhot.impl.NewsServiceImpl;
import by.pvt.herzhot.managers.ConfigManagerImpl;
import by.pvt.herzhot.managers.MessageManagerImpl;
import by.pvt.herzhot.pojos.impl.Author;
import by.pvt.herzhot.pojos.impl.News;
import by.pvt.herzhot.pojos.impl.NewsCategory;
import by.pvt.herzhot.util.Paginator;
import by.pvt.herzhot.utils.LoggingUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          24.05.2016
 */
public class DeleteNewsCommand extends AbstractCommand {

    private NewsServiceImpl newsService = NewsServiceImpl.INSTANCE;
    private Paginator paginator = Paginator.INSTANCE;

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession session = request.getSession();
        Author currentAuthor = (Author) session.getAttribute(Parameters.AUTHOR);
        String selectedNewsId = request.getParameter(Parameters.SELECTED_NEWS_ID);

        int id = 0;
        if (selectedNewsId != null) {
            id = Integer.valueOf(request.getParameter(Parameters.SELECTED_NEWS_ID));
            session.setAttribute(Parameters.SELECTED_NEWS_ID, selectedNewsId);
        } else if (session.getAttribute(Parameters.SELECTED_NEWS_ID) != null) {
            id = Integer.valueOf(session.getAttribute(Parameters.SELECTED_NEWS_ID).toString());
        }

        try {
            newsService.delete(id);
            session.setAttribute(Parameters.TOTAL_PAGES_QUANTITY,
                    newsService.countNewsByLogin(currentAuthor.getEmail()));
            List<News> listNews = newsService.getNewsByLogin(currentAuthor.getEmail(),
                    paginator.update(request));
            request.setAttribute(Parameters.NEWS_LIST, listNews);
            List<NewsCategory> listCategory = NewsCategoryServiceImpl.INSTANCE.findAll();
            request.setAttribute(Parameters.CATEGORY_LIST, listCategory);
            page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.INDEX_PAGE_PATH);
        }
        catch (ServiceException e) {
            page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE,
                    MessageManagerImpl.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE, request));
        }
        return page;
    }
}
