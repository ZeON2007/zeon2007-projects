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
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          10.05.2016
 */
public class AddNewsCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession session = request.getSession();
        try {
            Author currentAuthor = (Author) session.getAttribute(Parameters.AUTHOR);
            News news = new News();
            news.setCategoryId(Integer.valueOf(request.getParameter(Parameters.CATEGORY_ID)));
            news.setAuthorId(currentAuthor.getId());
            Timestamp ts = new Timestamp(new Date().getTime());
//            news.setDate(request.getParameter(Parameters.NEWS_DATE));
            news.setDate(new Timestamp(new Date().getTime()).toString());
            news.setName(request.getParameter(Parameters.NEWS_NAME));
            news.setDescription(request.getParameter(Parameters.NEWS_DESCRIPTION));
            news.setMainText(request.getParameter(Parameters.NEWS_BODYTEXT));
            NewsServiceImpl.INSTANCE.createEntity(news);

            List<News> listNews = NewsServiceImpl.INSTANCE.getNewsByLogin(currentAuthor.getEmail());
            request.setAttribute(Parameters.NEWS_LIST, listNews);
            List<CategoryOfNews> listCategory = CategoryOfNewsServiceImpl.INSTANCE.getAll();
            request.setAttribute(Parameters.CATEGORY_LIST, listCategory);
            page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.INDEX_PAGE_PATH);
        }
        catch (SQLException e) {
            CommandsLogger.INSTANCE.logError(getClass(), e.getMessage());
            page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE,
                    MessageManagerImpl.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        catch (NumberFormatException e) {
            CommandsLogger.INSTANCE.logError(getClass(), e.getMessage());

        }
        return page;

    }
}
