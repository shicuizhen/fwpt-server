package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.Approve;

import java.util.List;

public interface ApproveService {

    /**
     * 添加数据
     * @param approve
     * @return
     */
    Approve addApprove(Approve approve);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delApprove(int id);

    /**
     * 更新数据
     * @param approve
     * @return
     */
    Approve updateApprove(Approve approve);


    /**
     * 查询全部数据
     * @return
     */
    List<Approve> findAllApprove();
}
