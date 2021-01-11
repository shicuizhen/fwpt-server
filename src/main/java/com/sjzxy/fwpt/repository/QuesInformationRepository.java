package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.QuesInformation;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface QuesInformationRepository extends JpaRepository<QuesInformation, Long> {

    List<QuesInformation> findAllByIsFinish(int isFinish);

    void deleteById(Integer id);
}
