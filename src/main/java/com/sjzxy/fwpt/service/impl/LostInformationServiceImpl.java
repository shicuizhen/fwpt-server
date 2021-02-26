package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.LostInformation;
import com.sjzxy.fwpt.entity.QuesInformation;
import com.sjzxy.fwpt.repository.LostInformationRepository;
import com.sjzxy.fwpt.service.LostInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class LostInformationServiceImpl implements LostInformationService{

    @Autowired
    private LostInformationRepository lostInformationRepository;

    @Override
    public LostInformation addLostInformation(LostInformation lostInformation) {
        lostInformation.setCreateTime(new Date());
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
        /**
         *  "id": 2,
         *       "name": "书籍",
         *       "type": 1,
         *       "kindId": 1,
         *       "description": "我丢失了一本书",
         *       "username": "张三",
         *       "placeId": 1,
         *       "position": "1",
         *       "lostTime": "2021-02-24T19:35:26.000+00:00",
         *       "telephone": "12345625214",
         *       "email": "12454@11.ss",
         *       "createBy": 1,
         *       "createTime": "2021-02-10T19:36:01.000+00:00",
         *       "stateId": 2
         *     },
         */
        List<LostInformation> lostInformations = lostInformationRepository.findAll();
        return lostInformations;
    }


    @Override
    public List<String> findLunboData() {
        List<String> lunbo = new ArrayList<>();
        List<LostInformation> list = lostInformationRepository.findFiveByCreatTime();
        for (int i =0; i < list.size();i++){
            LostInformation data = list.get(i);
            String username = (data.getUsername().equals("") || data.getUsername() == null) ? "某用户" : data.getUsername();
            String type =  data.getType() == 0 ? "丢失了 " : "捡到了";
            String str = username + type + data.getName();
            lunbo.add(str);
        }
        return lunbo;
    }

}
