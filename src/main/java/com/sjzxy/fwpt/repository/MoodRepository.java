package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.LostPlace;
import com.sjzxy.fwpt.entity.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoodRepository extends JpaRepository<Mood, Long>{


    @Query(value = "select * from mood create_time order by create_time desc limit 5",nativeQuery = true)
    List<Mood> findTenMood();

    List<Mood> findAllByUid(Integer uid);

    void deleteById(Integer id);
}
