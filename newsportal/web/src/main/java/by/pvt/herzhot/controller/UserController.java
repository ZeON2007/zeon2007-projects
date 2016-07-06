package by.pvt.herzhot.controller;

import by.pvt.herzhot.constants.ConfigConstants;
import by.pvt.herzhot.constants.MessageConstants;
import by.pvt.herzhot.constants.Parameters;
import by.pvt.herzhot.constants.UserType;
import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.managers.ConfigManager;
import by.pvt.herzhot.managers.MessageManager;
import by.pvt.herzhot.pojos.impl.Author;
import by.pvt.herzhot.pojos.impl.News;
import by.pvt.herzhot.pojos.impl.NewsCategory;
import by.pvt.herzhot.services.IAuthorService;
import by.pvt.herzhot.services.INewsCategoryService;
import by.pvt.herzhot.services.INewsService;
import by.pvt.herzhot.util.MenuHelper;
import by.pvt.herzhot.util.Paginator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          02.07.2016
 */
@Controller
@SessionAttributes(value = {
        Parameters.CATEGORY_LIST,
        Parameters.AUTHOR,
        Parameters.USERTYPE,
        Parameters.PAGINATION_MENU,
        Parameters.PAGINATION_PARAMS})
public class UserController {

    @Autowired
    private INewsService newsService;
    @Autowired
    private INewsCategoryService newsCategoryService;
    @Autowired
    private IAuthorService authorService;
    @Autowired
    private Paginator paginator;
    @Autowired
    private MenuHelper menuHelper;
    @Autowired
    private ConfigManager configManager;
    @Autowired
    private MessageManager messageManager;

    @RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
    public String showMainPage(HttpServletRequest request, ModelMap model) {

        Map<String, Integer> paginationParams;
        String page;

        try {
            paginationParams = paginator.update(request, newsService.count());
            model.addAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
            model.addAttribute(Parameters.PAGINATION_MENU,
                    menuHelper.createStringMenu(paginationParams));

            List<News> listNews = newsService.findAll(paginationParams);
            model.addAttribute(Parameters.NEWS_LIST, listNews);

            List<NewsCategory> listCategory = newsCategoryService.findAll();
            model.addAttribute(Parameters.CATEGORY_LIST, listCategory);

            page = configManager.getProperty(ConfigConstants.MAIN_PAGE_PATH);
        }
        catch (ServiceException e) {
            page = configManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE,
                    messageManager.getProperty(MessageConstants.ERROR_DATABASE, request));
        }
        model.addAttribute(Parameters.CURRENT_PAGE, page);
        return page;
    }

    @RequestMapping(value = {"/category"}, method = RequestMethod.GET)
    public String showNewsCategoryPage(HttpServletRequest request, ModelMap model) {

        Map<String, Integer> paginationParams;
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
            if (currentAuthor == null) {

                paginationParams = paginator.update(request, newsService.countNewsInCategory(id));
//                model.addAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
                model.addAttribute(Parameters.PAGINATION_MENU,
                        menuHelper.createStringMenu(paginationParams));

                List<News> listNews = newsService.getNewsInCategory(id, paginationParams);
                model.addAttribute(Parameters.NEWS_LIST, listNews);

                page = configManager.getProperty(ConfigConstants.CATEGOR_PAGE_PATH);
            } else {

                paginationParams = paginator.update(request,
                        newsService.countNewsInCategoryByLogin(id, currentAuthor.getEmail()));
                model.addAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
                model.addAttribute(Parameters.PAGINATION_MENU,
                        menuHelper.createStringMenu(paginationParams));

                List<News> listNews = newsService.getNewsInCategoryByLogin(id,
                        currentAuthor.getEmail(), paginationParams);
                model.addAttribute(Parameters.NEWS_LIST, listNews);

                page = configManager.getProperty(ConfigConstants.CATEGOR_PAGE_PATH);
            }
        }
        catch (ServiceException e) {
            page = configManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE,
                    messageManager.getProperty(MessageConstants.ERROR_DATABASE, request));
        }
        model.addAttribute(Parameters.CURRENT_PAGE, page);
        return page;
    }

    @RequestMapping(value = {"/bodytext"}, method = RequestMethod.GET)
    public String showBodyTextPage(HttpServletRequest request, ModelMap model) {

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
            News news = newsService.find(id);
            model.addAttribute(Parameters.NEWS, news);
            if (currentAuthor == null) {
                Author author = news.getAuthor();
                model.addAttribute(Parameters.AUTHOR, author);
                page = configManager.getProperty(ConfigConstants.BODYTEXT_PAGE_PATH);
            } else {
                page = configManager.getProperty(ConfigConstants.BODYTEXT_PAGE_PATH);
            }
        }
        catch (ServiceException e) {
            page = configManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE,
                    messageManager.getProperty(MessageConstants.ERROR_DATABASE, request));
        }

        return page;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(ModelMap model) {
        model.addAttribute(Parameters.AUTHOR, new Author());
        return configManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(HttpServletRequest request,
                            @ModelAttribute(Parameters.AUTHOR) @Valid Author authorDTO,
                            BindingResult bindingResult,
                            ModelMap model) {

        Map<String, Integer> paginationParams;
        String page;
        HttpSession session = request.getSession();
        Author currentAuthor = (Author) session.getAttribute(Parameters.AUTHOR);

        if(!bindingResult.hasErrors()) {
            String login = authorDTO.getEmail();
            try {
                if (authorService.checkAuthentication(login, authorDTO.getPassword())) {
                    Author author = authorService.find(login);
                    model.addAttribute(Parameters.USERTYPE, UserType.AUTHOR);
                    model.addAttribute(Parameters.AUTHOR, author);

                    paginationParams = paginator.update(request, newsService.countNewsByLogin(login));
                    model.addAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
                    model.addAttribute(Parameters.PAGINATION_MENU,
                            menuHelper.createStringMenu(paginationParams));

                    List<News> listNews = newsService.getNewsByLogin(login, paginationParams);
                    model.addAttribute(Parameters.NEWS_LIST, listNews);

                    page = configManager.getProperty(ConfigConstants.MAIN_PAGE_PATH);

                } else {
                    model.addAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD,
                            messageManager.getProperty(MessageConstants.WRONG_LOGIN_OR_PASSWORD, request));
                    page = configManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
                }

                if (currentAuthor != null) {
                    login = currentAuthor.getEmail();
                    paginationParams = paginator.update(request, newsService.countNewsByLogin(login));
                    model.addAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
                    model.addAttribute(Parameters.PAGINATION_MENU,
                            menuHelper.createStringMenu(paginationParams));

                    List<News> listNews = newsService.getNewsByLogin(login, paginationParams);
                    request.setAttribute(Parameters.NEWS_LIST, listNews);

                    page = configManager.getProperty(ConfigConstants.MAIN_PAGE_PATH);
                }
            } catch (ServiceException e) {
                model.addAttribute(Parameters.ERROR_DATABASE,
                        messageManager.getProperty(MessageConstants.ERROR_DATABASE, request));
                page = configManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);

            }
        } else {
            page = configManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
        }
        return page;
    }
}
