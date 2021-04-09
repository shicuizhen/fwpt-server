package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.common.enums.ResultCodeEnum;
import com.sjzxy.fwpt.common.exception.BusinessException;
import com.sjzxy.fwpt.common.response.BaseResponse;
import com.sjzxy.fwpt.entity.College;
import com.sjzxy.fwpt.entity.Major;
import com.sjzxy.fwpt.service.CollegeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Api(tags = "学院接口", description = "")
@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @ApiOperation(value = "添加数据")
    @PostMapping
    @ApiResponse(code = 200, message = "ok", response = BaseResponse.class)
    public BaseResponse addCollege(@ApiParam("实体对象") @Valid @RequestBody College college){
        College obj = collegeService.addCollege(college);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.AddDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("/del/{id}")
    public BaseResponse delCollege(@PathVariable int id){
        collegeService.delCollege(id);
        return BaseResponse.ok();
    }

    @ApiOperation(value = "更新数据")
    @PutMapping
    public BaseResponse updateCollege(@RequestBody College college){
        College obj = collegeService.updateCollege(college);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.UpdateDataError);
        }
        return BaseResponse.ok().data(obj);
    }

    @ApiOperation(value = "查询全部数据")
    @GetMapping("/datas")
    public BaseResponse findAllCollege(){
        List<College> lists = collegeService.findAllCollege();
        if (Objects.isNull(lists)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(lists);
    }

    @ApiOperation(value = "根据major查询college")
    @GetMapping("/datas/{mid}")
    public BaseResponse findAllMajorByCollege(@RequestParam("mid") int mid){
       College college = collegeService.findCollegeByMajor(mid);
        if (Objects.isNull(college)){
            throw new BusinessException(ResultCodeEnum.FindDataError);
        }
        return BaseResponse.ok().data(college);
    }
}
