package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.entity.QuesSort;
import com.sjzxy.fwpt.repository.QuesSortRepository;
import com.sjzxy.fwpt.service.QuesSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class QuesSortServiceImpl implements QuesSortService{

    @Autowired
    private QuesSortRepository quesSortRepository;

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
        return quesSortRepository.findAll();
    }

}
