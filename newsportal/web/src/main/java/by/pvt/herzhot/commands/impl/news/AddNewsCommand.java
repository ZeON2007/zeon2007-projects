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
import java.util.Date;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          10.05.2016
 */
public class AddNewsCommand extends AbstractCommand {

    private LoggingUtil logger = LoggingUtil.INSTANCE;
    private MessageManagerImpl messageManager = MessageManagerImpl.INSTANCE;
    private ConfigManagerImpl configManager = ConfigManagerImpl.INSTANCE;
    private NewsServiceImpl newsService = NewsServiceImpl.INSTANCE;
    private Paginator paginator = Paginator.INSTANCE;

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        try {
            Author currentAuthor = (Author) session.getAttribute(Parameters.AUTHOR);
            News news = new News();
            int categoryId = Integer.valueOf(request.getParameter(Parameters.CATEGORY_ID));
            NewsCategory newsCategory = NewsCategoryServiceImpl.INSTANCE.find(categoryId);
            news.setDate(new Date());
            news.setNewsCategory(newsCategory);
            news.setAuthor(currentAuthor);
            news.setName(request.getParameter(Parameters.NEWS_NAME));
            news.setDescription(request.getParameter(Parameters.NEWS_DESCRIPTION));
            news.setMainText(request.getParameter(Parameters.NEWS_BODYTEXT));
            newsService.saveOrUpdate(news);

            session.setAttribute(Parameters.TOTAL_PAGES_QUANTITY,
                    newsService.countNewsByLogin(currentAuthor.getEmail()));
            List<News> listNews = newsService.getNewsByLogin(currentAuthor.getEmail(),
                    paginator.update(request));
            request.setAttribute(Parameters.NEWS_LIST, listNews);
            List<NewsCategory> listCategory = NewsCategoryServiceImpl.INSTANCE.findAll();
            request.setAttribute(Parameters.CATEGORY_LIST, listCategory);
            page = configManager.getProperty(ConfigConstants.INDEX_PAGE_PATH);
        }
        catch (ServiceException e) {
            page = configManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE,
                    messageManager.getProperty(MessageConstants.ERROR_DATABASE, request));
        }
        catch (NumberFormatException e) {
            logger.logError(getClass(), e.getMessage());
            page = configManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
        }
        return page;

    }
}
