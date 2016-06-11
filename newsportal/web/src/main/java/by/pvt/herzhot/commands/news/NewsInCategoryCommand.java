package by.pvt.herzhot.commands.news;

import by.pvt.herzhot.beans.Author;
import by.pvt.herzhot.beans.CategoryOfNews;
import by.pvt.herzhot.beans.News;
import by.pvt.herzhot.commands.AbstractCommand;
import by.pvt.herzhot.constants.ConfigConstants;
import by.pvt.herzhot.constants.MessageConstants;
import by.pvt.herzhot.constants.Parameters;
import by.pvt.herzhot.impl.CategoryOfNewsServiceImpl;
import by.pvt.herzhot.impl.NewsServiceImpl;
import by.pvt.herzhot.managers.impl.ConfigManagerImpl;
import by.pvt.herzhot.managers.impl.MessageManagerImpl;
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
public class NewsInCategoryCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        int id = Integer.valueOf(request.getParameter(Parameters.SELECTED_CATEGORY_ID));
        HttpSession session = request.getSession();
        Author currentAuthor = (Author) session.getAttribute(Parameters.AUTHOR);
        try {
            List<CategoryOfNews> listCategory = CategoryOfNewsServiceImpl.INSTANCE.getAll();
            request.setAttribute(Parameters.CATEGORY_LIST, listCategory);
            if (currentAuthor == null) {
                List<News> listNews = NewsServiceImpl.INSTANCE.getNewsInCategory(id);
                request.setAttribute(Parameters.NEWS_LIST, listNews);
                page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.INDEX_PAGE_PATH);
            } else {
                List<News> listNews = NewsServiceImpl.INSTANCE.getNewsInCategoryByLogin(id, currentAuthor.getEmail());
                request.setAttribute(Parameters.NEWS_LIST, listNews);
                page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.INDEX_PAGE_PATH);
            }
        }
        catch (SQLException e) {
            CommandsLogger.INSTANCE.logError(getClass(), e.getMessage());
            page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManagerImpl.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }

}