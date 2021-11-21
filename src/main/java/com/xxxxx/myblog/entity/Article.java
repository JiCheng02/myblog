package com.xxxxx.myblog.entity;

import com.xxxxx.myblog.utils.CommonUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
@Accessors(chain = true)
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

    public Article setTitle(String title) {
        this.title = title;
        this.slug = CommonUtil.toSlug(title);
        return this;
    }

}
