package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.LostClaim;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LostClaimRepository extends JpaRepository<LostClaim, Long> {
}
