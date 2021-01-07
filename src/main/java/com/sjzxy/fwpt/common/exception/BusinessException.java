package com.sjzxy.fwpt.common.exception;

import com.sjzxy.fwpt.common.enums.ResultCodeEnum;
import lombok.Getter;

/**
 * @author tyd
 * @date 2020/12/3
 */
@Getter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;


    /**
     * throw new BusinessException(ResultCodeEnum.PARKING_DATA_NOT_EXIST);
     */

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

}
