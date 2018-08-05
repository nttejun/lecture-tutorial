package boot.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)

// property 설정 우선순위 2
//@TestPropertySource(properties="wj.name=priority second")

// property 설정 우선순위 3
//@SpringBootTest(properties="wj.name=priority third")

// application.property 설정 사용방법
// application.property 정의된 설정 값을 사용하기 원한다면 어노테이션 정의만 하면 사용할 수 있다 >> @SpringBootTest
@SpringBootTest

public class SampleRunnerTest {

    @Autowired
    Environment environment;

    @Test
    public void contextLoads(){
        assertThat(environment.getProperty("wj.name"))
                .isEqualTo("test wj");
    }
}
