package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.College;
import com.sjzxy.fwpt.repository.CollegeRepository;
import com.sjzxy.fwpt.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CollegeServiceImpl implements CollegeService{

    @Autowired
    private CollegeRepository collegeRepository;

    @Override
    public College addCollege(College college) {
        return collegeRepository.save(college);
    }

    @Override
    public void delCollege(int id) {
        collegeRepository.deleteById((long) id);
    }

    @Override
    public College updateCollege(College college){
        return collegeRepository.save(college);
    }

    @Override
    public List<College> findAllCollege() {
        return collegeRepository.findAll();
    }

}
