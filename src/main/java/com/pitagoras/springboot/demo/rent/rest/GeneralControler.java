package com.pitagoras.springboot.demo.rent.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralControler {
    @Value("${car.name}")
    private String carName;

    @Value("${motor.type}")
    private String motorType;

    @GetMapping("/")
    public String sayHello() {
        return "Hello world,my car name is " + this.carName + " ,and motor type is " + this.motorType;
    }

    @GetMapping("/about")
    public String tellAboutApplication() {
        return "This is an app we are creating for learning purposes!";
    }

    @GetMapping("/devtools")
    public String testingDevTools() {
        return "This should work.Because I changed the system";
    }
}


