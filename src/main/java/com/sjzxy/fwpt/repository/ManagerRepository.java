package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.Manager;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Manager findAllByUid(int uid);
}
