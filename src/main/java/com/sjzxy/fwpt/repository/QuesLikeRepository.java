package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.QuesLike;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
public interface QuesLikeRepository extends JpaRepository<QuesLike, Long> {

    List<QuesLike> findAllByQid(Integer qid);

    List<QuesLike> findAllByRid(Integer rid);

    void deleteById(Integer id);

    List<QuesLike> findAllByQidAndUid(Integer qid, Integer uid);

    List<QuesLike> findAllByRidAndUid(Integer rid, Integer uid);

    List<QuesLike> findAllByUid(int uid);

    List<QuesLike> deleteQuesLikeByRidAndUid(int rid, int uid);

}
