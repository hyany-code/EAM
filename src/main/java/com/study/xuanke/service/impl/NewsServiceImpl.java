package com.study.xuanke.service.impl;

import com.study.xuanke.dao.NewsDao;
import com.study.xuanke.model.News;
import com.study.xuanke.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsDao newsDao;
    @Override
    public List<News> findAll() {
        return newsDao.findAll();
    }

    @Override
    public List<News> findByKey(String key) {
        return newsDao.findByKey(key);
    }

    @Override
    public boolean addNews(News news) {
        return newsDao.addNews(news) > 0 ? true : false;
    }

    @Override
    public News getById(int newsId) {
        return newsDao.getById(newsId);
    }

    @Override
    public boolean updateNews(News news) {
        return newsDao.updateNews(news) > 0 ? true : false;
    }

    @Override
    public boolean deleteNews(int newsId) {
        return newsDao.deleteNews(newsId) > 0 ? true : false;
    }

    @Override
    public void batchDeletes(List delList) {
        newsDao.batchDeletes(delList);
    }
}
