package com.study.xuanke.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.xuanke.model.Admin;
import com.study.xuanke.model.Course;
import com.study.xuanke.model.SelectedCourse;
import com.alibaba.fastjson.JSONObject;
import com.study.xuanke.model.Student;
import com.study.xuanke.model.Teacher;
import com.study.xuanke.service.StudentService;
import com.study.xuanke.util.ResultVO;
//import com.sun.corba.se.impl.orbutil.closure.Constant;
//import com.sun.deploy.util.StringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

/**
 * 学生模块
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 学生登录
     * @param studentId,studentPassword
     * @return
     */
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> teacherLogin(Integer studentId, String studentPassword ,HttpSession session){
        try {
            Student user = new Student();
            user.setStudentId(studentId);
            user.setStudentPassword(studentPassword);
            Map<String, Object> map = studentService.getStudent(user);
            Student student = (Student)map.get("student");
            session.setAttribute("currentStudent",student);
            return map;
        } catch (Exception e) {
            Map<String,Object> ret = new HashMap<String,Object>();
            ret.put("code", -2);
            ret.put("msg", "系统繁忙，请稍后再试");
            return ret;
        }
    }


    /**
     * 查询全部成绩
     */
    @RequestMapping("/queryScoreList")
    public String queryScoreList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                           SelectedCourse selectedCourse,
//                                  Map<String,Object> param,
                                           HttpSession session,Model model){
        ResultVO<Object> result = new ResultVO<>();
        try {
//  获取当前登录用户信息
            Student student = (Student) session.getAttribute("currentStudent");
            //  获得studentId
            Integer studentId = student.getStudentId();
            Map<String,Object> param = new HashMap<>();
            param.put("studentId",studentId);
            //1.添加分页
            PageHelper.startPage(page,10);
            //2.查询
            List<SelectedCourse> list = studentService.queryScoreList(param);
            //3.将查询的结果进行封装，可以传入可连续显示的页码
            PageInfo<SelectedCourse> info = new PageInfo<>(list,5);
            model.addAttribute("info",info);

            Integer count = studentService.queryScoreCount(param);
            Map<String,Object> restMap = new HashMap<>();
            restMap.put("data",list);
            restMap.put("count",count);
            result.setResult(restMap);
            result.setMsg("查询成功！");

        }catch (Exception e){
            result.setFlag(1);
            result.setMsg("查询失败！");
        }
        return "/view/students/score/student_score.jsp";
    }


    /**
     * 关键字查询成绩
     */
    @RequestMapping("/queryScoreByKey")
    public String queryScoreByKey(@RequestParam(value = "page",defaultValue = "1") Integer page,
//                                           SelectedCourse selectedCourse,
                                            Course course,
//                                  Map<String,Object> param,
                                           HttpSession session,Model model){
        ResultVO<Object> result = new ResultVO<>();
        try {
            //  获取当前登录用户信息
            Student student = (Student) session.getAttribute("currentStudent");
            //  获得studentId
            Integer studentId = student.getStudentId();
            Map<String,Object> param = new HashMap<>();
            param.put("studentId",studentId);
            param.put("academicYear",course.getAcademicYear());
            param.put("semester",course.getSemester());
            System.out.println(param);
            //1.添加分页
            PageHelper.startPage(page,10);
            //2.查询
            List<SelectedCourse> list = studentService.queryScoreByKey(param);
            //3.将查询的结果进行封装，可以传入可连续显示的页码
            PageInfo<SelectedCourse> info = new PageInfo<>(list,5);
            model.addAttribute("param",param);  //  回显关键字
            model.addAttribute("info",info);
            Integer count = studentService.queryScoreCount(param);
            Map<String,Object> restMap = new HashMap<>();
            restMap.put("data",list);
            restMap.put("count",count);
            result.setResult(restMap);
            result.setMsg("查询成功！");
        }catch (Exception e){
            result.setFlag(1);
            result.setMsg("查询失败！");
        }
        return "/view/students/score/student_score.jsp";

    }

//    查询所有学生信息
    @RequestMapping("/listAll")
    public String doList(@RequestParam(value = "page",defaultValue = "1") Integer page, Model model){
        // 1添加分页 page表示查询第几页 分页查询,每页5条数据
        PageHelper.startPage(page,5);
        //2 做查询
        List<Student> list = studentService.findAll();

        // 3将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<Student> info = new PageInfo<>(list,3);
        // 获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );
        // 4 绑定PageInfo 向页面返回封装后的数据
        model.addAttribute("info",info);

        //model.addAttribute("list",list);
        return "/view/admin/student/student_list.jsp";
    }
    @RequestMapping("/search")
    public String doSearch(@RequestParam(value = "page",defaultValue = "1") Integer page,String key,Model model){
        // 1添加分页 page表示查询第几页 分页查询,每页5条数据
        PageHelper.startPage(page,5);
        List<Student> list = studentService.findByKey(key);
        // 3将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<Student> info = new PageInfo<>(list,3);
        // 获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );

        model.addAttribute("info",info);
        // 回显
        model.addAttribute("key",key);
        return "/view/admin/student/student_list.jsp";
    }
    // 添加对象,接收表单参数,执行添加，重定向到listAll
    @RequestMapping("/add")
    public String doAdd(Student student){
        studentService.addStudent(student);
        // 可判断是成功还是失败
        // 再做查询
        return "redirect:listAll";
    }
    // 根据主键获取单个对象，转发到department_update.jsp
    @RequestMapping("/getOne")
    public String doGetOne(int studentId,Model model){
        Student student = studentService.getById(studentId);
        model.addAttribute("student",student);
        return "/view/admin/student/student_update.jsp";
    }

    // 修改对象，接收表单参数，执行修改，重定向到listAll
    @RequestMapping("/update")
    public String doUpdate(Student student){
        studentService.updateStudent(student);
        return "redirect:listAll";
    }
    // 删除对象，接收请求参数id,执行删除，重定向到listAll
    @RequestMapping("/delete")
    public String doDelete(int studentId){
        studentService.deleteStudent(studentId);
        return "redirect:listAll";
    }

    private static String SESSION_STUDENT;
    /**
     * 修改密码
     * @param studentId
     * @param oldpassword
     * @param newpassword
     * @return
     */
    @RequestMapping(value="/updatePassword",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updatePassword(Integer studentId, String oldpassword, String newpassword){
        System.out.println("updatePasswordController");
        System.out.println(studentId);
        System.out.println(oldpassword);
        System.out.println(newpassword);
        return studentService.updatePassword(studentId, oldpassword, newpassword);
    }
    // 退出登录
    @RequestMapping("loginOut")
    public String loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(StudentController.SESSION_STUDENT);
        session.invalidate();
        return "redirect:/login";
    }
    //    学生个人信息显示
    @RequestMapping("/studentInfo")
    public String doList_info(Model model,HttpSession session){
        //2 做查询
        Student student = (Student) session.getAttribute("currentStudent");
        int studentId = student.getStudentId();
        List<Student> list= studentService.findStudentInfo(studentId);
        System.out.println(list);
        model.addAttribute("student",list);
        return "/view/students/information/info_list.jsp";
    }

}
