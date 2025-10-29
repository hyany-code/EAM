package com.study.xuanke.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
//import com.mysql.cj.Session;
import com.mysql.cj.result.Row;
import com.study.xuanke.model.*;
import com.study.xuanke.service.TeacherService;
import com.study.xuanke.util.ExcelUtil;
import com.study.xuanke.util.ResultVO;
import javafx.scene.control.Cell;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.study.xuanke.service.TeacherService;
//import com.sun.corba.se.impl.orbutil.closure.Constant;

import org.springframework.beans.factory.annotation.Autowired;
import com.study.xuanke.model.Teacher;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import static com.alibaba.druid.sql.parser.Token.BY;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    private static String SESSION_TEACHER;

    /**
     * 教师登录
     * @param
     * @return
     */
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> teacherLogin(Integer teacherId, String teacherPassword ,HttpSession session){
        try {
            Teacher user = new Teacher();
            user.setTeacherId(teacherId);
            user.setTeacherPassword(teacherPassword);
            Map<String, Object> map = teacherService.getTeacher(user);
            Teacher teacher = (Teacher)map.get("teacher");
            session.setAttribute("currentTeacher",teacher);
            return map;
        } catch (Exception e) {
            Map<String,Object> ret = new HashMap<String,Object>();
            ret.put("code", -2);
            ret.put("msg", "系统繁忙，请稍后再试");
            return ret;
        }
    }

    /**
     * 查询全部选课学生信息接口
     */
    @RequestMapping("/queryStudentInfoList")
    public String queryStudentInfoList(@RequestParam(value = "page",defaultValue = "1") Integer page, Map<String,Object> param,HttpSession session,Model model){
        ResultVO<Object> result = new ResultVO<>();
        try {
            //  获取当前登录用户信息
            Teacher teacher = (Teacher)session.getAttribute("currentTeacher");
            //  获得teacherId
            Integer teacherId = teacher.getTeacherId();
//            //  分页设置
//            Integer pageNum = Integer.valueOf(param.get("pageNum").toString());     //  页码
//            System.out.println(pageNum);
//            Integer numPerPage = Integer.valueOf(param.get("numPerPage").toString());  //  每页行数
//            System.out.println(numPerPage);
//            Integer startIndex = (pageNum - 1) * numPerPage;   //   起始页
//            param.put("startIndex",startIndex);
//            param.put("numPerPage",numPerPage);
            param.put("teacherId",teacherId);
            //1.添加分页
            PageHelper.startPage(page,10);
            //2.查询
            List<SelectedCourse> list = teacherService.queryStudentInfoList(param);
            //3.将查询的结果进行封装，可以传入可连续显示的页码
            PageInfo<SelectedCourse> info = new PageInfo<>(list,5);
            model.addAttribute("info",info);

            Integer count = teacherService.queryScoreCount(param);
            Map<String,Object> restMap = new HashMap<>();
            restMap.put("data",list);
            restMap.put("count",count);
            result.setResult(restMap);
            result.setMsg("查询成功！");
            System.out.println(result);     //  输出结果
        }catch (Exception e){
            result.setFlag(1);
            System.out.println("异常为：" + e);      //  输出异常信息
            result.setMsg("查询失败！");
        }
//        return result;
        return "/view/teacher/student_information.jsp";     //  webapp是虚目录

    }

    /**
     * 关键字查询全部选课学生信息接口
     */
    @RequestMapping("/queryStudentInfoByKey")
    public String queryStudentInfoByKey(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                        SelectedCourse selectedCourse,HttpSession session,Model model){
        ResultVO<Object> result = new ResultVO<>();
        try {
            //  获取当前登录用户信息
            Teacher teacher = (Teacher)session.getAttribute("currentTeacher");
            //  获得teacherId
            Integer teacherId = teacher.getTeacherId();
            //     将前端传入参数放入Map中
            Map<String,Object> param = new HashMap<>();
            param.put("teacherId",teacherId);
            param.put("courseId",selectedCourse.getCourseId());
            param.put("courseName",selectedCourse.getCourseName());
            //1.添加分页
            PageHelper.startPage(page,5);
            //2.查询
            List<SelectedCourse> list = teacherService.queryStudentInfoByKey(param);
            //3.将查询的结果进行封装，可以传入可连续显示的页码
            PageInfo<SelectedCourse> info = new PageInfo<>(list,3);
            model.addAttribute("info",info);
            model.addAttribute("param",param);  //  回显关键字

            Integer count = teacherService.queryScoreCount(param);
            Map<String,Object> restMap = new HashMap<>();
            restMap.put("data",list);
            restMap.put("count",count);
            result.setResult(restMap);
            result.setMsg("查询成功！");
            System.out.println(result);
        }catch (Exception e){
            result.setFlag(1);
            System.out.println("异常为：" + e);      //  输出异常信息
            result.setMsg("查询失败！");
        }
        return "/view/teacher/student_information.jsp";
    }

    /**
     * 查询全部学生成绩接口
     * @param param:teacherId 教师id
     */
    @RequestMapping("/queryScoreList")
    public String queryScoreList(@RequestParam(value = "page",defaultValue = "1") Integer page, Map<String,Object> param,HttpSession session,Model model){
        ResultVO<Object> result = new ResultVO<>();
        try {
            //  获取当前登录用户信息
            Teacher teacher = (Teacher)session.getAttribute("currentTeacher");
            //  获得teacherId
            Integer teacherId = teacher.getTeacherId();
//            //  分页设置
//            Integer pageNum = Integer.valueOf(param.get("pageNum").toString());     //  页码
//            System.out.println(pageNum);
//            Integer numPerPage = Integer.valueOf(param.get("numPerPage").toString());  //  每页行数
//            System.out.println(numPerPage);
//            Integer startIndex = (pageNum - 1) * numPerPage;   //   起始页
//            param.put("startIndex",startIndex);
//            param.put("numPerPage",numPerPage);
            param.put("teacherId",teacherId);
            //1.添加分页
            PageHelper.startPage(page,10);
            //2.查询
            List<SelectedCourse> list = teacherService.queryScoreList(param);
            //3.将查询的结果进行封装，可以传入可连续显示的页码
            PageInfo<SelectedCourse> info = new PageInfo<>(list,5);
            model.addAttribute("info",info);

            Integer count = teacherService.queryStudentInfoCount(param);
            Map<String,Object> restMap = new HashMap<>();
            restMap.put("data",list);
            restMap.put("count",count);
            result.setResult(restMap);
            result.setMsg("查询成功！");
            System.out.println(result);
        }catch (Exception e){
            result.setFlag(1);
            System.out.println("异常为：" + e);      //  输出异常信息
            result.setMsg("查询失败！");
        }
        return "/view/teacher/score/score_list.jsp";
    }


    /**
     * 关键字查询学生成绩
     */
    @RequestMapping("/queryScoreByKey")
    public String queryScoreByKey(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                  SelectedCourse selectedCourse,
//                                  Map<String,Object> param,
                                  HttpSession session,Model model){
        ResultVO<Object> result = new ResultVO<>();
        try {
            //  获取当前登录用户信息
            Teacher teacher = (Teacher)session.getAttribute("currentTeacher");
            //  获得teacherId
            Integer teacherId = teacher.getTeacherId();
            Map<String,Object> param = new HashMap<>();
            param.put("teacherId",teacherId);
            param.put("courseId",selectedCourse.getCourseId());
            param.put("courseName",selectedCourse.getCourseName());
            param.put("studentId",selectedCourse.getStudentId());
            param.put("studentName",selectedCourse.getStudentName());
            //1.添加分页
            PageHelper.startPage(page,10);
            //2.查询
            List<SelectedCourse> list = teacherService.queryScoreByKey(param);
            //3.将查询的结果进行封装，可以传入可连续显示的页码
            PageInfo<SelectedCourse> info = new PageInfo<>(list,5);
            model.addAttribute("param",param);  //  回显关键字
            model.addAttribute("info",info);
            Integer count = teacherService.queryScoreCount(param);
            Map<String,Object> restMap = new HashMap<>();
            restMap.put("data",list);
            restMap.put("count",count);
            result.setResult(restMap);
            result.setMsg("查询成功！");
            System.out.println(result);
        }catch (Exception e){
            result.setFlag(1);
            System.out.println("异常为：" + e);      //  输出异常信息
            result.setMsg("查询失败！");
        }
        return "/view/teacher/score/score_list.jsp";
    }
    // 根据主键获取单个对象，转发到.jsp
    @RequestMapping("/getOneScore")
    public String doGetOneScore(Integer optionId,Model model){
        SelectedCourse selectedCourse = teacherService.getByOptionId(optionId);
        model.addAttribute("selectedCourse",selectedCourse);
        model.addAttribute("optionId",optionId);
        return "/view/teacher/score/score_update.jsp";
    }

    /**
     * 课程id查询全部学生信息
     */
    @RequestMapping("/getStudentInfoDetails")
    public String getOneStudentInfo(@RequestParam(value = "page",defaultValue = "1") Integer page,SelectedCourse selectedCourse,Model model,HttpSession session ){
        //  获取当前登录用户信息
        Teacher teacher = (Teacher)session.getAttribute("currentTeacher");
        //  获得teacherId
        Integer teacherId = teacher.getTeacherId();
        Map<String,Object> param = new HashMap<>();
        param.put("teacherId",teacherId);
        param.put("courseId",selectedCourse.getCourseId());
        param.put("departmentName",selectedCourse.getDepartmentName());
        param.put("majorName",selectedCourse.getMajorName());
        param.put("className",selectedCourse.getClassName());

        //1.添加分页
        PageHelper.startPage(page,10);
        //2.查询
        List<SelectedCourse> list = teacherService.getByCourseId(param);
        //3.将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<SelectedCourse> info = new PageInfo<>(list,5);
        model.addAttribute("param",param);  //  回显关键字
        model.addAttribute("info",info);

        return "/view/teacher/student_details_information.jsp";
    }

    /**
     * 添加、修改学生成绩
     */
//    @RequestMapping("/doUpdate")
//    public String doUpdate(SelectedCourse selectedCourse){
//        boolean result = teacherService.updateScore(selectedCourse);
//        return "redirect:scoreList";
//    }
    @RequestMapping(value = "updateScore",method = RequestMethod.POST)
    public String updateScore(SelectedCourse selectedCourse,Course course){
        ResultVO<Object> result = new ResultVO<>();
        try {
            System.out.println(selectedCourse.getOptionId());
            teacherService.updateScore(selectedCourse);
            result.setMsg("保存成功！");
        }catch (Exception e){
            result.setFlag(1);
            System.out.println("异常为：" + e);      //  输出异常信息
            result.setMsg("保存失败！");
        }
//        return result;
        return "redirect:queryScoreList";
    }

    /**
     * 成绩删除接口
     * @param  optionId:主键
     * @return
     */
    @RequestMapping("deleteScore")
    @Transactional
    public String deleteScore(Integer optionId){
        ResultVO<Object> result = new ResultVO<>();
        try {
            teacherService.deleteScore(optionId);
            result.setMsg("删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            result.setFlag(1);
            System.out.println("异常为：" + e);      //  输出异常信息
            result.setMsg("删除失败！");
        }
        return "redirect:queryScoreList";
    }

    /**
     * 成绩删除接口
     * @param  ids:主键
     * @return
     */
    @RequestMapping("/batchDeletesScore")
    public String delAllScore(String ids){
        List<String> delList = new ArrayList<String>();
        String[] strs = ids.split(",");
        for (String str : strs) {
            delList.add(str);
        }
        //开始循环批量删除
        teacherService.batchDeletesScore(delList);
        //重定向刷新数据
        return "redirect:queryScoreList";
    }


    /**
     * 修改密码
     * @param teacherId
     * @param oldpassword
     * @param newpassword
     * @return
     */
    @RequestMapping(value="/updatePassword",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updatePassword(Integer teacherId,String oldpassword,String newpassword){
        System.out.println("updatePasswordController");
        System.out.println(teacherId);
        System.out.println(oldpassword);
        System.out.println(newpassword);
        return teacherService.updatePassword(teacherId,oldpassword,newpassword);
    }


    // 退出登录
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(TeacherController.SESSION_TEACHER);
        session.invalidate();
        return "/login.jsp";
    }
    @RequestMapping("/listAll")
    public String doList(@RequestParam(value = "page",defaultValue = "1") Integer page, Model model){
        //1.添加分页
        PageHelper.startPage(page,5);
        //2.查询
        List<Teacher> list = teacherService.findAll();

        //3.将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<Teacher> info = new PageInfo<>(list,3);
        //获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );
        //4.绑定info
        model.addAttribute("info",info);

        return "/view/admin/teacher/teacher_list.jsp";//webapp是虚目录
    }

    @RequestMapping("/showTeachers")
    @ResponseBody
    public List<Teacher> getTeachersByDepartmentId(int departmentId){
        List<Teacher> teacherList = teacherService.getTeachersByDepartmentId(departmentId);
        return teacherList;
    }

    // 根据关键字查询,绑定数据，转发到department_list.jsp
    @RequestMapping("/search")
    public String doSearch(@RequestParam(value = "page",defaultValue = "1") Integer page, String key,Model model){

        PageHelper.startPage(page,5);
        List<Teacher> list = teacherService.findByKey(key);
        PageInfo<Teacher> info = new PageInfo<>(list,3);
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );

        model.addAttribute("info",info);
        // 回显
        model.addAttribute("key",key);
        return "/view/admin/teacher/teacher_list.jsp";
    }
    // 添加对象,接收表单参数,执行添加，重定向到listAll
    @RequestMapping("/add")
    public String doAdd(Teacher teacher){
        boolean result = teacherService.addTeacher(teacher);
        // 可判断是成功还是失败
        // 再做查询
        return "redirect:listAll";//到listAll重新全查一遍
    }
    // 根据主键获取单个对象，转发到department_update.jsp
    @RequestMapping("/getOne")
    public String doGetOne(int teacherId,Model model){
        Teacher teacher = teacherService.getById(teacherId);
        model.addAttribute("teacher",teacher);
        return "/view/admin/teacher/teacher_update.jsp";
    }
    //   修改和删除操作自己独立完成
    // 修改对象，接收表单参数，执行修改，重定向到listAll
    @RequestMapping("/doUpdate")
    public String doUpdate(Teacher teacher){
        boolean result = teacherService.updateTeacher(teacher);
        return "redirect:listAll";

    }
    // 删除对象，接收请求参数id,执行删除，重定向到listAll
    @RequestMapping("/doDelete")
    public String doDelete(int teacherId){
        boolean result=teacherService.deleteTeacher(teacherId);
        return"redirect:listAll";

    }

    //    教师个人信息显示
    @RequestMapping("/teacherInfo")
    public String doList_info(Model model,HttpSession session){
        //2 做查询
        Teacher teacher = (Teacher) session.getAttribute("currentTeacher");
        int teacherId = teacher.getTeacherId();
        List<Teacher> list= teacherService.findTeacherInfo(teacherId);
        System.out.println(list);
        model.addAttribute("teacher",list);
        return "/view/teacher/information/info_list_t.jsp";
    }


    /**
     * 报告详细信息导出——excel
     * @param request
     * @param response
     */
    @RequestMapping(value = "/export")
    public String export(HttpServletRequest request, HttpServletResponse response,HttpSession session,
                         SelectedCourse selectedCourse,Model model) throws Exception {
        //  获取当前登录用户信息
        Teacher teacher = (Teacher)session.getAttribute("currentTeacher");
        //  获得teacherId
        Integer teacherId = teacher.getTeacherId();
        Map<String,Object> param = new HashMap<>();
        param.put("teacherId",teacherId);
        param.put("courseId",selectedCourse.getCourseId());
        param.put("courseName",selectedCourse.getCourseName());
        //获取数据
        List<SelectedCourse> list = teacherService.export(param);

        //excel标题
        //根据sql语句查询的字段名添加
        String[] title = {"课程号", "课程名", "学生学号", "学生姓名","所属学院","专业","班级"};
        //excel文件名
        String fileName = selectedCourse.getCourseName()+"-"+"学生花名册" + System.currentTimeMillis() + ".xls";
        //sheet名
        String sheetName = "学生信息";

        String [][] content = new String[list.size()][7];
        //根据字段名添加数据（String类型）
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            SelectedCourse obj=list.get(i);
            content[i][0] = obj.getCourseId().toString();
            content[i][1] = obj.getCourseName();
            content[i][2] = obj.getStudentId().toString();
            content[i][3] = obj.getStudentName();
            content[i][4] = obj.getDepartmentName();
            content[i][5] = obj.getMajorName();
            content[i][6] = obj.getClassName();
        }
        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
        //响应到客户端，可以自己选择保存路径
        try {
            FileOutputStream out = new FileOutputStream("/Users/litudou/desktop/"+fileName);
            wb.write(out);
            out.close();
            session.setAttribute("msg", "<script>alert('导出成功！')</script>");
        } catch (Exception e) {
            session.setAttribute("msg", "<script>alert('导出失败！')</script>");
            e.printStackTrace();
        }
        return "redirect:/teacher/queryStudentInfoByKey";
    }

    /**
     * 报告详细信息导出——excel
     * @param request
     * @param response
     */
    @RequestMapping(value = "/exportClassInfo")
    public String exportClassInfo(HttpServletRequest request, HttpServletResponse response,HttpSession session,
                         SelectedCourse selectedCourse,Model model) throws Exception {
        //  获取当前登录用户信息
        Teacher teacher = (Teacher)session.getAttribute("currentTeacher");
        //  获得teacherId
        Integer teacherId = teacher.getTeacherId();
        Map<String,Object> param = new HashMap<>();
        param.put("teacherId",teacherId);
        param.put("courseId",selectedCourse.getCourseId());
        param.put("courseName",selectedCourse.getCourseName());
        param.put("className",selectedCourse.getClassName());
        //获取数据
        List<SelectedCourse> list = teacherService.exportClassInfo(param);

        //excel标题
        //根据sql语句查询的字段名添加
        String[] title = {"课程号", "课程名", "学生学号", "学生姓名","所属学院","专业","班级"};
        //excel文件名
        String fileName = selectedCourse.getCourseName()+"-"+selectedCourse.getClassName()+"-"+"学生花名册" + System.currentTimeMillis() + ".xls";
        //sheet名
        String sheetName = selectedCourse.getClassName()+"学生信息";

        String [][] content = new String[list.size()][7];
        //根据字段名添加数据（String类型）
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            SelectedCourse obj=list.get(i);
            content[i][0] = obj.getCourseId().toString();
            content[i][1] = obj.getCourseName();
            content[i][2] = obj.getStudentId().toString();
            content[i][3] = obj.getStudentName();
            content[i][4] = obj.getDepartmentName();
            content[i][5] = obj.getMajorName();
            content[i][6] = obj.getClassName();
        }
        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
        //响应到客户端，可以自己选择保存路径
        try {
            FileOutputStream out = new FileOutputStream("/Users/litudou/desktop/"+fileName);
            wb.write(out);
            out.close();
            session.setAttribute("msg", "<script>alert('导出成功！')</script>");
        } catch (Exception e) {
            session.setAttribute("msg", "<script>alert('导出失败！')</script>");
            e.printStackTrace();
        }
//        return "/view/teacher/student_details_information.jsp";
//        return "redirect:/teacher/getStudentInfoDetails";
        return "redirect:/teacher/queryStudentInfoByKey";
    }
    @RequestMapping( "/checkEmail")
    public @ResponseBody boolean checkEmail(Teacher teacher){
        Map<String,Object> param = new HashMap<>();
        param.put("teacherId",teacher.getTeacherId());
        param.put("email",teacher.getEmail());
        List<Teacher> checkemail = teacherService.checkEmail(param);
        System.out.println(param);
        if(checkemail.size()!=0){
            return true;
        }else{
            return false;
        }
    }
    @RequestMapping("/checkCaptcha")
    public @ResponseBody boolean checkCaptcha(HttpSession httpSession,@RequestParam String captcha){
        String captcha1 = (String)httpSession.getAttribute("Captcha");
        if(captcha.equals(captcha1)){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("/deleteCaptcha")
    public @ResponseBody void deleteCaptcha(HttpSession httpSession){
        httpSession.removeAttribute("Captcha");
    }
}

