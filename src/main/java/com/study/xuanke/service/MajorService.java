package com.study.xuanke.service;

import com.study.xuanke.model.Major;
import com.study.xuanke.model.Major;

import java.util.List;

public interface MajorService {
    List<Major> findAll();

    List<Major> findByKey(String key);

    boolean addMajor(Major major);

    Major getById(int majorId);

    boolean updateMajor(Major major);

    // 逻辑删除
    boolean deleteMajor(int majorId);

    //真实删除一大堆
    void batchDeletes(List delList);
}
