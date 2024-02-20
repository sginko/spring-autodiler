package com.project.autodiler.service;

import com.project.autodiler.model.Manager;
import com.project.autodiler.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    public final ManagerRepository managerRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public List<Manager> getAllManager() {
        return managerRepository.findAll();
    }

    @Override
    public Manager getManagerById(Long id) {
        Optional<Manager> optionalManager = managerRepository.findById(id);
        if (optionalManager.isEmpty()) {
            throw new IllegalStateException("Manager with id" + id + "does not exist");
        }
        return optionalManager.get();
    }

    @Override
    public Manager createManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public void deleteManager(Long id) {
        managerRepository.deleteById(id);
    }
}
