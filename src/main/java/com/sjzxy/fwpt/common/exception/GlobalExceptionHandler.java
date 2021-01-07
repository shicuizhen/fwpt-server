package com.sjzxy.fwpt.common.exception;

import com.sjzxy.fwpt.common.response.BaseResponse;
import com.sjzxy.fwpt.common.enums.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author tyd
 * @date 2020/12/3
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private static final String ERROR_MESSAGE = "全局异常处理器捕获到 {} 类型的异常，错误信息：{}";

    /**
     * 业务异常处理
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse error(BusinessException e) {
        log.warn(ERROR_MESSAGE, e.getClass().getSimpleName(), e.getMessage());
        return BaseResponse.setResponse(e.getCode(), e.getMessage());
    }

    /**
     * 数据库操作异常
     */
    @ExceptionHandler(value = DataAccessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse error(DataAccessException e) {
        log.error(ERROR_MESSAGE, e.getClass().getSimpleName(), e.getMessage());
        return BaseResponse.setResponse(ResultCodeEnum.DATA_ACCESS_EXCEPTION.getCode(), ResultCodeEnum.DATA_ACCESS_EXCEPTION.getMessage() + e.getMessage());
    }
}
