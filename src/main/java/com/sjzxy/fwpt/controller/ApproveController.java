package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.entity.Approve;
import com.sjzxy.fwpt.service.ApproveService;
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
@RequestMapping("/fwpt/approve/")
public class ApproveController {

    @Autowired
    private ApproveService approveService;

    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addApprove(@ApiParam("实体对象") @Valid @RequestBody Approve approve){
        approve.setCreateTime(new Date());
        Approve obj = approveService.addApprove(approve);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.AddDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delApprove(@PathVariable int id){
        approveService.delApprove(id);
        return BaseResponse.ok();
    }

    @ApiOperation(value = "更新数据")
    @PutMapping
    public BaseResponse updateApprove(@RequestBody Approve approve){
        Approve obj = approveService.updateApprove(approve);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "查询全部数据")
    @GetMapping("/")
    public BaseResponse findAllApprove(){
        List<Approve> lists = approveService.findAllApprove();
        return BaseResponse.ok().data(lists);

    }
}
