package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.entity.QuesLike;
import com.sjzxy.fwpt.service.QuesLikeService;
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
@RequestMapping("/quesLike")
public class QuesLikeController {

    @Autowired
    private QuesLikeService quesLikeService;

    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addQuesLike(@ApiParam("实体对象") @Valid @RequestBody QuesLike quesLike){
        QuesLike obj = quesLikeService.addQuesLike(quesLike);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.AddDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delQuesLike(@PathVariable int id){
        quesLikeService.delQuesLike(id);
        return BaseResponse.ok();
    }

    @ApiOperation(value = "更新数据")
    @PutMapping
    public BaseResponse updateQuesLike(@RequestBody QuesLike quesLike){
        QuesLike obj = quesLikeService.updateQuesLike(quesLike);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "查询全部数据")
    @GetMapping("/datas")    public BaseResponse findAllQuesLike(){
        List<QuesLike> lists = quesLikeService.findAllQuesLike();
        return BaseResponse.ok().data(lists);

    }
}
