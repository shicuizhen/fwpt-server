package com.sjzxy.fwpt.config.aop.log;

import com.sjzxy.fwpt.common.response.BaseResponse;
import com.sjzxy.fwpt.config.aop.sendMessage.ASendMessage;
import com.sjzxy.fwpt.entity.QuesInformation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "日志管理相关接口", description = "提供日志管理的相关查询接口")
@RestController
@RequestMapping("/log")
public class SystemLogController {

    @Autowired
    private SystemLogService logService;

    @ApiOperation(value = "查询所有日志")
    @GetMapping("/system-logs")
    public BaseResponse findAll() {
        List<SystemLog> systemLogs = logService.findAll();
        return BaseResponse.ok().data("systemLogs", systemLogs);
    }




    @ApiOperation(value = "debug接口")
    @GetMapping
    @ASystemLog(value = "执行了debug方法")
    public BaseResponse debug() {
        return BaseResponse.ok();
    }

    @ApiOperation(value = "send接口")
    @PostMapping("/send")
    @ASendMessage(value = "执行了sendMessage方法")
    public BaseResponse sendMessage(@ApiParam("实体对象") @Valid @RequestBody QuesInformation quesInformation){
        System.out.println("controller-执行了sendMessage方法");
        return BaseResponse.ok();
    }


}
