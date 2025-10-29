package com.study.xuanke.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.xuanke.model.Department;
import com.study.xuanke.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/listAll")
    public String doList(@RequestParam(value = "page",defaultValue = "1") Integer page, Model model){
        //1.添加分页
        PageHelper.startPage(page,5);
        //2.查询
        List<Department> list = departmentService.findAll();

        //3.将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<Department> info = new PageInfo<>(list,3);
        //获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );
        //4.绑定info
        model.addAttribute("info",info);

        return "/view/admin/department/department_list.jsp";//webapp是虚目录
    }
    @RequestMapping("/listAll.do")
    @ResponseBody
    public List<Department> getAllDepartment(){
        List<Department> departmentList = departmentService.findAll();
        return departmentList;
    }

    // 根据关键字查询,绑定数据，转发到department_list.jsp
    @RequestMapping("/search")
    public String doSearch(@RequestParam(value = "page",defaultValue = "1") Integer page, String key,Model model){

        PageHelper.startPage(page,5);
        List<Department> list = departmentService.findByKey(key);
        PageInfo<Department> info = new PageInfo<>(list,3);
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );

        model.addAttribute("info",info);
        // 回显
        model.addAttribute("key",key);
        return "/view/admin/department/department_list.jsp";
    }
    // 添加对象,接收表单参数,执行添加，重定向到listAll
    @RequestMapping("/add")
    public String doAdd(Department department){
        boolean result = departmentService.addDepartment(department);
        // 可判断是成功还是失败
        // 再做查询
        return "redirect:listAll";//到listAll重新全查一遍
    }
    // 根据主键获取单个对象，转发到department_update.jsp
    @RequestMapping("/getOne")
    public String doGetOne(int departmentId,Model model){
        Department department = departmentService.getById(departmentId);
        model.addAttribute("department",department);
        return "/view/admin/department/department_update.jsp";
    }
    //   修改和删除操作自己独立完成
    // 修改对象，接收表单参数，执行修改，重定向到listAll
    @RequestMapping("/doUpdate")
    public String doUpdate(Department department){
        boolean result = departmentService.updateDepartment(department);
        return "redirect:listAll";

    }
//    @RequestMapping("/doUpdate.do")
//    public String modifyTodepartment(int departmentId,Model model){
//        Department department = departmentService.getById(departmentId);
//        List<Department> list = departmentService.findAll();
//        if(department !=null) {
//            model.addAttribute("department", department);
//            model.addAttribute("list", list);
//            return "/department/department_list.jsp";
//        }else{
//            return
//        }
//    }


    // 删除对象，接收请求参数id,执行删除，重定向到listAll
    @RequestMapping("/doDelete")
    public String doDelete(int departmentId){
        boolean result=departmentService.deleteDepartment(departmentId);
        return"redirect:listAll";

    }
    @RequestMapping("/batchDeletes")
    //批量删除
    public String delAll(String ids){
        List<String> delList = new ArrayList<String>();
        String[] strs = ids.split(",");
        for (String str : strs) {
            delList.add(str);
        }
        //开始循环批量删除
        departmentService.batchDeletes(delList);
        //重定向刷新数据
        return "redirect:/listAll";
    }
}
