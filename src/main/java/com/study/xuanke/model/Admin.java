package com.study.xuanke.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Admin {
    private Integer adminId;
    private String adminName;
    private String adminPassword;
    private String adminPhone;
}
