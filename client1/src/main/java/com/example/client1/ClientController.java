package com.example.client1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    IServicea servicea;

    @RequestMapping(value = "/getName", method = RequestMethod.GET )
    public String helloWorld(){
        String res = servicea.helloWorld();
        System.out.println("Res: "+ res);
        return "Abbiamo chiamato "+ res;
    }
}
