package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.QuesComment;
import com.sjzxy.fwpt.repository.QuesCommentRepository;
import com.sjzxy.fwpt.service.QuesCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class QuesCommentServiceImpl implements QuesCommentService{

    @Autowired
    private QuesCommentRepository quesCommentRepository;

    @Override
    public QuesComment addQuesComment(QuesComment quesComment) {
        return quesCommentRepository.save(quesComment);
    }

    @Override
    public void delQuesComment(int id) {
        quesCommentRepository.deleteById((long) id);
    }

    @Override
    public QuesComment updateQuesComment(QuesComment quesComment){
        return quesCommentRepository.save(quesComment);
    }

    @Override
    public List<QuesComment> findAllQuesComment() {
        return quesCommentRepository.findAll();
    }

}
