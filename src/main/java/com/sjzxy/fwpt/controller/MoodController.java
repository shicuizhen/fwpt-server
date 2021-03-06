package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.common.enums.ResultCodeEnum;
import com.sjzxy.fwpt.common.exception.BusinessException;
import com.sjzxy.fwpt.common.response.BaseResponse;
import com.sjzxy.fwpt.config.websocket.MoodWebsoketServer;
import com.sjzxy.fwpt.entity.Mood;
import com.sjzxy.fwpt.service.MoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;


@EnableRabbit
@Api(tags = "Mood相关接口", description = "提供日志管理的相关查询接口")
@RestController
@RequestMapping("/mood")
public class MoodController {

    @Autowired
    private MoodService moodService;


    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addMood(@ApiParam("实体对象") @Valid @RequestBody Mood mood){
        return moodService.addMood(mood);
    }

    @ApiOperation(value = "查询最新10条数据")
    @GetMapping("/datas")
    public BaseResponse findAllMood(){
        List<Mood> lists = moodService.findTenMood();
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);
    }

    @Resource
    MoodWebsoketServer moodWebsoket;

    @RabbitListener(queuesToDeclare = @Queue(value = "mood", durable = "true", exclusive = "false", autoDelete = "false"))
    @RabbitHandler
    public void SendMood(String mood) {
        System.out.println("mood:" + mood);
        // 将用户心情推送到前端
        moodWebsoket.sendInfo(mood);
    }
}
