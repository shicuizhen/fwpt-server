package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.College;
import com.sjzxy.fwpt.entity.LostKind;

import java.util.List;

public interface CollegeService {

    /**
     * 添加数据
     * @param college
     * @return
     */
    College addCollege(College college);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delCollege(int id);

    /**
     * 更新数据
     * @param college
     * @return
     */
    College updateCollege(College college);


    /**
     * 查询全部数据
     * @return
     */
    List<College> findAllCollege();
}
