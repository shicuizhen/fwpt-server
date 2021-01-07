package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.Approve;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ApproveRepository extends JpaRepository<Approve, Long> {
}
