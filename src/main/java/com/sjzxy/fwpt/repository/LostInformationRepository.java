package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.LostInformation;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LostInformationRepository extends JpaRepository<LostInformation, Long> {
}
