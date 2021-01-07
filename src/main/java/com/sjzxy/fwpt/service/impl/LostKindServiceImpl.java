package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.LostKind;
import com.sjzxy.fwpt.repository.LostKindRepository;
import com.sjzxy.fwpt.service.LostKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class LostKindServiceImpl implements LostKindService{

    @Autowired
    private LostKindRepository lostKindRepository;

    @Override
    public LostKind addLostKind(LostKind lostKind) {
        return lostKindRepository.save(lostKind);
    }

    @Override
    public void delLostKind(int id) {
        lostKindRepository.deleteById((long) id);
    }

    @Override
    public LostKind updateLostKind(LostKind lostKind){
        return lostKindRepository.save(lostKind);
    }

    @Override
    public List<LostKind> findAllLostKind() {
        return lostKindRepository.findAll();
    }

}
