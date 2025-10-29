package com.study.xuanke.dao;

import com.study.xuanke.model.SelectedCourse;
import com.study.xuanke.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class TeacherDaoTest {
    @Autowired
    TeacherDao teacherDao;

    @Test
    public void getTeacher() {
        Map<String,Object> params = new HashMap<>();
        params.put("teacherId",1);
        params.put("teacherPassword","1234");
        Teacher tea = teacherDao.getTeacher(params);
        System.out.println(tea);
    }

//    @Test
//    public void queryScoreList() {
//        Map<String,Object> params = new HashMap<>();
//        params.put("teacherId",1);
//        List<SelectedCourse> selectedCourses = teacherDao.queryScoreList(params);
//        System.out.println(selectedCourses);
//    }
//    @Test
//    public void queryScoreById() {
//        Map<String,Object> params = new HashMap<>();
//        params.put("studentId",1);
//        teacherDao.queryScoreByKey(params);
//    }

    @Test
    public void queryScoreCount() {
        Map<String,Object> params = new HashMap<>();
        params.put("teacherId",1);
//        params.put("courseId",1);
//        params.put("courseName","Java程序设计");
        params.put("studentName","李土豆");
        List<SelectedCourse> selectedCourses = teacherDao.queryScoreByKey(params);
        System.out.println(selectedCourses);
    }

    @Test
    public void updateScore() {
        Map<String,Object> params = new HashMap<>();
        SelectedCourse selectedCourse = new SelectedCourse();
        params.put("optionId",1);
        selectedCourse.setOptionId(1);
        selectedCourse.setScore(90.00f);
        teacherDao.updateScore(selectedCourse);
    }

    @Test
    public void getOneScore() {

        SelectedCourse id = teacherDao.getByOptionId(1);

        System.out.println(id);
    }
    @Test
    public void deleteScore() {
        teacherDao.deleteScore(1);
    }

    @Test
    public void batchDeletes() {
    }

    @Test
    public void update() {
    }

    @Test
    public void updatePassword() {
        int i = teacherDao.updatePassword(1, "777777");
        System.out.println(i);
    }

    @Test
    public void findAll() {
        List<Teacher> list = teacherDao.findAll();
        for (Teacher teacher : list) {
            System.out.println("Teacher = " + teacher);
        }
    }

    @Test
    public void findByKey() {
        List<Teacher> list = teacherDao.findByKey("张");
        for (Teacher teacher:list) {
            System.out.println("teacher = " + teacher);
        }
    }

    @Test
    public void addTeacher() {
        Teacher teacher = new Teacher();
        teacher.setTeacherName("石述思");
        teacher.setTeacherSex("男");
        teacher.setDepartmentId(1);
        teacher.setTitle("讲师");
        teacher.setTeacherPhone("16547886789");
        teacher.setTeacherAddress("山东省济南市长清区丹凤小区2号楼");
        teacher.setAdminName("张三");
        int result = teacherDao.addTeacher(teacher);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void getById() {
        Teacher teacher = teacherDao.getById(1);
        Assert.assertNotNull(teacher);
        System.out.println("teacher = " + teacher);
    }

    @Test
    public void updateTeacher() {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(2);
        teacher.setTeacherName("上京东和");
        teacher.setTeacherSex("男");
        teacher.setDepartmentId(1);
        teacher.setTitle("教授");
        teacher.setTeacherPhone("16547886789");
        teacher.setTeacherAddress("山东省济南市长清区丹凤小区2号楼");
        teacher.setTeacherPassword("123456");
        teacher.setAdminName("张三");
        int result = teacherDao.updateTeacher(teacher);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void deleteTeacher() {
        int result = teacherDao.deleteTeacher(4);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void batchDeletesScore() {
    }
    @Test
    public void queryStudentInfoList() {
        Map<String,Object> params = new HashMap<>();
        params.put("teacherId",1);
//        params.put("courseId",1);
//        params.put("courseName","Java程序设计");
//        params.put("studentName","李土豆");
        List<SelectedCourse> selectedCourses = teacherDao.queryStudentInfoList(params);
        System.out.println(selectedCourses);
    }
    @Test
    public void queryStudentInfoLista() {
        Map<String,Object> params = new HashMap<>();
        params.put("teacherId",1);
//        params.put("courseId",1);
//        params.put("courseName","Java程序设计");
//        params.put("studentName","李土豆");
        List<SelectedCourse> selectedCourses = teacherDao.queryStudentInfoList(params);
        for (SelectedCourse selectedCours : selectedCourses) {
            System.out.println(selectedCours);
        }
    }
    @Test
    public void queryStudentInfoByKey() {
        Map<String,Object> params = new HashMap<>();
        params.put("teacherId",1);
        params.put("courseId",1);
        params.put("courseName","Java程序设计");
//        params.put("studentName","李土豆");
        List<SelectedCourse> selectedCourses = teacherDao.queryStudentInfoByKey(params);
        System.out.println(selectedCourses);
    }
    @Test
    public void getStudentInfoById() {
        Map<String,Object> params = new HashMap<>();
        params.put("teacherId",1);
        params.put("courseId",2);
//        params.put("courseName","Java程序设计");
//        params.put("studentName","李土豆");
        List<SelectedCourse> selectedCourses = teacherDao.getByCourseId(params);
        for (SelectedCourse selectedCours : selectedCourses) {
            System.out.println(selectedCours);
        }
    }
    @Test
    public void export() {
        Map<String,Object> params = new HashMap<>();
        params.put("teacherId",1);
        params.put("courseId",1);
//        params.put("courseName","Java程序设计");
//        params.put("studentName","李土豆");
        List<SelectedCourse> selectedCourses = teacherDao.export(params);
        for (SelectedCourse selectedCours : selectedCourses) {
            System.out.println(selectedCours);
        }
    }
    @Test
    public void exportClassInfo() {
        Map<String,Object> params = new HashMap<>();
        params.put("teacherId",1);
        params.put("courseId",1);
        params.put("courseName","Java程序设计");
        params.put("className","19软件本");
//        params.put("studentName","李土豆");
        List<SelectedCourse> selectedCourses = teacherDao.exportClassInfo(params);
        for (SelectedCourse selectedCours : selectedCourses) {
            System.out.println(selectedCours);
        }
    }
    @Test
    public void getStudentInfoDetails() {
        Map<String,Object> params = new HashMap<>();
        params.put("teacherId",1);
        params.put("courseId",1);
        params.put("className","19");
//        params.put("studentName","李土豆");
        List<SelectedCourse> selectedCourses = teacherDao.getByCourseId(params);
        for (SelectedCourse selectedCours : selectedCourses) {
            System.out.println(selectedCours);
        }
    }
    @Test
    public void checkEmail() {
        Map<String,Object> params = new HashMap<>();
        params.put("teacherId",1);
        params.put("email","2308037150@qq.com");
        List<Teacher> teachers = teacherDao.checkEmail(params);
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
}