package com.sjzxy.fwpt.dao;

import com.sjzxy.fwpt.entity.LostInformation;
import com.sjzxy.fwpt.entity.LostSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface LostInformationMapper {

    @Select("SELECT * FROM lost_information")
    public List<LostInformation> selectAll();

    List<LostInformation> findLostInfoBySearch(LostSearch lostSearch);

    int findNumByTypeAndTime(@Param("type") int type,@Param("now") Date now, @Param("startDate") Date startDate);
}
