package com.project.autodiler.service;

import com.project.autodiler.model.Car;
import com.project.autodiler.model.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> getAllManager();

    Manager getManagerById(Long id);

    Manager createManager(Manager manager);

    void deleteManager(Long id);
}
