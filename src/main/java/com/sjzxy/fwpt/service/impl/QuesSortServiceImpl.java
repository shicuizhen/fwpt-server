package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.*;
import com.sjzxy.fwpt.repository.QuesCommentRepository;
import com.sjzxy.fwpt.repository.QuesInformationRepository;
import com.sjzxy.fwpt.repository.QuesReplyRepository;
import com.sjzxy.fwpt.repository.QuesSortRepository;
import com.sjzxy.fwpt.service.QuesSortService;
import com.sun.xml.internal.fastinfoset.util.CharArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class QuesSortServiceImpl implements QuesSortService{

    @Autowired
    private QuesSortRepository quesSortRepository;

    @Autowired
    private QuesInformationRepository quesInformationRepository;

    @Autowired
    private QuesReplyRepository quesReplyRepository;

    @Autowired
    private QuesCommentRepository quesCommentRepository;

    @Override
    public QuesSort addQuesSort(QuesSort quesSort) {
        quesSort.setCreateTime(new Date());
        return quesSortRepository.save(quesSort);
    }

    @Override
    public void delQuesSort(int id) {
        quesSortRepository.deleteById((long) id);
    }

    @Override
    public QuesSort updateQuesSort(QuesSort quesSort){
        return quesSortRepository.save(quesSort);
    }

    @Override
    public List<QuesSort> findAllQuesSort() {
        List<QuesSort> quesSorts =  quesSortRepository.findAll();


        ArrayList list = new ArrayList();
        //类别id，父id，类别名，内容描述，创建时间，讨论次数，问题数
        //问题数：该类别下有多少问题
        for (int i = 0;i<quesSorts.size();i++){
            Map<String,Object> map = new HashMap();
            map.put("id",quesSorts.get(i).getId());
            map.put("pid",quesSorts.get(i).getPid());
            map.put("name",quesSorts.get(i).getName());
            map.put("depression",quesSorts.get(i).getDepression());
            map.put("createTime",quesSorts.get(i).getCreateTime());
            //获取当前分类id下的所有问题信息
            List<QuesInformation> quesInformations =  quesInformationRepository.findAllBySortId(quesSorts.get(i).getId());
            map.put("QuesNum",quesInformations.size());
            //讨论次数：该类别下有多少回答和评论
            int num = 0;
            for (int j = 0;j<quesInformations.size();j++){
                List<QuesReply> quesReplys = quesReplyRepository.findAllByQid(quesInformations.get(j).getId());
                num += quesReplys.size();
            }
            map.put("replyNum",num);
            list.add(map);
        }

        return list;
    }

}
