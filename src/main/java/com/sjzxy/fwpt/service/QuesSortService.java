package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.QuesSort;

import java.util.List;

public interface QuesSortService {

    /**
     * 添加数据
     * @param quesSort
     * @return
     */
    QuesSort addQuesSort(QuesSort quesSort);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delQuesSort(int id);

    /**
     * 更新数据
     * @param quesSort
     * @return
     */
    QuesSort updateQuesSort(QuesSort quesSort);


    /**
     * 查询全部数据
     * @return
     */
    List<QuesSort> findAllQuesSort();
}
