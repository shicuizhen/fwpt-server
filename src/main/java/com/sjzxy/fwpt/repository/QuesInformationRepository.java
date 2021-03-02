package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.LostInformation;
import com.sjzxy.fwpt.entity.QuesInformation;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface QuesInformationRepository
        extends JpaRepository<QuesInformation, Long> ,
        JpaSpecificationExecutor<QuesInformation>,
        PagingAndSortingRepository<QuesInformation, Long>,
        CrudRepository<QuesInformation, Long> {

    List<QuesInformation> findAllByIsFinish(int isFinish);

    List<QuesInformation> findAllByIsFinishAndSortId(int isFinish, int sid);

    void deleteById(Integer id);

    List<QuesInformation> findAllBySortId(int sortId);

    QuesInformation findAllById(int id);

    List<QuesInformation> findAllByCreateBy(int createby);

}
