package com.study.xuanke.dao;

import com.study.xuanke.model.News;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class NewsDaoTest extends BaseTest{
    @Autowired
    private NewsDao newsDao;
    @Test
    public void findAll() {
        List<News> list = newsDao.findAll();
        for (News news : list) {
            System.out.println("News = " + news);
        }
    }

    @Test
    public void findByKey() {
        List<News> list = newsDao.findByKey("数据库");
        for (News news:list) {
            System.out.println("news = " + news);
        }
    }

    @Test
    public void addNews() {
        News news = new News();
        news.setNewsId(22003);
        news.setNewsName("数据库调课通知");
        news.setNewsType("学工办");
        news.setNewsDetails("王老师的数据库课程，由原来的周三上午34节，调整到周六下午78节");
        news.setAdminName("Wwabfy");
        int result = newsDao.addNews(news);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void getById() {
        News news = newsDao.getById(22003);
        Assert.assertNotNull(news);
        System.out.println("news = " + news);
    }

    @Test
    public void updateNews() {
        News news = new News();
        news.setNewsId(22003);
        news.setNewsName("数据库调课通知");
        news.setNewsType("班级新闻");
        news.setNewsDetails("王老师的数据库课程，由原来的周三上午34节，调整到周六下午78节");
        int result = newsDao.updateNews(news);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void deleteNews() {
        int result = newsDao.deleteNews(22003);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void batchDeletes() {
        List<String> list = new ArrayList<String>();
        list.add("202207");
        list.add("202208");
        newsDao.batchDeletes(list);
    }
}