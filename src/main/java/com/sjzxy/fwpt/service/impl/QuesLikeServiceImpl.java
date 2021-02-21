package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.QuesLike;
import com.sjzxy.fwpt.mapper.QuesLikeMapper;
import com.sjzxy.fwpt.repository.QuesLikeRepository;
import com.sjzxy.fwpt.service.QuesLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class QuesLikeServiceImpl implements QuesLikeService{

    @Autowired
    private QuesLikeRepository quesLikeRepository;

    @Override
    public QuesLike addQuesLike(QuesLike quesLike) {
        quesLike.setCreateTime(new Date());
        return quesLikeRepository.save(quesLike);
    }

    @Override
    public void delQuesLike(int id) {
        quesLikeRepository.deleteById(id);
    }

    @Override
    public QuesLike updateQuesLike(QuesLike quesLike){
        return quesLikeRepository.save(quesLike);
    }

    @Override
    public List<QuesLike> findAllQuesLike() {
        return quesLikeRepository.findAll();
    }

    @Override
    public Boolean isQuesLike(Integer qid, Integer uid) {
        if (quesLikeRepository.findAllByQidAndUid(qid,uid).isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Boolean isReplyLike(Integer rid, Integer uid) {
        if (quesLikeRepository.findAllByRidAndUid(rid,uid).isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    //前端中，回答点赞数组信息初始化，根据用户uid查询对应的回答点赞信息
    @Override
    public ArrayList getReplyLikeIdsByUid(int uid) {
        ArrayList list = new ArrayList();
        List<QuesLike> likes = quesLikeRepository.findAllByUid(uid);
        for (int i = 0;i<likes.size();i++){
            if (likes.get(i).getRid() != 0){
                list.add(likes.get(i).getRid());
            }
        }
        return list;
    }



    //取消点赞，根据rid和uid删除数据
    @Override
    public void delQuesLikeByRidAddUid(Integer rid, Integer uid) {
        List<QuesLike> likes = quesLikeRepository.deleteQuesLikeByRidAndUid(rid, uid);
        System.out.println("like:" + likes);
    }

}
