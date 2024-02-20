package com.project.autodiler.service;

import com.project.autodiler.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();

    Car getCarById(Long id);

    Car createCar(Car car);

    void deleteCar(Long id);
}
