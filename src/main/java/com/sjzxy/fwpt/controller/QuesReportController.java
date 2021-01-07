package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.entity.QuesReport;
import com.sjzxy.fwpt.service.QuesReportService;
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
@RequestMapping("/fwpt/quesReport/")
public class QuesReportController {

    @Autowired
    private QuesReportService quesReportService;

    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addQuesReport(@ApiParam("实体对象") @Valid @RequestBody QuesReport quesReport){
        quesReport.setCreateTime(new Date());
        QuesReport obj = quesReportService.addQuesReport(quesReport);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.AddDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delQuesReport(@PathVariable int id){
        quesReportService.delQuesReport(id);
        return BaseResponse.ok();
    }

    @ApiOperation(value = "更新数据")
    @PutMapping
    public BaseResponse updateQuesReport(@RequestBody QuesReport quesReport){
        QuesReport obj = quesReportService.updateQuesReport(quesReport);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "查询全部数据")
    @GetMapping("/")
    public BaseResponse findAllQuesReport(){
        List<QuesReport> lists = quesReportService.findAllQuesReport();
        return BaseResponse.ok().data(lists);

    }
}