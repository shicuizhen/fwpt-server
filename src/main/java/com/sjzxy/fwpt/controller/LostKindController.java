package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.entity.LostKind;
import com.sjzxy.fwpt.service.LostKindService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import com.sjzxy.fwpt.common.response.BaseResponse;
import io.swagger.annotations.ApiParam;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import com.sjzxy.fwpt.common.exception.BusinessException;
import com.sjzxy.fwpt.common.enums.ResultCodeEnum;

@Api(tags = "失物种类接口", description = "提供日志管理的相关查询接口")
@RestController
@RequestMapping("/lostKind")
public class LostKindController {

    @Autowired
    private LostKindService lostKindService;

    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addLostKind(@ApiParam("实体对象") @Valid @RequestBody LostKind lostKind){
        LostKind obj = lostKindService.addLostKind(lostKind);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.AddDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delLostKind(@PathVariable int id){
        lostKindService.delLostKind(id);
        return BaseResponse.ok();
    }

    @ApiOperation(value = "更新数据")
    @PutMapping
    public BaseResponse updateLostKind(@RequestBody LostKind lostKind){
        LostKind obj = lostKindService.updateLostKind(lostKind);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "查询全部数据")
    @GetMapping("/datas")
    public BaseResponse findAllLostKind(){
        List<LostKind> lists = lostKindService.findAllLostKind();
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);
    }
}
