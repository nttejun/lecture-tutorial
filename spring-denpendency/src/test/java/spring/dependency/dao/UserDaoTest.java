package spring.dependency.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spring.dependency.domain.User;

import java.sql.SQLException;

public class UserDaoTest {

//    private static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        UserDao userDao = new NUserDao();

//        logger.info("USER INSERT START");

        User user = new User();
        user.setId("wj");
        user.setName("wj");
        user.setPassword("wj");

        userDao.add(user);

//        logger.info("USER INSERT END");


//        logger.info("USER FIND START");
        User user1 = userDao.get("wj", "wj");
//        logger.info(user1.getId() + " IS USER");
//        logger.info(user1.getName());
//        logger.info(user1.getPassword());

    }
}