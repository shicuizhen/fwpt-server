package com.sjzxy.fwpt.dao;

import com.sjzxy.fwpt.entity.LostInformation;
import com.sjzxy.fwpt.entity.LostSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LostInformationMapper {

    @Select("SELECT * FROM lost_information")
    public List<LostInformation> selectAll();

    List<LostInformation> findLostInfoBySearch(LostSearch lostSearch);
}
