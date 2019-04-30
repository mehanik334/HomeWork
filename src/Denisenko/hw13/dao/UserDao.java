package denisenko.hw13.dao;

import denisenko.hw13.model.User;

import java.sql.*;

public class UserDao {

    private Connection connection = DBConnector.connect();

    public void addUser(User user) {
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO users(login,password) values ('" + user.getLogin() + "','" + user.getPassword() + "')";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String login, String password) {
        User userDB = new User();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users WHERE users.login = '" + login + "' AND users.password = '" + password + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                userDB.setLogin(resultSet.getString("login"));
                userDB.setPassword(resultSet.getString("password"));
            }
            return userDB;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDB;
    }
}
