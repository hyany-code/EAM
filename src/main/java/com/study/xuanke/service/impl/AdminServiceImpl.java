package com.study.xuanke.service.impl;

import com.study.xuanke.dao.AdminDao;
import com.study.xuanke.model.Admin;
import com.study.xuanke.model.Teacher;
import com.study.xuanke.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    //  注入dao
    @Autowired
    private AdminDao adminDao;
    @Override
    public Map<String,Object> updatePassword(int adminId,String oldpassword,String newpassword){
        Map<String,Object> ret = new HashMap<String,Object>();
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("adminId",adminId);
        params.put("adminPassword",oldpassword);
        com.study.xuanke.model.Admin u = adminDao.getAdmin(params);
        if(u!=null){
            if(!oldpassword.equals(newpassword)){
            int i = adminDao.updatePassword(adminId,newpassword);
            if(i>0){
                ret.put("code","1");
                ret.put("msg","修改成功");
            }else{
                ret.put("code","0");
                ret.put("msg","修改失败");
            }
        }else{
                ret.put("code","-2");
                ret.put("msg","新密码不得与旧密码相同");
        }}
        else{
            ret.put("code","-1");
            ret.put("msg","旧密码错误");
        }
        return ret;
    }

    @Override
    public Map<String,Object> getAdmin(Admin admin) {
        System.out.println("走到管理员service");
        Map<String,Object> ret = new HashMap<>();
        Map<String,Object> params = new HashMap<>();
        params.put("adminId",admin.getAdminId());
        params.put("adminPassword",admin.getAdminPassword());
        Admin a = adminDao.getAdmin(params);
        if (a == null){
            a = new Admin();
            ret.put("code",-1);
            ret.put("msg","用户或密码不正确");
//            ret.put("teacher",tea);
            return ret;
        }
        ret.put("code",3);
        ret.put("msg","登录成功");
        ret.put("adminId",admin.getAdminId());
        ret.put("adminPassword",admin.getAdminPassword());
        ret.put("admin",a);

        return ret;
    }

}
