package com.sjzxy.fwpt.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@Mapper
public interface QuesInformationMapper {

    int findNumByTime(@Param("now") Date now, @Param("startDate") Date startDate);
}
