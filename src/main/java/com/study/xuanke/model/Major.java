package com.study.xuanke.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class Major {
//    专业代码
    private Integer majorId;
//    专业名称
    private String majorName;
    //    所属院系id
    private Integer departmentId;
//    创建人id
    private String adminName;
//    创建时间
    private Date createTime;
//    更新时间
    private Date updateTime;
//    逻辑删除
    private Integer state;
}
