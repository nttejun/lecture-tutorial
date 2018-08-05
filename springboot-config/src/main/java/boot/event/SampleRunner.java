package boot.event;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner{

    @Value("${wj.name}")
    private String name;

    @Value("${wj.age}")
    private String age;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("===============");
        System.out.println(name);
        System.out.println(age);
        System.out.println("===============");
    }
}
