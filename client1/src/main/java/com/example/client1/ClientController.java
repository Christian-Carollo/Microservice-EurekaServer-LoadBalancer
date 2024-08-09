package com.example.client1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    IServicea iServicea;

    @RequestMapping(value = "/servicea", method = RequestMethod.GET )
    public String callServiceA(){
        String res = iServicea.callServiceA();
        System.out.println("Res: "+ res);
        return "We called "+ res;
    }
}
