package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.LostKind;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface LostKindRepository extends JpaRepository<LostKind, Long> {

    LostKind findAllById(int id);
}
