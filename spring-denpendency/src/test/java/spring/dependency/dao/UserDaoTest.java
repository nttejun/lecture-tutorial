package spring.dependency.dao;
import spring.dependency.domain.User;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        UserDao userDao = new DaoFactory().userDao();

        System.out.println("USER INSERT START");

        User user = new User();
        user.setId("wj");
        user.setName("wj");
        user.setPw("wj");

        userDao.add(user);

        System.out.println("USER INSERT END");


        System.out.println("USER FIND START");

        User user1 = userDao.get("wj", "wj");
        System.out.println(user1.getId() + " IS USER");
        System.out.println(user1.getName());
        System.out.println(user1.getPw());

    }
}