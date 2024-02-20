package com.project.autodiler.controller;

import com.project.autodiler.model.Car;
import com.project.autodiler.repository.CarRepository;
import com.project.autodiler.service.CarService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//@AllArgsConstructor
@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public List<Car> gettAllCars(){
        return carService.getAllCars();
    }

    @PostMapping("/create")
    public Car createCar(@RequestBody Car car){
        return carService.createCar(car);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCarById(@PathVariable("id") Long id){
        carService.deleteCar(id);
    }
}
