package com.xxxxx.myblog.repository;

import com.xxxxx.myblog.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {

    //通过slug查找文章
    Article findBySlug(String slug);

    //查找所有文章并通过添加时间及描述来排序
    Iterable<Article> findAllByOrderByAddedAtDesc();

}
