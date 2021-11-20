package com.xxxxx.myblog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Article {

    @Id
    @GeneratedValue
    //主键
    private Long id;
    //标题
    private String title;
    //摘要
    private String headline;
    //内容
    private String content;
    @ManyToOne
    //作者
    private User author;
    //slug格式的标题
    private String slug;
    //创建时间
    private LocalDateTime addedAt;

    //空参构造
    public Article() {
        addedAt = LocalDateTime.now();
    }

    //getter与setter
    public Long getId() {
        return id;
    }

    public Article setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }
}
