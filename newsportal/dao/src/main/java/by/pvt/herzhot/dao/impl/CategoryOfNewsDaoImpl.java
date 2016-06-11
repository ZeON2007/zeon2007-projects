package by.pvt.herzhot.dao.impl;

import by.pvt.herzhot.beans.CategoryOfNews;
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
 *          09.05.2016
 */
public enum CategoryOfNewsDaoImpl implements IDao<CategoryOfNews> {

    INSTANCE;


    @Override
    public List<CategoryOfNews> getAll() throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_CATEGORIES);
        ResultSet result = statement.executeQuery();
        List<CategoryOfNews> list = new ArrayList<>();
        CategoryOfNews category;
        while(result.next()) {
            category = new CategoryOfNews();
            getDataFromResult(category, result);
            list.add(category);
        }
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        ClosingUtil.close(result);
        return list;
    }

    @Override
    public int createEntity(CategoryOfNews entity) throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_CATEGORY_OF_NEWS);
        statement.setString(1, entity.getCategory());
        int result =  statement.executeUpdate();
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        return result;
    }

    @Override
    public CategoryOfNews getEntityById(int id) throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_CATEGORY_BY_ID);
        statement.setString(1, Integer.toString(id));
        ResultSet result = statement.executeQuery();
        CategoryOfNews category = null;
        while(result.next()) {
            category = new CategoryOfNews();
            getDataFromResult(category, result);
        }
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        ClosingUtil.close(result);
        return category;
    }

    @Override
    public int deleteEntity(int id) throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.DELETE_CATEGORY_OF_NEWS);
        statement.setInt(1, id);
        int result =  statement.executeUpdate();
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        return result;
    }

    @Override
    public int getNextId() throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_NEXT_ID_OF_CATEGORIES_TABLE);
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

    private void getDataFromResult(CategoryOfNews category, ResultSet result) throws SQLException {
        category.setId(result.getInt(ColumnNames.CATEGORY_ID));
        category.setCategory(result.getString(ColumnNames.CATEGORY));
    }
}
