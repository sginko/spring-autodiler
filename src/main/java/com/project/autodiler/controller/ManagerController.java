package com.project.autodiler.controller;

import com.project.autodiler.model.Car;
import com.project.autodiler.model.Manager;
import com.project.autodiler.service.CarService;
import com.project.autodiler.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/all")
    public List<Manager> gettAllManager() {
        return managerService.getAllManager();
    }

    @PostMapping("/create")
    public Manager createManager(@RequestBody Manager manager) {
        return managerService.createManager(manager);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteManagerById(@PathVariable("id") Long id) {
        managerService.deleteManager(id);
    }
}
