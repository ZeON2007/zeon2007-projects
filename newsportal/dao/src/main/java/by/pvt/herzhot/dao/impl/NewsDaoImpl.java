package by.pvt.herzhot.dao.impl;

import by.pvt.herzhot.beans.News;
import by.pvt.herzhot.constants.ColumnNames;
import by.pvt.herzhot.constants.SqlRequests;
import by.pvt.herzhot.dao.IDao;
import by.pvt.herzhot.managers.ConnectionsPoolManager;
import by.pvt.herzhot.utils.ClosingUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          08.05.2016
 */
public enum NewsDaoImpl implements IDao<News> {

    INSTANCE;

    @Override
    public List<News> getAll() throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_NEWS);
        ResultSet result = statement.executeQuery();
        List<News> list = new ArrayList<>();
        News news = null;
        while(result.next()) {
            news = new News();
            getDataFromResult(news, result);
            list.add(news);
        }
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        ClosingUtil.close(result);
        return list;
    }

    @Override
    public int getNextId() throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_NEXT_ID_OF_NEWS_TABLE);
        ResultSet result = statement.executeQuery();
        int getNextId = 0;
        while(result.next()) {
            getNextId = result.getInt(ColumnNames.AUTO_INCREMENT);
        }
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        ClosingUtil.close(result);
        return getNextId;
    }

    public List<News> getNewsInCategory(int id) throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_NEWS_IN_CATEGORY);
        statement.setString(1, Integer.toString(id));
        ResultSet result = statement.executeQuery();
        List<News> list = new ArrayList<>();
        News news;
        while(result.next()) {
            news = new News();
            getDataFromResult(news, result);
            list.add(news);
        }
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        ClosingUtil.close(result);
        return list;
    }

    public List<News> getNewsByLogin(String login) throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_NEWS_BY_LOGIN);
        statement.setString(1, login);
        ResultSet result = statement.executeQuery();
        List<News> list = new ArrayList<>();
        News news;
        while(result.next()) {
            news = new News();
            getDataFromResult(news, result);
            list.add(news);
        }
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        ClosingUtil.close(result);
        return list;
    }

    public List<News> getNewsInCategoryByLogin(int id, String login) throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_NEWS_IN_CATEGORY_BY_LOGIN);
        statement.setString(1, Integer.toString(id));
        statement.setString(2, login);
        ResultSet result = statement.executeQuery();
        List<News> list = new ArrayList<>();
        News news;
        while(result.next()) {
            news = new News();
            getDataFromResult(news, result);
            list.add(news);
        }
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        ClosingUtil.close(result);
        return list;
    }

    @Override
    public int createEntity(News entity) throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_NEWS);

        statement.setInt(1, entity.getCategoryId());
        statement.setInt(2, entity.getAuthorId());
        statement.setString(3, entity.getDate());
        statement.setString(4, entity.getName());
        statement.setString(5, entity.getDescription());
        statement.setString(6, entity.getMainText());
        int result =  statement.executeUpdate();
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        return result;
    }

    @Override
    public News getEntityById(int id) throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_NEWS_BY_ID);
        statement.setString(1, Integer.toString(id));
        ResultSet result = statement.executeQuery();
        News news = null;
        while(result.next()) {
            news = new News();
            getDataFromResult(news, result);
        }
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        ClosingUtil.close(result);
        return news;
    }

    @Override
    public int deleteEntity(int id) throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.DELETE_NEWS);
        statement.setInt(1, id);
        int result =  statement.executeUpdate();
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        return result;
    }

    private void getDataFromResult(News news, ResultSet result) throws SQLException {
        news.setId(result.getInt(ColumnNames.NEWS_ID));
        news.setCategoryId(result.getInt(ColumnNames.NEWS_CATEGORY_ID));
        news.setAuthorId(result.getInt(ColumnNames.NEWS_AUTHOR_ID));
        news.setDate(result.getString(ColumnNames.NEWS_DATE));
        news.setName(result.getString(ColumnNames.NEWS_NAME));
        news.setDescription(result.getString(ColumnNames.NEWS_DESCRIPTION));
        news.setMainText(result.getString(ColumnNames.NEWS_BODY_TEXT));
    }
}
