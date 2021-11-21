package com.xxxxx.myblog.config;

import com.xxxxx.myblog.entity.Article;
import com.xxxxx.myblog.entity.User;
import com.xxxxx.myblog.repository.ArticleRepository;
import com.xxxxx.myblog.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogConfiguration  implements ApplicationRunner {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public BlogConfiguration(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User meimeihan = userRepository.save(new User()
                .setLogin("meimeihan")
                .setFirstName("meimei")
                .setLastName("han"));
        articleRepository.save(new Article()
                .setTitle("the title1")
                .setHeadline("headline1")
                .setContent("content1")
                .setAuthor(meimeihan));
        articleRepository.save(new Article()
                .setTitle("the title2")
                .setHeadline("headline2")
                .setContent("content2")
                .setAuthor(meimeihan));
    }
}
