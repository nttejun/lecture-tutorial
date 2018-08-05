package boot.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner{

    private Logger logger = LoggerFactory.getLogger(SampleRunner.class);

    @Autowired
    WjProperties wjProperties;

    @Autowired
    private String hello;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("===============");
        logger.info(wjProperties.getName());
        logger.info(String.valueOf(wjProperties.getAge()));
        logger.info(String.valueOf(wjProperties.getSessionTimeout()));
        logger.info("===============");

        logger.info(" ");

        logger.info("===============");
        logger.info(hello);
        logger.info("===============");

    }
}
