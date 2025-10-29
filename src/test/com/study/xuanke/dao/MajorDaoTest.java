package com.study.xuanke.dao;

import com.study.xuanke.model.Major;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MajorDaoTest extends BaseTest {

    @Autowired
    private MajorDao majorDao;
    @Test
    public void findAll() {
        List<Major> list = majorDao.findAll();
        for (Major major : list) {
            System.out.println("major:" + major);

        }
    }

    @Test
    public void findByKey() {
        List<Major> list = majorDao.findByKey("软件工程");
        for (Major major : list) {
            System.out.println("major = " + major);
        }
    }

    @Test
    public void addMajor() {
        Major major = new Major();
        major.setMajorName("new");
        major.setDepartmentId(1);
        major.setAdminName("lisi");
        int result = majorDao.addMajor(major);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void getById() {
        Major major = majorDao.getById(1);
        Assert.assertNotNull(major);
        System.out.println("major=" + major);
    }

    @Test
    public void updateMajor() {
        Major major = new Major();
        major.setMajorId(2);
        major.setMajorName("自然系");
        major.setDepartmentId(7);
        major.setAdminName("jackkk");
        int result = majorDao.updateMajor(major);
        Assert.assertTrue(result > 0);
        System.out.println("major" + major);
    }

    @Test
    public void deleteMajor() {
        int result = majorDao.deleteMajor(6);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void batchDeletes() {
        List<String> list = new ArrayList<String>();
        list.add("2");
        majorDao.batchDeletes(list);

    }
}