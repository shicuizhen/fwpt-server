package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.LostKind;

import java.util.List;

public interface LostKindService {

    /**
     * 添加数据
     * @param lostKind
     * @return
     */
    LostKind addLostKind(LostKind lostKind);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delLostKind(int id);

    /**
     * 更新数据
     * @param lostKind
     * @return
     */
    LostKind updateLostKind(LostKind lostKind);


    /**
     * 查询全部数据
     * @return
     */
    List<LostKind> findAllLostKind();
}
