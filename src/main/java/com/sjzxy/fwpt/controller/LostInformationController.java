package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.config.websocket.WebSocketServer;
import com.sjzxy.fwpt.entity.LostInformation;
import com.sjzxy.fwpt.entity.LostSearch;
import com.sjzxy.fwpt.entity.QuesInformation;
import com.sjzxy.fwpt.service.LostInformationService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.sjzxy.fwpt.common.response.BaseResponse;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import com.sjzxy.fwpt.common.exception.BusinessException;
import com.sjzxy.fwpt.common.enums.ResultCodeEnum;

@Api(tags = "失物信息相关接口", description = "提供日志管理的相关查询接口")
@RestController
@RequestMapping("/lostInformation")
public class LostInformationController {

    @Autowired
    private LostInformationService lostInformationService;

    private WebSocketServer webSocketServer;

    @ApiOperation(value = "添加数据")
    @PostMapping("/add")
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addLostInformation(@ApiParam("实体对象") @Valid @RequestBody LostInformation lostInformation){

        //前端表单提交的时间： Tue Feb 23 2021 00:00:00 GMT+0800 (中国标准时间)
        //前端转化的时间：    2021-02-23
        //新创建的date：     Sun Feb 28 21:25:59 CST 2021
        //存入数据库：       2021-02-28T13:25:59.513+00:00

        System.out.println("losttime:"+lostInformation.getLostTime());
        LostInformation obj = lostInformationService.addLostInformation(lostInformation);
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delLostInformation(@RequestParam int id){
        lostInformationService.delLostInformation(id);
        return BaseResponse.ok();
    }


    @ApiOperation(value = "更新数据")
    @PutMapping
    public BaseResponse updateLostInformation(@RequestBody LostInformation lostInformation){
        LostInformation obj = lostInformationService.updateLostInformation(lostInformation);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = LostInformation.class)})
    @ApiOperation(value = "查询全部数据")
    @GetMapping("/datas")
    public BaseResponse findAllLostInformation() throws ParseException {
        List<LostInformation> lists = lostInformationService.findAllLostInformation();
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);
    }


    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = LostInformation.class)})
    @ApiOperation(value = "查询轮播数据")
    @GetMapping("/lunbodata")
    public BaseResponse findLunboData(){
        List<String> lists = lostInformationService.findLunboData();
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);
    }



    @ApiOperation(value = "多条件查询")
    @PostMapping("/getSearch")
    public BaseResponse findLostInformation(@RequestBody LostSearch lostSearch) throws ParseException {
        boolean needPagination = lostSearch.getPageNo() > 0 && lostSearch.getPageSize() > 0;
        Page<LostInformation> informationPage = lostInformationService.getSearch(lostSearch, needPagination);
        System.out.println("lists:" + informationPage);
        if (Objects.isNull(informationPage)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(informationPage.getContent());
    }


    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = LostInformation.class)})
    @ApiOperation(value = "根据uid查询失物数据")
    @GetMapping("/lost/{uid}")
    public BaseResponse findLostInfoByUid(@RequestParam Integer uid){
        List<LostInformation> list = lostInformationService.findLostInfoByUid(uid,0);
        if (Objects.isNull(list)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(list);
    }

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = LostInformation.class)})
    @ApiOperation(value = "根据uid查询招领数据")
    @GetMapping("/get/{uid}")
    public BaseResponse findGetInfoByUid(@RequestParam Integer uid){
        List<LostInformation> list = lostInformationService.findLostInfoByUid(uid,1);
        if (Objects.isNull(list)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(list);
    }




}
