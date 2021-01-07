package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.QuesInformation;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuesInformationRepository extends JpaRepository<QuesInformation, Long> {
}
