package com.study.xuanke.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class SelectedCourse {
//    选课id
    private Integer optionId;
//    课程号
    private Integer courseId;
//    授课教师id/创建人id
    private Integer teacherId;
    private String teacherName;

//    学生id
    private Integer studentId;
//    百分制成绩
    private Float score = 0.0f;
    //    绩点
    private Float gpa;
//    创建时间
    private Date createTime;
//    修改时间
    private Date updateTime;

    private Integer state;

    /*各科的成绩换算为绩点*/
//    public float setGpa(float score) {
//        float gpa;
//        if(score>=90 && score<=100)
//            gpa = (float)4.0;
//        else if(score>=85 && score<=89)
//            gpa = (float)3.7;
//        else if(score>=80 && score <=84)
//            gpa = (float)3.3;
//        else if(score>=76 && score<=79)
//            gpa = (float)3.0;
//        else if(score>=73 && score<=75)
//            gpa = (float)2.7;
//        else if(score>=70 && score<=72)
//            gpa = (float)2.3;
//        else if(score>=66 && score<=69)
//            gpa = (float)2.0;
//        else if(score>=63 && score<=65)
//            gpa = (float)1.7;
//        else if(score>=61 && score<=62)
//            gpa = (float)1.3;
//        else if(score==60)
//            gpa = (float)1.0;
//        else
//            gpa = 0;
//        return gpa;
//    }

    //  以下为多表联查所需属性
    private String studentName;  //  学生姓名
    private String courseName;  //  课程名称
    private String departmentName;  //  学生所属院系名称
    private String majorName;   //  所属专业名称
    private String className;   //  所属班级名称
    private String academicYear;    //  学年
    private String semester;    //  学期
    private Integer credit;     //  学分
    private String examType;    //  考试类型
    private String courseDepartmentName;    //  开课学院
    private String courseType;  //  课程类型
    private Integer creditHour;  //  学时
    private Integer selectedNumber;     //  已选人数
    private Course course;
    private String msg;     //   提示信息
    private Integer classId;    //  学生班级id
}
