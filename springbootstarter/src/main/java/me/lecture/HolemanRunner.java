package me.lecture;

import me.tester.Holeman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class HolemanRunner implements ApplicationRunner {

    @Autowired
    Holeman holeman;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(holeman);
    }
}
