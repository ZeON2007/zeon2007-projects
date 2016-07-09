package by.pvt.herzhot.controller;

import by.pvt.herzhot.constants.ConfigConstants;
import by.pvt.herzhot.constants.MessageConstants;
import by.pvt.herzhot.constants.Parameters;
import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.managers.ConfigManager;
import by.pvt.herzhot.managers.MessageManager;
import by.pvt.herzhot.pojos.impl.News;
import by.pvt.herzhot.services.IAuthorService;
import by.pvt.herzhot.services.INewsCategoryService;
import by.pvt.herzhot.services.INewsService;
import by.pvt.herzhot.util.MenuHelper;
import by.pvt.herzhot.util.Paginator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          04.07.2016
 */
@Controller
@RequestMapping("/author")
public class AuthorController {

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

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String showMainPage() {

        return configManager.getProperty(ConfigConstants.ADD_NEWS_PAGE_PATH);
    }



}
