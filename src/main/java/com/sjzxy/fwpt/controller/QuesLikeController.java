package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.entity.QuesInformation;
import com.sjzxy.fwpt.entity.QuesLike;
import com.sjzxy.fwpt.service.QuesLikeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sjzxy.fwpt.common.response.BaseResponse;

import javax.validation.Valid;
import java.util.*;

import com.sjzxy.fwpt.common.exception.BusinessException;
import com.sjzxy.fwpt.common.enums.ResultCodeEnum;

@Api(tags = "点赞信息接口", description = "提供日志管理的相关查询接口")
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

    @ApiOperation(value = "根据rid和uid删除数据")
    @PostMapping("/delQuesLike")
    public BaseResponse delQuesLikeByRidAddUid(@ApiParam("实体对象") @Valid @RequestBody QuesLike quesLike){
        quesLikeService.delQuesLikeByRidAddUid(quesLike.getRid(),quesLike.getUid());
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

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = QuesLike.class)})
    @ApiOperation(value = "查询全部数据")
    @GetMapping("/datas")
    public BaseResponse findAllQuesLike(){
        List<QuesLike> lists = quesLikeService.findAllQuesLike();
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);
    }

    @ApiResponses({@ApiResponse(code = 200,message = "OK")})
    @ApiOperation(value = "根据用户id查询回答点赞信息")
    @GetMapping("/rid/{uid}")
    public BaseResponse findReplyLikeIds(@RequestParam int uid){
        ArrayList list = new ArrayList();
        list = quesLikeService.getReplyLikeIdsByUid(uid);
        return BaseResponse.ok().data(list);
    }
}
