package com.study.xuanke.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.xuanke.model.Admin;
import com.study.xuanke.model.News;
import com.study.xuanke.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController{
    // 注入Service
    @Autowired
    private NewsService newsService;
    /*
    管理员-新闻管理
    */
    @RequestMapping("/admin/listAll")
    public String doList_admin(@RequestParam(value = "page",defaultValue = "1") Integer page, Model model){
        // 1添加分页 page表示查询第几页 分页查询,每页5条数据
        PageHelper.startPage(page,7);
        //2 做查询
        List<News> list = newsService.findAll();

        // 3将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<News> info = new PageInfo<>(list,3);
        // 获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );
        // 4 绑定PageInfo 向页面返回封装后的数据
        model.addAttribute("info",info);
        return "/view/admin/news/news_list.jsp";
    }
    @RequestMapping("/admin/search")
    public String doSearch_admin(@RequestParam(value = "page",defaultValue = "1") Integer page,String key,Model model){
        // 1添加分页 page表示查询第几页 分页查询,每页5条数据
        PageHelper.startPage(page,5);
        List<News> list = newsService.findByKey(key);
        // 3将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<News> info = new PageInfo<>(list,3);
        // 获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );

        model.addAttribute("info",info);
        // 回显
        model.addAttribute("key",key);
        return "/view/admin/news/news_list.jsp";
    }
    // 添加对象,接收表单参数,执行添加，重定向到listAll
    @RequestMapping("/admin/add")
    public String doAdd(News news,HttpSession session){
        Admin admin = (Admin) session.getAttribute("currentAdmin");
        news.setAdminName(admin.getAdminName());
        newsService.addNews(news);
        // 可判断是成功还是失败
        // 再做查询
        return "redirect:listAll";
    }
    // 根据主键获取单个对象，转发到.jsp
    @RequestMapping("/admin/getOne")
    public String doGetOne(int newsId,Model model){
        News news = newsService.getById(newsId);
        model.addAttribute("news",news);
        return "/view/admin/news/news_update.jsp";
    }

    // 修改对象，接收表单参数，执行修改，重定向到listAll
    @RequestMapping("/admin/update")
    public String doUpdate(News news, HttpSession session){
        Admin admin = (Admin) session.getAttribute("currentAdmin");
        news.setAdminName(admin.getAdminName());
        newsService.updateNews(news);
        return "redirect:listAll";
    }
    // 删除对象，接收请求参数id,执行删除，重定向到listAll
    @RequestMapping("/admin/delete")
    public String doDelete(int newsId){
        newsService.deleteNews(newsId);
        return "redirect:listAll";
    }

//    批量删除
    @RequestMapping("/admin/batchDeletes")
    public String delAllNews(String ids){
        List<String> delList = new ArrayList<String>();
        String[] strs = ids.split(",");
        for (String str : strs) {
            delList.add(str);
        }
        //开始循环批量删除
        newsService.batchDeletes(delList);
        //重定向刷新数据
        return "redirect:listAll";
    }


    /*
    * 学生-新闻
    * */
    @RequestMapping("/student/listAll")
    public String doList_stu(@RequestParam(value = "page",defaultValue = "1") Integer page, Model model){
        // 1添加分页 page表示查询第几页 分页查询,每页5条数据
        PageHelper.startPage(page,5);
        //2 做查询
        List<News> list = newsService.findAll();

        // 3将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<News> info = new PageInfo<>(list,3);
        // 获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );
        // 4 绑定PageInfo 向页面返回封装后的数据
        model.addAttribute("info",info);

        //model.addAttribute("list",list);
        return "/view/students/news/news_list.jsp";
    }
    @RequestMapping("/student/search")
    public String doSearch_stu(@RequestParam(value = "page",defaultValue = "1") Integer page,String key,Model model){
        // 1添加分页 page表示查询第几页 分页查询,每页5条数据
        PageHelper.startPage(page,5);
        List<News> list = newsService.findByKey(key);
        // 3将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<News> info = new PageInfo<>(list,3);
        // 获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );

        model.addAttribute("info",info);
        // 回显
        model.addAttribute("key",key);
        return "/view/students/news/news_list.jsp";
    }
    @RequestMapping("/student/getOne")
    public String doGetOne_stu(int newsId,Model model){
        News news = newsService.getById(newsId);
        model.addAttribute("news",news);
        return "/view/students/news/news_view.jsp";
    }
    /*
    * 教师-新闻
    * */
    @RequestMapping("/teacher/search")
    public String doSearch_teacher(@RequestParam(value = "page",defaultValue = "1") Integer page,String key,Model model){
        // 1添加分页 page表示查询第几页 分页查询,每页5条数据
        PageHelper.startPage(page,5);
        List<News> list = newsService.findByKey(key);
        // 3将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<News> info = new PageInfo<>(list,3);
        // 获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );

        model.addAttribute("info",info);
        // 回显
        model.addAttribute("key",key);
        return "/view/teacher/news/news_list.jsp";
    }
    @RequestMapping("/teacher/listAll")
    public String doList_teacher(@RequestParam(value = "page",defaultValue = "1") Integer page, Model model){
        // 1添加分页 page表示查询第几页 分页查询,每页5条数据
        PageHelper.startPage(page,5);
        //2 做查询
        List<News> list = newsService.findAll();

        // 3将查询的结果进行封装，可以传入可连续显示的页码
        PageInfo<News> info = new PageInfo<>(list,3);
        // 获取信息测试
        System.out.println("总记录数" +info.getTotal() );
        System.out.println("总页数" +info.getPages() );
        System.out.println("当前页码" +info.getPageNum());
        System.out.println("结果" +info.getList() );
        // 4 绑定PageInfo 向页面返回封装后的数据
        model.addAttribute("info",info);
        return "/view/teacher/news/news_list.jsp";
    }
    @RequestMapping("/teacher/getOne")
    public String doGetOne_teacher(int newsId,Model model){
        News news = newsService.getById(newsId);
        model.addAttribute("news",news);
        return "/view/teacher/news/news_view.jsp";
    }
}
