package com.study.xuanke.service;

import com.study.xuanke.model.Admin;
import com.study.xuanke.model.Teacher;

import java.util.Map;

public interface AdminService {
    //修改密码
    public Map<String,Object> updatePassword(int adminId,String oldpassword,String newpassword);
    //    查询所有教师信息
    Map<String,Object> getAdmin(Admin admin);
}
