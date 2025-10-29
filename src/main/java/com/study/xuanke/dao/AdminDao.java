package com.study.xuanke.dao;

import com.study.xuanke.model.Admin;
import com.study.xuanke.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface AdminDao {
    //修改密码
    public int updatePassword(@Param("adminId") int adminId, @Param("adminPassword") String adminPassword);
    //    查询所有教师信息
    Admin getAdmin(Map<String, Object> params);
}
