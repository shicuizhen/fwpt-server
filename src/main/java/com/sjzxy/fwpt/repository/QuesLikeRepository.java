package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.QuesLike;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

@Repository
public interface QuesLikeRepository extends JpaRepository<QuesLike, Long> {

    List<QuesLike> findAllByQid(Integer qid);

    List<QuesLike> findAllByRid(Integer rid);

    List<QuesLike> findAllByCid(Integer id);

    void deleteById(Integer id);

    List<QuesLike> findAllByQidAndUid(Integer qid, Integer uid);

    List<QuesLike> findAllByRidAndUid(Integer rid, Integer uid);

    List<QuesLike> findAllByCidAndUid(Integer cid, Integer uid);
}
