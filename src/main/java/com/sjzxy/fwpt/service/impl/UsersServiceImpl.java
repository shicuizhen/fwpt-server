package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.common.enums.ResultCodeEnum;
import com.sjzxy.fwpt.common.exception.BusinessException;
import com.sjzxy.fwpt.entity.Users;
import com.sjzxy.fwpt.repository.UsersRepository;
import com.sjzxy.fwpt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users addUsers(Users users) {
        if (usersRepository.findAllBySno(users.getSno()) == null || usersRepository.findAllBySno(users.getSno()).equals(null)){
            users.setCreateTime(new Date());
            return usersRepository.save(users);
        }else {
            return null;
        }
    }

    @Override
    public void delUsers(int id) {
        usersRepository.deleteById((long) id);
    }

    @Override
    public Users updateUsers(Users users){
        return usersRepository.save(users);
    }

    @Override
    public List<Users> findAllUsers() {
        return usersRepository.findAll();
    }

    // TODO 查询用户信息
    @Override
    public Optional<Users> getUsersByUsername(String username) {
        return usersRepository.findAllByName(username);
    }

    @Override
    public ResultCodeEnum login(String sno, String password) {
        Optional<Users> optional = usersRepository.findAllBySno(sno);
        if (optional.get().equals(null)){
            return ResultCodeEnum.USER_IS_NOT_EXIT;
        }
        if (!password.equals(optional.get().getPassword())){
            return ResultCodeEnum.PASSWORD_ERROR;
        }
        return ResultCodeEnum.USER_LOGIN_SUCCESS;
    }

}
