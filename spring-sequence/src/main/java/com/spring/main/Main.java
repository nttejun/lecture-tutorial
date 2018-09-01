package com.spring.main;

import com.spring.config.SequenceGeneratorConfiguration;
import com.spring.sequnece.SequenceGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String args[]){

        ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);

        /* 실제 타입에 맞게 캐스팅
        SequenceGenerator generator = (SequenceGenerator)context.getBean("sequenceGenerator");
        */

        /* Bean 클래스명을 지정하여 타입을 설정 */
        SequenceGenerator generator = context.getBean("sequenceGenerator" ,SequenceGenerator.class);

        System.out.println(generator.getSequence());
        System.out.println(generator.getSequence());
    }
}
