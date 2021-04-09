package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.College;
import com.sjzxy.fwpt.entity.LostKind;
import com.sjzxy.fwpt.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorRepository extends JpaRepository<Major, Long> {

    Major findAllById(int id);

    List<Major> findAllByCollege(int cid);

    Major findMajorById(int mid);
}
