package me.tester;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HolemanProperties.class)
public class HolemanConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Holeman holeman(HolemanProperties properties){
        Holeman holeman = new Holeman();
        holeman.setHowLong(properties.getHowLong());
        holeman.setName(properties.getName());
        return holeman;
    }
}
