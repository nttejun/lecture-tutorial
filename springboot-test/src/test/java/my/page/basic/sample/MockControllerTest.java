package my.page.basic.sample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
 */

// MOCK 사용한 테스트
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MockControllerTest {

    // 테스트 유틸 : OutputCapture
    // OutputCapture 사용하면 logger.info System.out.println 콘솔창에서 확인할 수 있다
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    MockMvc mockMvc;

    // 자동완성이 안된다는 단점이 있다
    @Test
    public void hello() throws Exception{
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello wonjun"))
                .andDo(print());

        assertThat(outputCapture.toString())
        .contains("wonjun")
        .contains("hello");
    }
}
