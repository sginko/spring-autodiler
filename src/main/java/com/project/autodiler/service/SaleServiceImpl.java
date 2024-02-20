package com.project.autodiler.service;

import com.project.autodiler.model.Car;
import com.project.autodiler.model.Manager;
import com.project.autodiler.model.Sale;
import com.project.autodiler.repository.SaleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService{

    private final CarServiceImpl carService;
    private final ManagerService managerService;
    private final SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(CarServiceImpl carService, ManagerService managerService, SaleRepository saleRepository) {
        this.carService = carService;
        this.managerService = managerService;
        this.saleRepository = saleRepository;
    }

    @Override
    @Transactional
    public Sale createSale(Long carId, Long managerId, int quantity) {
        Car car = carService.getCarById(carId);
        Manager manager = managerService.getManagerById(managerId);

        Sale sale = new Sale();
        if (quantity < car.getQuantity()){
            car.setQuantity(car.getQuantity() - quantity);
            manager.setSales(manager.getSales() + quantity);

            carService.createCar(car);
            managerService.createManager(manager);
        }
        sale.setCar(car);
        sale.setManager(manager);
        sale.setQuantity(quantity);

        return saleRepository.save(sale);
    }
}
