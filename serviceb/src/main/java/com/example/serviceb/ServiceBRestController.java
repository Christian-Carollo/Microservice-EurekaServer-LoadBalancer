package com.example.serviceb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceBRestController {

    private final RestTemplate restTemplate;

    public ServiceBRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/serviceb")
    public String hello(){
        return restTemplate.getForObject("http://servicea/hello", String.class);
    }
}
