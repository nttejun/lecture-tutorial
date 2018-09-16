package spring.dependency.dao;

public class DaoFactory {

    public UserDao userDao() {
        ConnectionMaker connectionMaker = new ConnectionMakerImpl();
        return new UserDao(connectionMaker);
    }
}
