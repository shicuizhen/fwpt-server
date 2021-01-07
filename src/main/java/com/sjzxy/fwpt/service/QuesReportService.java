package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.QuesReport;

import java.util.List;

public interface QuesReportService {

    /**
     * 添加数据
     * @param quesReport
     * @return
     */
    QuesReport addQuesReport(QuesReport quesReport);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delQuesReport(int id);

    /**
     * 更新数据
     * @param quesReport
     * @return
     */
    QuesReport updateQuesReport(QuesReport quesReport);


    /**
     * 查询全部数据
     * @return
     */
    List<QuesReport> findAllQuesReport();
}
