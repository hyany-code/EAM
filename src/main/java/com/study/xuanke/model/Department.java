package com.study.xuanke.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;


@Data
@ToString
public class Department {
    private Integer departmentId;
    private String departmentName;
    private String teacherName;
    private String adminName;
    private Date createTime;
    private Date updateTime;
    private Integer state;
}
