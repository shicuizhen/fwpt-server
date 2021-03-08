package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.LostInformation;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

@Repository
public interface LostInformationRepository
        extends JpaRepository<LostInformation, Long>,
        JpaSpecificationExecutor<LostInformation>,
        PagingAndSortingRepository<LostInformation, Long> ,
        CrudRepository<LostInformation, Long> {

    @Query(value = "SELECT * FROM `lost_information` order by create_time DESC LIMIT 5",nativeQuery = true)
    List<LostInformation> findFiveByCreateTime();

    void deleteById(Integer id);

    List<LostInformation> findAllByCreateByAndType(int create_by,int type);

}
