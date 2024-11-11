package com.pitagoras.springboot.demo.rent.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralControler {

    @GetMapping("/")
    public String sayHello(){
        return "Hello world!";
    }

    @GetMapping("/about")
    public String tellAboutApplication(){
        return "This is an app we are creating for learning purposes!";
    }
    @GetMapping("/devtools")
    public String testingDevTools(){
        return "This should work.Because I changed the system";
    }
}
