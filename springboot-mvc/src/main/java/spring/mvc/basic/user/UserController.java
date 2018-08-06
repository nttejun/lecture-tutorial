package spring.mvc.basic.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello(){
        // @RestController 통해 "hello"는 View Resolver 에서 Message Converter로 인식
        return "hello";
    }

    @PostMapping("/users/create")
    // @RestController 제공하는 HttpMessageConverter
    // Content-type, 요청본문 타입이 JSON 일 때 요청 데이터를 User 객체로 컨버트 되어진다 (=HttpMessageConverter)
    public User create(@RequestBody User user){
        return user;
    }

}
