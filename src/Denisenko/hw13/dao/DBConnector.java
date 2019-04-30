package denisenko.hw13.dao;

import java.sql.*;

public class DBConnector {

    private static final String DB_PATH = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Kiev";
    private static final String NAME = "root";
    private static final String PASSWORD = "1111";

    public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_PATH, NAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}