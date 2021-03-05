package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.common.enums.ResultCodeEnum;
import com.sjzxy.fwpt.common.exception.BusinessException;
import com.sjzxy.fwpt.common.response.BaseResponse;
import com.sjzxy.fwpt.config.websocket.WebSocketServer;
import com.sjzxy.fwpt.entity.Mood;
import com.sjzxy.fwpt.repository.MoodRepository;
import com.sjzxy.fwpt.service.MoodService;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.Objects;

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


}
