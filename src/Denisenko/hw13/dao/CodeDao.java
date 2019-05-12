package denisenko.hw13.dao;

import denisenko.hw13.model.Code;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CodeDao {

    private Connection connection = DBConnector.connect();
    private static final Logger LOGGER = Logger.getLogger(CodeDao.class);

    public void addGood(Code newCode) {
        try {
            String sql = "INSERT INTO codes(user_id,good_id,value_code) values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, newCode.getUserId());
            statement.setLong(2, newCode.getGoodId());
            statement.setString(3, newCode.getValue());
            statement.execute();
            LOGGER.debug(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error(e);
        }
    }

    public boolean checkCode(Code code) {
        try {
            String sql = "SELECT * FROM codes WHERE value_code = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, code.getValue());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long userId = resultSet.getLong("user_id");
                Long goodId = resultSet.getLong("good_id");
                String value = resultSet.getString("value_code");
                Code codeDb = new Code(userId, goodId, value);
                LOGGER.debug(codeDb);
                return codeDb.equals(code);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return false;
    }

}
