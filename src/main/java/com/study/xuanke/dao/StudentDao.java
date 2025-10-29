package com.study.xuanke.dao;

import com.study.xuanke.model.Course;
import com.study.xuanke.model.SelectedCourse;
import com.study.xuanke.model.Student;
import com.study.xuanke.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository  //  说明是数据访问层
public interface StudentDao {
    //    查询所有学生信息
    Student getStudent(Map<String, Object> params);
    //    查询所有成绩
    List<SelectedCourse> queryScoreList(Map<String, Object> param);
    //    关键字查询成绩
    List<SelectedCourse> queryScoreByKey(Map<String, Object> param);

    //    符合条件的成绩总条数
    Integer queryScoreCount(Map<String, Object> param);
//    Integer update(Student student);

    //修改密码
    int updatePassword(@Param("studentId") int studentId, @Param("studentPassword") String studentPassword);

    //学生管理
    List<Student> findAll();
    //根据关键字查找学生
    List<Student> findByKey(String key);
    //添加学生
    int addStudent(Student student);
    //根据学生id获取学生信息
    Student getById(int  StudentId);
    //更新学生信息
    int updateStudent(Student student);
    // 逻辑删除
    int deleteStudent(int studentId);
    //真实删除一大堆
    void batchDeletes(List delList);
    //学生个人信息
    List<Student> findStudentInfo(Integer studentId);
}
