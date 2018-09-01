package com.spring.config;

import com.spring.sequnece.SequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SequenceGeneratorConfiguration {

    @Bean
    public SequenceGenerator sequenceGenerator(){
        SequenceGenerator sequence = new SequenceGenerator();
        sequence.setPrefix("30");
        sequence.setSuffix("A");
        sequence.setInit(100000);
        return sequence;
    }
}
