package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.QuesLike;

import java.util.List;

public interface QuesLikeService {

    /**
     * 添加数据
     * @param quesLike
     * @return
     */
    QuesLike addQuesLike(QuesLike quesLike);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delQuesLike(int id);

    /**
     * 更新数据
     * @param quesLike
     * @return
     */
    QuesLike updateQuesLike(QuesLike quesLike);


    /**
     * 查询全部数据
     * @return
     */
    List<QuesLike> findAllQuesLike();
}
