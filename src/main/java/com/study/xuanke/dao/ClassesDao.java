package com.study.xuanke.dao;


import com.study.xuanke.model.Classes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesDao {
    List<Classes> findAll();

    List<Classes> findByKey(String key);

    int addClasses(Classes classes);

    Classes getById(int classId);

    int updateClasses(Classes classes);

    // 逻辑删除
    int deleteClasses(int classesId);

    //真实删除一大堆
    void batchDeletes(List delList);
}
