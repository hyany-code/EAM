package com.study.xuanke.service;

import com.study.xuanke.model.*;

import java.util.List;
import java.util.Map;

public interface StudentService {
    //    查询所有教师信息
    Map<String,Object> getStudent(Student student);
    //    查询所有成绩
    List<SelectedCourse> queryScoreList(Map<String, Object> param);
    //    关键字查询成绩
    List<SelectedCourse> queryScoreByKey(Map<String, Object> param);
    //    符合条件的成绩总条数
    Integer queryScoreCount(Map<String, Object> param);
//    Integer update(Student student);

    List<Student> findAll();

    List<Student> findByKey(String key);
    //是否删除成功，一个逻辑值
    boolean addStudent(Student student);

    Student getById(int studentId);

    boolean updateStudent(Student student);

    // 逻辑删除
    boolean deleteStudent(int studentId);

    void batchDeletes(List delList);

    //   修改密码
    Map<String,Object> updatePassword(int studentId, String oldpassword, String newpassword);
//学生个人信息
    List<Student> findStudentInfo(Integer studentId);
}
