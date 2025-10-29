package com.study.xuanke.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.xuanke.model.*;
import com.study.xuanke.service.CourseService;
import com.study.xuanke.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseController {
    // 注入Service
    @Autowired
    private CourseService courseService;

    @Autowired
    private DepartmentService departmentService;
    // 查询所有,绑定数据，转发到department_list.jsp
    @RequestMapping("/listAll")
    public String doList(@RequestParam(value = "page",defaultValue = "1") Integer page, Model model){
        //1.添加分页
        PageHelper.startPage(page,5);
        //2.做查询，原来怎么查还是怎么查
        List<Course> list = courseService.findAll();
        //3. 将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<Course> info = new PageInfo<>(list,3);
        // 获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );
        //4.绑定pageInfo
        model.addAttribute("info",info);
        //发送到页面
        return "/view/course/course_list.jsp";
    }
    @RequestMapping("/select/listAll")
    public String doseletList(@RequestParam(value = "page",defaultValue = "1") Integer page, Model model){
        //1.添加分页
        PageHelper.startPage(page,5);
        //2.做查询，原来怎么查还是怎么查
        List<Course> list = courseService.findAll();
        //3. 将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<Course> info = new PageInfo<>(list,3);
        // 获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );
        //4.绑定pageInfo
        model.addAttribute("info",info);
        //发送到页面
        return "/view/course/course_select.jsp";
    }
    @RequestMapping("/selected/listAll")
    public String doselectedList(@RequestParam(value = "page",defaultValue = "1") Integer page, HttpSession session, Model model){
        Student student = (Student) session.getAttribute("currentStudent");
//        student.setStudentId(student.getStudentId());
        //1.添加分页
        PageHelper.startPage(page,5);
        //2.做查询，原来怎么查还是怎么查
        List<SelectedCourse> list = courseService.findAllSelectedCourse(student.getStudentId());
        //3. 将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<SelectedCourse> info = new PageInfo<>(list,3);
        // 获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );
        //4.绑定pageInfo
        model.addAttribute("info",info);
        //发送到页面
        return "/view/course/course_selected.jsp";
    }
    @RequestMapping("/teached/listAll")
    public String doteachedList(@RequestParam(value = "page",defaultValue = "1") Integer page, HttpSession session, Model model){
        Teacher teacher = (Teacher) session.getAttribute("currentTeacher");
        //1.添加分页
        PageHelper.startPage(page,5);
        //2.做查询，原来怎么查还是怎么查
        List<Course> list = courseService.findAllTeachedCourse(teacher.getTeacherId());
        //3. 将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<Course> info = new PageInfo<>(list,3);
        // 获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );
        //4.绑定pageInfo
        model.addAttribute("info",info);
        //发送到页面
        return "/view/course/course_teached.jsp";
    }
    // 根据关键字查询,绑定数据，转发到department_list.jsp
    @RequestMapping("/search")
    public String doSearch(@RequestParam(value = "page",defaultValue = "1") Integer page,String key,Model model){

        //1.添加分页
        PageHelper.startPage(page,5);
        //2.做查询，原来怎么查还是怎么查
        List<Course> list = courseService.findByKey(key);
        //3. 将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<Course> info = new PageInfo<>(list,3);
        // 获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );
        //4.绑定pageInfo
        model.addAttribute("info",info);
        //发送到页面
        // 回显
        return "/view/course/course_list.jsp";
    }
    @RequestMapping("/select/search")
    public String doselectSearch(@RequestParam(value = "page",defaultValue = "1") Integer page,String key,Model model){

        //1.添加分页
        PageHelper.startPage(page,5);
        //2.做查询，原来怎么查还是怎么查
        List<Course> list = courseService.findByKey(key);
        //3. 将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<Course> info = new PageInfo<>(list,3);
        // 获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );
        //4.绑定pageInfo
        model.addAttribute("info",info);
        //发送到页面
        // 回显
        return "/view/course/course_select.jsp";
    }
    // 添加对象,接收表单参数,执行添加，重定向到listAll
    @RequestMapping("/add")
    public String doAdd(Course course, HttpSession session){
        Admin admin = (Admin) session.getAttribute("currentAdmin");
        course.setAdminName(admin.getAdminName());
        boolean result = courseService.addCourse(course);
        // 可判断是成功还是失败
        // 再做查询
        return "redirect:listAll";
    }
    // 根据主键获取单个对象，转发到department_update.jsp
    @RequestMapping("/getOne")
    public String doGetOne(int courseId, Model model){
        Course course = courseService.getById(courseId);
        model.addAttribute("course",course);
        return "/view/course/course_update.jsp";
    }
    @RequestMapping("/Update")
    public String doUpdate(Course course,HttpSession session){
        Admin admin = (Admin) session.getAttribute("currentAdmin");
        course.setAdminName(admin.getAdminName());
        boolean result = courseService.updateCourse(course);
        // 可判断是成功还是失败
        // 再做查询
        return "redirect:listAll";
    };
    // 删除对象，接收请求参数id,执行删除，重定向到listAll
    @RequestMapping("/Delete")
    public String doDelete(int courseId){
        boolean result = courseService.deleteCourse(courseId);
        // 可判断是成功还是失败
        // 再做查询
        return "redirect:listAll";
    };

    @RequestMapping("/selectCourse/{courseId}/{score}/{gpa}/{teacherId}")
    public String selectCourse(@PathVariable("courseId") int courseId,
                               @PathVariable("score") float score,
                               @PathVariable("gpa") float gpa,
                               @PathVariable("teacherId") int teacherId,
                               HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response){
        Student student =(Student) session.getAttribute("currentStudent");
        Map<String, Object> param = new HashMap<>();
            param.put("studentId", student.getStudentId());
            param.put("courseId", courseId);
            Integer count = courseService.queryScoreCount(param);
            Integer planNumber = courseService.queryPlanNum(param);
            Integer selectedNumber = courseService.querySelectedNum(param);
            if (selectedNumber < planNumber) {
                if (count < 1) {
                    courseService.addCourse2(student.getStudentId(), courseId, score, gpa, teacherId);
                    model.addAttribute("msg", "选课成功");
                    //  将msg信息传到前端jsp
                    session.setAttribute("msg", "<script>alert('选课成功')</script>");
                    return "redirect:/course/selected/listAll";
                } else {
                    model.addAttribute("msg", "选课失败,已选本门课程!!!");
                    session.setAttribute("msg", "<script>alert('选课失败,已选本门课程，请先退选')</script>");
                    return "redirect:/course/selected/listAll";
                }
            }else {
                model.addAttribute("msg", "选课失败,本课程已满!!!");
                session.setAttribute("msg", "<script>alert('选课失败,本课程已满')</script>");
//            return "/view/course/course_select.jsp";
//            return "redirect:/course/select/search";
                return "redirect:/course/selected/listAll";
            }
    }
    @RequestMapping("/selected/Delete")
    public String doSelectedDelete(int courseId){
        boolean result = courseService.deleteSelectedCourse(courseId);
        // 可判断是成功还是失败
        // 再做查询
        return "redirect:/course/selected/listAll";
    }
}
