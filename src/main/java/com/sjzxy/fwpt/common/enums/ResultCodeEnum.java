package com.sjzxy.fwpt.common.enums;

/**
 * @author tyd
 * @date 2020/12/3
 */
public enum ResultCodeEnum {

    // 1开头的是系统方面的
    SUCCESS(10000, "操作成功."),
    ERROR(-10001, "操作失败，请稍后重试."),
    // 2数据库增删改查出现的问题
    AddDataError(-20001, "添加数据异常"),
    DelDataError(-20002, "删除数据异常"),
    UpdateDataError(-20002, "删除数据异常"),
    // 3开头是持久层方面的
    DATA_ACCESS_EXCEPTION(-30001, "数据访问异常: "),
    ;

    /**
     * 响应码
     */
    private final Integer code;

    /**
     * 响应消息
     */
    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
