package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.QuesLike;
import com.sjzxy.fwpt.entity.QuesReply;
import com.sjzxy.fwpt.entity.Users;
import com.sjzxy.fwpt.repository.QuesLikeRepository;
import com.sjzxy.fwpt.repository.QuesReplyRepository;
import com.sjzxy.fwpt.repository.UsersRepository;
import com.sjzxy.fwpt.service.QuesReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class QuesReplyServiceImpl implements QuesReplyService{

    @Autowired
    private QuesReplyRepository quesReplyRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private QuesLikeRepository quesLikeRepository;

    @Override
    public QuesReply addQuesReply(QuesReply quesReply) {
        quesReply.setCreateTime(new Date());
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
        return getQuesReplyData(quesReplyRepository.findAll());
    }


    @Autowired
    QuesInformationServiceImpl quesInformationService;

    @Override
    public List<QuesReply> findQuesReplyByQid(int qid) {
        List<QuesReply> lists = quesReplyRepository.findAllByQid(qid);
        return getQuesReplyData(lists);
    }


    /**
     * 获得统一QuesReply的返回数据
     * @param lists
     * @return
     */
    List getQuesReplyData(List<QuesReply> lists){

        ArrayList list = new ArrayList();
        for (int i = 0;i<lists.size();i++){
            Map<String,Object> map = new HashMap();
            map.put("id",lists.get(i).getId());

            //创建者
            Users user = usersRepository.findAllById(lists.get(i).getCreateBy());
            map.put("createBy",user==null||user.equals(null) ? null : user.getName());
            map.put("photo",user==null||user.equals(null) ? null : user.getPhotoAddress());

            map.put("createTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lists.get(i).getCreateTime()));
            map.put("content",lists.get(i).getContent());

            map.put("qid", lists.get(i).getQid());
            if (lists.get(i).getQid()==null){
                System.out.println("qid为空");
                map.put("content","===================这条数据不对，qid为空=====================");
                map.put("likeNum",100001);
                return list;
            }

            //点赞数
            //根据回答id即rid去like表中查询点赞的数量
            List<QuesLike> replyLikes = quesLikeRepository.findAllByRid(lists.get(i).getId());
            map.put("likeNum",replyLikes.size());

            list.add(map);
        }
        return list;
    }

}
