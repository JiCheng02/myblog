package com.xxxxx.myblog.config;

import com.xxxxx.myblog.domain.Banner;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("blog")
@Data
public class BlogProperties {
    private String title;
    private Banner banner;
}
