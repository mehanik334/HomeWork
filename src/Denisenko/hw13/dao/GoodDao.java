package denisenko.hw13.dao;

import denisenko.hw13.model.Good;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GoodDao {

    private Connection connection = DBConnector.connect();
    private static final Logger LOGGER = Logger.getLogger(GoodDao.class);


    public void addGood(Good good) {
        try {
            String sql = "INSERT INTO goods(name,description,price) values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, good.getName());
            statement.setString(2, good.getDescription());
            statement.setDouble(3, good.getPrice());
            statement.execute();
            LOGGER.debug(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error(e);
        }
    }

    public Optional<Good> getGoodByID(Long id) {
        try {
            String sql = "SELECT * FROM goods WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long good = resultSet.getLong(1);
                String goodName = resultSet.getString("name");
                String goodDescription = resultSet.getString("description");
                double goodPrice = resultSet.getDouble("price");
                Good goodDb = new Good(id, goodPrice, goodName, goodDescription);
                LOGGER.debug(good);
                return Optional.of(goodDb);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return Optional.empty();
    }

    public void updateGood(Good good, double newPrice) {
        try {
            String sql = "UPDATE goods SET  price = ? WHERE id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, newPrice);
            preparedStatement.setLong(2, good.getId());
            preparedStatement.execute();
            LOGGER.debug(sql);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void deleteGood(Good good) {
        try {
            String sql = "DELETE FROM goods WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, good.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void deleteAllGoods() {
        try {
            String sql = "DELETE FROM goods ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public Optional<List<Good>> getAllGoods() {
        try {
            List<Good> allGoods = new ArrayList<>();
            String sql = "SELECT * FROM goods";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allGoods.add(new Good(resultSet.getLong("id")
                        , resultSet.getDouble("price")
                        , resultSet.getString("name")
                        , resultSet.getString("description")));
            }
            return Optional.of(allGoods);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return Optional.empty();
    }
}
