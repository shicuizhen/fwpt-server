package com.sjzxy.fwpt.security.service;

import com.sjzxy.fwpt.security.dao.LoginUser;
import com.sjzxy.fwpt.service.UsersService;
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
    private UsersService userService;

    @Override
    public UserDetails loadUserByUsername(String str) throws UsernameNotFoundException {
        str = "w";
        return null;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = userService.getUserByUsername(username);
//        return new LoginUser(user);
//    }

}
