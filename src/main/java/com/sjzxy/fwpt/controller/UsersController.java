package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.entity.QuesInformation;
import com.sjzxy.fwpt.entity.Users;
import com.sjzxy.fwpt.service.UsersService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sjzxy.fwpt.common.response.BaseResponse;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import com.sjzxy.fwpt.common.exception.BusinessException;
import com.sjzxy.fwpt.common.enums.ResultCodeEnum;

@Api(tags = "用户信息相关接口", description = "提供日志管理的相关查询接口")
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addUsers(@ApiParam("实体对象") @Valid @RequestBody Users users){
        Users obj = usersService.addUsers(users);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.AddDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delUsers(@PathVariable int id){
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
}
