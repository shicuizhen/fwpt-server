package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.LostInformation;
import com.sjzxy.fwpt.entity.LostSearch;
import com.sjzxy.fwpt.repository.LostInformationRepository;
import com.sjzxy.fwpt.repository.LostKindRepository;
import com.sjzxy.fwpt.repository.LostPlaceRepository;
import com.sjzxy.fwpt.repository.UsersRepository;
import com.sjzxy.fwpt.service.LostInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class LostInformationServiceImpl implements LostInformationService{

    @Autowired
    private LostInformationRepository lostInformationRepository;


    @Override
    public LostInformation addLostInformation(LostInformation lostInformation) {

        lostInformation.setCreateTime(new Date());
        return lostInformationRepository.save(lostInformation);
    }



    @Override
    public void delLostInformation(int id) {
        lostInformationRepository.deleteById((long) id);
    }

    @Override
    public LostInformation updateLostInformation(LostInformation lostInformation){
        return lostInformationRepository.save(lostInformation);
    }

    @Override
    public List<LostInformation> findAllLostInformation() throws ParseException {
        List<LostInformation> lostInformations = lostInformationRepository.findAll();
        return getLostInformationData(lostInformations);
    }

    @Autowired
    LostKindRepository lostKindRepository;

    @Autowired
    LostPlaceRepository lostPlaceRepository;

    @Autowired
    UsersRepository usersRepository;

    public List<LostInformation> getLostInformationData(List<LostInformation> lists) throws ParseException {

        ArrayList list = new ArrayList();
        //每一组数据都放到map中，每一个map都放到list中
        for (int i = 0;i<lists.size();i++){
            Map<String,Object> map = new HashMap();
            //遍历每一个lists，将数据取出放入到新的map中
            //问题id，分类id，创建者id（不需要），创建时间，问题标题，具体内容，回答数，点赞数，用户名，用户头像
            map.put("id",lists.get(i).getId());
            map.put("name", lists.get(i).getName());
            map.put("typeId",lists.get(i).getType());
            map.put("type1",lists.get(i).getType() == 0 ? "丢失了" : "捡到了");
            map.put("type2",lists.get(i).getType() == 0 ? "寻物启事" : "招领启事");

            map.put("kindId",lostKindRepository.findAllById(lists.get(i).getKindId()).getName());
            map.put("description",lists.get(i).getDescription());
            map.put("username",lists.get(i).getUsername());
            map.put("placeId",lostPlaceRepository.findAllById(lists.get(i).getPlaceId()).getName());
            map.put("position",lists.get(i).getPosition());
            map.put("lostTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lists.get(i).getLostTime()));
            map.put("telephone",lists.get(i).getTelephone());
            map.put("email",lists.get(i).getEmail());
            map.put("createBy",usersRepository.findAllById(lists.get(i).getCreateBy()).getName());
            map.put("createTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lists.get(i).getCreateTime()));
            map.put("stateId",lists.get(i).getStateId());

            //将封装好的一组list数据存放到map中
            list.add(map);
        }
        return list;
    }

    @Override
    public List<String> findLunboData() {
        List<String> lunbo = new ArrayList<>();
        List<LostInformation> list = lostInformationRepository.findFiveByCreateTime();
        for (int i =0; i < list.size();i++){
            LostInformation data = list.get(i);
            String username = ((data.getUsername() == null)||data.getUsername().equals("")) ? "某用户" : data.getUsername();
            String type =  data.getType() == 0 ? "丢失了 " : "捡到了";
            String str = username + type + data.getName();
            lunbo.add(str);
        }
        return lunbo;
    }



    public Page getSearch(LostSearch lostSearch, Boolean needPagination) {

//        System.out.println("impl:type:" + lostSearch.getType());
//        System.out.println("impl:kind_id:" + lostSearch.getKind_id());

        Specification<LostInformation> specification = (Specification<LostInformation>) (root, criteriaQuery, criteriaBuilder) -> {

            List<Predicate> list = new ArrayList<>();

            if (lostSearch.getType() != null && lostSearch.getType() >= 0) {
                System.out.println("type:" + lostSearch.getType() );
                list.add(criteriaBuilder.equal(root.get("type").as(Integer.class), lostSearch.getType() ));
            }

            if (lostSearch.getKind_id() != null && lostSearch.getKind_id() > 0) {
                System.out.println("kind_id:" + lostSearch.getKind_id());
                list.add(criteriaBuilder.equal(root.get("kindId").as(Integer.class), lostSearch.getKind_id()));
            }

            if (lostSearch.getPlace_id() != null && lostSearch.getPlace_id() > 0) {
                System.out.println("placeId:" + lostSearch.getPlace_id());
                list.add(criteriaBuilder.equal(root.get("placeId").as(Integer.class), lostSearch.getPlace_id()));
            }

            System.out.println("时间：" + lostSearch.getLost_time1());
            if (lostSearch.getLost_time1() != null && !lostSearch.getLost_time1().equals("")) {
                list.add(criteriaBuilder.greaterThanOrEqualTo(root.get("lostTime"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lostSearch.getLost_time1())));
            }
            if (lostSearch.getLost_time2() != null && !lostSearch.getLost_time2().equals("")) {
                list.add(criteriaBuilder.lessThanOrEqualTo(root.get("lostTime"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lostSearch.getLost_time2())));
            }

//                cb.and    “and”表示这几个条件并且的关系   Predicate and(Predicate... var1);
//            return cb.and(list.toArray(p));

            // 组装and查询语句
            Predicate predicateAnd = criteriaBuilder.and(list.toArray(new Predicate[0]));
            System.out.println("predicateAnd:" + predicateAnd.toString());
            return criteriaQuery.where(predicateAnd).getRestriction();

//            return list.size() == 0 ?
//                    criteriaQuery.where(predicateAnd).getRestriction() :
//                    criteriaQuery.where(predicateAnd, predicateOr).getRestriction();
        };
//        if (needPagination) {
//            Pageable pageable = PageRequest.of(lostSearch.getPageNo(), lostSearch.getPageSize());
//            return lostInformationRepository.findAll(specification, pageable);
//        }
        // 查询结果不分页
        return new PageImpl(lostInformationRepository.findAll(specification));
    }

}
