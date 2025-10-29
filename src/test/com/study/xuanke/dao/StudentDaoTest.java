package com.study.xuanke.dao;

import com.study.xuanke.model.News;
import com.study.xuanke.model.SelectedCourse;
import com.study.xuanke.model.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class StudentDaoTest {
    @Autowired
    StudentDao studentDao;

    @Test
    public void getStudent() {
        List<Student> list = studentDao.findAll();
        for (Student student : list) {
            System.out.println("student:" + student);

        }
    }

    @Test
    public void queryScoreList() {
    }

    @Test
    public void queryScoreCount() {
    }

    @Test
    public void update() {
    }

    @Test
    public void updatePassword() {
        int i = studentDao.updatePassword(190502,"444444");
        System.out.println(i);
    }

    @Test
    public void findAll() {
        List<Student> list = studentDao.findAll();
        for (Student student : list) {
            System.out.println("Student = " + student);
        }
    }

    @Test
    public void findByKey() {
        List<Student> list = studentDao.findByKey("李");
        for (Student student:list) {
            System.out.println("student = " + student);
        }
    }

    @Test
    public void addStudent() {
        Student student=new Student();
        student.setStudentName("张五");
        student.setStudentSex("女");
        student.setDepartmentId(1);
        student.setMajorId(1);
        student.setClassId(1);
        student.setStudentPassword("789456");
        student.setAdminName("jack");
        int result = studentDao.addStudent(student);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void getById() {
        Student student=studentDao.getById(190508);
        Assert.assertNotNull(student);
        System.out.println("student="+student);
    }

    @Test
    public void updateStudent() {
        Student student=new Student();
        student.setStudentName("张五");
        student.setStudentSex("女");
        student.setDepartmentId(1);
        student.setMajorId(1);
        student.setClassId(1);
        student.setStudentPassword("789456");
        student.setAdminName("jack");
        student.setStudentId(190508);
        int result=studentDao.updateStudent(student);
        Assert.assertTrue(result>0);
        System.out.println("student"+student);


    }

    @Test
    public void deleteStudent() {
        int result=studentDao.deleteStudent(190509);
        Assert.assertTrue(result>0);
    }

    @Test
    public void batchDeletes() {
        List<String> list = new ArrayList<String>();
        list.add("190509");

        studentDao.batchDeletes(list);
    }

    @Test
    public void findStudentInfo() {
        List<Student> list = studentDao.findStudentInfo(190502);
        for (Student student:list) {
            System.out.println("student = " + student);
        }
    }
    @Test
    public void queryScoreByKey() {
        Map<String,Object> params = new HashMap<>();
        params.put("studentId",1);
//        params.put("courseId",1);
//        params.put("courseName","Java程序设计");
        params.put("semester","第1学期");
        List<SelectedCourse> selectedCourses = studentDao.queryScoreByKey(params);
        System.out.println(selectedCourses);
    }
}