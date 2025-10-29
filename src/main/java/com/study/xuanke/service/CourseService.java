package com.study.xuanke.service;

import com.study.xuanke.model.Course;
import com.study.xuanke.model.SelectedCourse;

import java.util.List;
import java.util.Map;

public interface CourseService {
    List<Course> findAll();
    List<SelectedCourse> findAllSelectedCourse(int studentId);
    List<Course> findAllTeachedCourse(int teachedId);
    List<Course> findByKey(String key);

    boolean addCourse(Course course);

    boolean addCourse2(int studentId,int courseId,float score,float gpa,int teacherId);

    Course getById(int  courseId);

    boolean updateCourse(Course course);
    // 逻辑删除
    boolean deleteCourse(int courseId);
    boolean deleteSelectedCourse(int courseId);
    Integer queryScoreCount(Map<String, Object> param);
    Integer queryPlanNum(Map<String, Object> param);
    Integer querySelectedNum(Map<String, Object> param);

}
