package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.common.enums.ResultCodeEnum;
import com.sjzxy.fwpt.common.response.BaseResponse;
import com.sjzxy.fwpt.entity.Users;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public interface UsersService {

    /**
     * 添加数据
     * @param users
     * @return
     */
    BaseResponse addUsers(Users users);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delUsers(int id);

    /**
     * 更新数据
     * @param users
     * @return
     */
    Users updateUsers(Users users);


    /**
     * 查询全部数据
     * @return
     */
    List<Users> findAllUsers();


    Optional<Users> getUsersByUsername(String username);


    BaseResponse login(String sno, String password);

    Map findByUid(int uid);

    String getUsersById(Integer uid);

    String getImg(String img);

    BaseResponse editUsers(Users users);
}
