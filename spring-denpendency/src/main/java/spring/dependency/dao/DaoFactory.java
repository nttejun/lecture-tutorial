package spring.dependency.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        ConnectionMaker connectionMaker = new ConnectionMakerImpl();
        return new UserDao(connectionMaker);
    }
}
