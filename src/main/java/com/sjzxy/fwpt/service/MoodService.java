package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.common.response.BaseResponse;
import com.sjzxy.fwpt.entity.Mood;

public interface MoodService {
    BaseResponse addMood(Mood mood);
}
