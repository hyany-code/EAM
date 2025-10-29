package com.study.xuanke.dao;

import com.study.xuanke.model.Major;
import com.study.xuanke.model.Major;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorDao {
    List<Major> findAll();

    List<Major> findByKey(String key);

    int addMajor(Major major);

    Major getById(int majorId);

    int updateMajor(Major major);

    // 逻辑删除
    int deleteMajor(int majorId);

    //真实删除一大堆
    void batchDeletes(List delList);
}
