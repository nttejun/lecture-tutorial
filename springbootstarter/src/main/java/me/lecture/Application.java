package me.lecture;

import me.tester.Holeman;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication application = new SpringApplication(Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    /*
    @Bean
    public Holeman holeman(){
        Holeman holeman = new Holeman();
        holeman.setName("mom");
        holeman.setHowLong(60);
        return holeman;
    }
    */

}
