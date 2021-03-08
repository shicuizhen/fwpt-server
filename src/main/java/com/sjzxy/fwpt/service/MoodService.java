package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.common.response.BaseResponse;
import com.sjzxy.fwpt.entity.Mood;

import java.util.List;
import java.util.Map;

public interface MoodService {
    BaseResponse addMood(Mood mood);

    List<Mood> findTenMood();

    Map getMoodNum();
}
