package com.sjzxy.fwpt.security.service;

import com.sjzxy.fwpt.doamin.User;
import com.sjzxy.fwpt.security.dao.LoginUser;
import com.sjzxy.fwpt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @date 2020-11-23 16:20:06
 * @author scz
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        return new LoginUser(user);
    }

}
