package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.config.aop.sendMessage.ASendMessage;
import com.sjzxy.fwpt.entity.LostInformation;
import com.sjzxy.fwpt.entity.QuesInformation;
import com.sjzxy.fwpt.entity.QuesSort;
import com.sjzxy.fwpt.service.QuesInformationService;
import com.sjzxy.fwpt.service.impl.QuesInformationServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.sjzxy.fwpt.common.response.BaseResponse;

import javax.validation.Valid;
import java.util.*;

import com.sjzxy.fwpt.common.exception.BusinessException;
import com.sjzxy.fwpt.common.enums.ResultCodeEnum;

@Api(tags = "问题信息接口", description = "提供日志管理的相关查询接口")
@RestController
@RequestMapping("/quesInformation")
public class QuesInformationController {

    @Autowired
    private QuesInformationService quesInformationService;

    @ASendMessage
    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addQuesInformation(@ApiParam("实体对象") @Valid @RequestBody QuesInformation quesInformation){
        QuesInformation obj = quesInformationService.addQuesInformation(quesInformation);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.AddDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delQuesInformation(@PathVariable int id){
        quesInformationService.delQuesInformation(id);
        return BaseResponse.ok();
    }

    @ApiOperation(value = "更新数据")
    @PutMapping
    public BaseResponse updateQuesInformation(@RequestBody QuesInformation quesInformation){
        QuesInformation obj = quesInformationService.updateQuesInformation(quesInformation);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = QuesInformation.class)})
    @ApiOperation(value = "查询全部数据")
    @GetMapping("/datas")
    public BaseResponse findAllQuesInformation(){
        List<QuesInformation> lists = quesInformationService.findAllQuesInformation();
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);
    }

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = QuesInformation.class)})
    @ApiOperation(value = "根据qid查询数据")
    @GetMapping("/data/{qid}")
    public BaseResponse findQuesInformationByQid(@RequestParam Integer qid){
        Map map = quesInformationService.findQuesInformationByQid(qid);
        if (Objects.isNull(map)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(map);
    }


    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = QuesInformation.class)})
    @ApiOperation(value = "根据sid查询数据")
    @GetMapping("/datas/{sid}")
    public BaseResponse findQuesInformationBySid(@RequestParam Integer sid){
        List<QuesInformation> list = quesInformationService.findQuesInformationBySid(sid);
        if (list.size() <= 0){
            return BaseResponse.error().code(401);
        }
        if (Objects.isNull(list)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(list);
    }

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = QuesInformation.class)})
    @ApiOperation(value = "查询热门问题数据")
    @GetMapping("/hotdatas")
    public BaseResponse findHotQuesInformation(){
        List list = quesInformationService.findHotQuesInformation();
        if (Objects.isNull(list)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(list);
    }


    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = QuesInformation.class)})
    @ApiOperation(value = "根据关键字查询数据")
    @PostMapping("/key")
    public BaseResponse findQuesInformationByKey(@RequestParam String key){

        Page<QuesInformation> informationPage = quesInformationService.findQuesInformationByKey(key, true);
        System.out.println("lists:" + informationPage);
        if (Objects.isNull(informationPage)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(informationPage.getContent());
    }

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = QuesInformation.class)})
    @ApiOperation(value = "查询已解决的问题")
    @GetMapping("/finish")
    public BaseResponse findQuesInformationByFinish(){

        List<QuesInformation> list = quesInformationService.findQuesByFinish(1);

        if (Objects.isNull(list)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(list);
    }

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = QuesInformation.class)})
    @ApiOperation(value = "查询未解决的问题")
    @GetMapping("/unfinish")
    public BaseResponse findQuesInformationByUnFinish(){
        List<QuesInformation> list = quesInformationService.findQuesByFinish(0);
        if (Objects.isNull(list)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(list);
    }


    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = QuesInformation.class)})
    @ApiOperation(value = "根据分类查询已解决的问题")
    @GetMapping("/finish/{sid}")
    public BaseResponse findQuesByFinishAndSort(@RequestParam Integer sid){

        List<QuesInformation> list = quesInformationService.findQuesByFinishAndSort(1,sid);

        if (Objects.isNull(list)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(list);
    }

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = QuesInformation.class)})
    @ApiOperation(value = "根据分类查询未解决的问题")
    @GetMapping("/unfinish/{sid}")
    public BaseResponse findByUnFinishAndSort(@RequestParam Integer sid){
        List<QuesInformation> list = quesInformationService.findQuesByFinishAndSort(0,sid);
        if (Objects.isNull(list)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(list);
    }

    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = QuesInformation.class)})
    @ApiOperation(value = "根据关键字/分类/是否解决 查询问题")
    @PostMapping("/many_search")
    public BaseResponse findByFinishAndSortAndKey(@RequestParam(required = false) Integer sid,
                                                  @RequestParam(required = false) Integer finish,
                                                  @RequestParam String key){
        List<QuesInformation> list = quesInformationService.findQuesByFinishAndSortAndKey(finish,sid,key);
        if (Objects.isNull(list)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(list);
    }



}
