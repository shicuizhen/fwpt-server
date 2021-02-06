package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.config.aop.log.ASystemLog;
import com.sjzxy.fwpt.config.aop.sendMessage.ASendMessage;
import com.sjzxy.fwpt.entity.QuesComment;
import com.sjzxy.fwpt.entity.QuesInformation;
import com.sjzxy.fwpt.entity.Users;
import com.sjzxy.fwpt.service.QuesCommentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sjzxy.fwpt.common.response.BaseResponse;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import com.sjzxy.fwpt.common.exception.BusinessException;
import com.sjzxy.fwpt.common.enums.ResultCodeEnum;

@Api(tags = "问答评论接口", description = "提供日志管理的相关查询接口")
@RestController
@RequestMapping("/quesComment")
public class QuesCommentController {

    @Autowired
    private QuesCommentService quesCommentService;

    @ASendMessage("comment")
    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addQuesComment(@ApiParam("实体对象") @Valid @RequestBody QuesComment quesComment){
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

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = QuesComment.class)})
    @ApiOperation(value = "查询全部数据")
    @GetMapping("/datas")
    public BaseResponse findAllQuesComment(){
        List<QuesComment> lists = quesCommentService.findAllQuesComment();
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);
    }
}
