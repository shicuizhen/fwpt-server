package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.entity.Manager;
import com.sjzxy.fwpt.service.ManagerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import com.sjzxy.fwpt.common.response.BaseResponse;
import io.swagger.annotations.ApiParam;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import com.sjzxy.fwpt.common.exception.BusinessException;
import com.sjzxy.fwpt.common.enums.ResultCodeEnum;

@Api(tags = "管理员", description = "提供日志管理的相关查询接口")
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addManager(@ApiParam("实体对象") @Valid @RequestBody Manager manager){
        Manager obj = managerService.addManager(manager);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.AddDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delManager(@PathVariable int id){
        managerService.delManager(id);
        return BaseResponse.ok();
    }

    @ApiOperation(value = "更新数据")
    @PutMapping
    public BaseResponse updateManager(@RequestBody Manager manager){
        Manager obj = managerService.updateManager(manager);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "查询全部数据")
    @GetMapping("/datas")
    public BaseResponse findAllManager(){
        List<Manager> lists = managerService.findAllManager();
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);
    }

    @ApiOperation(value = "查用户是否存在")
    @GetMapping("/datas/{uid}")
    public BaseResponse findManager(@RequestParam Integer uid){
        Manager manager = managerService.findManagerByUid(uid);
        if (Objects.isNull(manager)){
            return BaseResponse.error();
        }
        return BaseResponse.ok().data(manager);
    }
}
