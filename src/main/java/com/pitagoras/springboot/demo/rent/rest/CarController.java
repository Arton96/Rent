package com.pitagoras.springboot.demo.rent.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private Car myCar;

    @Autowired
    public CarController(Car car){
        this.myCar = car;
    }

    @GetMapping("/drive")
    public String driveMyCar(){
        return this.myCar.drive();
    }
}
