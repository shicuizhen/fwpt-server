package com.sjzxy.fwpt.config.aop.log;

import com.sjzxy.fwpt.config.aop.log.SystemLog;

import java.util.List;

public interface SystemLogService {

    /**
     * 向数据库中插入日志信息
     *
     * @param systemLog 日志实体
     */
    void save(SystemLog systemLog);

    /**
     * 查询数据库中的所有日志信息
     *
     * @return List
     */
    List<SystemLog> findAll();
}
