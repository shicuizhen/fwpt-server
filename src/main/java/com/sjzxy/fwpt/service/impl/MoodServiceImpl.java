package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.common.enums.ResultCodeEnum;
import com.sjzxy.fwpt.common.exception.BusinessException;
import com.sjzxy.fwpt.common.response.BaseResponse;
import com.sjzxy.fwpt.dao.MoodMapper;
import com.sjzxy.fwpt.entity.Mood;
import com.sjzxy.fwpt.entity.QuesInformation;
import com.sjzxy.fwpt.repository.MoodRepository;
import com.sjzxy.fwpt.service.MoodService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class MoodServiceImpl implements MoodService {

    @Autowired
    MoodRepository moodRepository;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public BaseResponse addMood(Mood mood) {
        mood.setCreateTime(new Date());
        Mood obj = moodRepository.save(mood);
        if (Objects.isNull(obj)){
            throw new BusinessException(ResultCodeEnum.AddDataError);
        }
        rabbitTemplate.convertAndSend("mood",mood.getNick()+":"+mood.getContent());

        return BaseResponse.ok();
    }

    @Override
    public List<Mood> findTenMood() {
        return moodRepository.findTenMood();
    }


    @Autowired
    MoodMapper moodMapper;

    @Override
    public Map getMoodNum() {
        Map map = new HashMap();
        Date now = new Date();
        Date startDate = DateUtils.addDays(now, -30);

        System.out.println("startDate:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate));
        System.out.println("now:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now));


        map.put("num",moodRepository.findAll().size());
        map.put("currentNum",moodMapper.findNumByTime(now,startDate));
        return map;
    }

    @Override
    public List<Mood> findMoodByUid(Integer uid) {
        return moodRepository.findAllByUid(uid);
    }

    @Override
    public void delMoodInformation(int id) {
        moodRepository.deleteById(id);
    }

    @Override
    public List<Mood> findAllMood() {
        List<Mood> lists = moodRepository.findAll();
        return lists;
    }


}
