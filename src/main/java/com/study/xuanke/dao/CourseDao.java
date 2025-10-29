package com.study.xuanke.dao;


import com.study.xuanke.model.Course;
import com.study.xuanke.model.SelectedCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CourseDao {
    List<Course> findAll();
    List<Course> findByKey(String key);
    List<SelectedCourse> findAllSelectedCourse(int studentId);
    List<Course> findAllTeachedCourse(int teacherId);
    int addCourse(Course course);
    int addCourse2(@Param("studentId") int studentId, @Param("courseId") int courseId,
    @Param("score") float score, @Param("gpa") float gpa, @Param("teacherId") int teacherId);
    int addCourse3(int courseId);

    Course getById(int  courseId);

    int updateCourse(Course course);
    // 逻辑删除
    int deleteCourse(int courseId);
    int deleteSelectedCourse(int courseId);
    //   查询该学生选课的课程数，用作判断是否能重复选一门课
    Integer querySelectedCourseCountById(Map<String, Object> param);
    Integer queryPlanNum(Map<String, Object> param);

    Integer querySelectedNum(Map<String, Object> param);


}
