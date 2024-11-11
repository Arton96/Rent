package com.pitagoras.springboot.demo.rent.rest;

import org.springframework.stereotype.Component;

@Component
public class Golf implements Car{
    @Override
    public String drive() {
        return "Driving GOLF 200 km/h";
    }
}
