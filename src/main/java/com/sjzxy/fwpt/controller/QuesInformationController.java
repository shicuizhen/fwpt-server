package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.common.enums.ResultCodeEnum;
import com.sjzxy.fwpt.common.exception.BusinessException;
import com.sjzxy.fwpt.common.response.BaseResponse;
import com.sjzxy.fwpt.entity.QuesInformation;
import com.sjzxy.fwpt.service.QuesInformationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/quesInfo")
public class QuesInformationController {

    @Autowired
    private QuesInformationService quesInformationService;

    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addQuesInformation(@ApiParam("实体对象") @Valid @RequestBody QuesInformation quesInformation){
        quesInformation.setCreateTime(new Date());
        quesInformation.setCreateTime(new Date());
        QuesInformation obj = quesInformationService.addQuesInformation(quesInformation);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.AddDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delQuesInformation(@PathVariable int id){
        quesInformationService.delQuesInformation(id);
        return BaseResponse.ok();
    }

    @ApiOperation(value = "更新数据")
    @PutMapping
    public BaseResponse updateQuesInformation(@RequestBody QuesInformation quesInformation){
        QuesInformation obj = quesInformationService.updateQuesInformation(quesInformation);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "查询全部数据")
    @GetMapping("/datas")
    public BaseResponse findAllQuesInformation(){
        List<QuesInformation> lists = quesInformationService.findAllQuesInformation();
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);

    }

}
