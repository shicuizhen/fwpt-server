package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.QuesLike;
import com.sjzxy.fwpt.repository.QuesLikeRepository;
import com.sjzxy.fwpt.service.QuesLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class QuesLikeServiceImpl implements QuesLikeService{

    @Autowired
    private QuesLikeRepository quesLikeRepository;

    @Override
    public QuesLike addQuesLike(QuesLike quesLike) {
        return quesLikeRepository.save(quesLike);
    }

    @Override
    public void delQuesLike(int id) {
        quesLikeRepository.deleteById((long) id);
    }

    @Override
    public QuesLike updateQuesLike(QuesLike quesLike){
        return quesLikeRepository.save(quesLike);
    }

    @Override
    public List<QuesLike> findAllQuesLike() {
        return quesLikeRepository.findAll();
    }

}
