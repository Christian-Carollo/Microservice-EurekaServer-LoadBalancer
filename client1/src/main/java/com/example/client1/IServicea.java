package com.example.client1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "servicea")
public interface IServicea {

    @RequestMapping(value = "/api/ciao", method = RequestMethod.GET,name = "servicea")
    public String helloWorld();
}
