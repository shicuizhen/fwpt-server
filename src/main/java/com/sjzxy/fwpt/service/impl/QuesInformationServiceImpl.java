package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.config.annotation.MyAnnontation;
import com.sjzxy.fwpt.config.annotation.ResponseInfo;
import com.sjzxy.fwpt.entity.*;
import com.sjzxy.fwpt.repository.*;
import com.sjzxy.fwpt.service.QuesInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
@Transactional
public class QuesInformationServiceImpl implements QuesInformationService{

    @Autowired
    private QuesInformationRepository quesInformationRepository;

    @Autowired
    private QuesReplyRepository quesReplyRepository;

    @Autowired
    private QuesCommentRepository quesCommentRepository;

    @Autowired
    private QuesLikeRepository quesLikeRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private QuesSortRepository quesSortRepository;

    @Override
    public QuesInformation addQuesInformation(QuesInformation quesInformation) {
        quesInformation.setIsFinish(0);
        quesInformation.setCreateTime(new Date());
        return quesInformationRepository.save(quesInformation);
    }

    @Override
    public void delQuesInformation(int id) {
        quesInformationRepository.deleteById(id);
    }

    @Override
    public QuesInformation updateQuesInformation(QuesInformation quesInformation){
        return quesInformationRepository.save(quesInformation);
    }


    @MyAnnontation(WayCode = "a",WayName = "测试类1")
    public ResponseInfo gateWayOne(Map<String, Object> map) {
        System.out.printf("gateWayOne printf" + map.get("Key1"));
        ResponseInfo res = new ResponseInfo();
        res.setTestId("000000");
        res.setTestName("U get Class gateWayOne");
        return res;
    }



    @Override
    public List findAllQuesInformation() {

        List<QuesInformation> lists = quesInformationRepository.findAll();
        return getQuesInformationData(lists);
    }

    /**
     * 根据问题id获取全部回答
     * 评论数，回答id，创建者id（不需要），创建时间，具体内容，点赞数，回答的用户名，用户头像
     * @param qid
     * @return
     */
    @Override
    public List findAllReplyByQid(Integer qid) {
        List<QuesReply> lists = quesReplyRepository.findAllByQid(qid);
        return getQuesReplyData(lists);
    }

    /**
     * 根据问题是否被解决获取全部问题信息
     * @param state
     * @return
     */
    @Override
    public List findAllQuesInfoByFinish(int state) {

        List<QuesInformation> lists = quesInformationRepository.findAllByIsFinish(state);
        return getQuesInformationData(lists);
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

            //回答的评论数
            //根据回答id即rid去commoent表中查询评论的数量
            List<QuesComment> quesComments = quesCommentRepository.findAllByRid(lists.get(i).getId());
            map.put("commentNum",quesComments.size());

            //创建者
            Users user = usersRepository.findAllById(lists.get(i).getCreateBy());
            map.put("createBy",user.getName());
            map.put("photo",user.getPhotoAddress());

            map.put("createTime",lists.get(i).getCreateTime());
            map.put("content",lists.get(i).getContent());

            //点赞数
            //根据问题id即qid去like表中查询点赞的数量
            List<QuesLike> replyLikes = quesLikeRepository.findAllByRid(lists.get(i).getId());
            map.put("likeNum",replyLikes.size());
            list.add(map);
        }
        return list;
    }

    /**
     * 获得统一QuesInformation的返回数据
     * @param lists
     * @return
     */
    List getQuesInformationData(List<QuesInformation> lists){

        ArrayList list = new ArrayList();
        //每一组数据都放到map中，每一个map都放到list中
        for (int i = 0;i<lists.size();i++){
            Map<String,Object> map = new HashMap();
            //遍历每一个lists，将数据取出放入到新的map中
            //问题id，分类id，创建者id（不需要），创建时间，问题标题，具体内容，回答数，点赞数，用户名，用户头像
            map.put("id",lists.get(i).getId());
            map.put("sortName",quesSortRepository.getQuesSortById(lists.get(i).getSortId()).getName());
//            map.put("sortId",lists.get(i).getSortId());
            map.put("createTime",lists.get(i).getCreateTime());
            map.put("title",lists.get(i).getTitle());
            map.put("content",lists.get(i).getContent());
            map.put("is_finish",lists.get(i).getIsFinish());
            //回答数
            //根据问题id即qid去reply表中查询回答的数量
            List<QuesReply> quesReplys = quesReplyRepository.findAllByQid(lists.get(i).getId());
            map.put("replyNum",quesReplys.size());

            //点赞数
            //根据问题id即qid去like表中查询点赞的数量
            List<QuesLike> quesLikes = quesLikeRepository.findAllByQid(lists.get(i).getId());
            map.put("likeNum",quesLikes.size());

            //用户名和用户头像
            //根据创建者id即createBy，去user用户表查询用户名和头像
            Users user = usersRepository.findAllById(lists.get(i).getCreateBy());
            map.put("createBy",user.getName());
            map.put("photo",user.getPhotoAddress());

            //将封装好的一组list数据存放到map中
            list.add(map);
        }
        return list;
    }

}
