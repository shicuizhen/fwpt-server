package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.dao.QuesInformationMapper;
import com.sjzxy.fwpt.dao.QuesReplyMapper;
import com.sjzxy.fwpt.entity.*;
import com.sjzxy.fwpt.repository.*;
import com.sjzxy.fwpt.service.QuesInformationService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class QuesInformationServiceImpl implements QuesInformationService{

    @Autowired
    private QuesInformationRepository quesInformationRepository;

    @Autowired
    private QuesReplyRepository quesReplyRepository;

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
    public void delQuesInformation(int qid) {
        quesInformationRepository.deleteById(qid);
        quesReplyRepository.deleteByQid(qid);
    }

    @Override
    public QuesInformation updateQuesInformation(QuesInformation quesInformation){
        return quesInformationRepository.save(quesInformation);
    }

    @Override
    public List findAllQuesInformation() {
        List<QuesInformation> lists = quesInformationRepository.findAll();
        return getQuesInformationData(lists);
    }

    @Override
    public Map findQuesInformationByQid(Integer qid) {
        List<QuesInformation> list = new ArrayList<>();
        list.add(quesInformationRepository.findAllById(qid));
        return (Map) getQuesInformationData(list).get(0);
    }

    @Override
    public List<QuesInformation> findQuesInformationByUid(Integer uid) {
        return getQuesInformationData(quesInformationRepository.findAllByCreateBy(uid));
    }

    @Autowired
    QuesInformationMapper quesInformationMapper;

    @Autowired
    QuesReplyMapper quesReplyMapper;

//    查询问题总数，回答总数，本月问题总数，本月回答总数
    @Override
    public Map getQuesNum() {
        Map map = new HashMap();
        Date now = new Date();
        Date startDate = DateUtils.addDays(now, -30);
        map.put("quesNum", quesInformationRepository.findAll().size());
        map.put("replyNum", quesReplyRepository.findAll().size());
        map.put("currentQuesNum", quesInformationMapper.findNumByTime(now,startDate));
        map.put("currentReplyNum", quesReplyMapper.findNumByTime(now,startDate));
        return map;
    }


    @Autowired
    QuesReplyServiceImpl quesReplyService;

    /**
     * 根据问题id获取全部回答
     * 评论数，回答id，创建者id（不需要），创建时间，具体内容，点赞数，回答的用户名，用户头像
     * @param qid
     * @return
     */
    @Override
    public List findAllReplyByQid(Integer qid) {
        List<QuesReply> lists = quesReplyRepository.findAllByQid(qid);
        return quesReplyService.getQuesReplyData(lists);
    }


    @Override
    public List<QuesInformation> findQuesInformationBySid(Integer sid) {
        return getQuesInformationData(quesInformationRepository.findAllBySortId(sid));
    }

    /**
     * 根据关键字查找问题
     * @param key
     * @param needPagination
     * @return
     */
    @Override
    public Page findQuesInformationByKey(String key, Boolean needPagination) {

        Specification<QuesInformation> specification = (Specification<QuesInformation>) (root, criteriaQuery, criteriaBuilder) -> {

            List<Predicate> listOr = new ArrayList<>();

            if (key != null) {
                System.out.println("Search_key:" + key);
                listOr.add(criteriaBuilder.like(root.get("content"),"%" + key + "%"));
                listOr.add(criteriaBuilder.like(root.get("title"),"%" + key+ "%"));
            }

            Predicate predicateOr = criteriaBuilder.or(listOr.toArray(new Predicate[0]));

            return criteriaQuery.where(predicateOr).getRestriction();
        };
        // 查询结果不分页
        List<QuesInformation> lists = quesInformationRepository.findAll(specification);
        System.out.println("关键字key-lists:" + lists);
        List<QuesInformation> result = getQuesInformationData(lists);
        return new PageImpl(result);
    }

    /**
     * 根据问题是否被解决获取全部问题信息
     * @param finish
     * @return
     */
    @Override
    public List<QuesInformation> findQuesByFinish(int finish) {
        // 0 未解决
        return getQuesInformationData(quesInformationRepository.findAllByIsFinish(finish));
    }

    /**
     * 根据分类查询已解决或未解决的问题
     * @param finish
     * @param sid
     * @return
     */
    @Override
    public List<QuesInformation> findQuesByFinishAndSort(int finish, Integer sid) {
        return getQuesInformationData(quesInformationRepository.findAllByIsFinishAndSortId(finish,sid));
    }



    /**
     * 获取前5位热门问题信息
     * @return
     */
    @Override
    public List findHotQuesInformation() {
        List list = new LinkedList();
        List<List<Integer>> lists = quesReplyRepository.findHotQuestion();

        for (int i = 0;i<lists.size();i++){
            QuesInformation quesInformation = quesInformationRepository.findAllById(lists.get(i).get(0));
            if (quesInformation == null){
                break;
            }
            Map map = new HashMap();
            map.put("id", lists.get(i).get(0));
            map.put("title",quesInformation.getTitle());
            map.put("content",quesInformation.getContent());
            map.put("num",lists.get(i).get(1));
            list.add(map);
        }
        return list;
    }


    @Override
    public List<QuesInformation> findQuesByFinishAndSortAndKey(Integer finish, Integer sid, String key) {

        Specification<QuesInformation> specification = (Specification<QuesInformation>) (root, criteriaQuery, criteriaBuilder) -> {

            List<Predicate> listAnd = new ArrayList<>();
            List<Predicate> listOr = new ArrayList<>();

            if (key != null) {
                listOr.add(criteriaBuilder.like(root.get("content"),"%" + key + "%"));
                listOr.add(criteriaBuilder.like(root.get("title"),"%" + key + "%"));
            }

            if (finish != null && finish>0) {
                listAnd.add(criteriaBuilder.equal(root.get("isFinish").as(Integer.class),finish));
            }

            if (sid != null && sid>0) {
                listAnd.add(criteriaBuilder.equal(root.get("sortId").as(Integer.class),sid));
            }

            Predicate predicateAnd = criteriaBuilder.and(listAnd.toArray(new Predicate[0]));
            Predicate predicateOr = criteriaBuilder.or(listOr.toArray(new Predicate[0]));

//            return criteriaQuery.where(predicateAnd, predicateOr).getRestriction();
            return listAnd.size() == 0 ?
                    criteriaQuery.where(predicateOr).getRestriction() :
                    criteriaQuery.where(predicateOr, predicateAnd).getRestriction();
        };
        List<QuesInformation> lists = quesInformationRepository.findAll(specification);
        return getQuesInformationData(lists);
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
            map.put("sortName", quesSortRepository.getQuesSortById(lists.get(i).getSortId()).getName());
//            map.put("sortId",lists.get(i).getSortId());
            map.put("createTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lists.get(i).getCreateTime()));
            map.put("title",lists.get(i).getTitle());
            map.put("content",lists.get(i).getContent());
            map.put("is_finish",lists.get(i).getIsFinish());
            map.put("is_finish2",lists.get(i).getIsFinish() == 1 ? "已解决" : "未解决");
            //回答数
            //根据问题id即qid去reply表中查询回答的数量
            List<QuesReply> quesReplys = quesReplyRepository.findAllByQid(lists.get(i).getId());
            map.put("replyNum",quesReplys.size());

            //点赞数
            //根据问题id即qid去like表中查询点赞的数量
//            List<QuesLike> quesLikes = quesLikeRepository.findAllByQid(lists.get(i).getId());
//            map.put("likeNum",quesLikes.size());

            //用户名和用户头像
            //根据创建者id即createBy，去user用户表查询用户名和头像
            Users user = usersRepository.findAllById(lists.get(i).getCreateBy());
            map.put("createBy",user==null||user.equals(null) ? null : user.getName());
            map.put("photo",user==null||user.equals(null) ? null : user.getPhotoAddress());
            //将封装好的一组list数据存放到map中
            list.add(map);
        }
        return list;
    }

}
