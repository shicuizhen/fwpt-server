package com.sjzxy.fwpt.config.aop.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemLogServiceImpl implements SystemLogService {


    @Autowired(required = false)
    private SystemLogRepository systemLogRepository;


    @Override
    public void save(SystemLog systemLog) {
        systemLogRepository.save(systemLog);
    }

    @Override
    public List<SystemLog> findAll() {
        return systemLogRepository.findAll();
    }
}

