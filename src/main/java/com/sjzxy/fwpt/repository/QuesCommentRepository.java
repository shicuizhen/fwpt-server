package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.QuesComment;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuesCommentRepository extends JpaRepository<QuesComment, Long> {
}
