package com.example.servicea;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ServiceARestController {

    @Value("${server.instance.id}")
    String instanceId;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        System.out.println("instanceId: "+ instanceId);
        return "Hello from ServiceA instance: "+ instanceId;
    }
}
