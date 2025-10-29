package com.study.xuanke.service;

import com.study.xuanke.model.Classes;

import java.util.List;

public interface ClassesService {
    List<Classes> findAll();

    List<Classes> findByKey(String key);

    boolean addClasses(Classes classes);

    Classes getById(int classId);

    boolean updateClasses(Classes classes);

    // 逻辑删除
    boolean deleteClasses(int classesId);

    //真实删除一大堆
    void batchDeletes(List delList);
}
