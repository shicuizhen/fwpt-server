package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.QuesReport;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuesReportRepository extends JpaRepository<QuesReport, Long> {
}
