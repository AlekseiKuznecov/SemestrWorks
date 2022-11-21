package dao;

import Util.ConnectionProvider;
import Util.DbException;
import entity.Car;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private ConnectionProvider connectionProvider;

    public int getCount() throws DbException{
        try {
            Statement statement = this.connectionProvider.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(id) AS cnt FROM car");
            resultSet.next();
            return resultSet.getInt("cnt");
        } catch (SQLException e) {
            throw new DbException("Cant get count of cars", e);
        }
    }

    public CarDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public List<Car> getPage() throws DbException {
        try {
            PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("SELECT * FROM car");
            ResultSet result = preparedStatement.executeQuery();
            List<Car> cars = new ArrayList<>();
            while (result.next()){
                Car car = new Car(
                        result.getInt("id"),
                        result.getString("brand"),
                        result.getString("model"),
                        result.getInt("price_for_day")
                );
                cars.add(car);
            }
            System.out.println(cars);
            return cars;
        } catch (SQLException e) {
            throw new DbException("Cant get car from db", e);
        }
    }

    public Car getDetail(int id) throws DbException {
        try {
            PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("SELECT * FROM car WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            boolean hasOne = result.next();
            if(hasOne) {
                return new Car(
                        result.getInt("id"),
                        result.getString("brand"),
                        result.getString("model"),
                        result.getInt("price_for_day")
                );
            }else{
                return null;
            }
        } catch (SQLException e) {
            throw new DbException("Cant get car from db", e);
        }
    }
}

