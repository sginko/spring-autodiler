package com.project.autodiler.service;

import com.project.autodiler.model.Sale;

public interface SaleService {

    Sale createSale(Long carId, Long managerId, int quantity);
}
