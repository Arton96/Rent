package com.pitagoras.springboot.demo.rent.rest;

import org.springframework.stereotype.Component;

@Component
public class Bmw implements Car{

    @Override
    public String drive() {
        return "Driving BMW 100 km/h";
    }
}
