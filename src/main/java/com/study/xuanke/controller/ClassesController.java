package com.study.xuanke.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.xuanke.model.Classes;
import com.study.xuanke.model.Department;
import com.study.xuanke.service.ClassesService;
import com.study.xuanke.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @RequestMapping("/listAll")
    public String doList(@RequestParam(value = "page",defaultValue = "1") Integer page, Model model){
        //1.添加分页
        PageHelper.startPage(page,5);
        //2.查询
        List<Classes> list = classesService.findAll();
        //3.将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<Classes> info = new PageInfo<>(list,3);
        //获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );
        //4.绑定info
        model.addAttribute("info",info);

        return "/view/admin/class/class_list.jsp";//webapp是虚目录
    }
    // 根据关键字查询,绑定数据，转发到department_list.jsp
    @RequestMapping("/search")
    public String doSearch(@RequestParam(value = "page",defaultValue = "1") Integer page, String key,Model model){

        PageHelper.startPage(page,5);
        List<Classes> list = classesService.findByKey(key);
        PageInfo<Classes> info = new PageInfo<>(list,3);
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );

        model.addAttribute("info",info);
        // 回显
        model.addAttribute("key",key);
        return "/view/admin/class/class_list.jsp";
    }
    // 添加对象,接收表单参数,执行添加，重定向到listAll
    @RequestMapping("/add")
    public String doAdd(Classes classes){
        boolean result = classesService.addClasses(classes);
        // 可判断是成功还是失败
        // 再做查询
        return "redirect:listAll";//到listAll重新全查一遍
    }
    // 根据主键获取单个对象，转发到department_update.jsp
    @RequestMapping("/getOne")
    public String doGetOne(int classId, Model model){
            Classes classes = classesService.getById(classId);
            model.addAttribute("classes",classes);
            return "/view/admin/class/class_update.jsp";
    }
    //   修改和删除操作自己独立完成
    // 修改对象，接收表单参数，执行修改，重定向到listAll
    @RequestMapping("/doUpdate")
    public String doUpdate(Classes classes){
        boolean result = classesService.updateClasses(classes);
        return "redirect:listAll";

    }
    // 删除对象，接收请求参数id,执行删除，重定向到listAll
    @RequestMapping("/doDelete")
    public String doDelete(int classId){
        boolean result=classesService.deleteClasses(classId);
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
        classesService.batchDeletes(delList);
        //重定向刷新数据
        return "redirect:/listAll";
    }
}

