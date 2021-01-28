package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.entity.QuesInformation;
import com.sjzxy.fwpt.entity.QuesSort;
import com.sjzxy.fwpt.service.QuesSortService;
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

@Api(tags = "问题类别接口", description = "提供日志管理的相关查询接口")
@RestController
@RequestMapping("/quesSort")
public class QuesSortController {

    @Autowired
    private QuesSortService quesSortService;

    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addQuesSort(@ApiParam("实体对象") @Valid @RequestBody QuesSort quesSort){
        QuesSort obj = quesSortService.addQuesSort(quesSort);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.AddDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delQuesSort(@PathVariable int id){
        quesSortService.delQuesSort(id);
        return BaseResponse.ok();
    }

    @ApiOperation(value = "更新数据")
    @PutMapping
    public BaseResponse updateQuesSort(@RequestBody QuesSort quesSort){
        QuesSort obj = quesSortService.updateQuesSort(quesSort);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = QuesSort.class)})
    @ApiOperation(value = "查询全部数据")
    @GetMapping("/datas")
    public BaseResponse findAllQuesSort(){
        List<QuesSort> lists = quesSortService.findAllQuesSort();
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);
    }
}
