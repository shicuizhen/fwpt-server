package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.LostInformation;
import com.sjzxy.fwpt.entity.LostSearch;
import org.springframework.data.domain.Page;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface LostInformationService {

    /**
     * 添加数据
     * @param lostInformation
     * @return
     */
    LostInformation addLostInformation(LostInformation lostInformation);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delLostInformation(int id);

    /**
     * 更新数据
     * @param lostInformation
     * @return
     */
    LostInformation updateLostInformation(LostInformation lostInformation);


    /**
     * 查询全部数据
     * @return
     */
    List<LostInformation> findAllLostInformation() throws ParseException;

    /**
     * 获取前五条数据
     * @return
     */
    List<String> findLunboData();

    Page getSearch(LostSearch lostSearch, Boolean needPagination) throws ParseException;

    List<LostInformation> findLostInfoByUid(Integer uid,Integer type);

    Page getMybatisSearch(LostSearch lostSearch,Boolean needPagination);

    Map getLostNum();

    List findById(Integer lid);

    LostInformation editLostInformation(LostInformation lostInformation);
}
