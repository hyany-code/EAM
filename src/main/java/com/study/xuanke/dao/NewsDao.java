package com.study.xuanke.dao;

import com.study.xuanke.model.News;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsDao {
    List<News> findAll();

    List<News> findByKey(String key);

    int addNews(News news);

    News getById(int newsId);

    int updateNews(News news);
    // 逻辑删除
    int deleteNews(int newsId);
    //真实删除一大堆
    void batchDeletes(List delList);
}
