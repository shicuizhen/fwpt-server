package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.doamin.User;
import com.sjzxy.fwpt.repository.UserRepository;
import com.sjzxy.fwpt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author scz
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
