package com.project.autodiler.controller;

import com.project.autodiler.model.Sale;
import com.project.autodiler.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleController {

    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }


    @GetMapping("/create/{carId}/{managerId}/{quantity}")
    public Sale createSale(@PathVariable("carId") Long carId,
                           @PathVariable("managerId") Long managerId,
                           @PathVariable("quantity") int quantity) {
        return saleService.createSale(carId, managerId, quantity);
    }
}
