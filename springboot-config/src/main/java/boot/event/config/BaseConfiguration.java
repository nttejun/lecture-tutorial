package boot.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//BaseConfiguration 클래스는 "production" 이름의 프로파일에 사용한다
@Profile("production")
@Configuration
public class BaseConfiguration {

    @Bean
    public String hello(){
        return "hello";
    }
}
