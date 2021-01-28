package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.QuesSort;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuesSortRepository extends JpaRepository<QuesSort, Long> {

    QuesSort getQuesSortById(int id);
}
