package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.Manager;
import com.sjzxy.fwpt.repository.ManagerRepository;
import com.sjzxy.fwpt.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Manager addManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public void delManager(int id) {
        managerRepository.deleteById((long) id);
    }

    @Override
    public Manager updateManager(Manager manager){
        return managerRepository.save(manager);
    }

    @Override
    public List<Manager> findAllManager() {
        return managerRepository.findAll();
    }

    @Override
    public Manager findManagerByUid(Integer uid) {
        if (managerRepository.findAllByUid(uid) != null){
            return managerRepository.findAllByUid(uid);
        }else {
            return null;
        }

    }

}
