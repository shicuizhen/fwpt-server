package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.College;
import com.sjzxy.fwpt.entity.LostKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

    College findAllById(int id);
}
