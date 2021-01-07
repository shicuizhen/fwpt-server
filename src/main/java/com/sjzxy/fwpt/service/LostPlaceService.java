package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.LostPlace;

import java.util.List;

public interface LostPlaceService {

    /**
     * 添加数据
     * @param lostPlace
     * @return
     */
    LostPlace addLostPlace(LostPlace lostPlace);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delLostPlace(int id);

    /**
     * 更新数据
     * @param lostPlace
     * @return
     */
    LostPlace updateLostPlace(LostPlace lostPlace);


    /**
     * 查询全部数据
     * @return
     */
    List<LostPlace> findAllLostPlace();
}
