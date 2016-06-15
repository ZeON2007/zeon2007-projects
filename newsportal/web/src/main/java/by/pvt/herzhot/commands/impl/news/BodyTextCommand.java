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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          09.05.2016
 */
public class BodyTextCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String page;
        String selectedNewsId = request.getParameter(Parameters.SELECTED_NEWS_ID);
        Author currentAuthor = (Author) session.getAttribute(Parameters.AUTHOR);

        int id = 0;
        if (selectedNewsId != null) {
            id = Integer.valueOf(request.getParameter(Parameters.SELECTED_NEWS_ID));
            session.setAttribute(Parameters.SELECTED_NEWS_ID, selectedNewsId);
        } else if (session.getAttribute(Parameters.SELECTED_NEWS_ID) != null) {
            id = Integer.valueOf(session.getAttribute(Parameters.SELECTED_NEWS_ID).toString());
        }

        try {
            News news = NewsServiceImpl.INSTANCE.find(id);
            request.setAttribute(Parameters.NEWS, news);
            List<NewsCategory> listCategory = NewsCategoryServiceImpl.INSTANCE.findAll();
            request.setAttribute(Parameters.CATEGORY_LIST, listCategory);
            if (currentAuthor == null) {
                Author author = news.getAuthor();
                request.setAttribute(Parameters.AUTHOR, author);
                page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.INDEX_PAGE_PATH);
            } else {
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
