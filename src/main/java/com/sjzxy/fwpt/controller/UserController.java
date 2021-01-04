package com.sjzxy.fwpt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @data 2020-11-23 17:20:20
 * @author scz
 */
@Api(tags = "user相关接口")
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @ApiOperation(value = "用户登录接口")
    void login(){

    }

}
