package com.project.autodiler.service;

import com.project.autodiler.model.Car;
import com.project.autodiler.model.Manager;
import com.project.autodiler.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@AllArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isEmpty()) {
            throw new IllegalStateException("Car with id" + id + "does not exist");
        }
        return optionalCar.get();
    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
