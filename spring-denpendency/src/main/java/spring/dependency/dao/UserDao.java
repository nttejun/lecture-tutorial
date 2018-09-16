package spring.dependency.dao;

import spring.dependency.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {

    ConnectionMaker connectionMaker = new ConnectionMakerImpl();

    public UserDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException{
        Connection conn = connectionMaker.makeMysqlConnection();

        PreparedStatement statement = conn
                .prepareStatement("INSERT INTO TBM_USER(user_id, user_name, user_pw) VALUES (?, ?, ?)");
        statement.setString(1, user.getId());
        statement.setString(2, user.getName());
        statement.setString(3, user.getPw());
        statement.execute();

        statement.close();
        conn.close();
    }

    public User get(String id, String pw) throws ClassNotFoundException, SQLException {
        Connection conn = connectionMaker.makeMysqlConnection();

        PreparedStatement statement = conn
                .prepareStatement("SELECT * FROM TBM_USER WHERE user_id = ? AND user_pw = ?");
        statement.setString(1, id);
        statement.setString(2, pw);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getString("user_id"));
        user.setName(resultSet.getString("user_name"));
        user.setPw(resultSet.getString("user_pw"));

        resultSet.close();
        statement.close();
        conn.close();

        return user;
    }
}
