package com.sjzxy.fwpt.common.response;

import com.sjzxy.fwpt.common.enums.ResultCodeEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tyd
 * @date 2020/12/3
 */
@Data
public class BaseResponse {

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private Object data;


    /**
     * 通用返回成功
     */
    public static BaseResponse ok() {
        BaseResponse response = new BaseResponse();
        response.setCode(ResultCodeEnum.SUCCESS.getCode());
        response.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        response.setData(null);
        return response;
    }

    /**
     * 通用返回失败
     */
    public static BaseResponse error() {
        BaseResponse response = new BaseResponse();
        response.setCode(ResultCodeEnum.ERROR.getCode());
        response.setMessage(ResultCodeEnum.ERROR.getMessage());
        response.setData(null);
        return response;
    }

    /**
     * 自定义返回结果
     */
    public static BaseResponse setResponse(ResultCodeEnum codeEnum) {
        BaseResponse response = new BaseResponse();
        response.setCode(codeEnum.getCode());
        response.setMessage(codeEnum.getMessage());
        response.setData(null);
        return response;
    }

    /**
     * 自定义返回结果
     */
    public static BaseResponse setResponse(Integer code, String message) {
        BaseResponse response = new BaseResponse();
        response.setCode(code);
        response.setMessage(message);
        response.setData(null);
        return response;
    }

    /**
     * 设置数据部分
     */
    public BaseResponse data(Object data){
        this.setData(data);
        return this;
    }


    public BaseResponse data(Map<String, Object> data) {
        this.setData(data);
        return this;
    }

    public BaseResponse data(String key, Object value) {
        Map map = new HashMap();
        map.put(key,value);
        this.setData(map);
        return this;
    }

    public BaseResponse message(String message) {
        this.setMessage(message);
        return this;
    }

    public BaseResponse code(Integer code) {
        this.setCode(code);
        return this;
    }
}
