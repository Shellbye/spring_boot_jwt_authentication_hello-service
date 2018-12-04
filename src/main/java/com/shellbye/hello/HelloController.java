package com.shellbye.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * https://spring.io/guides/gs/spring-boot/
     * */
    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
