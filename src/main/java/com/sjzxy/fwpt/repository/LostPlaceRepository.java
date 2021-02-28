package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.LostKind;
import com.sjzxy.fwpt.entity.LostPlace;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LostPlaceRepository extends JpaRepository<LostPlace, Long> {

    LostPlace findAllById(int id);
}
