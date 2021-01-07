package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.QuesInformation;

import java.util.List;

public interface QuesInformationService {

    /**
     * 添加数据
     * @param quesInformation
     * @return
     */
    QuesInformation addQuesInformation(QuesInformation quesInformation);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delQuesInformation(int id);

    /**
     * 更新数据
     * @param quesInformation
     * @return
     */
    QuesInformation updateQuesInformation(QuesInformation quesInformation);


    /**
     * 查询全部数据
     * @return
     */
    List<QuesInformation> findAllQuesInformation();
}
