package com.study.xuanke.model;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class Student {
//    学生id
    private Integer studentId;
//    学生姓名
    private String studentName;
//    学生性别
    private String studentSex;
//    所属院系
    private Integer departmentId;
    private String departmentName;
//    所属专业
    private Integer majorId;
    private String majorName;
//    所属班级
    private Integer classId;
    private String className;
//    登录密码
    private String studentPassword;
//    创建人
    private String adminName;
//    创建时间
    private Date createTime;
//    修改时间
    private Date updateTime;

    private Integer state=1;
    private String msg;     //  输出提示信息

    private Department department;
    private Major major;
    private Classes classes;
    private Student student;
    private List<Major> majorList;
    private List<Department> departmentList;
    private List<Classes> classesList;
    private List<Student> studentList;


    public void setPassword(String newPassword) {
    }
}
