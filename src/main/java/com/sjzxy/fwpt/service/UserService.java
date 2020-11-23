package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.doamin.User;

/**
 * @author scz
 */
public interface UserService {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);
}
