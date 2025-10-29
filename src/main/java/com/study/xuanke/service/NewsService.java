package com.study.xuanke.service;

import com.study.xuanke.model.News;

import java.util.List;

public interface NewsService {
    List<News> findAll();

    List<News> findByKey(String key);

    boolean addNews(News news);

    News getById(int newsId);

    boolean updateNews(News news);
    // 逻辑删除
    boolean deleteNews(int newsId);
    //真实删除一大堆
    void batchDeletes(List delList);
}
