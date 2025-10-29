package com.study.xuanke.dao;

import com.study.xuanke.model.*;
import org.apache.ibatis.annotations.Param;
import com.study.xuanke.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository

public interface TeacherDao {
    //    查询所有教师信息
    Teacher getTeacher(Map<String, Object> params);
    //    查询所有选课学生信息
    List<SelectedCourse> queryStudentInfoList(Map<String, Object> param);
    //    查询所有选课学生信息
    List<SelectedCourse> queryStudentInfoByKey(Map<String, Object> param);
    //    符合条件的学生信息总条数
    Integer queryStudentInfoCount(Map<String, Object> param);
    //    查询所有成绩
    List<SelectedCourse> queryScoreList(Map<String, Object> param);
    //    关键字查询成绩
    List<SelectedCourse> queryScoreByKey(Map<String, Object> param);
    //    符合条件的成绩总条数
    Integer queryScoreCount(Map<String, Object> param);
    List<SelectedCourse> getByCourseId(Map<String, Object> param);
    //    导出本课程学生信息excel
    List<SelectedCourse> export(Map<String, Object> param);
    //    导出班级学生信息excel
    List<SelectedCourse> exportClassInfo(Map<String, Object> param);
    //    添加、修改成绩
    void updateScore(SelectedCourse selectedCourse);
//    int updateScore(SelectedCourse selectedCourse);
    //    更新数据时回显数据
    SelectedCourse getByOptionId(Integer optionId);
    //    逻辑删除成绩
    int deleteScore(Integer optionId);
    //    批量删除成绩
    void batchDeletesScore(List delList);

    //  查找所有教师
    List<Teacher> findAll();
    //  根据关键字查找教师
    List<Teacher> findByKey(String key);
    //  添加教师
    int addTeacher(Teacher teacher);
    //  根据id获得老师信息
    Teacher getById(int  teacherId);
    //  更新教师信息
    int updateTeacher(Teacher teacher);

    //  逻辑删除教师
    int deleteTeacher(int teacherId);
    //  批量删除教师
    void batchDeletes(List delList);



    //修改密码
    public int updatePassword(@Param("teacherId") int teacherId, @Param("teacherPassword") String teacherPassword);

    List<Teacher> getTeachersByDepartmentId(int departmentId);
    //教师个人信息
    List<Teacher> findTeacherInfo(Integer teacherId);
    List<Teacher> checkEmail(Map<String, Object> param);

}
