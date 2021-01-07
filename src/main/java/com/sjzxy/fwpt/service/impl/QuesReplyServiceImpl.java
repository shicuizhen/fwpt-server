package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.QuesReply;
import com.sjzxy.fwpt.repository.QuesReplyRepository;
import com.sjzxy.fwpt.service.QuesReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class QuesReplyServiceImpl implements QuesReplyService{

    @Autowired
    private QuesReplyRepository quesReplyRepository;

    @Override
    public QuesReply addQuesReply(QuesReply quesReply) {
        return quesReplyRepository.save(quesReply);
    }

    @Override
    public void delQuesReply(int id) {
        quesReplyRepository.deleteById((long) id);
    }

    @Override
    public QuesReply updateQuesReply(QuesReply quesReply){
        return quesReplyRepository.save(quesReply);
    }

    @Override
    public List<QuesReply> findAllQuesReply() {
        return quesReplyRepository.findAll();
    }

}
