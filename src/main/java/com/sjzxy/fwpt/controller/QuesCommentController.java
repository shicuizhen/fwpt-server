package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.entity.QuesComment;
import com.sjzxy.fwpt.service.QuesCommentService;
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
@RequestMapping("/fwpt/quesComment/")
public class QuesCommentController {

    @Autowired
    private QuesCommentService quesCommentService;

    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addQuesComment(@ApiParam("实体对象") @Valid @RequestBody QuesComment quesComment){
        quesComment.setCreateTime(new Date());
        QuesComment obj = quesCommentService.addQuesComment(quesComment);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.AddDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delQuesComment(@PathVariable int id){
        quesCommentService.delQuesComment(id);
        return BaseResponse.ok();
    }

    @ApiOperation(value = "更新数据")
    @PutMapping
    public BaseResponse updateQuesComment(@RequestBody QuesComment quesComment){
        QuesComment obj = quesCommentService.updateQuesComment(quesComment);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "查询全部数据")
    @GetMapping("/")
    public BaseResponse findAllQuesComment(){
        List<QuesComment> lists = quesCommentService.findAllQuesComment();
        return BaseResponse.ok().data(lists);

    }
}
