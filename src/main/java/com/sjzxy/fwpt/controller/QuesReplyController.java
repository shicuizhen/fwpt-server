package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.config.aop.sendMessage.ASendMessage;
import com.sjzxy.fwpt.entity.QuesComment;
import com.sjzxy.fwpt.entity.QuesInformation;
import com.sjzxy.fwpt.entity.QuesReply;
import com.sjzxy.fwpt.service.QuesReplyService;
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

@Api(tags = "问题回答接口", description = "提供日志管理的相关查询接口")
@RestController
@RequestMapping("/quesReply")
public class QuesReplyController {

    @Autowired
    private QuesReplyService quesReplyService;

    @ASendMessage("reply")
    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addQuesReply(@ApiParam("实体对象") @Valid @RequestBody QuesReply quesReply){
        QuesReply obj = quesReplyService.addQuesReply(quesReply);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.AddDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delQuesReply(@PathVariable int id){
        quesReplyService.delQuesReply(id);
        return BaseResponse.ok();
    }

    @ApiOperation(value = "更新数据")
    @PutMapping
    public BaseResponse updateQuesReply(@RequestBody QuesReply quesReply){
        QuesReply obj = quesReplyService.updateQuesReply(quesReply);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = QuesReply.class)})
    @ApiOperation(value = "根据问题id查询回答数据")
    @GetMapping("/datas/{qid}")
    public BaseResponse findQuesReplyByQid(int qid){
        List<QuesReply> lists = quesReplyService.findQuesReplyByQid(qid);
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);
    }

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = QuesReply.class)})
    @ApiOperation(value = "查询全部数据")
    @GetMapping("/datas")
    public BaseResponse findAllQuesReply(){
        List<QuesReply> lists = quesReplyService.findAllQuesReply();
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);
    }
}
