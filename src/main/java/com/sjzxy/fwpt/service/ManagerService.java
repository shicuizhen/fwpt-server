package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.Manager;

import java.util.List;

public interface ManagerService {

    /**
     * 添加数据
     * @param manager
     * @return
     */
    Manager addManager(Manager manager);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delManager(int id);

    /**
     * 更新数据
     * @param manager
     * @return
     */
    Manager updateManager(Manager manager);


    /**
     * 查询全部数据
     * @return
     */
    List<Manager> findAllManager();

    Manager findManagerByUid(Integer uid);
}
