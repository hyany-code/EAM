package com.study.xuanke.service;

import com.study.xuanke.model.SelectedCourse;
import com.study.xuanke.model.Teacher;

import java.util.List;
import java.util.Map;


public interface TeacherService {
    //    查询所有教师信息
    Map<String,Object> getTeacher(Teacher teacher);
    //    查询所有选课学生信息
    List<SelectedCourse> queryStudentInfoList(Map<String, Object> param);
    //    关键字查询选课学生信息
    List<SelectedCourse> queryStudentInfoByKey(Map<String, Object> param);
    //    符合条件的学生信息总条数
    Integer queryStudentInfoCount(Map<String, Object> param);
    //    查询所有成绩
    List<SelectedCourse> queryScoreList(Map<String, Object> param);
    //    关键字查询成绩
    List<SelectedCourse> queryScoreByKey(Map<String, Object> param);
    //    符合条件的成绩总条数
    Integer queryScoreCount(Map<String, Object> param);
    //    根据选课id查询全部
    SelectedCourse getByOptionId(Integer optionId);
    //    根据课程id查询全部
    List<SelectedCourse> getByCourseId(Map<String, Object> param);
    List<SelectedCourse> export(Map<String, Object> param);
    //    导出班级学生信息excel
    List<SelectedCourse> exportClassInfo(Map<String, Object> param);

    //    添加、修改成绩
    void updateScore(SelectedCourse selectedCourse);
//    boolean updateScore(SelectedCourse selectedCourse);

    //    逻辑删除成绩
    boolean deleteScore(Integer optionId);
    //    批量删除成绩
    void batchDeletesScore(List delList);

    //   修改密码
    public  Map<String,Object> updatePassword(int teacherId, String oldpassword, String newpassword);

    List<Teacher> findAll();

    List<Teacher> findByKey(String key);
    //是否删除成功，一个逻辑值
    boolean addTeacher(Teacher teacher);

    Teacher getById(int teacherId);

    boolean updateTeacher(Teacher teacher);

    // 逻辑删除
    boolean deleteTeacher(int teacherId);

    List<Teacher> getTeachersByDepartmentId(int departmentId);
    //学生个人信息
    List<Teacher> findTeacherInfo(Integer teacherId);
    List<Teacher> checkEmail(Map<String, Object> param);

}
