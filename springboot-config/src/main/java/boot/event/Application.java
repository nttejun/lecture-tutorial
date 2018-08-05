package boot.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}
