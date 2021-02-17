package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.QuesComment;
import com.sjzxy.fwpt.entity.QuesLike;
import com.sjzxy.fwpt.entity.QuesReply;
import com.sjzxy.fwpt.entity.Users;
import com.sjzxy.fwpt.repository.QuesCommentRepository;
import com.sjzxy.fwpt.repository.QuesLikeRepository;
import com.sjzxy.fwpt.repository.QuesReplyRepository;
import com.sjzxy.fwpt.repository.UsersRepository;
import com.sjzxy.fwpt.service.QuesReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class QuesReplyServiceImpl implements QuesReplyService{

    @Autowired
    private QuesReplyRepository quesReplyRepository;

    @Autowired
    private QuesCommentRepository quesCommentRepository;

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
        return quesReplyRepository.findAll();
    }



    /**
     * 根据回答id获取评论
     * 评论id，创建者id（不需要），安特的用户id，at的用户名，创建时间，具体内容，点赞数，用户名，用户头像
     * @param rid
     * @return
     */
    @Override
    public List<QuesComment> findAllCommentByRid(Integer rid) {

        List<QuesComment> lists = quesCommentRepository.findAllByRid(rid);

        ArrayList list = new ArrayList();
        for (int i = 0;i<lists.size();i++){
            Map<String,Object> map = new HashMap();
            map.put("id",lists.get(i).getId());

            //创建者
            Users user = usersRepository.findAllById(lists.get(i).getCreateBy());
            if (user != null){
                map.put("createBy",user.getName());
                map.put("photo",user.getPhotoAddress());
            }


            map.put("createTime",lists.get(i).getCreateTime());
            map.put("content",lists.get(i).getContent());
            map.put("atId",lists.get(i).getAt());

            //at的用户昵称
            Users atUser = usersRepository.findAllById(lists.get(i).getAt());
            map.put("atUsername",atUser.getNick());

            //点赞数
            //根据问题id即qid去like表中查询点赞的数量
            List<QuesLike> commentLikes = quesLikeRepository.findAllByCid(lists.get(i).getId());
            map.put("likeNum",commentLikes.size());
            list.add(map);
        }
        return list;
    }

    @Autowired
    QuesInformationServiceImpl quesInformationService;

    @Override
    public List<QuesReply> findQuesReplyByQid(int qid) {
        List<QuesReply> lists = quesReplyRepository.findAllByQid(qid);
        return quesInformationService.getQuesReplyData(lists);
    }

}
