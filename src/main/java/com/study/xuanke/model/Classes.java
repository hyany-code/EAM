package com.study.xuanke.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Classes {
//    班级代码
    private Integer classId;
//    班级名称
    private String className;
//    所属专业id
    private Integer majorId;
//    创建人id
    private String adminName;
//    创建时间
    private Date createTime;
//    修改时间
    private Date updateTime;

    private Integer state=1;

}
