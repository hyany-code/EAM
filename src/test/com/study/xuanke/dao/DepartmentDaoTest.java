package com.study.xuanke.dao;

import com.study.xuanke.model.Department;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DepartmentDaoTest extends BaseTest{

    @Autowired
    private DepartmentDao  departmentDao;
    @Test
    public void findAll() {
        List<Department> list=departmentDao.findAll();
        for(Department department :list){
            System.out.println("department:" +department);

        }
    }
    @Test
    public void findByKey() {
        List<Department> list = departmentDao.findByKey("信息");
        for (Department department : list) {
            System.out.println("department = " + department);
        }
    }

    @Test
    public void addDepartment() {
        Department department = new Department();
        department.setDepartmentName("新学院1");
        department.setTeacherName("李四");
        department.setAdminName("jack");
        int result = departmentDao.addDepartment(department);
        Assert.assertTrue(result > 0);

    }

    @Test
    public void getById() {
        Department department=departmentDao.getById(6);
        Assert.assertNotNull(department);
        System.out.println("department="+department);
    }

    @Test
    public void updateDepartment() {
        Department department=new Department();
        department.setDepartmentId(10);
        department.setDepartmentName("自然学院");
        department.setTeacherName("张三");
        department.setAdminName("jack");
        int result=departmentDao.updateDepartment(department);
        Assert.assertTrue(result>0);
        System.out.println("department"+department);

    }

    @Test
    public void deleteDepartment() {
        int result=departmentDao.deleteDepartment(11);
        Assert.assertTrue(result>0);

    }

    @Test
    public void batchDeletes() {
        List<String> list = new ArrayList<String>();
        list.add("10");
        list.add("11");
        departmentDao.batchDeletes(list);


    }
}