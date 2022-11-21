package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    private static ConnectionProvider _instance;

    public static ConnectionProvider getInstance() throws DbException {
        if (_instance == null) {
            _instance = new ConnectionProvider();
        }
        return _instance;
    }

    private Connection connection;

    private ConnectionProvider() throws DbException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/semestrovka","postgres","123qwas");
        } catch (SQLException | ClassNotFoundException e) {
            throw new DbException("Cant connect to DB", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
