package com.study.xuanke.service.impl;

import com.study.xuanke.dao.CourseDao;
import com.study.xuanke.model.Course;
import com.study.xuanke.model.SelectedCourse;
import com.study.xuanke.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }
    @Override
    public List<SelectedCourse> findAllSelectedCourse(int studentId) {
        return courseDao.findAllSelectedCourse(studentId);
    }
    @Override
    public List<Course> findAllTeachedCourse(int teacherId) {
        return courseDao.findAllTeachedCourse(teacherId);
    }
    @Override
    public List<Course> findByKey(String key) {
        return courseDao.findByKey(key);
    }

    @Override
    public boolean addCourse(Course course) {
        return courseDao.addCourse(course) > 0 ? true : false;
    }

    @Override
    @Transactional
    public  boolean addCourse2(int studentId,int courseId,float score,float gpa,int teacherId) {
        boolean flag =false;
        if(courseDao.addCourse2(studentId,courseId,score,gpa,teacherId)>0){
            courseDao.addCourse3(courseId);
             flag = true;
        }
             return flag;
    }
    @Override
    public Course getById(int courseId) {
        return courseDao.getById(courseId);
    }

    @Override
    public boolean updateCourse(Course course) {
        return courseDao.updateCourse(course) > 0 ? true : false;
    }

    @Override
    public boolean deleteCourse(int courseId) {
        return courseDao.deleteCourse(courseId) > 0 ? true : false;
    }
    @Override
    public boolean deleteSelectedCourse(int courseId) {
        return courseDao.deleteSelectedCourse(courseId) > 0 ? true : false;
    }

    @Override
    public Integer queryScoreCount(Map<String, Object> param) {
        return courseDao.querySelectedCourseCountById(param);
    }

    @Override
    public Integer queryPlanNum(Map<String, Object> param) {
        return courseDao.queryPlanNum(param);
    }

    @Override
    public Integer querySelectedNum(Map<String, Object> param) {
        return courseDao.querySelectedNum(param);
    }
}
