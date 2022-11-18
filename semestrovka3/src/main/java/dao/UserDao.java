package dao;

import Util.ConnectionProvider;
import Util.DbException;
import entity.Car;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private ConnectionProvider connectionProvider;

    public UserDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public User geUserByPhone(Long userPhone) throws DbException {
        try {
            PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("SELECT * FROM users WHERE user_phone = ?");
            preparedStatement.setLong(1, userPhone);
            ResultSet result = preparedStatement.executeQuery();
            boolean hasOne = result.next();
            if(hasOne) {
                return new User(
                        null,
                        null,
                        null,
                        null,
                        result.getLong("user_phone")
                );
            }else{
                return null;
            }
        } catch (SQLException e) {
            throw new DbException("Cant get car from db", e);
        }
    }
}

