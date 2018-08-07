package spring.mvc.basic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// 원하는 리소스 핸들러 추가가 가능하다
@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/p/**")
                .addResourceLocations("classpath:/p/")
                .setCachePeriod(20);
    }
}
