package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.QuesInformation;
import com.sjzxy.fwpt.entity.QuesReply;

import java.util.List;

public interface QuesReplyService {

    /**
     * 添加数据
     * @param quesReply
     * @return
     */
    QuesReply addQuesReply(QuesReply quesReply);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delQuesReply(int id);


    /**
     * 更新数据
     * @param quesReply
     * @return
     */
    QuesReply updateQuesReply(QuesReply quesReply);


    /**
     * 查询全部数据
     * @return
     */
    List<QuesReply> findAllQuesReply();


//    /**
//     * 根据rid查询全部评论
//     * @param rid
//     * @return
//     */
//    List<QuesComment> findAllCommentByRid(Integer rid);

    /**
     * 根据qid查询对应问题下全部评论
     * @return
     */
    List<QuesReply> findQuesReplyByQid(int qid);

    List<QuesInformation> findQuesReplyByUid(int uid);
}
