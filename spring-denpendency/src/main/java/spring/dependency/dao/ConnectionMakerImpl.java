package spring.dependency.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMakerImpl implements ConnectionMaker {
    public Connection makeMysqlConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_dependency", "root", "");
        return connection;
    }
}
