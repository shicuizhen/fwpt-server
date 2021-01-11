package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.Approve;
import com.sjzxy.fwpt.repository.ApproveRepository;
import com.sjzxy.fwpt.service.ApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ApproveServiceImpl implements ApproveService{

    @Autowired
    private ApproveRepository approveRepository;

    @Override
    public Approve addApprove(Approve approve) {
        approve.setCreateTime(new Date());
        return approveRepository.save(approve);
    }

    @Override
    public void delApprove(int id) {
        approveRepository.deleteById((long) id);
    }

    @Override
    public Approve updateApprove(Approve approve){
        return approveRepository.save(approve);
    }

    @Override
    public List<Approve> findAllApprove() {
        return approveRepository.findAll();
    }

}
