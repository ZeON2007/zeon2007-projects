package by.pvt.herzhot.commands.news;

import by.pvt.herzhot.commands.AbstractCommand;
import by.pvt.herzhot.constants.ConfigConstants;
import by.pvt.herzhot.constants.MessageConstants;
import by.pvt.herzhot.constants.Parameters;
import by.pvt.herzhot.impl.NewsCategoryServiceImpl;
import by.pvt.herzhot.impl.NewsServiceImpl;
import by.pvt.herzhot.managers.impl.ConfigManagerImpl;
import by.pvt.herzhot.managers.impl.MessageManagerImpl;
import by.pvt.herzhot.pojos.impl.NewsCategory;
import by.pvt.herzhot.pojos.impl.News;
import by.pvt.herzhot.utils.CommandsLogger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          09.05.2016
 */
public class MainPageCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try {
            List<News> listNews = NewsServiceImpl.INSTANCE.getAll();
            request.setAttribute(Parameters.NEWS_LIST, listNews);
            List<NewsCategory> listCategory = NewsCategoryServiceImpl.INSTANCE.getAll();
            request.setAttribute(Parameters.CATEGORY_LIST, listCategory);
            page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.INDEX_PAGE_PATH);
        }
        catch (SQLException e) {
            CommandsLogger.INSTANCE.logError(getClass(), e.getMessage());
            page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManagerImpl.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}
