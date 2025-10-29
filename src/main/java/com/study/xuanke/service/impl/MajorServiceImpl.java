package com.study.xuanke.service.impl;

import com.study.xuanke.dao.MajorDao;
import com.study.xuanke.model.Major;
import com.study.xuanke.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorDao majorDao;


    @Override
    public List<Major> findAll() {
        return majorDao.findAll();
    }

    @Override
    public List<Major> findByKey(String key) {
        return majorDao.findByKey(key);
    }

    @Override
    public boolean addMajor(Major major) {
        return majorDao.addMajor(major)>0?true:false;
    }

    @Override
    public Major getById(int majorId) {
        return majorDao.getById(majorId);
    }

    @Override
    public boolean updateMajor(Major major) {
        return majorDao.updateMajor(major)>0?true:false;
    }

    @Override
    public boolean deleteMajor(int majorId) {
        return majorDao.deleteMajor(majorId)>0?true:false;
    }

    @Override
    public void batchDeletes(List delList) {

    }
}
