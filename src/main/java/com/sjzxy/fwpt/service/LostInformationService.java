package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.LostInformation;
import com.sjzxy.fwpt.entity.QuesInformation;

import java.util.List;

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
    List<LostInformation> findAllLostInformation();

    /**
     * 获取前五条数据
     * @return
     */
    List<String> findLunboData();
}
