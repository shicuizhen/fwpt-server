package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.entity.LostInformation;
import com.sjzxy.fwpt.service.LostInformationService;
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

@RestController
@RequestMapping("/lostInformation")
public class LostInformationController {

    @Autowired
    private LostInformationService lostInformationService;

    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addLostInformation(@ApiParam("实体对象") @Valid @RequestBody LostInformation lostInformation){
        LostInformation obj = lostInformationService.addLostInformation(lostInformation);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.AddDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delLostInformation(@PathVariable int id){
        lostInformationService.delLostInformation(id);
        return BaseResponse.ok();
    }

    @ApiOperation(value = "更新数据")
    @PutMapping
    public BaseResponse updateLostInformation(@RequestBody LostInformation lostInformation){
        LostInformation obj = lostInformationService.updateLostInformation(lostInformation);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "查询全部数据")
    @GetMapping("/datas")
    public BaseResponse findAllLostInformation(){
        List<LostInformation> lists = lostInformationService.findAllLostInformation();
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);
    }
}
