package com.pitagoras.springboot.demo.rent.rest;

import com.pitagoras.springboot.demo.rent.dao.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pitagoras.springboot.demo.rent.entity.Car;

import java.util.List;

@RestController
public class CarController {

    private CarDAO carDAO;
    @Autowired
    public CarController(CarDAO carDAO){
        this.carDAO = carDAO;
      }


    @GetMapping("/save-car/{make}/{model}/{color}")
    public Car save(@PathVariable String make,@PathVariable String model,@PathVariable String color){
        Car car = new Car();
        car.setModel(make);
        car.setMake(model);
        car.setColor(color);

         this.carDAO.save(car);
         return this.carDAO.findById(car.getId());
    }
    @GetMapping("/find-car/{carId}")
    public Car findMyCar(@PathVariable int carId){

        Car vetura = this.carDAO.findById(carId);
        if(vetura == null){
            throw new CarNotFoundException("Car with id " + carId + " was not found");
        }
             return vetura;
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
    public List<Car> findAll(){
        List<Car> cars = this.carDAO.findAll();
        return cars;
   }
   @GetMapping("/test-html")
    public String testingHtml(){
        return "<h1> Pitagoras</h1>";
  }

}
