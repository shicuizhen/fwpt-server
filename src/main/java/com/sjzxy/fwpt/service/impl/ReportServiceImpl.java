package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.Report;
import com.sjzxy.fwpt.repository.ReportRepository;
import com.sjzxy.fwpt.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report addQuesReport(Report report) {
        report.setCreateTime(new Date());
        return reportRepository.save(report);
    }

    @Override
    public void delQuesReport(int id) {
        reportRepository.deleteById((long) id);
    }

    @Override
    public Report updateQuesReport(Report report){
        return reportRepository.save(report);
    }

    @Override
    public List<Report> findAllQuesReport() {
        return reportRepository.findAll();
    }

}
