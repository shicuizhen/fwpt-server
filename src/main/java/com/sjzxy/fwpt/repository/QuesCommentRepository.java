package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.QuesComment;
import com.sjzxy.fwpt.entity.QuesReply;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface QuesCommentRepository extends JpaRepository<QuesComment, Long> {

    List<QuesComment> findAllByRid(Integer id);
}
