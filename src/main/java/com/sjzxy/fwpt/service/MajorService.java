package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.LostKind;
import com.sjzxy.fwpt.entity.Major;

import java.util.List;

public interface MajorService {

    /**
     * 添加数据
     * @param major
     * @return
     */
    Major addMajor(Major major);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delMajor(int id);

    /**
     *
     * @param major
     * @return
     */
    Major updateMajor(Major major);


    /**
     * 查询全部数据
     * @return
     */
    List<Major> findAllMajor();

    List<Major> findAllMajorByCollege(int cid);
}
