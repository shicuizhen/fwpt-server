package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.Report;
import com.sjzxy.fwpt.repository.ReportRepository;
import com.sjzxy.fwpt.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

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
        reportRepository.deleteById(id);
    }

    @Override
    public Report updateQuesReport(Report report){
        return reportRepository.save(report);
    }

    @Override
    public List<Report> findAllQuesReport() {
        List<Report> report = reportRepository.findAll();
        List list = new ArrayList();
        for (int i = 0;i<report.size();i++){
            Map map = new HashMap();
            map.put("id",report.get(i).getId());
            map.put("content",report.get(i).getContent());
            map.put("uid",report.get(i).getUid());
            map.put("createTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(report.get(i).getCreateTime()));
            list.add(map);
        }
        return list;
    }

}
