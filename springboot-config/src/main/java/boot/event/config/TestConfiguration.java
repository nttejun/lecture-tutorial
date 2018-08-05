package boot.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// TestConfiguration 클래스는 "test" 라는 프로파일에 사용한다
@Profile("test")
@Configuration
public class TestConfiguration {

    @Bean
    public String hello(){
        return "hello test";
    }
}
