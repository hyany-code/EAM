package com.study.xuanke.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class AdminDaoTest {
    @Autowired
    AdminDao adminDao;

    @Test
    public void getAdmin() {
    }

    @Test
    public void updatePassword() {
        int i = adminDao.updatePassword(1,"333333");
        System.out.println(i);
    }
}