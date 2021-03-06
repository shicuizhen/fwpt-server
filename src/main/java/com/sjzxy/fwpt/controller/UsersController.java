package com.sjzxy.fwpt.controller;
import com.sjzxy.fwpt.entity.QuesInformation;
import com.sjzxy.fwpt.entity.UserLogin;
import com.sjzxy.fwpt.entity.Users;
import com.sjzxy.fwpt.repository.UsersRepository;
import com.sjzxy.fwpt.service.UsersService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sjzxy.fwpt.common.response.BaseResponse;

import javax.validation.Valid;
import java.util.*;

import com.sjzxy.fwpt.common.exception.BusinessException;
import com.sjzxy.fwpt.common.enums.ResultCodeEnum;

@Api(tags = "用户信息相关接口", description = "提供日志管理的相关查询接口")
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @ApiOperation(value = "图片")
    @PostMapping("/img")
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse getImg(@ApiParam("base64编码") @Valid @RequestBody String baseData) {
        String path = usersService.getImg(baseData);
        if (Objects.isNull(path)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(path);
    }


    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse login(@ApiParam("实体对象") @Valid @RequestBody UserLogin userLogin){
        return usersService.login(userLogin.getSno(),userLogin.getPassword());
    }

    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addUsers(@ApiParam("实体对象") @Valid @RequestBody Users users){
        return usersService.addUsers(users);
    }

    @ApiOperation(value = "修改数据")
    @PostMapping("/edit")
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse editUsers(@ApiParam("实体对象") @Valid @RequestBody Users users){
        System.out.println("controller-user");
        System.out.println(users);
        return usersService.editUsers(users);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delUsers(@RequestParam int id){
        usersService.delUsers(id);
        return BaseResponse.ok();
    }

    @ApiOperation(value = "更新数据")
    @PutMapping
    public BaseResponse updateUsers(@RequestBody Users users){
        Users obj = usersService.updateUsers(users);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = Users.class)})
    @ApiOperation(value = "查询全部数据")
    @GetMapping("/datas")
    public BaseResponse findAllUsers(){
        List<Users> lists = usersService.findAllUsers();
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);
    }

    @Autowired
    UsersRepository usersRepository;

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = Users.class)})
    @ApiOperation(value = "通过名字查询数据")
    @PostMapping("/datas/username")
    public BaseResponse findAllByUsername(@RequestParam String username){
        username = "张三";
        Optional<Users> users = usersRepository.findAllByName(username);
        System.out.println("users:" + users);
        return BaseResponse.ok().data(users);
    }


    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = Users.class)})
    @ApiOperation(value = "通过用户id查询数据")
    @PostMapping("/datas/{uid}")
    public BaseResponse findAllByUid(@RequestParam int uid){
        Map map = usersService.findByUid(uid);
        System.out.println("map");
        System.out.println(map);
        return BaseResponse.ok().data(map);
    }





}
