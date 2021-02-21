package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.QuesLike;

import java.util.ArrayList;
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


    /**
     * 查看当前用户是否点赞当前问题
     * @param qid
     * @param uid
     * @return
     */
    Boolean isQuesLike(Integer qid, Integer uid);

    Boolean isReplyLike(Integer rid, Integer uid);

    ArrayList getReplyLikeIdsByUid(int uid);

    void delQuesLikeByRidAddUid(Integer rid, Integer uid);
}
