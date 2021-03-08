package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.Report;

import java.util.List;

public interface ReportService {

    /**
     * 添加数据
     * @param report
     * @return
     */
    Report addQuesReport(Report report);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delQuesReport(int id);

    /**
     * 更新数据
     * @param report
     * @return
     */
    Report updateQuesReport(Report report);


    /**
     * 查询全部数据
     * @return
     */
    List<Report> findAllQuesReport();
}
