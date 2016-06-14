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
import by.pvt.herzhot.pojos.impl.News;
import by.pvt.herzhot.pojos.impl.NewsCategory;
import by.pvt.herzhot.util.Paginator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          09.05.2016
 */
public class MainPageCommand extends AbstractCommand {

    private NewsServiceImpl newsService = NewsServiceImpl.INSTANCE;
    private Paginator paginator = Paginator.INSTANCE;

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String page;
        try {

            session.setAttribute(Parameters.TOTAL_PAGES_QUANTITY, newsService.count());

            List<News> listNews = newsService.findAll(paginator.update(request));
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
