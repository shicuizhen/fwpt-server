package com.sjzxy.fwpt.common.enums;

/**
 * @author tyd
 * @date 2020/12/3
 */
public enum ResultCodeEnum {

    // 1开头的是系统方面的
    SUCCESS(200, "操作成功."),
    ERROR(-101, "操作失败，请稍后重试."),
    // 2数据库增删改查出现的问题
    AddDataError(-201, "添加数据异常"),
    DelDataError(-202, "删除数据异常"),
    UpdateDataError(-203, "更新数据异常"),
    FindDataError(-204, "查找数据异常"),
    InvalidLike(-205, "点赞无效"),
    // 3开头是持久层方面的
    DATA_ACCESS_EXCEPTION(-301, "数据访问异常: "),
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
