package com.xxxxx.myblog.domain;

import com.xxxxx.myblog.entity.User;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RenderedArticle {
    private String slug;
    private String title;
    private String headline;
    private String content;
    private User author;
    private String addedAt;
}
