package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.Report;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
