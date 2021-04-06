package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.LostPlace;
import com.sjzxy.fwpt.entity.QuesInformation;
import com.sjzxy.fwpt.repository.LostPlaceRepository;
import com.sjzxy.fwpt.service.LostPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class LostPlaceServiceImpl implements LostPlaceService{

    @Override
    public LostPlace findPlaceByPid(int pid) {
        return lostPlaceRepository.findAllById(pid);
    }



    @Autowired
    private LostPlaceRepository lostPlaceRepository;

    @Override
    public LostPlace addLostPlace(LostPlace lostPlace) {
        return lostPlaceRepository.save(lostPlace);
    }

    @Override
    public void delLostPlace(int id) {
        lostPlaceRepository.deleteById((long) id);
    }

    @Override
    public LostPlace updateLostPlace(LostPlace lostPlace){
        return lostPlaceRepository.save(lostPlace);
    }

    @Override
    public List<LostPlace> findAllLostPlace() {
        return lostPlaceRepository.findAll();
    }

}
