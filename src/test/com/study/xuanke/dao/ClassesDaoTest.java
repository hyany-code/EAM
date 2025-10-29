package com.study.xuanke.dao;

import com.study.xuanke.model.Classes;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClassesDaoTest extends BaseTest{


    @Autowired
    private  ClassesDao classesDao;
    @Test
    public void findAll() {
        List<Classes> list = classesDao.findAll();
        for (Classes classes : list) {
            System.out.println("classes:" + classes);

        }
    }

    @Test
    public void findByKey() {
        List<Classes> list = classesDao.findByKey("软件工程本");
        for (Classes classes : list) {
            System.out.println("classes = " + classes);
        }

    }

    @Test
    public void addClasses() {
        Classes classes=new Classes();
        classes.setClassName("new");
        classes.setMajorId(1);
        classes.setAdminName("lisi");
        int result = classesDao.addClasses(classes);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void getById() {
        Classes classes = classesDao.getById(1001);
        Assert.assertNotNull(classes);
        System.out.println("classes=" + classes);
    }

    @Test
    public void updateClasses() {
        Classes classes=new Classes();
        classes.setClassName("软件工程本");
        classes.setMajorId(3);
        classes.setAdminName("jack");
        classes.setClassId(1001);
        int result = classesDao.updateClasses(classes);
        Assert.assertTrue(result > 0);
        System.out.println("classes" + classes);
    }

    @Test
    public void deleteClasses() {
        int result = classesDao.deleteClasses(1003);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void batchDeletes() {
        List<String> list = new ArrayList<String>();
        list.add("1003");
        classesDao.batchDeletes(list);
    }
}