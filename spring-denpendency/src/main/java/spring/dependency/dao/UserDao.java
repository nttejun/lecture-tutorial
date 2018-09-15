package spring.dependency.dao;

import spring.dependency.domain.User;
import sun.tools.java.ClassNotFound;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class UserDao {

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

    public void add(User user) throws ClassNotFoundException, SQLException{
        Connection conn = getConnection();

        PreparedStatement statement = conn
                .prepareStatement("INSERT INTO USER(id, name, password) VALUES (?, ?, ?)");
        statement.setString(1, user.getId());
        statement.setString(2, user.getName());
        statement.setString(3, user.getPassword());
        statement.execute();

        statement.close();
        conn.close();
    }

    public User get(String id, String pw) throws ClassNotFoundException, SQLException {
        Connection conn = getConnection();

        PreparedStatement statement = conn
                .prepareStatement("SELECT * FROM USER WHERE user_id = ? AND user_pw = ?");
        statement.setString(1, id);
        statement.setString(2, pw);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        statement.close();
        conn.close();

        return user;
    }
}
