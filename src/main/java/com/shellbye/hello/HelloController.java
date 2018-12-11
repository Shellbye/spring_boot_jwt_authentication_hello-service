package com.shellbye.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HelloController {

    /**
     * https://spring.io/guides/gs/spring-boot/
     */

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String index() {
        // This is how eureka works， with the help of Ribbon
        String msg = restTemplate.getForObject("http://rest-service/msg/", String.class);
        // This is by zuul
//        String msg = restTemplate.getForObject("http://gate-zuul/msg/msg", String.class);
        return "Greetings from Spring Boot demo [Hello]! with msg: " + msg;
    }

}

@Configuration
class RestTemplateConfig {

    // Create a bean for restTemplate to call services
    @Bean
    @LoadBalanced        // Load balance between service instances running at different ports.
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
