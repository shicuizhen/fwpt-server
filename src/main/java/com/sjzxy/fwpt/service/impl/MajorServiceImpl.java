package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.LostKind;
import com.sjzxy.fwpt.entity.Major;
import com.sjzxy.fwpt.repository.LostKindRepository;
import com.sjzxy.fwpt.repository.MajorRepository;
import com.sjzxy.fwpt.service.LostKindService;
import com.sjzxy.fwpt.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorRepository majorRepository;

    @Override
    public Major addMajor(Major Major) {
        return majorRepository.save(Major);
    }

    @Override
    public void delMajor(int id) {
        majorRepository.deleteById((long) id);
    }

    @Override
    public Major updateMajor(Major Major){
        return majorRepository.save(Major);
    }

    @Override
    public List<Major> findAllMajor() {
        return majorRepository.findAll();
    }

    @Override
    public List<Major> findAllMajorByCollege(int cid) {
        System.out.println("cid");
        System.out.println(cid);
        return majorRepository.findAllByCollege(cid);
    }

}
