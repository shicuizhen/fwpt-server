package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.QuesComment;

import java.util.List;

public interface QuesCommentService {

    /**
     * 添加数据
     * @param quesComment
     * @return
     */
    QuesComment addQuesComment(QuesComment quesComment);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delQuesComment(int id);

    /**
     * 更新数据
     * @param quesComment
     * @return
     */
    QuesComment updateQuesComment(QuesComment quesComment);


    /**
     * 查询全部数据
     * @return
     */
    List<QuesComment> findAllQuesComment();


}
