package com.study.xuanke.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Teacher {
    private Integer teacherId;
    private String teacherName;
    private String teacherSex;
    private Integer departmentId;
    private String departmentName; //教师所属学院
    private String title;  //教师职称
    private String teacherPhone;
    private String teacherAddress;
    private String teacherPassword;
    private String adminName;
    private Date createTime;
    private Date updateTime;
    private Integer state=1;
    private String email;
    private String msg;
}
