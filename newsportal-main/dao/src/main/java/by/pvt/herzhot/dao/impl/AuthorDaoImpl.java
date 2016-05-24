package by.pvt.herzhot.dao.impl;

import by.pvt.herzhot.beans.Author;
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
public enum AuthorDaoImpl implements IDao<Author> {

    INSTANCE;

    @Override
    public List<Author> getAll() throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_AUTHORS);
        ResultSet result = statement.executeQuery();
        List<Author> list = new ArrayList<>();
        Author author;
        while(result.next()) {
            author = new Author();
            getDataFromResult(author, result);
            list.add(author);
        }
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        ClosingUtil.close(result);
        return list;
    }

    @Override
    public int createEntity(Author entity) throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_AUTHOR);
        statement.setString(1, entity.getFirstName());
        statement.setString(2, entity.getLastName());
        statement.setString(3, entity.getEmail());
        statement.setString(4, entity.getPassword());
        statement.setInt(5, entity.getAccessLevel());
        int result =  statement.executeUpdate();
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        return result;
    }

    public boolean isAuthorized(String login, String password) throws SQLException{
        boolean isLogIn = false;
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.CHECK_AUTHORIZATION);
        statement.setString(1, login);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        if(result.next()){
            isLogIn = true;
        }
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        ClosingUtil.close(result);
        return isLogIn;
    }

    @Override
    public Author getEntityById(int id) throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_AUTHOR_BY_ID);
        statement.setString(1, Integer.toString(id));
        ResultSet result = statement.executeQuery();
        Author author = null;
        while(result.next()) {
            author = new Author();
            getDataFromResult(author, result);
        }
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        ClosingUtil.close(result);
        return author;
    }

    @Override
    public int deleteEntity(int id) throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.DELETE_AUTHOR);
        statement.setInt(1, id);
        int result =  statement.executeUpdate();
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        return result;
    }

    @Override
    public int getNextId() throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_NEXT_ID_OF_AUTHORS_TABLE);
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

    public Author getAuthorByLogin(String login) throws SQLException {
        Connection connection = ConnectionsPoolManager.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_AUTHOR_BY_LOGIN);
        statement.setString(1, login);
        ResultSet result = statement.executeQuery();
        Author author = null;
        while(result.next()) {
            author = new Author();
            getDataFromResult(author, result);
        }
        ConnectionsPoolManager.INSTANCE.freeConnection(connection);
        ClosingUtil.close(statement);
        ClosingUtil.close(result);
        return author;
    }

    private void getDataFromResult(Author author, ResultSet result) throws SQLException {
        author.setId(result.getInt(ColumnNames.AUTHOR_ID));
        author.setFirstName(result.getString(ColumnNames.AUTHOR_FIRST_NAME));
        author.setLastName(result.getString(ColumnNames.AUTHOR_LAST_NAME));
        author.setEmail(result.getString(ColumnNames.AUTHOR_EMAIL));
        author.setPassword(result.getString(ColumnNames.AUTHOR_PASSWORD));
        author.setAccessLevel(result.getInt(ColumnNames.AUTHOR_ACCESS_LEVEL));
    }
}
