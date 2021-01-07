package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.QuesInformation;
import com.sjzxy.fwpt.repository.QuesInformationRepository;
import com.sjzxy.fwpt.service.QuesInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class QuesInformationServiceImpl implements QuesInformationService{

    @Autowired
    private QuesInformationRepository quesInformationRepository;

    @Override
    public QuesInformation addQuesInformation(QuesInformation quesInformation) {
        return quesInformationRepository.save(quesInformation);
    }

    @Override
    public void delQuesInformation(int id) {
        quesInformationRepository.deleteById((long) id);
    }


    @Override
    public QuesInformation updateQuesInformation(QuesInformation quesInformation){
        return quesInformationRepository.save(quesInformation);
    }

    @Override
    public List<QuesInformation> findAllQuesInformation() {
        return quesInformationRepository.findAll();
    }
}
