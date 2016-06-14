package by.pvt.herzhot.commands.factory;

import by.pvt.herzhot.commands.ICommand;
import by.pvt.herzhot.commands.impl.author.LogOutAuthorCommand;
import by.pvt.herzhot.commands.impl.author.LoginAuthorCommand;
import by.pvt.herzhot.commands.impl.author.LoginPageCommand;
import by.pvt.herzhot.commands.impl.news.*;

/**
 * @author Herzhot
 * @version 1.0
 *          09.05.2016
 */
public enum CommandType {

    UPDATEPAGE(0),
    LOGIN(0), LOGOUT(0),
    GOTOMAINPAGE(0), GOTOCATEGORYPAGE(0), GOTOBODYTEXTPAGE(0), GOTOLOGINPAGE(0), GOTOADDNEWSPAGE(1),
    ADDNEWS(1), DELETENEWS(1);

    private int securityLevel;

    CommandType(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    public ICommand getCurrentCommand() {
        switch (this) {
            case LOGIN:
                return new LoginAuthorCommand();
            case LOGOUT:
                return new LogOutAuthorCommand();
            case GOTOMAINPAGE:
                return new MainPageCommand();
            case GOTOBODYTEXTPAGE:
                return new BodyTextCommand();
            case GOTOCATEGORYPAGE:
                return new NewsInCategoryCommand();
            case GOTOLOGINPAGE:
                return new LoginPageCommand();
            case GOTOADDNEWSPAGE:
                return new AddNewsPageCommand();
            case ADDNEWS:
                return new AddNewsCommand();
            case DELETENEWS:
                return new DeleteNewsCommand();
            default:
                return new MainPageCommand();
        }
    }

}
