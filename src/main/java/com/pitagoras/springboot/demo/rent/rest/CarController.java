package com.pitagoras.springboot.demo.rent.rest;

import com.pitagoras.springboot.demo.rent.dao.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pitagoras.springboot.demo.rent.entity.Car;

import java.util.List;

@RestController
public class CarController {

    //private Car myCar;
    private CarDAO carDAO;
    @Autowired
    public CarController(CarDAO carDAO){
        this.carDAO = carDAO;
      }


    @GetMapping("/save-car")
    public String save(){
        Car car = new Car();
        car.setModel("M3");
        car.setMake("BMW");
        car.setColor("RED");
         this.carDAO.save(car);

         return "Car was created succesfully " + car.getId();
    }
    @GetMapping("/find-car")
    public String findMyCar(){
        return this.carDAO.findById(2).toString();
    }
    @GetMapping("/update-car")
    public String updateCar(){
        Car car = this.carDAO.findById(2);

        if(car == null){
            return "Car with the id 2 was not found";
        }
        car.setMake("Peugeot");
        car.setModel("3008");
        car.setColor("Blue");
        car.setAvailable(true);
        car.setYear(2001);
        car.setLicensePlate("01-MK-21S");

        carDAO.updateCar(car);
        return "Car updated successfully with id: " + car.getId();
    }
    @GetMapping("/delete-car")
    public String deleteCar(){
        Car car = this.carDAO.findById(9);

        if(car == null){
            return "Car with the id 2 was not found";
        }
        carDAO.deleteCar(car);
        return "Car was deleted";
    }
    @GetMapping("/findAll-car")
    public String findAll(){
        List<Car> cars = this.carDAO.findAll();
        String response = ",";
        for(Car car : cars){
            response += car.toString() + "\n";
        }
        return response;
    }
}
