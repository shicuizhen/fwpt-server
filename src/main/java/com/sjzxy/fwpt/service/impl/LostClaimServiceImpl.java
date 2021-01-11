package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.LostClaim;
import com.sjzxy.fwpt.repository.LostClaimRepository;
import com.sjzxy.fwpt.service.LostClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class LostClaimServiceImpl implements LostClaimService{

    @Autowired
    private LostClaimRepository lostClaimRepository;

    @Override
    public LostClaim addLostClaim(LostClaim lostClaim) {
        lostClaim.setCreateTime(new Date());
        return lostClaimRepository.save(lostClaim);
    }

    @Override
    public void delLostClaim(int id) {
        lostClaimRepository.deleteById((long) id);
    }

    @Override
    public LostClaim updateLostClaim(LostClaim lostClaim){
        return lostClaimRepository.save(lostClaim);
    }

    @Override
    public List<LostClaim> findAllLostClaim() {
        return lostClaimRepository.findAll();
    }

}
