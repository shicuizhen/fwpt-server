package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.QuesLike;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuesLikeRepository extends JpaRepository<QuesLike, Long> {
}
