package com.study.xuanke.controller;

import com.alibaba.fastjson.JSONObject;
import com.study.xuanke.model.Admin;
import com.study.xuanke.model.Student;
import com.study.xuanke.model.Teacher;
import com.study.xuanke.service.AdminService;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    private static String SESSION_ADMIN;

    /**
     * 修改密码
     * @param adminId
     * @param oldpassword
     * @param newpassword
     * @return
     */
    @RequestMapping(value="/updatePassword",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updatePassword(Integer adminId,String oldpassword,String newpassword){
        System.out.println("updatePasswordController");
        System.out.println(adminId);
        System.out.println(oldpassword);
        System.out.println(newpassword);
        return adminService.updatePassword(adminId,oldpassword,newpassword);
    }

    // 退出登录
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(AdminController.SESSION_ADMIN);
        session.invalidate();
        return "/login.jsp";
    }

    /**
     * 管理员登录
     * @param adminId:管理员id
     * @param adminPassword:管理员密码
     * @return
     */
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> teacherLogin(Integer adminId, String adminPassword ,HttpSession session){
        try {
            Admin user = new Admin();
            user.setAdminId(adminId);
            user.setAdminPassword(adminPassword);
            Map<String, Object> map = adminService.getAdmin(user);
            Admin admin = (Admin) map.get("admin");
            session.setAttribute("currentAdmin",admin);
            return map;
        } catch (Exception e) {
            Map<String,Object> ret = new HashMap<String,Object>();
            ret.put("code", -2);
            ret.put("msg", "系统繁忙，请稍后再试");
            return ret;
        }
    }

}

