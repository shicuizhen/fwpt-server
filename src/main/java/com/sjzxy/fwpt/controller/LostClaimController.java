package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.entity.LostClaim;
import com.sjzxy.fwpt.service.LostClaimService;
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
@RequestMapping("/lostClaim")
public class LostClaimController {

    @Autowired
    private LostClaimService lostClaimService;

    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addLostClaim(@ApiParam("实体对象") @Valid @RequestBody LostClaim lostClaim){
        lostClaim.setCreateTime(new Date());
        LostClaim obj = lostClaimService.addLostClaim(lostClaim);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.AddDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delLostClaim(@PathVariable int id){
        lostClaimService.delLostClaim(id);
        return BaseResponse.ok();
    }

    @ApiOperation(value = "更新数据")
    @PutMapping
    public BaseResponse updateLostClaim(@RequestBody LostClaim lostClaim){
        LostClaim obj = lostClaimService.updateLostClaim(lostClaim);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "查询全部数据")
    @GetMapping("/datas")
    public BaseResponse findAllLostClaim(){
        List<LostClaim> lists = lostClaimService.findAllLostClaim();
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);
    }
}
