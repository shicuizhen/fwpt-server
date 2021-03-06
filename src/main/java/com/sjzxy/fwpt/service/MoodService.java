package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.common.response.BaseResponse;
import com.sjzxy.fwpt.entity.Mood;

import java.util.List;

public interface MoodService {
    BaseResponse addMood(Mood mood);

    List<Mood> findTenMood();
}
