package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.LostInformation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface LostInformationRepository extends JpaRepository<LostInformation, Long> {

    @Query(value = "SELECT * FROM `lost_information` order by create_time DESC LIMIT 5",nativeQuery = true)
    List<LostInformation> findFiveByCreatTime();
}
