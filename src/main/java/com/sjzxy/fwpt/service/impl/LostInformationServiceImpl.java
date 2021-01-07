package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.LostInformation;
import com.sjzxy.fwpt.repository.LostInformationRepository;
import com.sjzxy.fwpt.service.LostInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class LostInformationServiceImpl implements LostInformationService{

    @Autowired
    private LostInformationRepository lostInformationRepository;

    @Override
    public LostInformation addLostInformation(LostInformation lostInformation) {
        return lostInformationRepository.save(lostInformation);
    }

    @Override
    public void delLostInformation(int id) {
        lostInformationRepository.deleteById((long) id);
    }

    @Override
    public LostInformation updateLostInformation(LostInformation lostInformation){
        return lostInformationRepository.save(lostInformation);
    }

    @Override
    public List<LostInformation> findAllLostInformation() {
        return lostInformationRepository.findAll();
    }

}
