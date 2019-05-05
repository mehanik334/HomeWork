package denisenko.hw13.dao;

import denisenko.hw13.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao {

    private Connection connection = DBConnector.connect();

    public void addUser(User user) {
        try {
            String sql = "INSERT INTO users(login,password) values (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String login, String password) {
        try {
            String sql = "SELECT * FROM users WHERE login = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long userId = resultSet.getLong(1);
                String userLogin = resultSet.getString("login");
                String userPassword = resultSet.getString("password");
                User userDb = new User(userId, userLogin, userPassword);
                return userDb;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser(User user, String newPassword) {
        try {
            String sql = "UPDATE users SET  password = ? WHERE login = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(User user) {
        try {
            String sql = "DELETE FROM users WHERE login = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllUser() {
        try {
            String sql = "DELETE FROM users ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        try {
            List<User> allUsers = new ArrayList<>();
            String sql = "SELECT * FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allUsers.add(new User(resultSet.getLong("id")
                        , resultSet.getString("login")
                        , resultSet.getString("password")));
            }
            return allUsers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
