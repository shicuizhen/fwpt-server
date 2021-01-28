package com.sjzxy.fwpt.config.aop.log;

import com.sjzxy.fwpt.config.aop.log.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemLogRepository extends JpaRepository<SystemLog, Integer> {
    /**
     * 查询数据库中的所有日志
     *
     * @return List
     */
    @Override
    List<SystemLog> findAll();
}
