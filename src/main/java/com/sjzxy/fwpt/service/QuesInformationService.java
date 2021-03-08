package com.sjzxy.fwpt.service;

import com.sjzxy.fwpt.entity.QuesInformation;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface QuesInformationService {

    /**
     * 添加数据
     * @param quesInformation
     * @return
     */
    QuesInformation addQuesInformation(QuesInformation quesInformation);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void delQuesInformation(int id);

    /**
     * 更新数据
     * @param quesInformation
     * @return
     */
    QuesInformation updateQuesInformation(QuesInformation quesInformation);


    /**
     * 查询全部数据
     * @return
     */
    List findAllQuesInformation();


    /**
     * 根据qid查询问题信息
     * @param qid
     * @return
     */
    Map findQuesInformationByQid(Integer qid);


    /**
     * 根据qid查询全部回答信息
     * @param qid
     * @return
     */
    List findAllReplyByQid(Integer qid);



    /**
     * 查询热门问题的id和内容
     * @return
     */
    List findHotQuesInformation();


    /**
     * 根据分类id查询全部问题信息
     * @param sid
     * @return
     */
    List findQuesInformationBySid(Integer sid);


    Page findQuesInformationByKey(String key, Boolean needPagination) ;

    /**
     * 根据问题是否解决查找问题信息
     * @param finish
     * @return
     */
    List<QuesInformation> findQuesByFinish(int finish);

    List<QuesInformation> findQuesByFinishAndSort(int finish, Integer sid);


    List<QuesInformation> findQuesByFinishAndSortAndKey(Integer finish, Integer sid, String key);

    List<QuesInformation> findQuesInformationByUid(Integer uid);

    Map getQuesNum();
}
