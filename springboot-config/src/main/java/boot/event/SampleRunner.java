package boot.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner{

    @Autowired
    WjProperties wjProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("===============");
        System.out.println(wjProperties.getName());
        System.out.println(wjProperties.getAge());
        System.out.println(wjProperties.getSessionTimeout());
        System.out.println("===============");
    }
}
