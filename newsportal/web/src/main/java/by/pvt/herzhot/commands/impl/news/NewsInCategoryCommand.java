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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          09.05.2016
 */
public class NewsInCategoryCommand extends AbstractCommand {

    private NewsServiceImpl newsService = NewsServiceImpl.INSTANCE;
    private Paginator paginator = Paginator.INSTANCE;

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String page;
        Author currentAuthor = (Author) session.getAttribute(Parameters.AUTHOR);
        String selectedCategoryId = request.getParameter(Parameters.SELECTED_CATEGORY_ID);

        int id = 0;
        if (selectedCategoryId != null) {
            id = Integer.valueOf(request.getParameter(Parameters.SELECTED_CATEGORY_ID));
            session.setAttribute(Parameters.SELECTED_CATEGORY_ID, selectedCategoryId);
        } else if (session.getAttribute(Parameters.SELECTED_CATEGORY_ID) != null) {
            id = Integer.valueOf(session.getAttribute(Parameters.SELECTED_CATEGORY_ID).toString());
        }

        try {
            List<NewsCategory> listCategory = NewsCategoryServiceImpl.INSTANCE.findAll();
            request.setAttribute(Parameters.CATEGORY_LIST, listCategory);
            if (currentAuthor == null) {

                session.setAttribute(Parameters.TOTAL_PAGES_QUANTITY,
                        newsService.countNewsInCategory(id));
                List<News> listNews = newsService.getNewsInCategory(id, paginator.update(request));
                request.setAttribute(Parameters.NEWS_LIST, listNews);
                page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.INDEX_PAGE_PATH);
            } else {

                session.setAttribute(Parameters.TOTAL_PAGES_QUANTITY,
                        newsService.countNewsInCategoryByLogin(id, currentAuthor.getEmail()));
                List<News> listNews = newsService.getNewsInCategoryByLogin(id, currentAuthor.getEmail(),
                        paginator.update(request));
                request.setAttribute(Parameters.NEWS_LIST, listNews);
                page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.INDEX_PAGE_PATH);
            }
        }
        catch (ServiceException e) {
            session.invalidate();
            page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE,
                    MessageManagerImpl.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE, request));
        }
        return page;
    }

}
