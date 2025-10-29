package com.study.xuanke.service.impl;

import com.study.xuanke.dao.ClassesDao;
import com.study.xuanke.model.Classes;
import com.study.xuanke.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClassesServiceImpl implements ClassesService{
    @Autowired
    private  ClassesDao classesDao;
    @Override
    public List<Classes> findAll() {
        return classesDao.findAll();
    }

    @Override
    public List<Classes> findByKey(String key) {
        return classesDao.findByKey(key);
    }

    @Override
    public boolean addClasses(Classes classes) {
        return classesDao.addClasses(classes)>0?true:false;
    }

    @Override
    public Classes getById(int classId) {
        return classesDao.getById(classId);
    }

    @Override
    public boolean updateClasses(Classes classes) {
        return classesDao.updateClasses(classes)>0?true:false;
    }

    @Override
    public boolean deleteClasses(int classId) {
        return classesDao.deleteClasses(classId)>0?true:false;
    }

    @Override
    public void batchDeletes(List delList) {
        classesDao.batchDeletes(delList);
    }
}
