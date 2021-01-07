package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.LostClaim;

import java.util.List;

public interface LostClaimService {

    /**
     * 添加数据
     * @param lostClaim
     * @return
     */
    LostClaim addLostClaim(LostClaim lostClaim);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delLostClaim(int id);

    /**
     * 更新数据
     * @param lostClaim
     * @return
     */
    LostClaim updateLostClaim(LostClaim lostClaim);


    /**
     * 查询全部数据
     * @return
     */
    List<LostClaim> findAllLostClaim();
}
