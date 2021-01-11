package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.QuesReply;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface QuesReplyRepository extends JpaRepository<QuesReply, Long> {

    /**
     *
     * @param qid
     * @return
     */
    List<QuesReply> findAllByQid(Integer qid);
}
