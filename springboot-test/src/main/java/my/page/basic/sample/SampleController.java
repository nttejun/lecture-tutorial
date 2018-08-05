package my.page.basic.sample;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class SampleController {

    org.slf4j.Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SampleService sampleService;

    @GetMapping("/hello")
    public String hello(){

        //OutputCapture 사용하면 logger.info System.out.println 콘솔창에서 확인할 수 있다
        logger.info("hello");
        System.out.println(sampleService.getName());
        return "hello " + sampleService.getName();
    }
}
