package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.LostPlace;
import com.sjzxy.fwpt.entity.Mood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodRepository extends JpaRepository<Mood, Long>{
}
