package denisenko.hw13.dao;

import denisenko.hw13.model.Role;
import denisenko.hw13.model.User;
import denisenko.hw13.utils.HashUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserDao {

    private Connection connection = DBConnector.connect();

    public void addUser(Long id) {

        try {
            String sql = "INSERT INTO users(login,password,role,email,salt) values (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            User user = getUser(id).get();
            statement.setString(1, user.getLogin());
            statement.setString(2, HashUtils.getSHA512SecurePassword(user.getPassword(), user.getSalt()));
            statement.setString(3, user.getRole().getValue());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getSalt());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {

        try {
            String sql = "INSERT INTO users(login,password,role,email,salt) values (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setString(2, HashUtils.getSHA512SecurePassword(user.getPassword(), user.getSalt()));
            statement.setString(3, user.getRole().getValue());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getSalt());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<User> getUser(Long id) {
        try {
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long userId = resultSet.getLong(1);
                String userLogin = resultSet.getString("login");
                String userPassword = resultSet.getString("password");
                Role userRole = Role.fromString(resultSet.getString("role"));
                String email = resultSet.getString("email");
                String salt = resultSet.getString("salt");
                User userDb = new User(userId, userLogin, email, userPassword, userRole, salt);
                return Optional.of(userDb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<User> getUser(User user) {
        try {
            String sql = "SELECT * FROM users WHERE login = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long userId = resultSet.getLong(1);
                String userLogin = resultSet.getString("login");
                String userPassword = resultSet.getString("password");
                Role userRole = Role.fromString(resultSet.getString("role"));
                String email = resultSet.getString("email");
                String salt = resultSet.getString("salt");
                User userDb = new User(userId, userLogin, email, userPassword, userRole, salt);
                return Optional.of(userDb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void updateUser(Long id, String newPassword) {
        try {
            String sql = "UPDATE users SET  password = ? WHERE id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setLong(2, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(Long id) {
        try {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
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

    public Optional<List<User>> getAllUsers() {
        try {
            List<User> allUsers = new ArrayList<>();
            String sql = "SELECT * FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allUsers.add(new User(resultSet.getLong("id")
                        , resultSet.getString("login")
                        , resultSet.getString("email")
                        , resultSet.getString("password")
                        , Role.fromString(resultSet.getString("role"))
                        , resultSet.getString("salt")));
            }
            return Optional.of(allUsers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
