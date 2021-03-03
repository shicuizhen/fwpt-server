package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.QuesReply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

@Repository
public interface QuesReplyRepository extends JpaRepository<QuesReply, Long> {

    /**
     *
     * @param qid
     * @return
     */
    List<QuesReply> findAllByQid(Integer qid);

    void deleteByQid(Integer qid);

    void deleteById(Integer id);

    /**
     * 查找回答数多的前五个问题的qid和回答数
     * select classid,count(*) as abc from user group by classid order by count(*) desc
     * @return
     */
    @Query(value = "select qid,count(*) as num from ques_reply group by qid order by count(*) desc limit 5",nativeQuery = true)
    List<List<Integer>> findHotQuestion();

    List<QuesReply> findAllByCreateBy(int uid);
}
