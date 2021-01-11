package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.QuesReport;
import com.sjzxy.fwpt.repository.QuesReportRepository;
import com.sjzxy.fwpt.service.QuesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class QuesReportServiceImpl implements QuesReportService{

    @Autowired
    private QuesReportRepository quesReportRepository;

    @Override
    public QuesReport addQuesReport(QuesReport quesReport) {
        quesReport.setCreateTime(new Date());
        return quesReportRepository.save(quesReport);
    }

    @Override
    public void delQuesReport(int id) {
        quesReportRepository.deleteById((long) id);
    }

    @Override
    public QuesReport updateQuesReport(QuesReport quesReport){
        return quesReportRepository.save(quesReport);
    }

    @Override
    public List<QuesReport> findAllQuesReport() {
        return quesReportRepository.findAll();
    }

}
