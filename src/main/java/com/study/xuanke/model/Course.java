package com.study.xuanke.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class Course {
    private Integer courseId; //课程ID
    private String courseName;//课程名
    private String courseType;//课程类型
    private Integer teacherId;//教师ID
    private  String studentName;
    private String teacherName;//教师姓名
    private Integer departmentId;//学院ID
    private String departmentName;//学院名
    private String  academicYear;//学年
    private String semester;//学期
    private String time;//上课时间
    private String place;//上课地点
    private Integer creditHour;
    private Integer credit;
    private String examType;//考试类型
    private Integer planNumber;
    private Integer selectedNumber;
    private String adminName;
    private Date createTime;
    private Date updateTime;
    private Course course;
    private Float score;
    private Float gpa;
    private Integer studentId;
    private Boolean state; // 状态 对应数据库中bit类型
    private List<Teacher> teacherList;
    private List<Department> departmentList;
    private Department department;
    private SelectedCourse selectedcourse;
    private Student student;
   // private List<SelectedCourse2> selectedCourse2List;
   private Teacher teacher;
}
