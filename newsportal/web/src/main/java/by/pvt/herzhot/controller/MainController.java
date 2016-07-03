package by.pvt.herzhot.controller;

import by.pvt.herzhot.constants.ConfigConstants;
import by.pvt.herzhot.constants.MessageConstants;
import by.pvt.herzhot.constants.Parameters;
import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.managers.ConfigManagerImpl;
import by.pvt.herzhot.managers.MessageManagerImpl;
import by.pvt.herzhot.pojos.impl.News;
import by.pvt.herzhot.pojos.impl.NewsCategory;
import by.pvt.herzhot.services.IAuthorService;
import by.pvt.herzhot.services.INewsCategoryService;
import by.pvt.herzhot.services.INewsService;
import by.pvt.herzhot.services.impl.NewsCategoryServiceImpl;
import by.pvt.herzhot.services.impl.NewsServiceImpl;
import by.pvt.herzhot.util.Paginator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          02.07.2016
 */
@Controller
public class MainController {

    private Paginator paginator = Paginator.INSTANCE;

    @Autowired
    private INewsService newsService;
    @Autowired
    private INewsCategoryService newsCategoryService;
    @Autowired
    private IAuthorService authorService;


    @RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
    public String showMainPage(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String page;
        try {

            session.setAttribute(Parameters.TOTAL_PAGES_QUANTITY, newsService.count());

            List<News> listNews = newsService.findAll(paginator.update(request));
            request.setAttribute(Parameters.NEWS_LIST, listNews);
            List<NewsCategory> listCategory = newsCategoryService.findAll();
            request.setAttribute(Parameters.CATEGORY_LIST, listCategory);
            page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.INDEX_PAGE_PATH);
        }
        catch (ServiceException e) {
            session.invalidate();
            page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE,
                    MessageManagerImpl.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE, request));
        }
        return "main";
    }
}
